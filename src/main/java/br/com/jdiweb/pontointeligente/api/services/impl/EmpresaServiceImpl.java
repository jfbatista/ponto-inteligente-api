package br.com.jdiweb.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jdiweb.pontointeligente.api.entities.Empresa;
import br.com.jdiweb.pontointeligente.api.entities.Funcionario;
import br.com.jdiweb.pontointeligente.api.repositories.EmpresaRepository;
import br.com.jdiweb.pontointeligente.api.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj) {
		log.info("Buscando empresa pelo cnpj {}", cnpj);

		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}
	
	@Override
	public Empresa salvar(Empresa empresa) {
		log.info("Salvar empresa {}", empresa);
		return this.empresaRepository.save(empresa);
	}

	@Override
	public void remover(Long id) {
		log.info("Remover empresa pelo id {}", id);
		this.empresaRepository.deleteById(id);
	}

}
