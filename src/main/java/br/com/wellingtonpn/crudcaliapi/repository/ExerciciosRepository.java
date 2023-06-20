package br.com.wellingtonpn.crudcaliapi.repository;

import br.com.wellingtonpn.crudcaliapi.model.ExercicioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciciosRepository extends JpaRepository<ExercicioModel, Long> {
}
