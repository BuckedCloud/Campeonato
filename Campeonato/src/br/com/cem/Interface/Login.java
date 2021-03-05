package br.com.cem.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexaoBd.ConexaoBD;
import br.com.cem.Campeonato.Usuario;
import br.com.cem.Campeonato.UsuarioDAO;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.JobAttributes;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;



public class Login extends JFrame {
	
	ConexaoBD con = new ConexaoBD();
	Usuario usuario = new Usuario(null, null, null, null, 0);
	UsuarioDAO user = new UsuarioDAO();
	
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldSenha;
	private JTextField textFieldCadNome;
	int flag = 0;
	private JTextField textFieldCadEmail;
	private JPasswordField passwordFieldCadSenha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//java.sql.Connection con = ConexaoUtil.getConnection().Conn();
	
	
	public Login() {
		setResizable(false);
		con.Conexao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 171);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBackground(Color.BLACK);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmail.setBounds(10, 54, 62, 14);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Senha:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 86, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAcessar.setBackground(new Color(255, 255, 255));
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try {
				con.ExecutaSql("select * from usuario where email='"+textFieldEmail.getText()+"'");
				con.rs.first();
				if(con.rs.getString("senha").equals(passwordFieldSenha.getText())){
					Inicial tela = new Inicial();
					tela.setVisible(true);
					tela.setResizable(false);
					dispose();
				}else{
					JOptionPane.showMessageDialog(rootPane, "Senha ou E-mail inválidos!");
				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(rootPane, "Senha ou E-mail inválidos!"+ex);
			}
			}
		});
		btnAcessar.setBounds(10, 111, 107, 23);
		contentPane.add(btnAcessar);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBackground(new Color(230, 230, 250));
		passwordFieldSenha.setBounds(54, 84, 196, 20);
		contentPane.add(passwordFieldSenha);
		
		textFieldCadNome = new JTextField();
		textFieldCadNome.setEnabled(false);
		textFieldCadNome.setBounds(54, 152, 196, 20);
		contentPane.add(textFieldCadNome);
		textFieldCadNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNome.setBounds(10, 155, 46, 14);
		contentPane.add(lblNome);
		
		JComboBox comboBoxCadSexo = new JComboBox();
		comboBoxCadSexo.setEnabled(false);
		comboBoxCadSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Masculino", "Feminino", "Outro"}));
		comboBoxCadSexo.setBounds(54, 246, 196, 20);
		contentPane.add(comboBoxCadSexo);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(new Color(255, 255, 255));
		lblSexo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSexo.setBounds(10, 249, 46, 14);
		contentPane.add(lblSexo);
		
	
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(255, 255, 255));
		btnSalvar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(textFieldCadNome.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o campo nome para continuar");
					textFieldCadNome.requestFocus();
				}else if(textFieldCadEmail.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o campo e-mail para continuar");
					textFieldEmail.requestFocus();
				}else if(passwordFieldCadSenha.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o campo senha para continuar");
					passwordFieldSenha.requestFocus();
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
				}
			}
			
		});
		btnSalvar.setBounds(143, 277, 107, 20);
		contentPane.add(btnSalvar);
		
		JLabel lblEmail_1 = new JLabel("E-mail:");
		lblEmail_1.setForeground(new Color(255, 255, 255));
		lblEmail_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmail_1.setBounds(10, 185, 62, 14);
		contentPane.add(lblEmail_1);
		
		textFieldCadEmail = new JTextField();
		textFieldCadEmail.setEnabled(false);
		textFieldCadEmail.setColumns(10);
		textFieldCadEmail.setBounds(54, 183, 196, 20);
		contentPane.add(textFieldCadEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 217, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordFieldCadSenha = new JPasswordField();
		passwordFieldCadSenha.setEnabled(false);
		passwordFieldCadSenha.setBackground(new Color(255, 255, 255));
		passwordFieldCadSenha.setForeground(new Color(0, 255, 255));
		passwordFieldCadSenha.setBounds(54, 215, 196, 20);
		contentPane.add(passwordFieldCadSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar-se");
		btnCadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.setToolTipText("");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroUsuario tela = new CadastroUsuario();
				tela.setVisible(true);
		}
		});
		btnCadastrar.setBounds(127, 112, 123, 22);
		contentPane.add(btnCadastrar);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBackground(new Color(230, 230, 250));
		textFieldEmail.setBounds(54, 52, 196, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(-17, -7, 292, 50);
		contentPane.add(panel);
		
		JLabel lblLogin = new JLabel("Login");
		panel.add(lblLogin);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	}
}
