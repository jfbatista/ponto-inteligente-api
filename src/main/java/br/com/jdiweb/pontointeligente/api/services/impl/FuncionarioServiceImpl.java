package br.com.jdiweb.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jdiweb.pontointeligente.api.entities.Funcionario;
import br.com.jdiweb.pontointeligente.api.repositories.FuncionarioRepository;
import br.com.jdiweb.pontointeligente.api.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public Optional<Funcionario> buscarPorCpf(String cpf) {
		log.info("Buscar funcionario pelo cpf {}", cpf);
		return Optional.ofNullable(funcionarioRepository.findByCpf(cpf));
	}

	@Override
	public Optional<Funcionario> buscarPorCpfOuEmail(String cpf, String email) {
		log.info("Buscar funcionario pelo cpf {} ou email {}", cpf, email);
		return Optional.ofNullable(funcionarioRepository.findByCpfOrEmail(cpf, email));
	}

	@Override
	public Optional<Funcionario> buscarPorNome(String nome) {
		log.info("Buscar funcionario pelo nome {}", nome);
		return Optional.ofNullable(funcionarioRepository.findByNome(nome));
	}

	@Override
	public Funcionario salvar(Funcionario funcionario) {
		log.info("Salvar funcionario {}", funcionario);
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public void remover(Long id) {
		log.info("Remover funcionario pelo id {}", id);
		this.funcionarioRepository.deleteById(id);
	}

}
