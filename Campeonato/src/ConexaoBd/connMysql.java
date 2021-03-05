package ConexaoBd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//In�cio da classe de conex�o//

public class connMysql {
	 public static String status = "N�o conectou...";
	    public connMysql() {
	    }
	public static java.sql.Connection getConnection() {
	        Connection conn = null; //pro compilador ficar feliz
	        try {
	        // Carrega o driver JDBC 
	        String driverName = "com.mysql.jdbc.Driver";   
	        Class.forName(driverName); 
	        // Configura��o da conex�o com um banco de dados//
	        //troque por seu ip, senha, user, etc
	        String serverName = "179.55.148.155:3306";    //caminho do servidor do BD
	        String mydatabase ="dudu01";        //nome do seu banco de dados
	        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
	        String user = "dudu01@10.19.0.12";        //nome de um usu�rio de seu BD      
	        String key = "ATCADEGAS1234";      //sua senha de acesso
	        conn = DriverManager.getConnection(url, user, key);         

	        //Testa sua conex�o// 
	        if (conn != null) {
	            status = ("STATUS--->Conectado com sucesso!");
	        } else {
	            status = ("STATUS--->N�o foi possivel realizar conex�o");
	        }
	        return conn; 

	    } catch (ClassNotFoundException e) {  //Driver n�o encontrado 
	                System.out.println("O driver expecificado nao foi encontrado.");
	                return null;
	    } catch (SQLException e) {
	    //N�o conseguindo se conectar ao banco
	            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
	            return null;
	      }
	}
	    //M�todo que retorna o status da sua conex�o//
	    public static String statusConection() {
	        return status;
	    }  

	   //M�todo que fecha sua conex�o//
	    public static boolean closeConnection() {
	        try {
	            connMysql.getConnection().close();
	            return true;
	        } catch (SQLException e) {
	            return false;
	        }
	    }

	   //M�todo que reinicia sua conex�o//
	    public static java.sql.Connection restartConnection() {
	        closeConnection();
	        return connMysql.getConnection();
	    }}
