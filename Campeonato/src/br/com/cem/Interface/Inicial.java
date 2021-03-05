package br.com.cem.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexaoBd.ConexaoBD;
import br.com.cem.Campeonato.Clube;
import br.com.cem.Campeonato.ClubeDAO;
import br.com.cem.Campeonato.ModeloTabela;
import br.com.cem.Campeonato.PartidaDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;

public class Inicial extends JFrame {
	
	ConexaoBD conecta = new ConexaoBD();
	Clube clube = new Clube(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	ClubeDAO dao = new ClubeDAO();
	PartidaDAO partDAO = new PartidaDAO();
	
	private JPanel contentPane;
	private JButton btnMostrar;
	private JLabel lblTabelaBrasileiraoSeriea;
	private JTable tableClube;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial frame = new Inicial();
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
	public Inicial() {
		setResizable(false);
		conecta.Conexao();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableClube = new JTable();
		tableClube.setBounds(26, 135, 665, 782);
		contentPane.add(tableClube);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 761, 21);
		contentPane.add(menuBar);
		
		JMenu mnCadatrar = new JMenu("Cadastrar");
		menuBar.add(mnCadatrar);
		
		JButton btnCadClube = new JButton("Clube");
		btnCadClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroClube clube = new CadastroClube();
				clube.setVisible(true);
				dispose();
			}
		});
		mnCadatrar.add(btnCadClube);
		
		JButton btnCadRodada = new JButton("Partida");
		btnCadRodada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarPartida part = new AdicionarPartida();
				part.setVisible(true);
				part.setResizable(false);
				dispose();
				
			}
		});
		mnCadatrar.add(btnCadRodada);
		
		JMenu mnEditar = new JMenu("Editar & Excluir");
		menuBar.add(mnEditar);
		
		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String input;
				int senha;
				input = JOptionPane.showInputDialog("Senha do admim:");
				senha = Integer.parseInt(input);
			if(senha==2355){
				EditarUsuario tela = new EditarUsuario();
				tela.setVisible(true);
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "Senha Incorreta");
		}
			}
		});
		
		JButton btnClube = new JButton("Clube");
		btnClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarClube tela = new EditarClube();
				tela.setVisible(true);
				dispose();
			}
		});
		mnEditar.add(btnClube);
		
		JButton btnRodada = new JButton("Partida");
		btnRodada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarPartida tela = new EditarPartida();
				tela.setVisible(true);
				tela.setResizable(false);
				dispose();
			}
		});
		mnEditar.add(btnRodada);
		mnEditar.add(btnUsuario);
		
		JMenu mnVisualizar = new JMenu("Reiniciar");
		menuBar.add(mnVisualizar);
		
		
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.setForeground(Color.GRAY);
		menuBar.add(mnSair);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conecta.Desconectar();
				System.exit(0);
			}
		});
		mnSair.add(btnSair);
		
		lblTabelaBrasileiraoSeriea = new JLabel("Tabela Brasileir\u00E3o Serie-A");
		lblTabelaBrasileiraoSeriea.setBounds(26, 45, 336, 36);
		lblTabelaBrasileiraoSeriea.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		contentPane.add(lblTabelaBrasileiraoSeriea);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(26, 112, 21, 21);
		contentPane.add(panel);
		
		JLabel lblId = new JLabel("ID");
		panel.add(lblId);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(47, 112, 122, 21);
		contentPane.add(panel_1);
		
		JLabel lblNome = new JLabel("Nome");
		panel_1.add(lblNome);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(169, 112, 58, 21);
		contentPane.add(panel_2);
		
		JLabel lblEstado = new JLabel("Estado");
		panel_2.add(lblEstado);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBounds(226, 112, 58, 21);
		contentPane.add(panel_3);
		
		JLabel lblPj = new JLabel("PJ");
		panel_3.add(lblPj);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2_1.setBounds(284, 112, 58, 21);
		contentPane.add(panel_2_1);
		
		JLabel lblPts = new JLabel("PTS");
		panel_2_1.add(lblPts);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2_2.setBounds(342, 112, 58, 21);
		contentPane.add(panel_2_2);
		
		JLabel lblVts = new JLabel("VIT");
		panel_2_2.add(lblVts);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2_3.setBounds(400, 112, 58, 21);
		contentPane.add(panel_2_3);
		
		JLabel lblDer = new JLabel("DER");
		panel_2_3.add(lblDer);
		
		JPanel panel_2_4 = new JPanel();
		panel_2_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2_4.setBounds(458, 112, 58, 21);
		contentPane.add(panel_2_4);
		
		JLabel lblEmp = new JLabel("EMP");
		panel_2_4.add(lblEmp);
		
		JPanel panel_2_5 = new JPanel();
		panel_2_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2_5.setBounds(516, 112, 58, 21);
		contentPane.add(panel_2_5);
		
		JLabel lblGp = new JLabel("GP");
		panel_2_5.add(lblGp);
		
		JPanel panel_2_6 = new JPanel();
		panel_2_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2_6.setBounds(574, 112, 58, 21);
		contentPane.add(panel_2_6);
		
		JLabel lblGc = new JLabel("GC");
		panel_2_6.add(lblGc);
		
		JPanel panel_2_7 = new JPanel();
		panel_2_7.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2_7.setBounds(627, 112, 64, 21);
		contentPane.add(panel_2_7);
		
		JLabel lblDf = new JLabel("SG");
		panel_2_7.add(lblDf);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 204, 102));
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(10, 135, 16, 15);
		contentPane.add(panel_4);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_1.setBackground(new Color(102, 204, 102));
		panel_4_1.setBounds(10, 199, 16, 15);
		contentPane.add(panel_4_1);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_2.setBackground(new Color(102, 204, 102));
		panel_4_2.setBounds(10, 150, 16, 15);
		contentPane.add(panel_4_2);
		
		JPanel panel_4_3 = new JPanel();
		panel_4_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_3.setBackground(new Color(102, 204, 102));
		panel_4_3.setBounds(10, 166, 16, 15);
		contentPane.add(panel_4_3);
		
		JPanel panel_4_4 = new JPanel();
		panel_4_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_4.setBackground(new Color(102, 204, 102));
		panel_4_4.setBounds(10, 183, 16, 15);
		contentPane.add(panel_4_4);
		
		JPanel panel_4_5 = new JPanel();
		panel_4_5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_5.setBackground(new Color(102, 204, 102));
		panel_4_5.setBounds(10, 215, 16, 15);
		contentPane.add(panel_4_5);
		
		JPanel panel_4_6 = new JPanel();
		panel_4_6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_6.setBackground(new Color(102, 204, 102));
		panel_4_6.setBounds(10, 231, 16, 15);
		contentPane.add(panel_4_6);
		
		JPanel panel_4_7 = new JPanel();
		panel_4_7.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_7.setBackground(new Color(102, 204, 102));
		panel_4_7.setBounds(10, 247, 16, 15);
		contentPane.add(panel_4_7);
		
		JPanel panel_4_8 = new JPanel();
		panel_4_8.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_8.setBackground(new Color(255, 204, 102));
		panel_4_8.setBounds(10, 264, 16, 15);
		contentPane.add(panel_4_8);
		
		JPanel panel_4_2_1 = new JPanel();
		panel_4_2_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_2_1.setBackground(new Color(255, 204, 102));
		panel_4_2_1.setBounds(10, 279, 16, 15);
		contentPane.add(panel_4_2_1);
		
		JPanel panel_4_3_1 = new JPanel();
		panel_4_3_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_3_1.setBackground(new Color(255, 204, 102));
		panel_4_3_1.setBounds(10, 295, 16, 15);
		contentPane.add(panel_4_3_1);
		
		JPanel panel_4_4_1 = new JPanel();
		panel_4_4_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_4_1.setBackground(new Color(255, 204, 102));
		panel_4_4_1.setBounds(10, 312, 16, 15);
		contentPane.add(panel_4_4_1);
		
		JPanel panel_4_5_1 = new JPanel();
		panel_4_5_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_5_1.setBackground(new Color(255, 204, 102));
		panel_4_5_1.setBounds(10, 344, 16, 15);
		contentPane.add(panel_4_5_1);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_1_1.setBackground(new Color(255, 204, 102));
		panel_4_1_1.setBounds(10, 328, 16, 15);
		contentPane.add(panel_4_1_1);
		
		JPanel panel_4_6_1 = new JPanel();
		panel_4_6_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_6_1.setBackground(new Color(51, 51, 51));
		panel_4_6_1.setBounds(10, 360, 16, 15);
		contentPane.add(panel_4_6_1);
		
		JPanel panel_4_7_1 = new JPanel();
		panel_4_7_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_7_1.setBackground(new Color(51, 51, 51));
		panel_4_7_1.setBounds(10, 376, 16, 15);
		contentPane.add(panel_4_7_1);
		
		JPanel panel_4_7_1_1 = new JPanel();
		panel_4_7_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_7_1_1.setBackground(new Color(255, 51, 51));
		panel_4_7_1_1.setBounds(10, 442, 16, 15);
		contentPane.add(panel_4_7_1_1);
		
		JPanel panel_4_6_1_1 = new JPanel();
		panel_4_6_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_6_1_1.setBackground(new Color(255, 51, 51));
		panel_4_6_1_1.setBounds(10, 426, 16, 15);
		contentPane.add(panel_4_6_1_1);
		
		JPanel panel_4_5_1_1 = new JPanel();
		panel_4_5_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_5_1_1.setBackground(new Color(255, 51, 51));
		panel_4_5_1_1.setBounds(10, 410, 16, 15);
		contentPane.add(panel_4_5_1_1);
		
		JPanel panel_4_1_1_1 = new JPanel();
		panel_4_1_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_1_1_1.setBackground(new Color(255, 51, 51));
		panel_4_1_1_1.setBounds(10, 393, 16, 15);
		contentPane.add(panel_4_1_1_1);
		
		JPanel panel_4_9 = new JPanel();
		panel_4_9.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_9.setBackground(new Color(102, 204, 102));
		panel_4_9.setBounds(541, 36, 16, 15);
		contentPane.add(panel_4_9);
		
		JPanel panel_4_8_1 = new JPanel();
		panel_4_8_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_8_1.setBackground(new Color(255, 204, 102));
		panel_4_8_1.setBounds(541, 62, 16, 15);
		contentPane.add(panel_4_8_1);
		
		JPanel panel_4_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4_1_1_1_1.setBackground(new Color(255, 51, 51));
		panel_4_1_1_1_1.setBounds(541, 88, 16, 15);
		contentPane.add(panel_4_1_1_1_1);
		
		JLabel lblLibertadores = new JLabel("Libertadores");
		lblLibertadores.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLibertadores.setBounds(574, 36, 98, 14);
		contentPane.add(lblLibertadores);
		
		JLabel lblCopaSulamericana = new JLabel("Copa Sul-Americana");
		lblCopaSulamericana.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCopaSulamericana.setBounds(574, 63, 117, 14);
		contentPane.add(lblCopaSulamericana);
		
		JLabel lblR = new JLabel("Rebaixamento");
		lblR.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblR.setBounds(574, 88, 117, 14);
		contentPane.add(lblR);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(211, 211, 211));
		panel_5.setBounds(535, 32, 168, 76);
		contentPane.add(panel_5);
		PreencherTabela("select *from clubes order by pontos DESC ");
		
		JButton btnReiniciarClubes = new JButton("Reiniciar Campeonato");
		btnReiniciarClubes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input;
				int senha;
				input = JOptionPane.showInputDialog("Senha do admim:");
				senha = Integer.parseInt(input);
			if(senha==2355){
				dao.Reinicio();
				partDAO.Reinicio();
			}else{
				JOptionPane.showMessageDialog(null, "Senha Incorreta");
		}
			}
		});
		mnVisualizar.add(btnReiniciarClubes);
		
	}
	
	public void PreencherTabela(String sql){
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] {"id","nome","estado","jogo",
				"ponto","vitoria","derrota","empate","golPro","golContra","difGol"};
		conecta.Conexao();
		conecta.ExecutaSql(sql);
		
		try{
			conecta.rs.first();
			do{
				dados.add(new Object[]{conecta.rs.getString("idClube"),conecta.rs.getString("nomeClube"),conecta.rs.getString("estadoClube"),conecta.rs.getInt("jogos"),conecta.rs.getInt("pontos"),conecta.rs.getInt("vitorias"),conecta.rs.getInt("derrotas"),conecta.rs.getInt("empates"),conecta.rs.getInt("golsPro"),conecta.rs.getInt("golsContra"),conecta.rs.getInt("difGols")});
				
				
				}while(conecta.rs.next());
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(rootPane, "Erro ao preencher o ArrayList"+ex);
		}
		ModeloTabela modelo = new ModeloTabela(dados, colunas);
		tableClube.setModel(modelo);
		tableClube.getColumnModel().getColumn(0).setPreferredWidth(23);
		tableClube.getColumnModel().getColumn(0).setResizable(false);
		tableClube.getColumnModel().getColumn(1).setPreferredWidth(180);
		tableClube.getColumnModel().getColumn(1).setResizable(false);
		tableClube.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableClube.getColumnModel().getColumn(2).setResizable(false);
		tableClube.getColumnModel().getColumn(3).setPreferredWidth(80);
		tableClube.getColumnModel().getColumn(3).setResizable(false);
		tableClube.getColumnModel().getColumn(4).setPreferredWidth(80);
		tableClube.getColumnModel().getColumn(4).setResizable(false);
		tableClube.getColumnModel().getColumn(5).setPreferredWidth(80);
		tableClube.getColumnModel().getColumn(5).setResizable(false);
		tableClube.getColumnModel().getColumn(6).setPreferredWidth(80);
		tableClube.getColumnModel().getColumn(6).setResizable(false);
		tableClube.getColumnModel().getColumn(7).setPreferredWidth(80);
		tableClube.getColumnModel().getColumn(7).setResizable(false);
		tableClube.getColumnModel().getColumn(8).setPreferredWidth(80);
		tableClube.getColumnModel().getColumn(8).setResizable(false);
		tableClube.getColumnModel().getColumn(9).setPreferredWidth(80);
		tableClube.getColumnModel().getColumn(9).setResizable(false);
		tableClube.getColumnModel().getColumn(10).setPreferredWidth(80);
		tableClube.getColumnModel().getColumn(10).setResizable(false);
		tableClube.getTableHeader().setReorderingAllowed(false);
		
		
		tableClube.setAutoResizeMode(tableClube.AUTO_RESIZE_OFF);
		tableClube.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		conecta.Desconectar();
		
		}
	
	

	private static void addPopup(Component component, final JPopupMenu popup) {
		
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		}
}
