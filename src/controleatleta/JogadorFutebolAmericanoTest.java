package tests.models;

import controleatleta.JogadorFutebolAmericano;
import controleatleta.Premiacao;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class JogadorFutebolAmericanoTest {
	private JogadorFutebolAmericano JogadorFutebolAmericano;
	@Before
	public void setUp() throws Exception {
		this.JogadorFutebolAmericano = new JogadorFutebolAmericano("Abc");
	}

	@Test
	public void testGetSetPremiacoes() {
		ArrayList<Premiacao> premiacoes = new ArrayList<Premiacao>();
		premiacoes.add(new Premiacao("a", 1));
		premiacoes.add(new Premiacao("ab", 12));
		premiacoes.add(new Premiacao("abc", 123));

		this.JogadorFutebolAmericano.setPremiacoes(premiacoes);

		for(int i=0; i < premiacoes.size(); i++) {
			String t = this.JogadorFutebolAmericano.getPremiacoes().get(i).toString();
			assertArrayEquals(premiacoes.get(i).toString(), t);
		}
	}

	@Test
	public void testGetSetPosicao() {
		this.JogadorFutebolAmericano.setPosicao("Quarterback");
		assertEquals("Quarterback", this.JogadorFutebolAmericano.getPosicao());
	}
        
        public void testGetSetTime() {
		this.JogadorFutebolAmericano.setPosicao("Flamengo");
		assertEquals("Flamengo", this.JogadorFutebolAmericano.getTime());
	}

	private void assertArrayEquals(String stringA, String stringB) {
		assertEquals(stringA.length(), stringB.length());

		for(int i = 0; i < stringA.length(); i++)
			assertEquals(stringA.charAt(i), stringB.charAt(i));
	}
}