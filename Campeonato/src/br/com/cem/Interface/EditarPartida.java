package br.com.cem.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.cem.Campeonato.Partida;
import br.com.cem.Campeonato.PartidaDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class EditarPartida extends JFrame {

	Partida part = new Partida(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	PartidaDAO dao = new PartidaDAO();
	
	private JPanel contentPane;
	private JTextField textFieldnumRodada;
	private JTextField textFieldIDCasa;
	private JTextField textFieldIDVisitante;
	private JTextField textFieldGolsCasa;
	private JTextField textFieldGolsVisitante;
	private JTextField textFieldCartA_Casa;
	private JTextField textFieldcartV_Casa;
	private JTextField textFieldcartA_Visitante;
	private JTextField textFieldcartV_Visitante;
	private JTextField textFieldNumRodada;
	private JTextField textFieldNumPartida;
	private JTextField textFieldNumPartidaPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarPartida frame = new EditarPartida();
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
	public EditarPartida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicial tela = new Inicial();
				tela.setVisible(true);
				dispose();
				
				
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				part.setPesquisa(Integer.parseInt(textFieldnumRodada.getText()));
				
				part.setId_Casa(Integer.parseInt(textFieldIDCasa.getText()));
				
				part.setId_Visitante(Integer.parseInt(textFieldIDVisitante.getText()));
				
				part.setNumPartida(Integer.parseInt(textFieldNumPartida.getText()));
				
				part.setRodada(Integer.parseInt(textFieldNumRodada.getText()));
				
				part.setCartA_Casa(Integer.parseInt(textFieldCartA_Casa.getText()));
				
				part.setCartA_Visitante(Integer.parseInt(textFieldcartA_Visitante.getText()));
				
				part.setCartV_Casa(Integer.parseInt(textFieldcartV_Casa.getText()));
				
				part.setCartV_Visitante(Integer.parseInt(textFieldcartV_Visitante.getText()));
				
				part.setGolsCasa(Integer.parseInt(textFieldGolsCasa.getText()));
				
				part.setGolsVisitante(Integer.parseInt(textFieldGolsVisitante.getText()));
				
				dao.Editar(part);
				
				textFieldCartA_Casa.setEnabled(false);
				textFieldcartA_Visitante.setEnabled(false);
				textFieldcartV_Casa.setEnabled(false);
				textFieldcartV_Visitante.setEnabled(false);
				textFieldGolsCasa.setEnabled(false);
				textFieldGolsVisitante.setEnabled(false);
				textFieldIDCasa.setEnabled(false);
				textFieldIDVisitante.setEnabled(false);
				textFieldNumPartida.setEnabled(false);
				textFieldNumRodada.setEnabled(false);
				btnSalvar.setEnabled(false);
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(377, 106, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldCartA_Casa.setEnabled(true);
				
				textFieldcartA_Visitante.setEnabled(true);
				
				textFieldcartV_Casa.setEnabled(true);
				
				textFieldcartV_Visitante.setEnabled(true);
				
				textFieldGolsCasa.setEnabled(true);
				
				textFieldGolsVisitante.setEnabled(true);
				
				textFieldIDCasa.setEnabled(true);
				
				textFieldIDVisitante.setEnabled(true);
				
				textFieldNumPartida.setEnabled(true);
				
				textFieldNumRodada.setEnabled(true);
				
				btnSalvar.setEnabled(true);
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setBounds(377, 140, 89, 23);
		contentPane.add(btnEditar);
		
	
		
		
		
		btnVoltar.setBounds(0, 0, 73, 23);
		contentPane.add(btnVoltar);
		
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				part.setPesquisa(Integer.parseInt(textFieldnumRodada.getText()));
				part.setProcura(Integer.parseInt(textFieldNumPartidaPesquisa.getText()));
				Partida model = dao.PesquisarPartida(part);
				
				
				
				textFieldNumPartida.setText(String.valueOf(model.getNumPartida()));
				
				textFieldNumRodada.setText(String.valueOf(model.getRodada()));
				
				textFieldCartA_Casa.setText(String.valueOf(model.getCartA_Casa()));
				
				textFieldcartA_Visitante.setText(String.valueOf(model.getCartA_Visitante()));
				
				textFieldcartV_Casa.setText(String.valueOf(model.getCartV_Casa()));
				
				textFieldcartV_Visitante.setText(String.valueOf(model.getCartV_Visitante()));
				
				textFieldGolsCasa.setText(String.valueOf(model.getGolsCasa()));
				
				textFieldGolsVisitante.setText(String.valueOf(model.getGolsVisitante()));
				
				textFieldIDCasa.setText(String.valueOf(model.getId_Casa()));
				
				textFieldIDVisitante.setText(String.valueOf(model.getId_Visitante()));
				
				
				btnEditar.setEnabled(true);
			}
		});
		btnPesquisar.setBounds(333, 16, 109, 23);
		contentPane.add(btnPesquisar);
		
	
		
		textFieldnumRodada = new JTextField();
		textFieldnumRodada.setBounds(261, 44, 41, 20);
		contentPane.add(textFieldnumRodada);
		textFieldnumRodada.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID Casa:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 95, 64, 14);
		contentPane.add(lblNewLabel);
		
		textFieldIDCasa = new JTextField();
		textFieldIDCasa.setEnabled(false);
		textFieldIDCasa.setColumns(10);
		textFieldIDCasa.setBounds(84, 93, 37, 20);
		contentPane.add(textFieldIDCasa);
		
		JLabel lblIdVisitante = new JLabel("ID Visitante:");
		lblIdVisitante.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblIdVisitante.setBounds(10, 126, 89, 14);
		contentPane.add(lblIdVisitante);
		
		textFieldIDVisitante = new JTextField();
		textFieldIDVisitante.setEnabled(false);
		textFieldIDVisitante.setColumns(10);
		textFieldIDVisitante.setBounds(84, 124, 37, 20);
		contentPane.add(textFieldIDVisitante);
		
		JLabel lblGolsCasa = new JLabel("Gols Casa:");
		lblGolsCasa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGolsCasa.setBounds(20, 157, 79, 14);
		contentPane.add(lblGolsCasa);
		
		textFieldGolsCasa = new JTextField();
		textFieldGolsCasa.setEnabled(false);
		textFieldGolsCasa.setColumns(10);
		textFieldGolsCasa.setBounds(84, 155, 37, 20);
		contentPane.add(textFieldGolsCasa);
		
		JLabel lblGolsVisitante = new JLabel("Gols Visitante:");
		lblGolsVisitante.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGolsVisitante.setBounds(0, 188, 84, 14);
		contentPane.add(lblGolsVisitante);
		
		textFieldGolsVisitante = new JTextField();
		textFieldGolsVisitante.setEnabled(false);
		textFieldGolsVisitante.setColumns(10);
		textFieldGolsVisitante.setBounds(84, 186, 37, 20);
		contentPane.add(textFieldGolsVisitante);
		
		JLabel lblCartaoACasa = new JLabel("Cartao amarelos casa:");
		lblCartaoACasa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCartaoACasa.setBounds(184, 95, 196, 14);
		contentPane.add(lblCartaoACasa);
		
		textFieldCartA_Casa = new JTextField();
		textFieldCartA_Casa.setEnabled(false);
		textFieldCartA_Casa.setColumns(10);
		textFieldCartA_Casa.setBounds(318, 93, 37, 20);
		contentPane.add(textFieldCartA_Casa);
		
		JLabel lblCartaoVCasa = new JLabel("Cart\u00F5es vermelhos casa:");
		lblCartaoVCasa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCartaoVCasa.setBounds(171, 126, 184, 14);
		contentPane.add(lblCartaoVCasa);
		
		textFieldcartV_Casa = new JTextField();
		textFieldcartV_Casa.setEnabled(false);
		textFieldcartV_Casa.setColumns(10);
		textFieldcartV_Casa.setBounds(318, 124, 37, 20);
		contentPane.add(textFieldcartV_Casa);
		
		JLabel lblCartaoAVisitante = new JLabel("Cart\u00F5es amarelos visitante:");
		lblCartaoAVisitante.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCartaoAVisitante.setBounds(159, 157, 216, 14);
		contentPane.add(lblCartaoAVisitante);
		
		textFieldcartA_Visitante = new JTextField();
		textFieldcartA_Visitante.setEnabled(false);
		textFieldcartA_Visitante.setColumns(10);
		textFieldcartA_Visitante.setBounds(318, 155, 37, 20);
		contentPane.add(textFieldcartA_Visitante);
		
		JLabel lblCartaoVVisitante = new JLabel("Cart\u00F5es vermelhos visitante:");
		lblCartaoVVisitante.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCartaoVVisitante.setBounds(150, 188, 184, 14);
		contentPane.add(lblCartaoVVisitante);
		
		textFieldcartV_Visitante = new JTextField();
		textFieldcartV_Visitante.setEnabled(false);
		textFieldcartV_Visitante.setColumns(10);
		textFieldcartV_Visitante.setBounds(318, 186, 37, 20);
		contentPane.add(textFieldcartV_Visitante);
		
		JLabel lblNumeroDaRodada = new JLabel("N\u00FAmero da Rodada:");
		lblNumeroDaRodada.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNumeroDaRodada.setBounds(196, 219, 150, 14);
		contentPane.add(lblNumeroDaRodada);
		
		textFieldNumRodada = new JTextField();
		textFieldNumRodada.setEnabled(false);
		textFieldNumRodada.setColumns(10);
		textFieldNumRodada.setBounds(318, 217, 37, 20);
		contentPane.add(textFieldNumRodada);
		
		textFieldNumPartida = new JTextField();
		textFieldNumPartida.setEnabled(false);
		textFieldNumPartida.setColumns(10);
		textFieldNumPartida.setBounds(318, 252, 37, 20);
		contentPane.add(textFieldNumPartida);
		
		JLabel lblNumeroDaPartida = new JLabel("N\u00FAmero da Partida:");
		lblNumeroDaPartida.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNumeroDaPartida.setBounds(196, 254, 242, 14);
		contentPane.add(lblNumeroDaPartida);
		
		JLabel lblIdDaPartida = new JLabel("N\u00FAmero da Partida:");
		lblIdDaPartida.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblIdDaPartida.setBounds(146, 19, 156, 14);
		contentPane.add(lblIdDaPartida);
		
		textFieldNumPartidaPesquisa = new JTextField();
		textFieldNumPartidaPesquisa.setBounds(261, 17, 41, 20);
		contentPane.add(textFieldNumPartidaPesquisa);
		textFieldNumPartidaPesquisa.setColumns(10);
		
		JLabel lblNmeroDaRodada = new JLabel("N\u00FAmero da Rodada:");
		lblNmeroDaRodada.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNmeroDaRodada.setBounds(146, 47, 163, 14);
		contentPane.add(lblNmeroDaRodada);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(-19, 75, 521, 1);
		contentPane.add(panel);
		
		
	}
}
