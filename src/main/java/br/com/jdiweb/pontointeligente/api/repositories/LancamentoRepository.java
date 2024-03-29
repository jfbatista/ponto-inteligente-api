package br.com.jdiweb.pontointeligente.api.repositories;

import java.util.List;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.jdiweb.pontointeligente.api.entities.Lancamento;

@Transactional(readOnly = true)
@NamedQueries({
		@NamedQuery(name = "LancamentoRepository.findByFuncionarioId", 
				   query = "SELECT lanc FROM lancamento lanc WHERE lanc.funcionario.funcionarioId = :funcionarioId") })
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

	@Query
	List<Lancamento> findByFuncionarioFuncionarioId(@Param("FuncionarioId") Long funcionarioId);

	@Query
	Page<Lancamento> findByFuncionarioFuncionarioId(@Param("FuncionarioId") Long funcionarioId, Pageable pageable);
}
