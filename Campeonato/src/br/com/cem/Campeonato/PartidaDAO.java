package br.com.cem.Campeonato;

//Bibliotecas Importadas
import java.awt.JobAttributes;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import ConexaoBd.ConexaoBD;

public class PartidaDAO {
	
	//Instancia da classe para conectar-se ao BD
	ConexaoBD conex = new ConexaoBD();
	//Instanciando o metodo construtor para atribuir os valores das variaveis 
	//Partida part = new Partida(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	
	public void Salvar(Partida part){
		conex.Conexao();//Iniciando Conexao com o BD
		try{
			PreparedStatement partida = (PreparedStatement) conex.con.prepareStatement("INSERT INTO partida(idCasa,"
				+ "idVisitante,golsCasa,golsVisitante,cartA_Casa,cartA_Visitante,cartV_Casa,cartV_Visitante,rodada,numPartida) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?)");//Sintaxe para inserir dados no MYSQL
		
		//Atribuindo o valor para a '?' da Sintaxe com valores escolhidos pelo user nas variaveis 
		partida.setInt(1, part.getId_Casa());
		partida.setInt(2, part.getId_Visitante());
		partida.setInt(3, part.getGolsCasa());
		partida.setInt(4, part.getGolsVisitante());
		partida.setInt(5, part.getCartA_Casa());
		partida.setInt(6, part.getCartA_Visitante());
		partida.setInt(7, part.getCartV_Casa());
		partida.setInt(8, part.getCartV_Visitante());
		partida.setInt(9, part.getRodada());
		partida.setInt(10, part.getNumPartida());
		
		partida.execute();//Executa os valores que foram atribuidos as variaveis na Sintaxe do MYSQL
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao inserir dados:\n"+ex);
		}
		conex.Desconectar();//Desconectando do BD
	}
	
	public Partida PesquisarPartida(Partida part){
			conex.Conexao();//Iniciando Conexao com o BD
			conex.ExecutaSql("SELECT * FROM partida WHERE rodada="+part.getPesquisa()+"&& numPartida="+part.getProcura());//Sintaxe para pegar dados da tabela do MYSQL
			try {
				//preenchendo variaveis com os dados da tabela preenchida no MYSQL para mostrar para o user
				conex.rs.first();
				part.setRodada(conex.rs.getInt("rodada"));
				
				part.setNumPartida(conex.rs.getInt("numPartida"));
				
				part.setCartA_Casa(conex.rs.getInt("cartA_Casa"));
				
				part.setCartA_Visitante(conex.rs.getInt("cartA_Visitante"));
				
				part.setCartV_Casa(conex.rs.getInt("cartV_Casa"));
				
				part.setCartV_Visitante(conex.rs.getInt("cartV_Visitante"));
				
				part.setGolsCasa(conex.rs.getInt("golsCasa"));
				
				part.setGolsVisitante(conex.rs.getInt("golsVisitante"));
				
				part.setId_Casa(conex.rs.getInt("idCasa"));
				
				part.setId_Visitante(conex.rs.getInt("idVisitante"));
			} catch (SQLException ex) {
				//Mostra mensagem para o user caso tiver erro ao encontrar o clube desejado
				JOptionPane.showMessageDialog(null, "Erro ao Buscar partida\n"+ex);
			}
			conex.Desconectar();//Desconectando do BD
			return part;
			
	}
		
	public void Editar(Partida part) {
			conex.Conexao();//Iniciando Conexao com o BD
			try {
				
				PreparedStatement pst = (PreparedStatement) conex.con.prepareStatement("UPDATE partida set rodada=?,"
						+ "numPartida=?, idCasa=?, idVisitante=?, golsCasa=?, golsVisitante=?, cartA_Casa=?, cartA_Visitante=?, cartV_Casa=?,"
						+ "cartV_Visitante=? Where idPartida=?");//Sintaxe para alterar os dados que estao preenchidos na tabela do MYSQL
				
				//Atribuindo o valor para a '?' da Sintaxe com valores escolhidos pelo user nas variaveis 
				pst.setInt(1, part.getRodada());
				pst.setInt(2, part.getNumPartida());
				pst.setInt(3, part.getId_Casa());
				pst.setInt(4, part.getId_Visitante());
				pst.setInt(5, part.getGolsCasa());
				pst.setInt(6, part.getGolsVisitante());
				pst.setInt(7, part.getCartA_Casa());
				pst.setInt(8, part.getCartA_Visitante());
				pst.setInt(9, part.getCartV_Casa());
				pst.setInt(10, part.getCartV_Visitante());
				pst.setInt(11, part.getPesquisa());
				
				pst.execute();//Executando o valor atribuido a cada variavel e alterando na tabela do MYSQL
			
				JOptionPane.showMessageDialog(null, "Partida alterada");//Mostrando mensagem para o usuario que foi efetuado com sucesso a alteracao no BD
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Erro ao alterar os dados!"+ex);//Mostrando para o usuario que houve algum erro na hora da alteracao no BD
			}
			conex.Desconectar();//Desconectando do BD
		}
	public void Reinicio(){
		conex.Conexao();
		try {
			PreparedStatement pst = (PreparedStatement) conex.con.prepareStatement("DROP TABLE partida ");//Sintaxe para deletar dados da tabela do MYSQL
	
			pst.execute();
			
			PreparedStatement stmt = (PreparedStatement) conex.con.prepareStatement("CREATE TABLE IF NOT EXISTS partida(idPartida int primary key not null auto_increment,"+
							"rodada int (3) not null,"+
		                        "numPartida int (3) not null,"+
		                        "idCasa int (3) not null,"+
		                        "idVisitante int (3) not null,"+
		                        "golsCasa int (3) not null,"+
		                        "golsVisitante int (3) not null,"+
		                        "cartA_Casa int (3) not null,"+
		                        "cartA_Visitante int (3) not null,"+
		                        "cartV_Casa int (3) not null,"+
		                        "cartV_Visitante int (3) not null);");
			
			stmt.execute();
		JOptionPane.showMessageDialog(null, "Partidas reiniciadas com sucesso!");//Mostrando para o usuario que os dados foram excluidos
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao reiniciar"+ex);//Mostrando para o usuario que houvbe algum erro na hora de deltar os dados da tabela
		}
		//conex.ExecutaSql("DROP TABLE partida");
		
	//	conex.ExecutaSql("CREATE TABLE IF NOT EXISTS partida(idPartida int primary key not null auto_increment,"+
		//						"rodada int (3) not null,"+
		//                        "numPartida int (3) not null,"+
		 //                       "idCasa int (3) not null,"+
		   //                     "idVisitante int (3) not null,"+
		     //                   "golsCasa int (3) not null,"+
		       //                 "golsVisitante int (3) not null,"+
		         //               "cartA_Casa int (3) not null,"+
		           //             "cartA_Visitante int (3) not null,"+
		             //           "cartV_Casa int (3) not null,"+
		               //         "cartV_Visitante int (3) not null);");
		conex.Desconectar();
	}
	}
	