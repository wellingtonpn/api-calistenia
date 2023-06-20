package br.com.wellingtonpn.crudcaliapi.model;

import br.com.wellingtonpn.crudcaliapi.dao.ExerciseDao;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
public class ExercicioModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nome_exercicio")
    private String nomeExercicio;
    @Column(name = "equipamento_utilizado")
    private String equipamentoUtilizado;
    @Column(name = "duracao_exercicio")
    private String duracaoExercicio;

    public ExercicioModel(){}

    public ExercicioModel(long id, String nomeExercicio, String equipamentoUtilizado, String duracaoExercicio) {
        this.id = id;
        this.nomeExercicio = nomeExercicio;
        this.equipamentoUtilizado = equipamentoUtilizado;
        this.duracaoExercicio = duracaoExercicio;
    }

    public ExercicioModel(ExerciseDao exercicioDao) {
        this.nomeExercicio = nomeExercicio;
        this.equipamentoUtilizado = equipamentoUtilizado;
        this.duracaoExercicio = duracaoExercicio;
    }
}
