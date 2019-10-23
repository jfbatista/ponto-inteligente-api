package br.com.jdiweb.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.jdiweb.pontointeligente.api.entities.Lancamento;
import br.com.jdiweb.pontointeligente.api.repositories.LancamentoRepository;
import br.com.jdiweb.pontointeligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Override
	public Optional<Lancamento> buscarPorId(Long id) {
		log.info("busca lancamento pelo id {} ", id);
		return this.lancamentoRepository.findById(id);
	}

	@Override
	public Page<Lancamento> buscarPorFuncionarioId(Long id, PageRequest pageRequest) {
		log.info("busca lancamento pelo funcionario id {} ", id);
		return this.lancamentoRepository.findByFuncionarioFuncionarioId(id, pageRequest);
	}

	@Override
	public void remove(Long id) {
		log.info("remove lancamento pelo id {} ", id);
		this.lancamentoRepository.deleteById(id);

	}

	@Override
	public Lancamento salvar(Lancamento lancamento) {
		log.info("busca lancamento  {} ", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

}
