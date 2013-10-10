package controleatleta;

import java.util.ArrayList;

public class ControleJogadorFutebolAmericano {

    private ArrayList<JogadorFutebolAmericano> listaJogadoresFutebolAmericano;

    public ControleJogadorFutebolAmericano() {
        this.listaJogadoresFutebolAmericano = new ArrayList<JogadorFutebolAmericano>();
    }
    
    public ArrayList<JogadorFutebolAmericano> getListaJogadoresFutebolAmericano() {
        return listaJogadoresFutebolAmericano;
    }
    
    public void adicionar(JogadorFutebolAmericano umJogadorFutebolAmericano) {
        listaJogadoresFutebolAmericano.add(umJogadorFutebolAmericano);
    }
    
    public void remover(JogadorFutebolAmericano umJogadorFutebolAmericano) {
        listaJogadoresFutebolAmericano.remove(umJogadorFutebolAmericano);
    }
    
    public JogadorFutebolAmericano pesquisar(String nome) {
        for (JogadorFutebolAmericano b: listaJogadoresFutebolAmericano) {
            if (b.getNome().equalsIgnoreCase(nome)) return b;
        }
        return null;
    }
}