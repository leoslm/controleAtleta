package tests.models;

import controleatleta.Atleta;
import controleatleta.Endereco;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AtletaTest {
	private Atleta atleta;

	@Before
	public void setUp() throws Exception {
		this.atleta = new Atleta(null);
	}

	@Test
	public void testGetAndSetNome() {
		this.atleta.setNome("Leonardo Lima");
		assertEquals("Leonardo Lima", this.atleta.getNome());
	}

	@Test
	public void testGetAndSetNomePai() {
		this.atleta.setNomePai("Ericsson Lima Macedo");
		assertEquals("Ericsson Lima Macedo", this.atleta.getNomePai());
	}

	@Test
	public void testGetAndSetNomeMae() {
		this.atleta.setNomeMae("Marilene dos Santos Lima Macedo");
		assertEquals("Marilene dos Santos Lima Macedo", this.atleta.getNomeMae());
	}

	@Test
	public void testGetAndSetRg() {
		this.atleta.setRg("1234567");
		assertEquals("1234567", this.atleta.getRg());
	}

	@Test
	public void testGetAndSetCpf() {
		this.atleta.setCpf("123456789-10");
		assertEquals("123456789-10", this.atleta.getCpf());
	}

	@Test
	public void testGetAndSetSexo() {
		this.atleta.setSexo('M');
		assertEquals('M', this.atleta.getSexo());
	}

	@Test
	public void testGetAndSetTelefones() {
		ArrayList<String> telefones = new ArrayList<String>();
		telefones.add("1111-2222");
		telefones.add("3333-4444");
		telefones.add("5555-6666");

		this.atleta.setTelefones(telefones);
		for(int i=0; i < telefones.size(); i++) {
			String t = this.atleta.getTelefones().get(i);
			assertArrayEquals(telefones.get(i), t);
		}
	}

	@Test
	public void testGetAndSetDataNascimento() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.atleta.setDataNascimento(dateFormat.parse("10/10/10"));

		assertEquals(dateFormat.format(dateFormat.parse("10/10/10")), 
				dateFormat.format(this.atleta.getDataNascimento()));
	}

	@Test
	public void testGetAndSetAltura() {
		this.atleta.setAltura(2.0);
		assertEquals(2.0, this.atleta.getAltura(), 0.000001);
	}


	@Test
	public void testGetAndSetPeso() {
		this.atleta.setPeso(78.0);
		assertEquals(78.0, this.atleta.getPeso(), 0.000001);
	}

	@Test
	public void testGetAndSetEndereco() {
		Endereco end = new Endereco();
		this.atleta.setEndereco(end);

		assertEquals(end, this.atleta.getEndereco());
	}

	private void assertArrayEquals(String stringA, String stringB) {
		assertEquals(stringA.length(), stringB.length());

		for(int i = 0; i < stringA.length(); i++)
			assertEquals(stringA.charAt(i), stringB.charAt(i));
	}
}
