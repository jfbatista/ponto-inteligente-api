package br.com.jdiweb.pontointeligente.api.services;

import java.util.Optional;

import br.com.jdiweb.pontointeligente.api.entities.Empresa;

public interface EmpresaService {
	
	Optional<Empresa> buscarPorCnpj(String cnpj);

	Empresa salvar(Empresa empresa);

	void remover(Long id);

}
