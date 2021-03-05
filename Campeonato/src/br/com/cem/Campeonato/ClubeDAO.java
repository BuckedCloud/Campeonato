package br.com.cem.Campeonato;

//Bibliotecas Importadas
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import ConexaoBd.ConexaoBD;

import br.com.cem.Campeonato.Clube;

public class ClubeDAO {
	
	//Instancia da classe para se conectar ao BD
	ConexaoBD conex = new ConexaoBD();
	
	//Clube clube = new Clube(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	
	
	public void ExcluirClube(Clube clube){
		conex.Conexao();//Conectando ao BD
		try {
			PreparedStatement pst = (PreparedStatement) conex.con.prepareStatement("DELETE FROM clubes WHERE idClube=?");//Sintaxe para deletar dados da tabela do MYSQL
			
			//Atreibuindo valor ao '?' na sintaxe do MYSQL
			pst.setInt(1, clube.getIdClube());
			
			pst.execute();//Executando a atribuicao de valor da variavel e a sintaxe do MYSQL 
		JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");//Mostrando para o usuario que os dados foram excluidos
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir os dados!"+ex);//Mostrando para o usuario que houvbe algum erro na hora de deltar os dados da tabela
		}
		conex.Desconectar();//Desconectando do BD
	}
	
	public void Editar(Clube clu) {
		conex.Conexao();//Conectando ao BD
		try {
			PreparedStatement pst = (PreparedStatement) conex.con.prepareStatement("UPDATE clubes set nomeClube=?,"
					+ "estadoClube=?, jogos=?, pontos=?, vitorias=?, derrotas=?, empates=?, golsPro=?, golsContra=?,"
					+ "difGols=? Where idClube=?");//Sintaxe para altualizar dados da tabela no MYSQL
			//Atribuindo valores aos '?' na sintaxe do MYSQL
			pst.setString(1, clu.getNome());
			pst.setString(2, clu.getEstado());
			pst.setInt(3, clu.getJogo());
			pst.setInt(4, clu.getPonto());
			pst.setInt(5, clu.getVitorias());
			pst.setInt(6, clu.getDerrotas());
			pst.setInt(7, clu.getEmpates());
			pst.setInt(8, clu.getGolsPro());
			pst.setInt(9, clu.getGolsContra());
			pst.setInt(10, clu.getDifGols());
			pst.setInt(11, clu.getIdClube());
			
			pst.execute();//Executa a atribuicao de valor a variavel e a sintaxe do MYSQL
		
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar os dados!"+ex);//Mostrando para o usuario que houve algum erro na hora de atualizar
		}
		conex.Desconectar();//Desconectando do BD
	}
	
	public Clube PesquisarClube(Clube clu){
		conex.Conexao();//Conectando ao BD
		conex.ExecutaSql("SELECT * FROM clubes WHERE nomeClube like'%"+clu.getPesquisa()+"%'");//Sintaxe para pegar dados da tabela do MYSQL com uma variavel que vai ter o seu valor determinado pelo usuario
		try {
			//Atribuindo valores as variaveis da classe Usuario com os dados que foram selecionados na tabela do MYSQL
			conex.rs.first();
			clu.setIdClube(conex.rs.getInt("idClube"));
			clu.setNome(conex.rs.getString("nomeClube"));
			clu.setEstado(conex.rs.getString("estadoClube"));
			clu.setJogo(conex.rs.getInt("jogos"));
			clu.setPonto(conex.rs.getInt("pontos"));
			clu.setVitorias(conex.rs.getInt("vitorias"));
			clu.setDerrotas(conex.rs.getInt("derrotas"));
			clu.setEmpates(conex.rs.getInt("empates"));
			clu.setGolsPro(conex.rs.getInt("golsPro"));
			clu.setGolsContra(conex.rs.getInt("golsContra"));
			clu.setDifGols(conex.rs.getInt("difGols"));
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Clube!\n"+ex);//Mostrando que houve um erro na hora de buscar um clube para o usuario
		}
		conex.Desconectar();//Desconectando do BD
		return clu;
	}
	
	public void Salvar(Clube clube){
		conex.Conexao();//Conectando ao BD
		try{
			PreparedStatement pst = (PreparedStatement) conex.con.prepareStatement
					("INSERT INTO clubes(nomeClube, estadoClube, jogos, pontos, vitorias,"
							+ "derrotas, empates, golsPro, golsContra, difGols) "
					+ "Values (?,?,?,?,?,?,?,?,?,?)");//Sintaxe para inserir dados em uma tabela do MYSQL
		
		//Atribundo valores aos '?' com os valores que foram atribuidos pelos usuarios 	
		pst.setString(1, clube.getNome());
		pst.setString(2, clube.getEstado());
		pst.setInt(3, clube.getJogo());
		pst.setInt(4, clube.getPonto());
		pst.setInt(5, clube.getVitorias());
		pst.setInt(6, clube.getDerrotas());
		pst.setInt(7, clube.getEmpates());
		pst.setInt(8, clube.getGolsPro());
		pst.setInt(9, clube.getGolsContra());
		pst.setInt(10, clube.getDifGols());
		
		pst.execute();//Executa a atribuicao de valor a variavel e a sintaxe do MYSQL
		JOptionPane.showMessageDialog(null, "Clube inserido com sucesso!");//Mostrando para o usuario que deu tudo certo na hora de inserir um novo clube
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao inserir dados:\n"+ex);//Mostrando para o usuario que houve um erro na hora de inserir dados na tabela Clube
		}
		conex.Desconectar();//Desconectando do BD
		}
	
	public void Reinicio(){
		try{
		conex.Conexao();
		PreparedStatement pst = (PreparedStatement) conex.con.prepareStatement("DROP TABLE clubes ");
		
		pst.execute();
		
		PreparedStatement stmt = (PreparedStatement) conex.con.prepareStatement("CREATE TABLE IF NOT EXISTS clubes (idClube int primary key not null auto_increment,"+
                                            "nomeClube varchar(30) not null,"+
											"estadoClube varchar(30) not null,"+
                                            "pontos int(3) not null,"+
                                            "jogos varchar (10) not null,"+
                                            "vitorias int (3) not null,"+
                                            "derrotas int (3) not null,"+
                                            "empates int (3) not null,"+
                                            "golsPro int (3) not null,"+
                                            "golsContra int (3) not null,"+
                                            "difGols int (3) not null);");
		stmt.execute();
		
	JOptionPane.showMessageDialog(null, "Clubes reiniciados com sucesso!");//Mostrando para o usuario que os dados foram excluidos
	} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao reiniciar!"+ex);//Mostrando para o usuario que houvbe algum erro na hora de deltar os dados da tabela
	}conex.Desconectar();
	}
}
	
