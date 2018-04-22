package teste;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Pais;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
	public class PaisTeste {
	Pais pais, copia;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais();
		pais.setId(id);
		pais.setNome("camboja03");
		pais.setPopulacao(1000000);
		pais.setArea(8.500151);
		copia = new Pais();
		copia.setId(id);
		copia.setNome("camboja03");
		copia.setPopulacao(1000000);
		copia.setArea(8.500151);
	}

	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Pais fixture = new Pais();
		fixture.setId(1);
		fixture.setNome("Brasil");
		fixture.setPopulacao(200000000);
		fixture.setArea(453.543);
		Pais novo = pais.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}
	
	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = pais.criar(pais);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setPopulacao(546546546);
		copia.setPopulacao(546546546);
		pais.atualizar(pais);
		pais.carregar(pais.getId());
		assertEquals("testa atualizacao", pais, copia);
	}
	
	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(-1);
		copia.setArea(-1);
		pais = pais.carregar(id);
		assertEquals("testa exclusao", pais, copia);//
	}
}