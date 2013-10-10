package tests.models;

import controleatleta.Endereco;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EnderecoTest {
	private Endereco endereco;

	@Before
	public void setUp() throws Exception {
		this.endereco = new Endereco();
	}

	@Test
	public void testGetAndSetLogradouro() { // Ok
		this.endereco.setLogradouro("Qd 0 casa 123");
		assertEquals("Qd 0 casa 123", this.endereco.getLogradouro());
	}

	@Test
	public void testGetAndSetNumero() {
		this.endereco.setNumero("01122");
		assertEquals("01122", this.endereco.getNumero());
	}


	@Test
	public void testGetAndSetBairro() {
		this.endereco.setBairro("Setor Oeste");
		assertEquals("Setor Oeste", this.endereco.getBairro());
	}

	@Test
	public void testGetAndSetCidade() {
		this.endereco.setCidade("Gama");
		assertEquals("Gama", this.endereco.getCidade());
	}

	@Test
	public void testGetAndSetEstado() {
		this.endereco.setEstado("DF");
		assertEquals("DF", this.endereco.getEstado());
	}

	@Test
	public void testGetAndSetPais() {
		this.endereco.setPais("Brasil");
		assertEquals("Brasil", this.endereco.getPais());
	}

	@Test
	public void testGetAndSetComplemento() {
		this.endereco.setComplemento("Alguma coisa ai");
		assertEquals("Alguma coisa ai", this.endereco.getComplemento());
	}

	@Test
	public void testGetAndSeCep() {
		this.endereco.setCep("72425-115");
		assertEquals("72425-115", this.endereco.getCep());
	}
}