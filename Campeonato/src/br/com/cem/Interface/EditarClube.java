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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class EditarClube extends JFrame {

	ConexaoBD con = new ConexaoBD();
	Clube clube = new Clube(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	ClubeDAO dao = new ClubeDAO();
	
	private JPanel contentPane;
	private JTextField textFieldPesquisa;
	private JTextField textFieldNome;
	private JTextField textFieldJogos;
	private JTextField textFieldPontos;
	private JTextField textFieldVitorias;
	private JTextField textFieldDerrotas;
	private JTextField textFieldEmpates;
	private JTextField textFieldGolsPro;
	private JTextField textFieldGolsContra;
	private JTextField textFieldDifGols;
	private JButton btnEditar;
	private JButton btnSalvar;

	int flag=0;
	private JTextField textFieldID;
	private JLabel lblId;
	private JButton btnNewButton;
	private JButton btnExcluir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarClube frame = new EditarClube();
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
	public EditarClube() {
		con.Conexao();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldPesquisa = new JTextField();
		textFieldPesquisa.setBounds(73, 48, 206, 20);
		contentPane.add(textFieldPesquisa);
		textFieldPesquisa.setColumns(10);
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setEnabled(false);
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF"}));
		comboBoxEstado.setBounds(131, 122, 48, 20);
		contentPane.add(comboBoxEstado);
		
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setBounds(325, 95, 53, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clube.setPesquisa(textFieldPesquisa.getText());
				Clube model = dao.PesquisarClube(clube);
				textFieldNome.setText(model.getNome());
				comboBoxEstado.setSelectedItem(model.getEstado());
				
				textFieldID.setText(String.valueOf(model.getIdClube()));
				
				textFieldPontos.setText(String.valueOf(model.getPonto()));
				
				textFieldJogos.setText(String.valueOf(model.getJogo()));
				
				textFieldVitorias.setText(String.valueOf(model.getVitorias()));
				
				textFieldDerrotas.setText(String.valueOf(model.getDerrotas()));
				
				textFieldEmpates.setText(String.valueOf(model.getEmpates()));
				
				textFieldGolsPro.setText(String.valueOf(model.getGolsPro()));
				
				textFieldGolsContra.setText(String.valueOf(model.getGolsContra()));
				
				textFieldDifGols.setText(String.valueOf(model.getDifGols()));
				
				btnEditar.setEnabled(true);
				btnExcluir.setEnabled(true);
				//textFieldDerrotas.setText(String.valueOf(model.getDerrotas())); //Int TO String
			}
		});
		btnPesquisar.setBounds(289, 47, 98, 23);
		contentPane.add(btnPesquisar);
		
		textFieldNome = new JTextField();
		textFieldNome.setEnabled(false);
		textFieldNome.setBounds(131, 95, 130, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldJogos = new JTextField();
		textFieldJogos.setEnabled(false);
		textFieldJogos.setBounds(131, 184, 53, 20);
		contentPane.add(textFieldJogos);
		textFieldJogos.setColumns(10);
		
		textFieldPontos = new JTextField();
		textFieldPontos.setEnabled(false);
		textFieldPontos.setBounds(131, 153, 53, 20);
		contentPane.add(textFieldPontos);
		textFieldPontos.setColumns(10);
		
		textFieldVitorias = new JTextField();
		textFieldVitorias.setEnabled(false);
		textFieldVitorias.setBounds(131, 215, 53, 20);
		contentPane.add(textFieldVitorias);
		textFieldVitorias.setColumns(10);
		
		textFieldDerrotas = new JTextField();
		textFieldDerrotas.setEnabled(false);
		textFieldDerrotas.setBounds(131, 273, 53, 20);
		contentPane.add(textFieldDerrotas);
		textFieldDerrotas.setColumns(10);
		
		textFieldEmpates = new JTextField();
		textFieldEmpates.setEnabled(false);
		textFieldEmpates.setBounds(131, 246, 53, 20);
		contentPane.add(textFieldEmpates);
		textFieldEmpates.setColumns(10);
		
		textFieldGolsPro = new JTextField();
		textFieldGolsPro.setEnabled(false);
		textFieldGolsPro.setBounds(325, 126, 53, 20);
		contentPane.add(textFieldGolsPro);
		textFieldGolsPro.setColumns(10);
		
		textFieldGolsContra = new JTextField();
		textFieldGolsContra.setEnabled(false);
		textFieldGolsContra.setBounds(325, 153, 53, 20);
		contentPane.add(textFieldGolsContra);
		textFieldGolsContra.setColumns(10);
		
		textFieldDifGols = new JTextField();
		textFieldDifGols.setEnabled(false);
		textFieldDifGols.setBounds(325, 184, 53, 20);
		contentPane.add(textFieldDifGols);
		textFieldDifGols.setColumns(10);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNome.setEnabled(true);
				comboBoxEstado.setEnabled(true);
				textFieldJogos.setEnabled(true);
				textFieldPontos.setEnabled(true);
				textFieldVitorias.setEnabled(true);
				textFieldDerrotas.setEnabled(true);
				textFieldEmpates.setEnabled(true);
				textFieldGolsPro.setEnabled(true);
				textFieldGolsContra.setEnabled(true);
				textFieldDifGols.setEnabled(true);
				btnSalvar.setEnabled(true);
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setBounds(289, 245, 89, 23);
		contentPane.add(btnEditar);
		
		
		
		JLabel lblEmpates = new JLabel("Empates:\r\n");
		lblEmpates.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmpates.setBounds(61, 248, 105, 14);
		contentPane.add(lblEmpates);
		
		JLabel lblDerrotas = new JLabel("Derrotas:\r\n");
		lblDerrotas.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDerrotas.setBounds(61, 275, 105, 14);
		contentPane.add(lblDerrotas);
		
		JLabel lblVitrias = new JLabel("Vit\u00F3rias:");
		lblVitrias.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblVitrias.setBounds(61, 215, 105, 14);
		contentPane.add(lblVitrias);
		
		JLabel lblPontos = new JLabel("Pontos:\r\n");
		lblPontos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPontos.setBounds(61, 155, 105, 14);
		contentPane.add(lblPontos);
		
		JLabel lblQuantidadeDeJogos = new JLabel("Partidas Jogadas:\r\n");
		lblQuantidadeDeJogos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQuantidadeDeJogos.setBounds(10, 184, 105, 18);
		contentPane.add(lblQuantidadeDeJogos);
		
		JLabel lblEstadoDoClube = new JLabel("Estado do Clube:");
		lblEstadoDoClube.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEstadoDoClube.setBounds(10, 124, 105, 14);
		contentPane.add(lblEstadoDoClube);
		
		JLabel lblDiferenasDeGols = new JLabel("Diferen\u00E7as de Gols:");
		lblDiferenasDeGols.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiferenasDeGols.setBounds(208, 186, 123, 14);
		contentPane.add(lblDiferenasDeGols);
		
		JLabel lblGolsPro = new JLabel("Gols Pro:");
		lblGolsPro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGolsPro.setBounds(266, 128, 105, 14);
		contentPane.add(lblGolsPro);
		
		JLabel lblGolsContra = new JLabel("Gols Contra:");
		lblGolsContra.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGolsContra.setBounds(248, 155, 105, 14);
		contentPane.add(lblGolsContra);
		
		JLabel lblNomeDoClube = new JLabel("Nome do Clube:");
		lblNomeDoClube.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNomeDoClube.setBounds(16, 97, 105, 14);
		contentPane.add(lblNomeDoClube);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clube.setIdClube(Integer.parseInt(textFieldID.getText()));
				clube.setNome(textFieldNome.getText());
				clube.setEstado(comboBoxEstado.getSelectedItem().toString());
				
				
				clube.setJogo(Integer.parseInt(textFieldJogos.getText()));
				
				clube.setPonto(Integer.parseInt(textFieldPontos.getText()));
				
				clube.setVitorias(Integer.parseInt(textFieldVitorias.getText()));
				
				clube.setDerrotas(Integer.parseInt(textFieldDerrotas.getText()));
				
				clube.setEmpates(Integer.parseInt(textFieldEmpates.getText()));
				
				clube.setGolsPro(Integer.parseInt(textFieldGolsPro.getText()));
				
				clube.setGolsContra(Integer.parseInt(textFieldGolsContra.getText()));
			
				clube.setDifGols(Integer.parseInt(textFieldDifGols.getText()));
				
				dao.Editar(clube);
				textFieldNome.setEnabled(false);
				comboBoxEstado.setEnabled(false);
				textFieldJogos.setEnabled(false);
				textFieldPontos.setEnabled(false);
				textFieldVitorias.setEnabled(false);
				textFieldDerrotas.setEnabled(false);
				textFieldEmpates.setEnabled(false);
				textFieldGolsPro.setEnabled(false);
				textFieldGolsContra.setEnabled(false);
				textFieldDifGols.setEnabled(false);
				btnSalvar.setEnabled(false);
				
				//clube.setJogo(Integer.parseInt(textFieldJogos.getText()));
				
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(289, 214, 89, 23);
		contentPane.add(btnSalvar);
		
		
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblId.setBounds(296, 97, 57, 14);
		contentPane.add(lblId);
		
		btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicial tela = new Inicial();
				tela.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 80, 20);
		contentPane.add(btnNewButton);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta=0;
				resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir?");
				if(resposta == JOptionPane.YES_OPTION){
					clube.setIdClube(Integer.parseInt(textFieldID.getText()));
					dao.ExcluirClube(clube);
					textFieldDerrotas.setText("");
					comboBoxEstado.setSelectedItem("");
					textFieldDifGols.setText("");
					textFieldEmpates.setText("");
					textFieldGolsContra.setText("");
					textFieldGolsPro.setText("");
					textFieldID.setText("");
					textFieldJogos.setText("");
					textFieldNome.setText("");
					textFieldPontos.setText("");
					textFieldVitorias.setText("");
				}
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(289, 277, 89, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNome.setBounds(34, 50, 46, 14);
		contentPane.add(lblNome);
	}
}
