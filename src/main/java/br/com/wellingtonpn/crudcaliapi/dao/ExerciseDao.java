package br.com.wellingtonpn.crudcaliapi.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ExerciseDao {

    private String nomeExercicio;
    private String equipamentoUtilizado;
    private String duracaoExercicio;
}
