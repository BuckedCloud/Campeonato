package br.com.cem.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.cem.Campeonato.Usuario;
import br.com.cem.Campeonato.UsuarioDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class CadastroUsuario extends JFrame {

	Usuario usuario = new Usuario(null, null, null, null, 0);
	UsuarioDAO user = new UsuarioDAO();
	
	private JPanel contentPane;
	private JTextField textFieldCadEmail;
	private JTextField textFieldCadNome;
	private JPasswordField passwordFieldCadSenha;

	
	int flag;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
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
	public CadastroUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxCadSexo = new JComboBox();
		comboBoxCadSexo.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBoxCadSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Masculino", "Feminino", "Outro"}));
		comboBoxCadSexo.setBounds(76, 106, 148, 20);
		contentPane.add(comboBoxCadSexo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag=1;
				if(textFieldCadNome.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o campo nome para continuar");
					textFieldCadNome.requestFocus();
				}else if(textFieldCadEmail.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o campo e-mail para continuar");
					textFieldCadEmail.requestFocus();
				}else if(passwordFieldCadSenha.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o campo senha para continuar");
					passwordFieldCadSenha.requestFocus();
				}
				if(flag==1){
					usuario.setNome(textFieldCadNome.getText());
					usuario.setEmail(textFieldCadEmail.getText());
					usuario.setSexo(comboBoxCadSexo.getSelectedItem().toString());
					usuario.setSenha(passwordFieldCadSenha.getText());
					user.Salvar(usuario);
					textFieldCadNome.setText("");
					passwordFieldCadSenha.setText("");
					textFieldCadEmail.setText("");
					textFieldCadNome.setEnabled(false);
					comboBoxCadSexo.setEnabled(false);
					textFieldCadEmail.setEnabled(false);
					passwordFieldCadSenha.setEnabled(false);
					btnSalvar.setEnabled(false);
					dispose();
				}
			}
			
		});
		btnSalvar.setBounds(28, 147, 196, 23);
		contentPane.add(btnSalvar);
		
		textFieldCadEmail = new JTextField();
		textFieldCadEmail.setBounds(76, 44, 148, 20);
		contentPane.add(textFieldCadEmail);
		textFieldCadEmail.setColumns(10);
		
		textFieldCadNome = new JTextField();
		textFieldCadNome.setBounds(76, 13, 148, 20);
		contentPane.add(textFieldCadNome);
		textFieldCadNome.setColumns(10);
		
		
		
		passwordFieldCadSenha = new JPasswordField();
		passwordFieldCadSenha.setBounds(76, 75, 148, 20);
		contentPane.add(passwordFieldCadSenha);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNome.setBounds(10, 15, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblEmail_1 = new JLabel("E-mail:");
		lblEmail_1.setForeground(Color.BLACK);
		lblEmail_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmail_1.setBounds(10, 46, 62, 14);
		contentPane.add(lblEmail_1);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 77, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(Color.BLACK);
		lblSexo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSexo.setBounds(10, 108, 46, 14);
		contentPane.add(lblSexo);
	}
}
