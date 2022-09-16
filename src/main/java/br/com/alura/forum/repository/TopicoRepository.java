package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	//criando metodo findBy + nome do atributo mais recurso
	List<Topico> findByCursoNome(String nomeCurso);
//	
	//criando metodo da maneira deseja porém tendo que preencher a query - jpqe
//	@Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
//	List<Topico> minhaChamada(@Param("nomeCurso") String nomeCurso);

}
