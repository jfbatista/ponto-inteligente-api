package br.com.jdiweb.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jdiweb.pontointeligente.api.entities.Empresa;
import br.com.jdiweb.pontointeligente.api.entities.Funcionario;
import br.com.jdiweb.pontointeligente.api.entities.Lancamento;
import br.com.jdiweb.pontointeligente.api.enums.PerfilEnum;
import br.com.jdiweb.pontointeligente.api.enums.TipoEnum;
import br.com.jdiweb.pontointeligente.api.util.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private LancamentoRepository lancamentoRepository;

	private Long funcionarioId;

	@Before
	public void setUp() throws Exception {
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());

		Funcionario funcionario = this.funcionarioRepository.save(obterDadosFuncionario(empresa));

		this.funcionarioId = funcionario.getFuncionarioId();

		this.lancamentoRepository.save(obterDadosLancamento(funcionario));
	}

	@After
	public final void tearDown() {
		this.empresaRepository.deleteAll();
	}

	@Test
	public void testBuscarLancamentoPorFuncionarioId() {
		List<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioFuncionarioId(funcionarioId);

		assertEquals(1, lancamentos.size());
	}

	@Test
	public void testBuscarLancamentoPorFuncionarioIdPaginado() {
		Page<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioFuncionarioId(funcionarioId, PageRequest.of(0,10));

		assertEquals(1, lancamentos.getTotalElements());
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
		funcionario.setCpf("79079512168");
		funcionario.setEmail("jfbatista@hotmail.com");
		funcionario.setPerfil(PerfilEnum.ROLE_ADMIN);
		funcionario.setSenha(PasswordUtils.gerarBCrypt("ju24cl22"));
		funcionario.setEmpresa(empresa);

		return funcionario;
	}

	private Lancamento obterDadosLancamento(Funcionario funcionario) {
		Lancamento lancamento = new Lancamento();

		lancamento.setData(new Date());
		lancamento.setTipo(TipoEnum.INICIO_ALMOCO);
		lancamento.setDescricao("Teste");
		lancamento.setLocalizacao("testando 2");
		lancamento.setFuncionario(funcionario);

		return lancamento;
	}
}
