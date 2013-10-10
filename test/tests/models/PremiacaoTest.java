package tests.models;

import controleatleta.Premiacao;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PremiacaoTest {
	private Premiacao premiacao;

	@Before
	public void setUp() throws Exception {
		this.premiacao = new Premiacao("Enter the Matrix", 1999);
	}

	@Test
	public void testGetSetTitulo() {
		this.premiacao.setTitulo("Mighty Boxer 2012");
		assertEquals("Mighty Boxer 2012", this.premiacao.getTitulo());
	}

	@Test
	public void testGetSetAno() {
		this.premiacao.setAno(2012);
		assertEquals(2012, this.premiacao.getAno());
	}

	@Test
	public void testToString() {
		this.premiacao.setTitulo("Enter the Matrix");
		this.premiacao.setAno(1999);
		assertEquals("1999 - Enter the Matrix", this.premiacao.toString());
	}

}