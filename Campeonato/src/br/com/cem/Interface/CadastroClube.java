package br.com.cem.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexaoBd.ConexaoBD;
import br.com.cem.Campeonato.Clube;
import br.com.cem.Campeonato.ClubeDAO;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroClube extends JFrame {
	
	ConexaoBD con = new ConexaoBD();
	Clube clube = new Clube(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	ClubeDAO dao = new ClubeDAO();

	private JPanel contentPane;
	private JTextField textFieldCadNome;
	private JTextField textFieldCadGolsPro;
	private JTextField textFieldCadDerrotas;
	private JTextField textFieldCadDifGols;
	private JTextField textFieldCadVitorias;
	private JTextField textFieldCadEmpates;
	private JTextField textFieldCadJogos;
	private JTextField textFieldCadGolsContra;
	private JTextField textFieldCadPontos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroClube frame = new CadastroClube();
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
	public CadastroClube() {
		con.Conexao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldCadNome = new JTextField();
		textFieldCadNome.setBounds(126, 47, 177, 20);
		contentPane.add(textFieldCadNome);
		textFieldCadNome.setColumns(10);
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF"}));
		comboBoxEstado.setBounds(126, 89, 53, 20);
		contentPane.add(comboBoxEstado);
		
		textFieldCadGolsPro = new JTextField();
		textFieldCadGolsPro.setBounds(338, 120, 53, 20);
		contentPane.add(textFieldCadGolsPro);
		textFieldCadGolsPro.setColumns(10);
		
		textFieldCadDerrotas = new JTextField();
		textFieldCadDerrotas.setBounds(126, 242, 53, 20);
		contentPane.add(textFieldCadDerrotas);
		textFieldCadDerrotas.setColumns(10);
		
		textFieldCadDifGols = new JTextField();
		textFieldCadDifGols.setBounds(338, 180, 53, 20);
		contentPane.add(textFieldCadDifGols);
		textFieldCadDifGols.setColumns(10);
		
		textFieldCadVitorias = new JTextField();
		textFieldCadVitorias.setBounds(126, 180, 53, 20);
		contentPane.add(textFieldCadVitorias);
		textFieldCadVitorias.setColumns(10);
		
		textFieldCadEmpates = new JTextField();
		textFieldCadEmpates.setBounds(126, 211, 53, 20);
		contentPane.add(textFieldCadEmpates);
		textFieldCadEmpates.setColumns(10);
		
		textFieldCadJogos = new JTextField();
		textFieldCadJogos.setBounds(126, 149, 53, 20);
		contentPane.add(textFieldCadJogos);
		textFieldCadJogos.setColumns(10);
		
		textFieldCadGolsContra = new JTextField();
		textFieldCadGolsContra.setBounds(338, 151, 53, 20);
		contentPane.add(textFieldCadGolsContra);
		textFieldCadGolsContra.setColumns(10);
		
		textFieldCadPontos = new JTextField();
		textFieldCadPontos.setBounds(126, 120, 53, 20);
		contentPane.add(textFieldCadPontos);
		textFieldCadPontos.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome do Clube:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(11, 49, 105, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEstadoDoClube = new JLabel("Estado do Clube:");
		lblEstadoDoClube.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEstadoDoClube.setBounds(10, 91, 105, 14);
		contentPane.add(lblEstadoDoClube);
		
		JLabel lblQuantidadeDeJogos = new JLabel("Partidas Jogadas:\r\n");
		lblQuantidadeDeJogos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQuantidadeDeJogos.setBounds(11, 151, 105, 18);
		contentPane.add(lblQuantidadeDeJogos);
		
		JLabel lblPontos = new JLabel("Pontos:\r\n");
		lblPontos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPontos.setBounds(61, 122, 105, 14);
		contentPane.add(lblPontos);
		
		JLabel lblVitrias = new JLabel("Vit\u00F3rias:");
		lblVitrias.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblVitrias.setBounds(61, 182, 105, 14);
		contentPane.add(lblVitrias);
		
		JLabel lblDerrotas = new JLabel("Derrotas:\r\n");
		lblDerrotas.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDerrotas.setBounds(61, 244, 105, 14);
		contentPane.add(lblDerrotas);
		
		JLabel lblEmpates = new JLabel("Empates:\r\n");
		lblEmpates.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmpates.setBounds(61, 213, 105, 14);
		contentPane.add(lblEmpates);
		
		JLabel lblDiferenasDeGols = new JLabel("Diferen\u00E7as de Gols:");
		lblDiferenasDeGols.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiferenasDeGols.setBounds(206, 182, 185, 14);
		contentPane.add(lblDiferenasDeGols);
		
		JLabel lblGolsPro = new JLabel("Gols Pro:");
		lblGolsPro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGolsPro.setBounds(266, 122, 105, 14);
		contentPane.add(lblGolsPro);
		
		JLabel lblGolsContra = new JLabel("Gols Contra:");
		lblGolsContra.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGolsContra.setBounds(248, 153, 105, 14);
		contentPane.add(lblGolsContra);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clube.setNome(textFieldCadNome.getText());
				clube.setEstado(comboBoxEstado.getSelectedItem().toString());
				
				String jogos = textFieldCadJogos.getText();
				int jogosConvertido = Integer.parseInt(jogos);
				clube.setJogo(jogosConvertido);
				
				String ponto = textFieldCadPontos.getText();
				int pontoConvertido = Integer.parseInt(ponto);
				clube.setPonto(pontoConvertido);
				
				String vitorias = textFieldCadVitorias.getText();
				int vitoriasConvertido = Integer.parseInt(vitorias);
				clube.setVitorias(vitoriasConvertido);
				
				String derrotas = textFieldCadDerrotas.getText();
				int derrotasConvertido = Integer.parseInt(derrotas);
				clube.setDerrotas(derrotasConvertido);
				
				String empates = textFieldCadEmpates.getText();
				int empatesConvertido = Integer.parseInt(empates);
				clube.setEmpates(empatesConvertido);
				
				String golsPro = textFieldCadGolsPro.getText();
				int golsProConvertido = Integer.parseInt(golsPro);
				clube.setGolsPro(golsProConvertido);
				
				String golsContra = textFieldCadGolsContra.getText();
				int golsContraConvertido = Integer.parseInt(golsContra);
				clube.setGolsContra(golsContraConvertido);
				
				String difGols = textFieldCadDifGols.getText();
				int difGolsConvertido = Integer.parseInt(difGols);
				clube.setDifGols(difGolsConvertido);
				dao.Salvar(clube);
				textFieldCadNome.setText("");
				textFieldCadJogos.setText("");
				textFieldCadPontos.setText("");
				textFieldCadVitorias.setText("");
				textFieldCadDerrotas.setText("");
				textFieldCadEmpates.setText("");
				textFieldCadGolsPro.setText("");
				textFieldCadGolsContra.setText("");
				textFieldCadDifGols.setText("");
			}
		});
		btnSalvar.setBounds(282, 223, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inicial tela = new Inicial();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(0, 0, 89, 23);
		contentPane.add(btnVoltar);
	}
}
