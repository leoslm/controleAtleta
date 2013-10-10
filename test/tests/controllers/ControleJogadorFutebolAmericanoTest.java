package tests.controllers;

import controleatleta.ControleJogadorFutebolAmericano;
import controleatleta.JogadorFutebolAmericano;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ControleJogadorFutebolAmericanoTest {
	private ControleJogadorFutebolAmericano controle;


	@Before
	public void setUp() throws Exception {
		this.controle = new ControleJogadorFutebolAmericano();
	}

	@Test
	public void testGetListaJogadoresFutebolAmericano() {
		JogadorFutebolAmericano J1 = new JogadorFutebolAmericano("J1");
		JogadorFutebolAmericano J2 = new JogadorFutebolAmericano("J2");
                JogadorFutebolAmericano J3 = new JogadorFutebolAmericano("J3");

		this.controle.adicionar(J1);
		this.controle.adicionar(J2);
		this.controle.adicionar(J3);

		ArrayList<JogadorFutebolAmericano> lista1 = this.controle.getListaJogadoresFutebolAmericano();
		ArrayList<JogadorFutebolAmericano> lista2 = new ArrayList<JogadorFutebolAmericano>();
		lista2.add(J1);
		lista2.add(J2);
		lista2.add(J3);

		assertEquals(lista1, lista2);
	}

	@Test
	public void testAdicionar() {
		JogadorFutebolAmericano J1 = new JogadorFutebolAmericano("J1");
		ArrayList<JogadorFutebolAmericano> lista;

		this.controle.adicionar(J1);
		lista = this.controle.getListaJogadoresFutebolAmericano();

		assertEquals(J1, lista.get(0));
	}

	@Test
	public void testRemover() {
		JogadorFutebolAmericano J1 = new JogadorFutebolAmericano("J1");
		JogadorFutebolAmericano J2 = new JogadorFutebolAmericano("J2");
                JogadorFutebolAmericano J3 = new JogadorFutebolAmericano("J3");

		this.controle.adicionar(J1);
		this.controle.adicionar(J2);
		this.controle.adicionar(J3);

		assertEquals(3, this.controle.getListaJogadoresFutebolAmericano().size());
		this.controle.remover(J1);
		assertEquals(2, this.controle.getListaJogadoresFutebolAmericano().size());
		this.controle.remover(J2);
		assertEquals(1, this.controle.getListaJogadoresFutebolAmericano().size());
		this.controle.remover(J3);
		assertEquals(0, this.controle.getListaJogadoresFutebolAmericano().size());
	}



	@Test
	public void testPesquisar() {
		JogadorFutebolAmericano J1 = new JogadorFutebolAmericano("J1");
		JogadorFutebolAmericano J2 = new JogadorFutebolAmericano("J2");
		JogadorFutebolAmericano J3 = new JogadorFutebolAmericano("J3");
		this.controle.adicionar(J1);
		this.controle.adicionar(J2);
		this.controle.adicionar(J3);

		assertEquals(J1, this.controle.pesquisar("J1"));
		assertEquals(J2, this.controle.pesquisar("J2"));
		assertEquals(J3, this.controle.pesquisar("J3"));
	}
}