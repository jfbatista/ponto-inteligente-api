package br.com.jdiweb.pontointeligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.jdiweb.pontointeligente.api.entities.Lancamento;

public interface LancamentoService {

	Optional<Lancamento> buscarPorId(Long id);

	Page<Lancamento> buscarPorFuncionarioId(Long id, PageRequest pageRequest);

	void remove(Long id);

	Lancamento salvar(Lancamento lancamento);

}
