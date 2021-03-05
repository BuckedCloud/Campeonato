package ConexaoBd;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;

public class ConexaoBD {
	
	public Statement stm;
	public ResultSet rs;
	private String driver = "com.mysql.jdbc.Driver";
	private String caminho = "jdbc:mysql://mysql27-farm1.kinghost.net:3306/dudu01";
	private String usuario = "dudu0101_add1";
	private String senha= "dudu1234";
	public Connection con;
	
	
	public void Conexao() throws ClassNotFoundException{
		try{
		Class.forName(driver);
		con = (Connection) DriverManager.getConnection(caminho, usuario, senha);
		System.out.println("Conectado!");
		
	}catch(SQLException ex){
		Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE,null,ex);
		JOptionPane.showMessageDialog(null, "Erro ao se conectar:\n"+ex);
	}
	}
		public void Desconectar(){
			try{
				con.close();
				
			}catch(SQLException ex){
				JOptionPane.showMessageDialog(null, "Erro ao fechar o BD:\n"+ex);
			}
		}
		public void ExecutaSql(String sql){
			try{
				stm = (Statement) con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
				rs = stm.executeQuery(sql);
			}catch(SQLException ex){
				JOptionPane.showMessageDialog(null, "Erro executaSQL:\n"+ex);
				Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
		
	}

