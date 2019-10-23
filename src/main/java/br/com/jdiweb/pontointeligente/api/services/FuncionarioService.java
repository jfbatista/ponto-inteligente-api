package br.com.jdiweb.pontointeligente.api.services;

import java.util.Optional;

import br.com.jdiweb.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {

	Optional<Funcionario> buscarPorCpf(String cpf);

	Optional<Funcionario> buscarPorCpfOuEmail(String cpf, String email);

	Optional<Funcionario> buscarPorNome(String nome);

	Funcionario salvar(Funcionario funcionario);

	void remover(Long id);

}
