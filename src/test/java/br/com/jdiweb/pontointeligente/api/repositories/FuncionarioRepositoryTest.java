package br.com.jdiweb.pontointeligente.api.repositories;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jdiweb.pontointeligente.api.entities.Empresa;
import br.com.jdiweb.pontointeligente.api.entities.Funcionario;
import br.com.jdiweb.pontointeligente.api.enums.PerfilEnum;
import br.com.jdiweb.pontointeligente.api.util.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	private static final String CPF = "79079512168";
	private static final String EMAIL = "jfbatista@hotmail.com";

	@Before
	public void setUp() throws Exception {
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());

		this.funcionarioRepository.save(obterDadosFuncionario(empresa));
	}

	@After
	public final void tearDown() {
		this.funcionarioRepository.deleteAll();
	}

	@Test
	public void testBuscarFuncionarioPorCpf() {
		Funcionario funcionario = this.funcionarioRepository.findByCpf(CPF);

		assertNotNull(funcionario);
	}

	@Test
	public void testBuscarFuncionarioPorEmailAndCpf() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, EMAIL);

		assertNotNull(funcionario);
	}

	@Test
	public void testBuscarFuncionarioPorEmailOuCpfParaEmailInvalido() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, "teste@invalido.com");

		assertNotNull(funcionario);
	}

	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Juvenal Ferreira Batista ME");
		empresa.setCnpj("07210322000104");
		return empresa;
	}

	private Funcionario obterDadosFuncionario(Empresa empresa) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Juvenal Ferreira Batista");
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setPerfil(PerfilEnum.ROLE_ADMIN);
		funcionario.setSenha(PasswordUtils.gerarBCrypt("ju24cl22"));
		funcionario.setEmpresa(empresa);

		return funcionario;
	}
}
