package br.com.cem.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.cem.Campeonato.Clube;
import br.com.cem.Campeonato.Usuario;
import br.com.cem.Campeonato.UsuarioDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class EditarUsuario extends JFrame {
	
	Usuario usu = new Usuario(null, null, null, null, 0);
	UsuarioDAO dao = new UsuarioDAO();

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldPesquisa;
	private JTextField textFieldID;
	private JTextField textFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarUsuario frame = new EditarUsuario();
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
	public EditarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setEnabled(false);
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(130, 120, 125, 20);
		contentPane.add(textFieldNome);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEnabled(false);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(130, 151, 125, 20);
		contentPane.add(textFieldEmail);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setEditable(true);
		comboBoxSexo.setEnabled(false);
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino", "Outro"}));
		comboBoxSexo.setBounds(130, 213, 125, 20);
		contentPane.add(comboBoxSexo);
		
		JLabel lblDerrotas = new JLabel("Sexo:");
		lblDerrotas.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDerrotas.setBounds(60, 213, 105, 14);
		contentPane.add(lblDerrotas);
		
		JLabel lblVitrias = new JLabel("Senha:");
		lblVitrias.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblVitrias.setBounds(60, 182, 105, 14);
		contentPane.add(lblVitrias);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta=0;
				resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir?");
				if(resposta == JOptionPane.YES_OPTION){
					usu.setId_Usuario(Integer.parseInt(textFieldID.getText()));
					dao.ExcluirUsuario(usu);
					textFieldSenha.setText("");
					textFieldID.setText("");
					textFieldNome.setText("");
					textFieldEmail.setText("");
				}
			}
		});
	
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(309, 150, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usu.setId_Usuario(Integer.parseInt(textFieldID.getText()));
				usu.setEmail(textFieldEmail.getText());
				usu.setNome(textFieldNome.getText());
				usu.setSenha(textFieldSenha.getText());
				usu.setSexo(comboBoxSexo.getSelectedItem().toString());
				dao.Editar(usu);
				textFieldNome.setEnabled(false);
				textFieldEmail.setEnabled(false);
				textFieldSenha.setEnabled(false);
				comboBoxSexo.setEnabled(false);
				btnSalvar.setEnabled(false);
				
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNome.setEnabled(true);
				comboBoxSexo.setEnabled(true);
				textFieldEmail.setEnabled(true);
				textFieldSenha.setEnabled(true);
				btnSalvar.setEnabled(true);
				btnExcluir.setEnabled(true);
			}
		});
		btnEditar.setBounds(309, 210, 89, 23);
		contentPane.add(btnEditar);
		
		JLabel lblPontos = new JLabel("Email:");
		lblPontos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPontos.setBounds(60, 151, 105, 14);
		contentPane.add(lblPontos);
		
		JLabel lblQuantidadeDeJogos = new JLabel("Nome:");
		lblQuantidadeDeJogos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQuantidadeDeJogos.setBounds(60, 120, 105, 18);
		contentPane.add(lblQuantidadeDeJogos);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				usu.setPesquisa(textFieldPesquisa.getText());
				Usuario model = dao.Pesquisar(usu);
				textFieldNome.setText(model.getNome());
				comboBoxSexo.setSelectedItem(model.getSexo());
				textFieldID.setText(String.valueOf(model.getId_Usuario()));
				textFieldSenha.setText(String.valueOf(model.getSenha()));
				textFieldEmail.setText(String.valueOf(model.getEmail()));
				
				
				btnEditar.setEnabled(true);
			}
		});
		
		
		
		
		
		
		
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(309, 179, 89, 23);
		contentPane.add(btnSalvar);
		
		
		
		
		btnPesquisar.setBounds(293, 47, 121, 23);
		contentPane.add(btnPesquisar);
		
		textFieldPesquisa = new JTextField();
		textFieldPesquisa.setColumns(10);
		textFieldPesquisa.setBounds(59, 48, 206, 20);
		contentPane.add(textFieldPesquisa);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicial tela = new Inicial();
				tela.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 80, 20);
		contentPane.add(btnNewButton);
		
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setBounds(348, 120, 50, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblId.setBounds(309, 122, 105, 14);
		contentPane.add(lblId);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setEnabled(false);
		textFieldSenha.setBounds(130, 182, 125, 20);
		contentPane.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmail.setBounds(3, 50, 46, 14);
		contentPane.add(lblEmail);
		
		
	}
}
