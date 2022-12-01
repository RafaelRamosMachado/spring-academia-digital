package me.dio.academia.digital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.dio.academia.digital.entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
	/*@Query(value = "SELECT * FROM tb_matriculas m " + 
		"INNER JOIN tb_alunos a ON m.alunos_id = a.id " +
		"WHERE a.bairro = :bairro", nativeQuery = true)
	@Query("FROM Matricula m WHERE m.aluno.bairro = :bairro ")*/
	//List<Matricula> findalunosMatriculadosBairro(String bairro);
	
	List<Matricula> findByAlunoBairro(String bairro);
}

