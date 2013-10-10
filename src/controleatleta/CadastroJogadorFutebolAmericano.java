/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo Lima
 */
public class CadastroJogadorFutebolAmericano extends javax.swing.JFrame {
    
    private JogadorFutebolAmericano umJogadorFutebolAmericano;
    private boolean modoAlteracao;
    private boolean novoRegistro;
    private DefaultListModel telefonesListModel;
    private DefaultListModel premiacaoListModel;
    private final byte SEXO_MASCULINO_INDICE = 0;
    private final byte SEXO_FEMININO_INDICE = 1;
    private final char SEXO_MASCULINO_VALOR = 'M';
    private final char SEXO_FEMININO_VALOR = 'F';
    private final byte CATEGORIA_AMADOR_INDICE = 0;
    private final byte CATEGORIA_PROFISSIONAL_INDICE = 1;
    private final char CATEGORIA_AMADOR_VALOR = 'A';
    private final char CATEGORIA_PROFISSIONAL_VALOR = 'P';
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private ControleJogadorFutebolAmericano controleJogadorFutebolAmericano;
    /* private final byte ESTILO_ORTODOXO_INDICE = 0;
     * private final byte ESTILO_SOUTHPAW_INDICE = 1;
     * private final char ESTILO_ORTODOXO_VALOR = 'O';
     * private final char ESTILO_SOUTHPAW_VALOR = 'S';*/

    /**
     * Creates new form CadastroJogadorFutebolAmericano
     */
    public CadastroJogadorFutebolAmericano() {
        initComponents();
        this.habilitarDesabilitarCampos();
        this.controleJogadorFutebolAmericano = new ControleJogadorFutebolAmericano();
        this.telefonesListModel = new DefaultListModel();
        this.listaTelefones.setModel(telefonesListModel);
        this.premiacaoListModel = new DefaultListModel();
        this.listaPremiacoes.setModel(premiacaoListModel);
        this.tabelaListaJogadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void limparCampos() {
        campoTextoNome.setText(null);
        campoTextoAltura.setText("0.0");
        campoTextoBairro.setText(null);
        campoTextoCep.setText(null);
        campoTextoCidade.setText(null);
        campoTextoComplemento.setText(null);
        campoTextoCpf.setText(null);
        campoTextoDataNascimento.setText(null);
        campoTextoLogradouro.setText(null);
        campoTextoNome.setText(null);
        campoTextoNomeMae.setText(null);
        campoTextoNomePai.setText(null);
        campoTextoNumero.setText("0");
        campoTextoPais.setText(null);
        campoTextoPeso.setText("0.0");
        campoTextoRg.setText(null);
        campoTextoTime.setText(null);
        campoTextoTotalDerrotas.setText("0");
        campoTextoTotalEmpates.setText("0");
        campoTextoTotalPartidas.setText("0");
        campoTextoTotalVitorias.setText("0");
        comboBoxSexo.setSelectedIndex(0);
        comboBoxCategoria.setSelectedIndex(0);
        comboBoxPosicao.setSelectedIndex(0);
        comboBoxEstado.setSelectedIndex(0);
        checkBoxAgilidade.setSelected(false);
        checkBoxBoaVisaoDeJogo.setSelected(false);
        checkBoxBomControleDeBola.setSelected(false);
        checkBoxBomPasse.setSelected(false);
        checkBoxBomPreparoFisico.setSelected(false);
        checkBoxLeituraPosicionamento.setSelected(false);
        checkBoxForca.setSelected(false);
        
        
    }

    private void habilitarDesabilitarCampos() {
        boolean registroSelecionado = (umJogadorFutebolAmericano != null);
        campoTextoAltura.setEnabled(modoAlteracao);
        campoTextoBairro.setEnabled(modoAlteracao);
        campoTextoCep.setEnabled(modoAlteracao);
        campoTextoCidade.setEnabled(modoAlteracao);
        campoTextoComplemento.setEnabled(modoAlteracao);
        campoTextoCpf.setEnabled(modoAlteracao);
        campoTextoTime.setEnabled(modoAlteracao);
        campoTextoDataNascimento.setEnabled(modoAlteracao);
        comboBoxEstado.setEnabled(modoAlteracao);
        campoTextoLogradouro.setEnabled(modoAlteracao);
        campoTextoNome.setEnabled(modoAlteracao);
        campoTextoNomeMae.setEnabled(modoAlteracao);
        campoTextoNomePai.setEnabled(modoAlteracao);
        campoTextoNumero.setEnabled(modoAlteracao);
        campoTextoPais.setEnabled(modoAlteracao);
        campoTextoPeso.setEnabled(modoAlteracao);
        campoTextoRg.setEnabled(modoAlteracao);
        campoTextoTotalDerrotas.setEnabled(modoAlteracao);
        campoTextoTotalEmpates.setEnabled(modoAlteracao);
        campoTextoTotalPartidas.setEnabled(modoAlteracao);
        campoTextoTotalVitorias.setEnabled(modoAlteracao);
        botaoNovo.setEnabled(modoAlteracao == false);
        botaoAlterar.setEnabled(modoAlteracao == false && registroSelecionado == true);
        botaoExcluir.setEnabled(modoAlteracao == false && registroSelecionado == true);
        botaoPesquisar.setEnabled(modoAlteracao == false);
        botaoSalvar.setEnabled(modoAlteracao);
        botaoCancelar.setEnabled(modoAlteracao);
        botaoAdicionarTelefone.setEnabled(modoAlteracao);
        botaoRemoverTelefone.setEnabled(modoAlteracao);
        botaoAdicionarPremiacoes.setEnabled(modoAlteracao);
        botaoRemoverPremiacoes.setEnabled(modoAlteracao);
        comboBoxSexo.setEnabled(modoAlteracao);
        comboBoxPosicao.setEnabled(modoAlteracao);
        comboBoxCategoria.setEnabled(modoAlteracao);
        jScrollPane3.setEnabled(modoAlteracao);
        jScrollPane1.setEnabled(modoAlteracao);
        tabelaListaJogadores.setEnabled(modoAlteracao == false);
    }
    
    private void preencherCampos() {
        
        ArrayList<String> telefones;
        ArrayList<Premiacao> premiacoes;

        campoTextoAltura.setText(Double.toString(umJogadorFutebolAmericano.getAltura()));
        campoTextoBairro.setText(umJogadorFutebolAmericano.getEndereco().getBairro());
        campoTextoCep.setText(umJogadorFutebolAmericano.getEndereco().getCep());
        campoTextoCidade.setText(umJogadorFutebolAmericano.getEndereco().getCidade());
        campoTextoComplemento.setText(umJogadorFutebolAmericano.getEndereco().getComplemento());
        campoTextoCpf.setText(umJogadorFutebolAmericano.getCpf());
       
        if (umJogadorFutebolAmericano.getDataNascimento() == null) {
            campoTextoDataNascimento.setText(null);
        } else {
            campoTextoDataNascimento.setText(dateFormat.format(umJogadorFutebolAmericano.getDataNascimento()));
        }
        comboBoxEstado.setSelectedItem(umJogadorFutebolAmericano.getEndereco().getEstado());
        campoTextoLogradouro.setText(umJogadorFutebolAmericano.getEndereco().getLogradouro());
        campoTextoNome.setText(umJogadorFutebolAmericano.getNome());
        comboBoxPosicao.setSelectedItem(umJogadorFutebolAmericano.getPosicao());
        campoTextoNomeMae.setText(umJogadorFutebolAmericano.getNomeMae());
        campoTextoTime.setText(umJogadorFutebolAmericano.getTime());
        campoTextoNomePai.setText(umJogadorFutebolAmericano.getNomePai());
        campoTextoNumero.setText(umJogadorFutebolAmericano.getEndereco().getNumero().toString());
        campoTextoPais.setText(umJogadorFutebolAmericano.getEndereco().getPais());
        campoTextoPeso.setText(Double.toString(umJogadorFutebolAmericano.getPeso()));
        campoTextoRg.setText(umJogadorFutebolAmericano.getRg());
        campoTextoTotalDerrotas.setText(Integer.toString(umJogadorFutebolAmericano.getTotalDerrotas()));
        campoTextoTotalEmpates.setText(Integer.toString(umJogadorFutebolAmericano.getTotalEmpates()));
        campoTextoTotalVitorias.setText(Integer.toString(umJogadorFutebolAmericano.getTotalVitorias()));

        telefonesListModel.clear();
        telefones = umJogadorFutebolAmericano.getTelefones();
        
        for (String t : telefones) {
            telefonesListModel.addElement(t);
        }

        premiacaoListModel.clear();
        premiacoes = umJogadorFutebolAmericano.getPremiacoes();
        
        for (Premiacao p : premiacoes) {
            premiacaoListModel.addElement(p);
        }

        switch (umJogadorFutebolAmericano.getSexo()) {
            case SEXO_MASCULINO_VALOR:
                comboBoxSexo.setSelectedIndex(SEXO_MASCULINO_INDICE);
                break;
            case SEXO_FEMININO_VALOR:
                comboBoxSexo.setSelectedIndex(SEXO_FEMININO_INDICE);
                break;
        }

        switch (umJogadorFutebolAmericano.getCategoria()) {
            case CATEGORIA_AMADOR_VALOR:
                comboBoxCategoria.setSelectedIndex(CATEGORIA_AMADOR_INDICE);
                break;
            case CATEGORIA_PROFISSIONAL_VALOR:
                comboBoxCategoria.setSelectedIndex(CATEGORIA_PROFISSIONAL_INDICE);
                break;
        }
    }
    
    private void exibirInformacao(String info) {
        JOptionPane.showMessageDialog(this, info, "Atenção", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private boolean validarCampos() {
        if (campoTextoNome.getText().trim().length() == 0) {
            this.exibirInformacao("O valor do campo 'Nome' não foi informado.");
            campoTextoNome.requestFocus();
            return false;
        }
        if (campoTextoCpf.getText().trim().length() == 0) {
            this.exibirInformacao("O valor do campo 'CPF' não foi informado.");
            campoTextoCpf.requestFocus();
            return false;
        }
        if (campoTextoRg.getText().trim().length() == 0) {
            this.exibirInformacao("O valor do campo 'RG' não foi informado.");
            campoTextoRg.requestFocus();
            return false;
        }
        if (comboBoxSexo.getSelectedIndex() == (0)) {
            this.exibirInformacao("O sexo, na aba Informações Gerais, não foi selecionado.");
            return false;
        }
        if (comboBoxEstado.getSelectedIndex() == (0)) {
            this.exibirInformacao("O estado, na aba Endereço, não foi selecionado.");
            return false;
        }
        if (comboBoxCategoria.getSelectedIndex() == (0)) {
            this.exibirInformacao("A Categoria, na aba Ficha Técnica, não foi selecionada.");
            return false;
        }
        if (comboBoxPosicao.getSelectedIndex() == (0)) {
            this.exibirInformacao("A posição, na aba Ficha Técnica, não foi selecionada.");
            return false;
        }
        if (campoTextoDataNascimento.getText().length() != 0) {
            try {
                dateFormat.parse(campoTextoDataNascimento.getText());
            } catch (ParseException ex) {
                this.exibirInformacao("O valor 'Data de Nascimento' é inválido.");
                campoTextoDataNascimento.requestFocus();
                return false;
            }
        }
        try {
            Double.parseDouble(campoTextoAltura.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Altura' é inválido.");
            campoTextoAltura.requestFocus();
            return false;
        }
        try {
            Double.parseDouble(campoTextoPeso.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Peso' é inválido.");
            campoTextoPeso.requestFocus();
            return false;
        }
        if (!campoTextoNumero.getText().equals("")) {
            try {
                Integer.parseInt(campoTextoNumero.getText());
            } catch (Exception ex) {
                this.exibirInformacao("O valor do campo 'Número' é inválido.");
                campoTextoNumero.requestFocus();
                return false;
            }
        }
        try {
            Integer.parseInt(campoTextoTotalDerrotas.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Total de Derrotas' é inválido.");
            campoTextoTotalDerrotas.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(campoTextoTotalEmpates.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Total de Empates' é inválido.");
            campoTextoTotalEmpates.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(campoTextoTotalVitorias.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Total de Vitórias' é inválido.");
            campoTextoTotalVitorias.requestFocus();
            return false;
        }
        return true;
    }
    
    private void salvarRegistro() {
        Endereco endereco;
        ArrayList<String> telefones;
        ArrayList<Premiacao> premiacoes;
        Date dataNascimento;

        if (this.validarCampos() == false) {
            return;
        }

        if (campoTextoDataNascimento.getText().length() == 0) {
            dataNascimento = null;
        } else {
            try {
                dataNascimento = dateFormat.parse(campoTextoDataNascimento.getText());
            } catch (ParseException ex) {
                exibirInformacao("Falha ao gravar a data de nascimento: " + ex.toString());
                return;
            }
        }

        endereco = new Endereco();
        endereco.setBairro(campoTextoBairro.getText());
        endereco.setCep(campoTextoCep.getText());
        endereco.setCidade(campoTextoCidade.getText());
        endereco.setComplemento(campoTextoComplemento.getText());
        endereco.setEstado((String) comboBoxEstado.getSelectedItem());
        endereco.setLogradouro(campoTextoLogradouro.getText());
        endereco.setNumero(campoTextoNumero.getText());
        endereco.setPais(campoTextoPais.getText());

        telefones = new ArrayList<String>();
        for (int i = 0; i < telefonesListModel.size(); i++) {
            telefones.add(telefonesListModel.getElementAt(i).toString());
        }

        premiacoes = new ArrayList<Premiacao>();
        for (int i = 0; i < premiacaoListModel.size(); i++) {
            Premiacao premiacao = (Premiacao) premiacaoListModel.getElementAt(i);
            premiacoes.add(premiacao);
        }

        if (novoRegistro == true) {
            umJogadorFutebolAmericano = new JogadorFutebolAmericano(campoTextoNome.getText());
        } else {
            umJogadorFutebolAmericano.setNome(campoTextoNome.getText());
        }
        umJogadorFutebolAmericano.setEndereco(endereco);
        umJogadorFutebolAmericano.setTelefones(telefones);
        umJogadorFutebolAmericano.setPremiacoes(premiacoes);
        umJogadorFutebolAmericano.setDataNascimento(dataNascimento);
        umJogadorFutebolAmericano.setAltura(Double.parseDouble(campoTextoAltura.getText()));
        umJogadorFutebolAmericano.setNomeMae(campoTextoNomeMae.getText());
        umJogadorFutebolAmericano.setNomePai(campoTextoNomePai.getText());
        umJogadorFutebolAmericano.setTime(campoTextoTime.getText());
        umJogadorFutebolAmericano.setPeso(Double.parseDouble(campoTextoPeso.getText()));
        umJogadorFutebolAmericano.setCpf(campoTextoCpf.getText());
        umJogadorFutebolAmericano.setRg(campoTextoRg.getText());
        umJogadorFutebolAmericano.setTotalDerrotas(Integer.parseInt(campoTextoTotalDerrotas.getText()));
        umJogadorFutebolAmericano.setTotalEmpates(Integer.parseInt(campoTextoTotalEmpates.getText()));
        umJogadorFutebolAmericano.setTotalVitorias(Integer.parseInt(campoTextoTotalVitorias.getText()));

        switch (comboBoxSexo.getSelectedIndex()) {
            case SEXO_MASCULINO_INDICE:
                umJogadorFutebolAmericano.setSexo(SEXO_MASCULINO_VALOR);
                break;
            case SEXO_FEMININO_INDICE:
                umJogadorFutebolAmericano.setSexo(SEXO_FEMININO_VALOR);
                break;
        }

        switch (comboBoxCategoria.getSelectedIndex()) {
            case CATEGORIA_AMADOR_INDICE:
                umJogadorFutebolAmericano.setCategoria(CATEGORIA_AMADOR_VALOR);
                break;
            case CATEGORIA_PROFISSIONAL_INDICE:
                umJogadorFutebolAmericano.setCategoria(CATEGORIA_PROFISSIONAL_VALOR);
                break;
        }

        /*switch (comboBoxPosicao.getSelectedIndex()) {
         * case ESTILO_ORTODOXO_INDICE:
         * umJogadorFutebolAmericano.setEstilo(ESTILO_ORTODOXO_VALOR);
         * break;
         * case ESTILO_SOUTHPAW_INDICE:
         * umJogadorFutebolAmericano.setEstilo(ESTILO_SOUTHPAW_VALOR);
         * break;
         * }*/

        if (novoRegistro == true) {
            controleJogadorFutebolAmericano.adicionar(umJogadorFutebolAmericano);
        }
        modoAlteracao = false;
        novoRegistro = false;
        this.carregarListaJogadoresFutebolAmericano();
        this.habilitarDesabilitarCampos();
    }
    
    private void carregarListaJogadoresFutebolAmericano() {
        ArrayList<JogadorFutebolAmericano> listaJogadoresFutebolAmericano = controleJogadorFutebolAmericano.getListaJogadoresFutebolAmericano();
        DefaultTableModel model = (DefaultTableModel) tabelaListaJogadores.getModel();
        model.setRowCount(0);
        for (JogadorFutebolAmericano b : listaJogadoresFutebolAmericano) {
            model.addRow(new String[]{b.getNome(), b.getCpf()});
        }
        tabelaListaJogadores.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDeBotoes = new javax.swing.JPanel();
        botaoNovo = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoPesquisar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        painelLabel = new javax.swing.JPanel();
        labelListaJogadoresFutebolAmericano = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        painelInformacoesAtleta = new javax.swing.JTabbedPane();
        painelInformacoesGerais = new javax.swing.JPanel();
        nome = new javax.swing.JLabel();
        campoTextoNome = new javax.swing.JTextField();
        dataNascimento = new javax.swing.JLabel();
        campoTextoDataNascimento = new javax.swing.JTextField();
        sexo = new javax.swing.JLabel();
        altura = new javax.swing.JLabel();
        campoTextoAltura = new javax.swing.JTextField();
        peso = new javax.swing.JLabel();
        campoTextoPeso = new javax.swing.JTextField();
        comboBoxSexo = new javax.swing.JComboBox();
        nomePai = new javax.swing.JLabel();
        campoTextoNomePai = new javax.swing.JTextField();
        nomeMae = new javax.swing.JLabel();
        campoTextoNomeMae = new javax.swing.JTextField();
        Rg = new javax.swing.JLabel();
        campoTextoRg = new javax.swing.JTextField();
        Cpf = new javax.swing.JLabel();
        campoTextoCpf = new javax.swing.JTextField();
        telefones = new javax.swing.JLabel();
        FormatoData = new javax.swing.JLabel();
        botaoAdicionarTelefone = new javax.swing.JButton();
        botaoRemoverTelefone = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaTelefones = new javax.swing.JList();
        painelEndereco = new javax.swing.JPanel();
        logradouro = new javax.swing.JLabel();
        numero = new javax.swing.JLabel();
        complemento = new javax.swing.JLabel();
        bairro = new javax.swing.JLabel();
        cidade = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        campoTextoLogradouro = new javax.swing.JTextField();
        campoTextoNumero = new javax.swing.JTextField();
        campoTextoComplemento = new javax.swing.JTextField();
        campoTextoBairro = new javax.swing.JTextField();
        campoTextoCidade = new javax.swing.JTextField();
        comboBoxEstado = new javax.swing.JComboBox();
        pais = new javax.swing.JLabel();
        cep = new javax.swing.JLabel();
        campoTextoCep = new javax.swing.JTextField();
        campoTextoPais = new javax.swing.JTextField();
        painelFichaTecnica = new javax.swing.JPanel();
        categoria = new javax.swing.JLabel();
        posicao = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        totalPartidas = new javax.swing.JLabel();
        totalVitorias = new javax.swing.JLabel();
        totalDerrotas = new javax.swing.JLabel();
        totalEmpates = new javax.swing.JLabel();
        agilidade = new javax.swing.JLabel();
        forca = new javax.swing.JLabel();
        leituraPosicionamento = new javax.swing.JLabel();
        bomPreparoFisico = new javax.swing.JLabel();
        campoTextoTime = new javax.swing.JTextField();
        campoTextoTotalPartidas = new javax.swing.JTextField();
        campoTextoTotalVitorias = new javax.swing.JTextField();
        campoTextoTotalDerrotas = new javax.swing.JTextField();
        campoTextoTotalEmpates = new javax.swing.JTextField();
        checkBoxAgilidade = new javax.swing.JCheckBox();
        checkBoxForca = new javax.swing.JCheckBox();
        checkBoxBomPreparoFisico = new javax.swing.JCheckBox();
        bomControleDeBola = new javax.swing.JLabel();
        bomPasse = new javax.swing.JLabel();
        boaVisaoDeJogo = new javax.swing.JLabel();
        checkBoxBomControleDeBola = new javax.swing.JCheckBox();
        checkBoxBomPasse = new javax.swing.JCheckBox();
        checkBoxBoaVisaoDeJogo = new javax.swing.JCheckBox();
        comboBoxPosicao = new javax.swing.JComboBox();
        premiacoes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPremiacoes = new javax.swing.JList();
        comboBoxCategoria = new javax.swing.JComboBox();
        botaoAdicionarPremiacoes = new javax.swing.JButton();
        botaoRemoverPremiacoes = new javax.swing.JButton();
        checkBoxLeituraPosicionamento = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaListaJogadores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoNovo.setText("Novo");
        botaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoActionPerformed(evt);
            }
        });

        botaoAlterar.setText("Alterar");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoPesquisar.setText("Pesquisar...");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        labelListaJogadoresFutebolAmericano.setText("Lista de jogadores de futebol americano:");

        javax.swing.GroupLayout painelLabelLayout = new javax.swing.GroupLayout(painelLabel);
        painelLabel.setLayout(painelLabelLayout);
        painelLabelLayout.setHorizontalGroup(
            painelLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelListaJogadoresFutebolAmericano)
        );
        painelLabelLayout.setVerticalGroup(
            painelLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelListaJogadoresFutebolAmericano)
        );

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDeBotoesLayout = new javax.swing.GroupLayout(painelDeBotoes);
        painelDeBotoes.setLayout(painelDeBotoesLayout);
        painelDeBotoesLayout.setHorizontalGroup(
            painelDeBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDeBotoesLayout.createSequentialGroup()
                .addComponent(botaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(painelDeBotoesLayout.createSequentialGroup()
                .addComponent(painelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        painelDeBotoesLayout.setVerticalGroup(
            painelDeBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDeBotoesLayout.createSequentialGroup()
                .addGroup(painelDeBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoNovo)
                    .addComponent(botaoAlterar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoPesquisar)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        nome.setText("Nome:");

        campoTextoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoNomeActionPerformed(evt);
            }
        });

        dataNascimento.setText("Data de Nascimento:");

        sexo.setText("Sexo:");

        altura.setText("Altura:");

        campoTextoAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoAlturaActionPerformed(evt);
            }
        });

        peso.setText("Peso:");

        comboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar", "Masculino", "Feminino" }));
        comboBoxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSexoActionPerformed(evt);
            }
        });

        nomePai.setText("Nome do Pai:");

        campoTextoNomePai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoNomePaiActionPerformed(evt);
            }
        });

        nomeMae.setText("Nome do Mãe:");

        Rg.setText("RG:");

        campoTextoRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoRgActionPerformed(evt);
            }
        });

        Cpf.setText("CPF:");

        campoTextoCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoCpfActionPerformed(evt);
            }
        });

        telefones.setText("Telefones");

        FormatoData.setText("DD/MM/AAAA");

        botaoAdicionarTelefone.setText("+");
        botaoAdicionarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarTelefoneActionPerformed(evt);
            }
        });

        botaoRemoverTelefone.setText("-");

        jScrollPane3.setViewportView(listaTelefones);

        javax.swing.GroupLayout painelInformacoesGeraisLayout = new javax.swing.GroupLayout(painelInformacoesGerais);
        painelInformacoesGerais.setLayout(painelInformacoesGeraisLayout);
        painelInformacoesGeraisLayout.setHorizontalGroup(
            painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInformacoesGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nome)
                    .addComponent(dataNascimento)
                    .addComponent(sexo)
                    .addComponent(nomePai)
                    .addComponent(nomeMae)
                    .addComponent(Rg)
                    .addComponent(Cpf)
                    .addComponent(telefones))
                .addGap(52, 52, 52)
                .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelInformacoesGeraisLayout.createSequentialGroup()
                        .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelInformacoesGeraisLayout.createSequentialGroup()
                                .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoTextoDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                    .addComponent(comboBoxSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FormatoData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(altura)
                                .addGap(5, 5, 5)
                                .addComponent(campoTextoAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(peso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoTextoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelInformacoesGeraisLayout.createSequentialGroup()
                                .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(campoTextoCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                        .addComponent(campoTextoRg, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoRemoverTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botaoAdicionarTelefone))))
                        .addGap(42, 42, 42))
                    .addGroup(painelInformacoesGeraisLayout.createSequentialGroup()
                        .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTextoNome)
                            .addComponent(campoTextoNomePai)
                            .addComponent(campoTextoNomeMae))
                        .addContainerGap())))
        );
        painelInformacoesGeraisLayout.setVerticalGroup(
            painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInformacoesGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome)
                    .addComponent(campoTextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataNascimento)
                    .addComponent(campoTextoDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(altura)
                    .addComponent(campoTextoAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peso)
                    .addComponent(campoTextoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FormatoData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sexo)
                    .addComponent(comboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomePai)
                    .addComponent(campoTextoNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeMae)
                    .addComponent(campoTextoNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Rg)
                    .addComponent(campoTextoRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cpf)
                    .addComponent(campoTextoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelInformacoesGeraisLayout.createSequentialGroup()
                        .addComponent(botaoAdicionarTelefone)
                        .addGap(35, 35, 35)
                        .addComponent(botaoRemoverTelefone))
                    .addComponent(telefones)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        painelInformacoesAtleta.addTab("Informações Gerais", painelInformacoesGerais);

        logradouro.setText("Logradouro:");

        numero.setText("Número:");

        complemento.setText("Complemento:");

        bairro.setText("Bairro:");

        cidade.setText("Cidade:");

        estado.setText("Estado:");

        campoTextoComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoComplementoActionPerformed(evt);
            }
        });

        campoTextoCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoCidadeActionPerformed(evt);
            }
        });

        comboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        comboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEstadoActionPerformed(evt);
            }
        });

        pais.setText("País:");

        cep.setText("CEP:");

        javax.swing.GroupLayout painelEnderecoLayout = new javax.swing.GroupLayout(painelEndereco);
        painelEndereco.setLayout(painelEnderecoLayout);
        painelEnderecoLayout.setHorizontalGroup(
            painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEnderecoLayout.createSequentialGroup()
                        .addComponent(cep)
                        .addGap(155, 155, 155)
                        .addComponent(campoTextoCep, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelEnderecoLayout.createSequentialGroup()
                        .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logradouro)
                            .addComponent(numero)
                            .addComponent(complemento)
                            .addComponent(bairro)
                            .addComponent(cidade)
                            .addComponent(estado)
                            .addComponent(pais))
                        .addGap(109, 109, 109)
                        .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoTextoLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                                .addComponent(campoTextoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoTextoCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(campoTextoBairro)
                                .addComponent(campoTextoComplemento))
                            .addComponent(comboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTextoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        painelEnderecoLayout.setVerticalGroup(
            painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logradouro)
                    .addComponent(campoTextoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numero)
                    .addComponent(campoTextoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complemento)
                    .addComponent(campoTextoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bairro)
                    .addComponent(campoTextoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidade)
                    .addComponent(campoTextoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estado)
                    .addComponent(comboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pais)
                    .addComponent(campoTextoPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cep)
                    .addComponent(campoTextoCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(193, Short.MAX_VALUE))
        );

        painelInformacoesAtleta.addTab("Endereço", painelEndereco);

        categoria.setText("Categoria:");

        posicao.setText("Posição:");

        time.setText("Time:");

        totalPartidas.setText("Total de partidas:");

        totalVitorias.setText("Total de vitórias");

        totalDerrotas.setText("Total de derrotas:");

        totalEmpates.setText("Total de empates:");

        agilidade.setText("Agilidade:");

        forca.setText("Força:");

        leituraPosicionamento.setText("Leitura de Posicionamento:");

        bomPreparoFisico.setText("Bom preparo físico:");

        campoTextoTotalPartidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoTotalPartidasActionPerformed(evt);
            }
        });

        checkBoxAgilidade.setText("Sim");
        checkBoxAgilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxAgilidadeActionPerformed(evt);
            }
        });

        checkBoxForca.setText("Sim");

        checkBoxBomPreparoFisico.setText("Sim");

        bomControleDeBola.setText("Bom controle de bola:");

        bomPasse.setText("Bom Passe:");

        boaVisaoDeJogo.setText("Boa Visão de jogo:");

        checkBoxBomControleDeBola.setText("Sim");

        checkBoxBomPasse.setText("Sim");

        checkBoxBoaVisaoDeJogo.setText("Sim");

        comboBoxPosicao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar", "Tackle", "Defensive End", "Linebacker", "Cornerback", "Safety", "Wide Receiver", "Ofensive Tackle", "Guard", "Center", "Tight End", "Quarterback", "Fullback", "Halfback" }));

        premiacoes.setText("Premiações:");

        jScrollPane1.setViewportView(listaPremiacoes);

        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar", "Amador", "Professional" }));
        comboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCategoriaActionPerformed(evt);
            }
        });

        botaoAdicionarPremiacoes.setText("+");
        botaoAdicionarPremiacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarPremiacoesActionPerformed(evt);
            }
        });

        botaoRemoverPremiacoes.setText("-");
        botaoRemoverPremiacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverPremiacoesActionPerformed(evt);
            }
        });

        checkBoxLeituraPosicionamento.setText("Sim");

        javax.swing.GroupLayout painelFichaTecnicaLayout = new javax.swing.GroupLayout(painelFichaTecnica);
        painelFichaTecnica.setLayout(painelFichaTecnicaLayout);
        painelFichaTecnicaLayout.setHorizontalGroup(
            painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFichaTecnicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelFichaTecnicaLayout.createSequentialGroup()
                        .addComponent(premiacoes)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelFichaTecnicaLayout.createSequentialGroup()
                        .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoria)
                            .addComponent(posicao)
                            .addComponent(time)
                            .addComponent(totalPartidas)
                            .addComponent(totalVitorias)
                            .addComponent(totalDerrotas)
                            .addComponent(totalEmpates))
                        .addGap(24, 24, 24)
                        .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxPosicao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoTextoTime)
                            .addComponent(campoTextoTotalPartidas)
                            .addComponent(campoTextoTotalVitorias)
                            .addComponent(campoTextoTotalDerrotas)
                            .addComponent(campoTextoTotalEmpates)
                            .addComponent(comboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bomControleDeBola)
                            .addComponent(bomPreparoFisico)
                            .addComponent(leituraPosicionamento)
                            .addComponent(bomPasse)
                            .addComponent(boaVisaoDeJogo)
                            .addComponent(forca)
                            .addComponent(agilidade))
                        .addGap(54, 54, 54)
                        .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxForca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxAgilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxLeituraPosicionamento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxBomControleDeBola, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxBoaVisaoDeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxBomPasse, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxBomPreparoFisico, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelFichaTecnicaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoAdicionarPremiacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(botaoRemoverPremiacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(42, Short.MAX_VALUE))))
        );
        painelFichaTecnicaLayout.setVerticalGroup(
            painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFichaTecnicaLayout.createSequentialGroup()
                .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoria)
                    .addComponent(agilidade)
                    .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxAgilidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(forca, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(posicao)
                        .addComponent(comboBoxPosicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBoxForca)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(time)
                        .addComponent(campoTextoTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(leituraPosicionamento)
                        .addComponent(checkBoxLeituraPosicionamento)))
                .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFichaTecnicaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bomPreparoFisico)
                            .addComponent(checkBoxBomPreparoFisico))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bomControleDeBola, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxBomControleDeBola))
                        .addGap(7, 7, 7))
                    .addGroup(painelFichaTecnicaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalPartidas)
                            .addComponent(campoTextoTotalPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalVitorias)
                            .addComponent(campoTextoTotalVitorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)))
                .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalDerrotas)
                    .addComponent(campoTextoTotalDerrotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bomPasse)
                    .addComponent(checkBoxBomPasse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalEmpates)
                    .addComponent(campoTextoTotalEmpates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boaVisaoDeJogo)
                    .addComponent(checkBoxBoaVisaoDeJogo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(premiacoes)
                .addGap(9, 9, 9)
                .addGroup(painelFichaTecnicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelFichaTecnicaLayout.createSequentialGroup()
                        .addComponent(botaoAdicionarPremiacoes)
                        .addGap(16, 16, 16)
                        .addComponent(botaoRemoverPremiacoes))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        painelInformacoesAtleta.addTab("Ficha Técnica", painelFichaTecnica);

        tabelaListaJogadores.setModel(new javax.swing.table.DefaultTableModel 
            (
                null,
                new String [] {
                    "Nome", "CPF"
                }
            )
            {
                @Override    
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            });
            jScrollPane2.setViewportView(tabelaListaJogadores);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelDeBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelInformacoesAtleta)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane2)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(painelDeBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelInformacoesAtleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed
        // TODO add your handling code here:
        umJogadorFutebolAmericano = null;
        modoAlteracao = true;
        novoRegistro = true;
        this.limparCampos();
        this.habilitarDesabilitarCampos();    
    }//GEN-LAST:event_botaoNovoActionPerformed

    private void campoTextoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoNomeActionPerformed

    private void campoTextoAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoAlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoAlturaActionPerformed

    private void comboBoxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSexoActionPerformed

    private void campoTextoNomePaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoNomePaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoNomePaiActionPerformed

    private void campoTextoRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoRgActionPerformed

    private void campoTextoCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoCpfActionPerformed

    private void campoTextoComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoComplementoActionPerformed

    private void campoTextoCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoCidadeActionPerformed

    private void checkBoxAgilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxAgilidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxAgilidadeActionPerformed

    private void campoTextoTotalPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoTotalPartidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoTotalPartidasActionPerformed

    private void comboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxEstadoActionPerformed

    private void botaoAdicionarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarTelefoneActionPerformed
        CadastroTelefone cadastro = new CadastroTelefone(this, true);
        cadastro.setVisible(true);
        if (cadastro.getTelefone() != null) {
            telefonesListModel.addElement(cadastro.getTelefone());
        }
        cadastro.dispose();
    }//GEN-LAST:event_botaoAdicionarTelefoneActionPerformed

    private void comboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCategoriaActionPerformed

    private void botaoRemoverPremiacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverPremiacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoRemoverPremiacoesActionPerformed

    private void botaoAdicionarPremiacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarPremiacoesActionPerformed
        CadastroPremiacao cadastro = new CadastroPremiacao(this, true);
        cadastro.setVisible(true);
        if (cadastro.getPremiacao() != null) {
            premiacaoListModel.addElement(cadastro.getPremiacao());
        }
        cadastro.dispose();
    }//GEN-LAST:event_botaoAdicionarPremiacoesActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        if (novoRegistro == true) {
            this.limparCampos();
        } else {
            this.preencherCampos();
        }
        modoAlteracao = false;
        novoRegistro = false;
        this.habilitarDesabilitarCampos();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        this.salvarRegistro();
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        modoAlteracao = true;
        novoRegistro = false;
        this.habilitarDesabilitarCampos();
        this.campoTextoNome.requestFocus();
    }//GEN-LAST:event_botaoAlterarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        this.controleJogadorFutebolAmericano.remover(umJogadorFutebolAmericano);
        umJogadorFutebolAmericano = null;
        this.limparCampos();
        this.carregarListaJogadoresFutebolAmericano();
        this.habilitarDesabilitarCampos();
        
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        String pesquisa = JOptionPane.showInputDialog("Informe o nome do Jogador.");
        if (pesquisa != null) {
            this.pesquisarJogadorFutebolAmericano(pesquisa);
    }//GEN-LAST:event_botaoPesquisarActionPerformed
    }
    private void pesquisarJogadorFutebolAmericano(String nome){
        
        JogadorFutebolAmericano jogadorPesquisado = controleJogadorFutebolAmericano.pesquisar(nome);

        if (jogadorPesquisado == null) {
            exibirInformacao("Jogador nao encontrado.");
        } else {
            this.umJogadorFutebolAmericano = jogadorPesquisado;
            this.preencherCampos();
            this.habilitarDesabilitarCampos();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroJogadorFutebolAmericano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroJogadorFutebolAmericano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroJogadorFutebolAmericano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroJogadorFutebolAmericano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroJogadorFutebolAmericano().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cpf;
    private javax.swing.JLabel FormatoData;
    private javax.swing.JLabel Rg;
    private javax.swing.JLabel agilidade;
    private javax.swing.JLabel altura;
    private javax.swing.JLabel bairro;
    private javax.swing.JLabel boaVisaoDeJogo;
    private javax.swing.JLabel bomControleDeBola;
    private javax.swing.JLabel bomPasse;
    private javax.swing.JLabel bomPreparoFisico;
    private javax.swing.JButton botaoAdicionarPremiacoes;
    private javax.swing.JButton botaoAdicionarTelefone;
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoRemoverPremiacoes;
    private javax.swing.JButton botaoRemoverTelefone;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoTextoAltura;
    private javax.swing.JTextField campoTextoBairro;
    private javax.swing.JTextField campoTextoCep;
    private javax.swing.JTextField campoTextoCidade;
    private javax.swing.JTextField campoTextoComplemento;
    private javax.swing.JTextField campoTextoCpf;
    private javax.swing.JTextField campoTextoDataNascimento;
    private javax.swing.JTextField campoTextoLogradouro;
    private javax.swing.JTextField campoTextoNome;
    private javax.swing.JTextField campoTextoNomeMae;
    private javax.swing.JTextField campoTextoNomePai;
    private javax.swing.JTextField campoTextoNumero;
    private javax.swing.JTextField campoTextoPais;
    private javax.swing.JTextField campoTextoPeso;
    private javax.swing.JTextField campoTextoRg;
    private javax.swing.JTextField campoTextoTime;
    private javax.swing.JTextField campoTextoTotalDerrotas;
    private javax.swing.JTextField campoTextoTotalEmpates;
    private javax.swing.JTextField campoTextoTotalPartidas;
    private javax.swing.JTextField campoTextoTotalVitorias;
    private javax.swing.JLabel categoria;
    private javax.swing.JLabel cep;
    private javax.swing.JCheckBox checkBoxAgilidade;
    private javax.swing.JCheckBox checkBoxBoaVisaoDeJogo;
    private javax.swing.JCheckBox checkBoxBomControleDeBola;
    private javax.swing.JCheckBox checkBoxBomPasse;
    private javax.swing.JCheckBox checkBoxBomPreparoFisico;
    private javax.swing.JCheckBox checkBoxForca;
    private javax.swing.JCheckBox checkBoxLeituraPosicionamento;
    private javax.swing.JLabel cidade;
    private javax.swing.JComboBox comboBoxCategoria;
    private javax.swing.JComboBox comboBoxEstado;
    private javax.swing.JComboBox comboBoxPosicao;
    private javax.swing.JComboBox comboBoxSexo;
    private javax.swing.JLabel complemento;
    private javax.swing.JLabel dataNascimento;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel forca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelListaJogadoresFutebolAmericano;
    private javax.swing.JLabel leituraPosicionamento;
    private javax.swing.JList listaPremiacoes;
    private javax.swing.JList listaTelefones;
    private javax.swing.JLabel logradouro;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel nomeMae;
    private javax.swing.JLabel nomePai;
    private javax.swing.JLabel numero;
    private javax.swing.JPanel painelDeBotoes;
    private javax.swing.JPanel painelEndereco;
    private javax.swing.JPanel painelFichaTecnica;
    private javax.swing.JTabbedPane painelInformacoesAtleta;
    private javax.swing.JPanel painelInformacoesGerais;
    private javax.swing.JPanel painelLabel;
    private javax.swing.JLabel pais;
    private javax.swing.JLabel peso;
    private javax.swing.JLabel posicao;
    private javax.swing.JLabel premiacoes;
    private javax.swing.JLabel sexo;
    private javax.swing.JTable tabelaListaJogadores;
    private javax.swing.JLabel telefones;
    private javax.swing.JLabel time;
    private javax.swing.JLabel totalDerrotas;
    private javax.swing.JLabel totalEmpates;
    private javax.swing.JLabel totalPartidas;
    private javax.swing.JLabel totalVitorias;
    // End of variables declaration//GEN-END:variables

}
