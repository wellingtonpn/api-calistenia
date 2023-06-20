package br.com.wellingtonpn.crudcaliapi.controller;

import br.com.wellingtonpn.crudcaliapi.dao.ExerciseDao;
import br.com.wellingtonpn.crudcaliapi.model.ExercicioModel;
import br.com.wellingtonpn.crudcaliapi.repository.ExerciciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciciosRepository exerciciosRepository;

    @GetMapping
    public List<ExercicioModel> listExercises(){
        ExercicioModel exercicioModel1 = new ExercicioModel(1,"flexão", "15 minutos", "solo");
        ExercicioModel exercicioModel2 = new ExercicioModel(2,"dips", "16 minutos", "paralelas");
        ExercicioModel exercicioModel3 = new ExercicioModel(3,"handstand", "14 minutos", "paralelas");
        ExercicioModel exercicioModel4 = new ExercicioModel(4,"puchada pronada", "12 minutos", "barra fixa");
        ExercicioModel exercicioModel5 = new ExercicioModel(5,"puchada supinada", "13 minutos", "barra fixa");
        ExercicioModel exercicioModel6 = new ExercicioModel(6,"front lever", "20 minutos", "barra fixa");
        List<ExercicioModel> listaDexercicio = new ArrayList<ExercicioModel>();
        listaDexercicio.add(exercicioModel1);
        listaDexercicio.add(exercicioModel2);
        listaDexercicio.add(exercicioModel3);
        listaDexercicio.add(exercicioModel4);
        listaDexercicio.add(exercicioModel5);
        listaDexercicio.add(exercicioModel6);
        exerciciosRepository.saveAll(listaDexercicio);

        List<ExercicioModel> exercises = new ArrayList<ExercicioModel>();
        List<ExercicioModel> listExercises = exerciciosRepository.findAll();

        listExercises.forEach( exercise -> {
            ExercicioModel exercicioModel = new ExercicioModel();
            exercicioModel.setId(exercise.getId());
            exercicioModel.setNomeExercicio(exercise.getNomeExercicio());
            exercicioModel.setDuracaoExercicio(exercise.getDuracaoExercicio());
            exercicioModel.setEquipamentoUtilizado(exercise.getEquipamentoUtilizado());
            exercises.add(exercicioModel);
        });

        return exercises;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExercicioModel exercise(@RequestBody ExercicioModel exerciseDao){
//        ExercicioModel exercicioModel = new ExercicioModel();
        exerciciosRepository.save(exerciseDao);
        return exerciseDao;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus exercise(@RequestBody ExercicioModel exerciseModel, @PathVariable long id){
        ExercicioModel exercicio = new ExercicioModel();
        Optional<ExercicioModel> retornoExercicio = exerciciosRepository.findById(id);
        try{
            if (retornoExercicio.isPresent()) {
                exercicio = retornoExercicio.get();
                exercicio.setEquipamentoUtilizado(exerciseModel.getEquipamentoUtilizado());
                exercicio.setNomeExercicio(exerciseModel.getNomeExercicio());
                exercicio.setDuracaoExercicio(exerciseModel.getDuracaoExercicio());
                exerciciosRepository.save(exercicio);
                return HttpStatus.OK;
            }
        } catch(Exception e) {
            e.printStackTrace();
            return HttpStatus.NOT_ACCEPTABLE;
        }

        return HttpStatus.NO_CONTENT;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    HttpStatus delete(@PathVariable long id){
        if(id < 0l){
            exerciciosRepository.deleteById(id);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_ACCEPTABLE;
        }
    }

}

