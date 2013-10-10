package controleatleta;

import java.util.ArrayList;

/**
 *
 * @author Leonardo Lima
 */
public class JogadorFutebolAmericano extends Atleta {

    private char categoria; // A=Amador P=Profissional
    private ArrayList<Premiacao> premiacoes;
    private int totalPartidas;
    private int totalVitorias;
    private int totalEmpates;
    private int totalDerrotas;
    private int totalLesoes;
    private String time;
    private String posicao;
    private boolean agilidade;
    private boolean forca;
    private boolean leituraDePosicionamento;
    private boolean bomPreparoFisico; 
    private boolean bomControleDeBola;
    private boolean bomPasse;
    private boolean boaVisaoDeJogo;
       

    public JogadorFutebolAmericano(String nome) {
        super(nome);
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public int getTotalDerrotas() {
        return totalDerrotas;
    }

    public void setTotalDerrotas(int derrotas) {
        this.totalDerrotas = derrotas;
    }

    public int getTotalEmpates() {
        return totalEmpates;
    }

    public void setTotalEmpates(int empates) {
        this.totalEmpates = empates;
    }

    public ArrayList<Premiacao> getPremiacoes() {
        return premiacoes;
    }

    public void setPremiacoes(ArrayList<Premiacao> premiacoes) {
        this.premiacoes = premiacoes;
    }

    public int getTotalVitorias() {
        return totalVitorias;
    }

    public void setTotalVitorias(int vitorias) {
        this.totalVitorias = vitorias;
    }

    public int getTotalPartidas() {
        return totalVitorias;
    }

    public void setTotalPartidas(int partidas) {
        this.totalPartidas = partidas;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    
    public boolean getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(boolean agilidade) {
        this.agilidade = agilidade;
    }
    
    public boolean getForca() {
        return forca;
    }

    public void setForca(boolean forca) {
        this.forca = forca;
    }
    
    public boolean getLeituraDePosicionamento() {
        return leituraDePosicionamento;
    }

    public void setLeituraDePosicionamento(boolean leituraDePosicionamento) {
        this.leituraDePosicionamento = leituraDePosicionamento;
    }
    
    public boolean getBomPreparoFisico() {
        return bomPreparoFisico;
    }

    public void setBomPreparoFisico(boolean bomPreparoFisico) {
        this.bomPreparoFisico = bomPreparoFisico;
    }
    
    public boolean getBomControleDeBola() {
        return bomControleDeBola;
    }

    public void setBomControleDeBola(boolean bomControleDeBola) {
        this.bomControleDeBola= bomControleDeBola;
    }
    
    public boolean getBomPasse() {
        return bomPasse;
    }

    public void setBomPasse(boolean bomPasse) {
        this.bomPasse = bomPasse;
    }
    
    public boolean getBoaVisaoDeJogo() {
        return boaVisaoDeJogo;
    }

    public void setBoaVisaoDeJogo(boolean boaVisaoDeJogo) {
        this.boaVisaoDeJogo = boaVisaoDeJogo;
    }
}