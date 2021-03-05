package br.com.cem.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.cem.Campeonato.Clube;
import br.com.cem.Campeonato.ClubeDAO;
import br.com.cem.Campeonato.Partida;
import br.com.cem.Campeonato.PartidaDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdicionarPartida extends JFrame {
	
	Clube clube = new Clube(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	ClubeDAO dao = new ClubeDAO();
	Partida part = new Partida(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	PartidaDAO pdao = new PartidaDAO();

	
	
	private JPanel contentPane;
	private JTextField textFieldPesquisa;
	private JTextField textFieldNome;
	private JTextField textFieldID;
	private JTextField textFieldIDCasa;
	private JTextField textFieldIDVisitante;
	private JTextField textFieldGolsCasa;
	private JTextField textFieldGolsVisitante;
	private JTextField textFieldCartA_Casa;
	private JTextField textFieldCartV_Casa;
	private JTextField textFieldCartA_Visitante;
	private JTextField textFieldCartV_Visitante;
	private JTextField textFieldRodada;
	private JTextField textFieldNumPartida;
	private JLabel lblNewLabel;
	private JLabel lblIdVisitante;
	private JLabel lblGolsCasa;
	private JLabel lblGolsVisitante;
	private JLabel lblCartaoACasa;
	private JLabel lblNumeroDaPartida;
	private JLabel lblNumeroDaRodada;
	private JLabel lblCartaoVVisitante;
	private JLabel lblCartaoAVisitante;
	private JLabel lblCartaoVCasa;
	private JLabel lblEmpates;
	private JTextField textFieldEEmpateCasa;
	private JLabel lblDerrotas;
	private JTextField textFieldDerrotaCasa;
	private JLabel lblVitrias;
	private JTextField textFieldVitoriaCasa;
	private JTextField textFieldGolsContraCasa;
	private JTextField textFieldPontoCasa;
	private JLabel lblGolsContra;
	private JLabel lblPontos;
	private JLabel lblQuantidadeDeJogos;
	private JTextField textFieldJogoCasa;
	private JLabel lblGolsPro;
	private JTextField textFieldGolsProCasa;
	private JTextField textFieldDifGolsCasa;
	private JLabel lblDiferenasDeGols;
	private JComboBox comboBoxEstadoCasa;
	private JLabel lblEstadoDoClube_1;
	private JLabel lblNomeDoClube_1;
	private JTextField textFieldNomeCasa;
	private JTextField textFieldIDCASA1;
	private JLabel lblId_1;
	private JLabel lblEmpates_1;
	private JTextField textFieldEmpateV;
	private JLabel lblDerrotas_1;
	private JTextField textFieldDerrotaV;
	private JLabel lblVitrias_1;
	private JTextField textFieldVitoriaV;
	private JTextField textFieldGolsContraV;
	private JTextField textFieldPontoV;
	private JLabel lblGolsContra_1;
	private JLabel lblPontos_1;
	private JLabel lblQuantidadeDeJogos_1;
	private JTextField textFieldJogoV;
	private JLabel lblGolsPro_1;
	private JTextField textFieldGolsProV;
	private JTextField textFieldDifGolsV;
	private JLabel lblDiferenasDeGols_1;
	private JComboBox comboBoxEstadoV;
	private JLabel lblEstadoDoClube_2;
	private JLabel lblNomeDoClube_2;
	private JTextField textFieldNomeV;
	private JTextField textFieldIDV;
	private JLabel lblId_2;
	private JButton btnEditar;
	private JTextField textFieldNomeC;
	private JTextField textFieldNomeVisit;
	private JButton btnNewButton;
	private JLabel lblCasa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarPartida frame = new AdicionarPartida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdicionarPartida() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		textFieldPesquisa = new JTextField();
		textFieldPesquisa.setBounds(61, 30, 206, 20);
		textFieldPesquisa.setColumns(10);
		contentPane.add(textFieldPesquisa);
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(151, 86, 48, 20);
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF"}));
		contentPane.add(comboBoxEstado);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(309, 29, 89, 23);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clube.setPesquisa(textFieldPesquisa.getText());
				Clube model = dao.PesquisarClube(clube);
				textFieldNome.setText(model.getNome());
				comboBoxEstado.setSelectedItem(model.getEstado());
				
				textFieldID.setText(String.valueOf(model.getIdClube()));
			}
		});
		contentPane.add(btnPesquisar);
		
		JLabel lblNomeDoClube = new JLabel("Nome do Clube:");
		lblNomeDoClube.setBounds(36, 61, 105, 14);
		lblNomeDoClube.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblNomeDoClube);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(151, 59, 130, 20);
		textFieldNome.setEditable(false);
		textFieldNome.setColumns(10);
		contentPane.add(textFieldNome);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(345, 59, 53, 20);
		textFieldID.setEditable(false);
		textFieldID.setColumns(10);
		contentPane.add(textFieldID);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(316, 61, 57, 14);
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblId);
		
		JLabel lblEstadoDoClube = new JLabel("Estado do Clube:");
		lblEstadoDoClube.setBounds(30, 88, 105, 14);
		lblEstadoDoClube.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblEstadoDoClube);
		
		textFieldIDCasa = new JTextField();
		textFieldIDCasa.setEnabled(false);
		textFieldIDCasa.setBounds(84, 181, 37, 20);
		contentPane.add(textFieldIDCasa);
		textFieldIDCasa.setColumns(10);
		
		textFieldIDVisitante = new JTextField();
		textFieldIDVisitante.setEnabled(false);
		textFieldIDVisitante.setBounds(84, 212, 37, 20);
		contentPane.add(textFieldIDVisitante);
		textFieldIDVisitante.setColumns(10);
		
		textFieldGolsCasa = new JTextField();
		textFieldGolsCasa.setEnabled(false);
		textFieldGolsCasa.setBounds(84, 243, 37, 20);
		contentPane.add(textFieldGolsCasa);
		textFieldGolsCasa.setColumns(10);
		
		textFieldGolsVisitante = new JTextField();
		textFieldGolsVisitante.setEnabled(false);
		textFieldGolsVisitante.setBounds(84, 274, 37, 20);
		contentPane.add(textFieldGolsVisitante);
		textFieldGolsVisitante.setColumns(10);
		
		textFieldCartA_Casa = new JTextField();
		textFieldCartA_Casa.setEnabled(false);
		textFieldCartA_Casa.setBounds(318, 181, 37, 20);
		contentPane.add(textFieldCartA_Casa);
		textFieldCartA_Casa.setColumns(10);
		
		textFieldCartV_Casa = new JTextField();
		textFieldCartV_Casa.setEnabled(false);
		textFieldCartV_Casa.setBounds(318, 212, 37, 20);
		contentPane.add(textFieldCartV_Casa);
		textFieldCartV_Casa.setColumns(10);
		
		textFieldCartA_Visitante = new JTextField();
		textFieldCartA_Visitante.setEnabled(false);
		textFieldCartA_Visitante.setBounds(318, 243, 37, 20);
		contentPane.add(textFieldCartA_Visitante);
		textFieldCartA_Visitante.setColumns(10);
		
		textFieldCartV_Visitante = new JTextField();
		textFieldCartV_Visitante.setEnabled(false);
		textFieldCartV_Visitante.setBounds(318, 274, 37, 20);
		contentPane.add(textFieldCartV_Visitante);
		textFieldCartV_Visitante.setColumns(10);
		
		textFieldRodada = new JTextField();
		textFieldRodada.setEnabled(false);
		textFieldRodada.setBounds(318, 305, 37, 20);
		contentPane.add(textFieldRodada);
		textFieldRodada.setColumns(10);
		
		textFieldNumPartida = new JTextField();
		textFieldNumPartida.setEnabled(false);
		textFieldNumPartida.setBounds(318, 340, 37, 20);
		contentPane.add(textFieldNumPartida);
		textFieldNumPartida.setColumns(10);
		
		
		
		lblNewLabel = new JLabel("ID Casa:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 183, 64, 14);
		contentPane.add(lblNewLabel);
		
		lblIdVisitante = new JLabel("ID Visitante:");
		lblIdVisitante.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblIdVisitante.setBounds(10, 214, 89, 14);
		contentPane.add(lblIdVisitante);
		
		lblGolsCasa = new JLabel("Gols Casa:");
		lblGolsCasa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGolsCasa.setBounds(20, 245, 79, 14);
		contentPane.add(lblGolsCasa);
		
		lblGolsVisitante = new JLabel("Gols Visitante:");
		lblGolsVisitante.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGolsVisitante.setBounds(0, 276, 84, 14);
		contentPane.add(lblGolsVisitante);
		
		lblCartaoACasa = new JLabel("Cartao amarelos casa:");
		lblCartaoACasa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCartaoACasa.setBounds(184, 183, 196, 14);
		contentPane.add(lblCartaoACasa);
		
		lblNumeroDaPartida = new JLabel("Numero da Partida:");
		lblNumeroDaPartida.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNumeroDaPartida.setBounds(196, 342, 242, 14);
		contentPane.add(lblNumeroDaPartida);
		
		lblNumeroDaRodada = new JLabel("Numero da Rodada:");
		lblNumeroDaRodada.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNumeroDaRodada.setBounds(196, 307, 150, 14);
		contentPane.add(lblNumeroDaRodada);
		
		lblCartaoVVisitante = new JLabel("Cart\u00F5es vermelhos visitante:");
		lblCartaoVVisitante.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCartaoVVisitante.setBounds(150, 276, 184, 14);
		contentPane.add(lblCartaoVVisitante);
		
		lblCartaoAVisitante = new JLabel("Cart\u00F5es amarelos visitante:");
		lblCartaoAVisitante.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCartaoAVisitante.setBounds(159, 245, 216, 14);
		contentPane.add(lblCartaoAVisitante);
		
		lblCartaoVCasa = new JLabel("Cart\u00F5es vermelhos casa:");
		lblCartaoVCasa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCartaoVCasa.setBounds(171, 214, 184, 14);
		contentPane.add(lblCartaoVCasa);
		
		lblEmpates = new JLabel("Empates:\r\n");
		lblEmpates.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmpates.setBounds(598, 215, 105, 14);
		contentPane.add(lblEmpates);
		
		textFieldEEmpateCasa = new JTextField();
		textFieldEEmpateCasa.setColumns(10);
		textFieldEEmpateCasa.setBounds(668, 213, 53, 20);
		contentPane.add(textFieldEEmpateCasa);
		
		lblDerrotas = new JLabel("Derrotas:\r\n");
		lblDerrotas.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDerrotas.setBounds(598, 181, 105, 14);
		contentPane.add(lblDerrotas);
		
		textFieldDerrotaCasa = new JTextField();
		textFieldDerrotaCasa.setColumns(10);
		textFieldDerrotaCasa.setBounds(668, 181, 53, 20);
		contentPane.add(textFieldDerrotaCasa);
		
		lblVitrias = new JLabel("Vit\u00F3rias:");
		lblVitrias.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblVitrias.setBounds(598, 150, 105, 14);
		contentPane.add(lblVitrias);
		
		textFieldVitoriaCasa = new JTextField();
		textFieldVitoriaCasa.setColumns(10);
		textFieldVitoriaCasa.setBounds(668, 150, 53, 20);
		contentPane.add(textFieldVitoriaCasa);
		
		textFieldGolsContraCasa = new JTextField();
		textFieldGolsContraCasa.setColumns(10);
		textFieldGolsContraCasa.setBounds(862, 119, 53, 20);
		contentPane.add(textFieldGolsContraCasa);
		
		textFieldPontoCasa = new JTextField();
		textFieldPontoCasa.setColumns(10);
		textFieldPontoCasa.setBounds(668, 119, 53, 20);
		contentPane.add(textFieldPontoCasa);
		
		lblGolsContra = new JLabel("Gols Contra:");
		lblGolsContra.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGolsContra.setBounds(785, 121, 105, 14);
		contentPane.add(lblGolsContra);
		
		lblPontos = new JLabel("Pontos:\r\n");
		lblPontos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPontos.setBounds(598, 119, 105, 14);
		contentPane.add(lblPontos);
		
		lblQuantidadeDeJogos = new JLabel("Partidas Jogadas:\r\n");
		lblQuantidadeDeJogos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQuantidadeDeJogos.setBounds(548, 90, 105, 18);
		contentPane.add(lblQuantidadeDeJogos);
		
		textFieldJogoCasa = new JTextField();
		textFieldJogoCasa.setColumns(10);
		textFieldJogoCasa.setBounds(668, 88, 53, 20);
		contentPane.add(textFieldJogoCasa);
		
		lblGolsPro = new JLabel("Gols Pro:");
		lblGolsPro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGolsPro.setBounds(803, 90, 105, 14);
		contentPane.add(lblGolsPro);
		
		textFieldGolsProCasa = new JTextField();
		textFieldGolsProCasa.setColumns(10);
		textFieldGolsProCasa.setBounds(862, 90, 53, 20);
		contentPane.add(textFieldGolsProCasa);
		
		textFieldDifGolsCasa = new JTextField();
		textFieldDifGolsCasa.setColumns(10);
		textFieldDifGolsCasa.setBounds(862, 63, 53, 20);
		contentPane.add(textFieldDifGolsCasa);
		
		lblDiferenasDeGols = new JLabel("Diferen\u00E7as de Gols:");
		lblDiferenasDeGols.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiferenasDeGols.setBounds(743, 61, 185, 14);
		contentPane.add(lblDiferenasDeGols);
		
		comboBoxEstadoCasa = new JComboBox();
		comboBoxEstadoCasa.setEditable(true);
		comboBoxEstadoCasa.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF"}));
		comboBoxEstadoCasa.setBounds(668, 57, 48, 20);
		contentPane.add(comboBoxEstadoCasa);
		
		lblEstadoDoClube_1 = new JLabel("Estado do Clube:");
		lblEstadoDoClube_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEstadoDoClube_1.setBounds(547, 59, 105, 14);
		contentPane.add(lblEstadoDoClube_1);
		
		lblNomeDoClube_1 = new JLabel("Nome do Clube:");
		lblNomeDoClube_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNomeDoClube_1.setBounds(553, 32, 105, 14);
		contentPane.add(lblNomeDoClube_1);
		
		textFieldNomeCasa = new JTextField();
		textFieldNomeCasa.setColumns(10);
		textFieldNomeCasa.setBounds(668, 30, 130, 20);
		contentPane.add(textFieldNomeCasa);
		
		textFieldIDCASA1 = new JTextField();
		textFieldIDCASA1.setEditable(false);
		textFieldIDCASA1.setColumns(10);
		textFieldIDCASA1.setBounds(152, 117, 28, 20);
		contentPane.add(textFieldIDCASA1);
		
		lblId_1 = new JLabel("ID:");
		lblId_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblId_1.setBounds(833, 32, 57, 14);
		contentPane.add(lblId_1);
		
		lblEmpates_1 = new JLabel("Empates:\r\n");
		lblEmpates_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmpates_1.setBounds(500, 454, 105, 14);
		contentPane.add(lblEmpates_1);
		
		textFieldEmpateV = new JTextField();
		textFieldEmpateV.setColumns(10);
		textFieldEmpateV.setBounds(570, 452, 53, 20);
		contentPane.add(textFieldEmpateV);
		
		lblDerrotas_1 = new JLabel("Derrotas:\r\n");
		lblDerrotas_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDerrotas_1.setBounds(500, 420, 105, 14);
		contentPane.add(lblDerrotas_1);
		
		textFieldDerrotaV = new JTextField();
		textFieldDerrotaV.setColumns(10);
		textFieldDerrotaV.setBounds(570, 420, 53, 20);
		contentPane.add(textFieldDerrotaV);
		
		lblVitrias_1 = new JLabel("Vit\u00F3rias:");
		lblVitrias_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblVitrias_1.setBounds(500, 389, 105, 14);
		contentPane.add(lblVitrias_1);
		
		textFieldVitoriaV = new JTextField();
		textFieldVitoriaV.setColumns(10);
		textFieldVitoriaV.setBounds(570, 389, 53, 20);
		contentPane.add(textFieldVitoriaV);
		
		textFieldGolsContraV = new JTextField();
		textFieldGolsContraV.setColumns(10);
		textFieldGolsContraV.setBounds(764, 358, 53, 20);
		contentPane.add(textFieldGolsContraV);
		
		textFieldPontoV = new JTextField();
		textFieldPontoV.setColumns(10);
		textFieldPontoV.setBounds(570, 358, 53, 20);
		contentPane.add(textFieldPontoV);
		
		lblGolsContra_1 = new JLabel("Gols Contra:");
		lblGolsContra_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGolsContra_1.setBounds(687, 360, 105, 14);
		contentPane.add(lblGolsContra_1);
		
		lblPontos_1 = new JLabel("Pontos:\r\n");
		lblPontos_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPontos_1.setBounds(500, 358, 105, 14);
		contentPane.add(lblPontos_1);
		
		lblQuantidadeDeJogos_1 = new JLabel("Partidas Jogadas:\r\n");
		lblQuantidadeDeJogos_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQuantidadeDeJogos_1.setBounds(549, 337, 105, 18);
		contentPane.add(lblQuantidadeDeJogos_1);
		
		textFieldJogoV = new JTextField();
		textFieldJogoV.setColumns(10);
		textFieldJogoV.setBounds(669, 335, 53, 20);
		contentPane.add(textFieldJogoV);
		
		lblGolsPro_1 = new JLabel("Gols Pro:");
		lblGolsPro_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGolsPro_1.setBounds(804, 337, 105, 14);
		contentPane.add(lblGolsPro_1);
		
		textFieldGolsProV = new JTextField();
		textFieldGolsProV.setColumns(10);
		textFieldGolsProV.setBounds(863, 337, 53, 20);
		contentPane.add(textFieldGolsProV);
		
		textFieldDifGolsV = new JTextField();
		textFieldDifGolsV.setColumns(10);
		textFieldDifGolsV.setBounds(863, 310, 53, 20);
		contentPane.add(textFieldDifGolsV);
		
		lblDiferenasDeGols_1 = new JLabel("Diferen\u00E7as de Gols:");
		lblDiferenasDeGols_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiferenasDeGols_1.setBounds(744, 308, 185, 14);
		contentPane.add(lblDiferenasDeGols_1);
		
		comboBoxEstadoV = new JComboBox();
		comboBoxEstadoV.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF"}));
		comboBoxEstadoV.setEditable(true);
		comboBoxEstadoV.setBounds(669, 304, 48, 20);
		contentPane.add(comboBoxEstadoV);
		
		lblEstadoDoClube_2 = new JLabel("Estado do Clube:");
		lblEstadoDoClube_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEstadoDoClube_2.setBounds(548, 306, 105, 14);
		contentPane.add(lblEstadoDoClube_2);
		
		lblNomeDoClube_2 = new JLabel("Nome do Clube:");
		lblNomeDoClube_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNomeDoClube_2.setBounds(554, 279, 105, 14);
		contentPane.add(lblNomeDoClube_2);
		
		textFieldNomeV = new JTextField();
		textFieldNomeV.setColumns(10);
		textFieldNomeV.setBounds(669, 277, 130, 20);
		contentPane.add(textFieldNomeV);
		
		textFieldIDV = new JTextField();
		textFieldIDV.setEditable(false);
		textFieldIDV.setColumns(10);
		textFieldIDV.setBounds(377, 118, 31, 20);
		contentPane.add(textFieldIDV);
		
		lblId_2 = new JLabel("ID:");
		lblId_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblId_2.setBounds(834, 279, 57, 14);
		contentPane.add(lblId_2);
		
		
		
		textFieldNomeC = new JTextField();
		textFieldNomeC.setBounds(50, 117, 130, 20);
		contentPane.add(textFieldNomeC);
		textFieldNomeC.setColumns(10);
		
		textFieldNomeVisit = new JTextField();
		textFieldNomeVisit.setBounds(279, 118, 129, 20);
		contentPane.add(textFieldNomeVisit);
		textFieldNomeVisit.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		
		JButton btnEscolherClube = new JButton("Escolher Clube");
		btnEscolherClube.setEnabled(false);
		btnEscolherClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clube.setPesquisa(textFieldNomeVisit.getText());
				Clube model = dao.PesquisarClube(clube);
				textFieldNomeV.setText(model.getNome());
				comboBoxEstadoV.setSelectedItem(model.getEstado());
				
				textFieldIDV.setText(String.valueOf(model.getIdClube()));
				
				textFieldJogoV.setText((String.valueOf(model.getJogo())));
				
				textFieldPontoV.setText(String.valueOf(model.getPonto()));
				
				textFieldVitoriaV.setText(String.valueOf(model.getVitorias()));
				
				textFieldDerrotaV.setText(String.valueOf(model.getDerrotas()));
				
				textFieldEmpateV.setText(String.valueOf(model.getEmpates()));
				
				textFieldGolsProV.setText(String.valueOf(model.getGolsPro()));
				
				textFieldGolsContraV.setText(String.valueOf(model.getGolsContra()));
				
				textFieldDifGolsV.setText(String.valueOf(model.getDifGols()));
				
				textFieldIDCasa.setEnabled(true);
				textFieldIDVisitante.setEnabled(true);
				textFieldGolsCasa.setEnabled(true);
				textFieldGolsVisitante.setEnabled(true);
				textFieldCartA_Casa.setEnabled(true);
				textFieldCartA_Visitante.setEnabled(true);
				textFieldCartV_Casa.setEnabled(true);
				textFieldCartV_Visitante.setEnabled(true);
				textFieldNumPartida.setEnabled(true);
				textFieldRodada.setEnabled(true);
				btnSalvar.setEnabled(true);
				JOptionPane.showMessageDialog(null, "Clube escolhido");
			}
		});
		btnEscolherClube.setBounds(279, 148, 130, 23);
		contentPane.add(btnEscolherClube);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			part.setId_Casa(Integer.parseInt(textFieldIDCasa.getText()));
				part.setId_Visitante(Integer.parseInt(textFieldIDVisitante.getText()));
				part.setGolsCasa(Integer.parseInt(textFieldGolsCasa.getText()));
				part.setGolsVisitante(Integer.parseInt(textFieldGolsVisitante.getText()));
				part.setCartA_Casa(Integer.parseInt(textFieldCartA_Casa.getText()));
				part.setCartA_Visitante(Integer.parseInt(textFieldCartA_Visitante.getText()));
				part.setCartV_Casa(Integer.parseInt(textFieldCartV_Casa.getText()));
				part.setCartV_Visitante(Integer.parseInt(textFieldCartV_Visitante.getText()));
				part.setNumPartida(Integer.parseInt(textFieldNumPartida.getText()));
				part.setRodada(Integer.parseInt(textFieldRodada.getText()));
				pdao.Salvar(part);
				
				//alteracao do time casa
				clube.setIdClube((Integer.parseInt(textFieldIDCASA1.getText())));
				clube.setNome(textFieldNomeCasa.getText());
				clube.setEstado(comboBoxEstadoCasa.getSelectedItem().toString());
				
				
				clube.setJogo(Integer.parseInt(textFieldJogoCasa.getText())+1);
				
				//Conversao dos valores
				int golsCasa;
				int golsVisitante;
				
				String golsC = textFieldGolsCasa.getText();
				golsCasa = Integer.parseInt(golsC);
				String golsV = textFieldGolsVisitante.getText();
				golsVisitante = Integer.parseInt(golsV);
				
				if(golsCasa > golsVisitante){
				clube.setPonto((Integer.parseInt(textFieldPontoCasa.getText()))+3);
				}else if(golsCasa == golsVisitante){
					clube.setPonto((Integer.parseInt(textFieldPontoCasa.getText()))+1);
				}else{
					clube.setPonto((Integer.parseInt(textFieldPontoCasa.getText()))+0);
				}
				
				if(golsCasa > golsVisitante){
				clube.setVitorias((Integer.parseInt(textFieldVitoriaCasa.getText()))+1);
				}else{
					clube.setVitorias((Integer.parseInt(textFieldVitoriaCasa.getText()))+0);
				}
				
				if(golsVisitante > golsCasa){
				clube.setDerrotas((Integer.parseInt(textFieldDerrotaCasa.getText()))+1);
				}else{
					clube.setDerrotas((Integer.parseInt(textFieldDerrotaCasa.getText()))+0);
				}
				
				if(golsCasa == golsVisitante){
				clube.setEmpates((Integer.parseInt(textFieldEEmpateCasa.getText()))+1);
				}else{
					clube.setEmpates((Integer.parseInt(textFieldEEmpateCasa.getText()))+0);
				}
				
				clube.setGolsPro((Integer.parseInt(textFieldGolsProCasa.getText()))+golsCasa);
				
				clube.setGolsContra((Integer.parseInt(textFieldGolsContraCasa.getText()))+golsVisitante);
			
				clube.setDifGols((Integer.parseInt(textFieldDifGolsCasa.getText()))+(golsCasa-golsVisitante));
				
				dao.Editar(clube);
				
			
//Alterar os dados do clube visitante
				
				clube.setIdClube((Integer.parseInt(textFieldIDV.getText())));
				clube.setNome(textFieldNomeV.getText());
				clube.setEstado(comboBoxEstadoV.getSelectedItem().toString());
				
				
				clube.setJogo(Integer.parseInt(textFieldJogoV.getText())+1);
				
				
				
				if(golsCasa < golsVisitante){
				clube.setPonto((Integer.parseInt(textFieldPontoV.getText()))+3);
				}else if(golsCasa == golsVisitante){
					clube.setPonto((Integer.parseInt(textFieldPontoV.getText()))+1);
				}else{
					clube.setPonto((Integer.parseInt(textFieldPontoV.getText()))+0);
				}
				
				if(golsCasa < golsVisitante){
				clube.setVitorias((Integer.parseInt(textFieldVitoriaV.getText()))+1);
				}else{
					clube.setVitorias((Integer.parseInt(textFieldVitoriaV.getText()))+0);
				}
				
				if(golsVisitante < golsCasa){
				clube.setDerrotas((Integer.parseInt(textFieldDerrotaV.getText()))+1);
				}else{
					clube.setDerrotas((Integer.parseInt(textFieldDerrotaV.getText()))+0);
				}
				
				if(golsCasa == golsVisitante){
				clube.setEmpates((Integer.parseInt(textFieldEmpateV.getText()))+1);
				}else{
					clube.setEmpates((Integer.parseInt(textFieldEmpateV.getText()))+0);
				}
				
				clube.setGolsPro((Integer.parseInt(textFieldGolsProV.getText()))+golsVisitante);
				
				clube.setGolsContra((Integer.parseInt(textFieldGolsContraV.getText()))+golsCasa);
			
				clube.setDifGols((Integer.parseInt(textFieldDifGolsV.getText()))+(golsVisitante-golsCasa));
				
				dao.Editar(clube);
		
				
				//Tirando o valor dos campos
				textFieldCartA_Casa.setText(null);
				textFieldCartA_Visitante.setText(null);
				textFieldCartV_Casa.setText(null);
				textFieldCartV_Visitante.setText(null);
				textFieldDerrotaCasa.setText(null);
				textFieldDerrotaV.setText(null);
				textFieldDifGolsCasa.setText(null);
				textFieldDifGolsV.setText(null);
				textFieldEEmpateCasa.setText(null);
				textFieldEmpateV.setText(null);
				textFieldGolsCasa.setText(null);
				textFieldGolsContraCasa.setText(null);
				textFieldGolsContraV.setText(null);
				textFieldGolsProCasa.setText(null);
				textFieldGolsProV.setText(null);
				textFieldGolsVisitante.setText(null);
				textFieldID.setText(null);
				textFieldIDCasa.setText(null);
				textFieldIDCASA1.setText(null);
				textFieldIDV.setText(null);
				textFieldIDVisitante.setText(null);
				textFieldJogoCasa.setText(null);
				textFieldJogoV.setText(null);
				textFieldNome.setText(null);
				textFieldNomeC.setText(null);
				textFieldNomeCasa.setText(null);
				textFieldNomeV.setText(null);
				textFieldNomeVisit.setText(null);
				textFieldNumPartida.setText(null);
				textFieldPesquisa.setText(null);
				textFieldPontoCasa.setText(null);
				textFieldPontoV.setText(null);
				textFieldRodada.setText(null);
				textFieldVitoriaCasa.setText(null);
				textFieldVitoriaV.setText(null);
				
				//Desativando campos para inserir dados de outra partida
				textFieldIDCasa.setEnabled(false);
				textFieldIDVisitante.setEnabled(false);
				textFieldGolsCasa.setEnabled(false);
				textFieldGolsVisitante.setEnabled(false);
				textFieldCartA_Casa.setEnabled(false);
				textFieldCartA_Visitante.setEnabled(false);
				textFieldCartV_Casa.setEnabled(false);
				textFieldCartV_Visitante.setEnabled(false);
				textFieldNumPartida.setEnabled(false);
				textFieldRodada.setEnabled(false);
				btnSalvar.setEnabled(false);
				btnEscolherClube.setEnabled(false);
				
				JOptionPane.showMessageDialog(null, "Dados Salvos!");
			}
		});
		btnSalvar.setBounds(378, 242, 89, 23);
		contentPane.add(btnSalvar);
		
	
		
		btnEditar = new JButton("Escolher Clube ");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			clube.setPesquisa(textFieldNomeC.getText());
			Clube model = dao.PesquisarClube(clube);
			textFieldNomeCasa.setText(model.getNome());
			comboBoxEstadoCasa.setSelectedItem(model.getEstado());
			
			textFieldIDCASA1.setText(String.valueOf(model.getIdClube()));
			
			textFieldJogoCasa.setText(String.valueOf(model.getJogo()));
			
			textFieldPontoCasa.setText(String.valueOf(model.getPonto()));
			
			textFieldVitoriaCasa.setText(String.valueOf(model.getVitorias()));
			
			textFieldDerrotaCasa.setText(String.valueOf(model.getDerrotas()));
			
			textFieldEEmpateCasa.setText(String.valueOf(model.getEmpates()));
			
			textFieldGolsProCasa.setText(String.valueOf(model.getGolsPro()));
			
			textFieldGolsContraCasa.setText(String.valueOf(model.getGolsContra()));
			
			textFieldDifGolsCasa.setText(String.valueOf(model.getDifGols()));
			
			btnEscolherClube.setEnabled(true);
			//JOptionPane.showMessageDialog(null, "Clube escolhido");
			}
		});
	
		btnEditar.setBounds(50, 147, 130, 23);
		contentPane.add(btnEditar);
		
		btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inicial ini = new Inicial();
				ini.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 74, 23);
		contentPane.add(btnNewButton);
		
		lblCasa = new JLabel("Casa:");
		lblCasa.setBounds(13, 120, 46, 14);
		contentPane.add(lblCasa);
		
		JLabel lblVisitante = new JLabel("Visitante:");
		lblVisitante.setBounds(220, 121, 177, 14);
		contentPane.add(lblVisitante);
		
	}
}
