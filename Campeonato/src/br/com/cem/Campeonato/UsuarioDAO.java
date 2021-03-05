package br.com.cem.Campeonato;

//Bibliotecas Importadas
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import ConexaoBd.ConexaoBD;

import br.com.cem.Campeonato.Usuario;

public class UsuarioDAO {
	
	//Instancia da classe para conectar-se ao BD
	ConexaoBD conex = new ConexaoBD();
	
	public void ExcluirUsuario(Usuario usu){
		conex.Conexao();//Conectando com o BD
		try {
			PreparedStatement pst = (PreparedStatement) conex.con.prepareStatement("DELETE FROM usuario WHERE idUsuario=?");//Sintaxe para excluir dados da tabela no MYSQL
			
			//Atribuindo valor ao '?' da sintaxe do MYSQL
			pst.setInt(1, usu.getId_Usuario());
			
		pst.execute();//Executa a atribuicao de valor a variavel e a sintaxe do MYSQL
		JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");//Mostra que deu tudo certo na hora de excluir o user
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar os excluir dados!"+ex);//Mostra que ocorreu um erro na hora de excluir o user para o usuario
		}
		
		conex.Desconectar();//Desconectando do BD
	}
	
	public void Editar(Usuario usuario) {
		conex.Conexao();//Conectando com o BD
		try {
			PreparedStatement pst = (PreparedStatement) conex.con.prepareStatement("UPDATE usuario set nome=?,"
					+ "email=?, senha=?, sexo=? Where idUsuario=?");//Sintaxe de alteracao de dados da tabela no MYSQL
			
			//Atribuindo valores aos '?' da sintaxe do MYSQL
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			pst.setString(4, usuario.getSexo());
			pst.setInt(5, usuario.getId_Usuario());
			
			pst.execute();//Executando os valores atribuidos as variaveis e a sintaxe do MYSQL 
			JOptionPane.showMessageDialog(null, "Dados Alterado com sucesso!");//Mostrando para o usuario que os dados foram alterados com sucesso
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar os dados!"+ex);//Mostra que houve algum erro na hora de alterar os dados para o usuario
		}
		conex.Desconectar();//Desconectando do BD
	}
	
	public Usuario Pesquisar(Usuario usu){
		conex.Conexao();//Conectando ao BD
		
		conex.ExecutaSql("SELECT * FROM usuario WHERE email like'%"+usu.getPesquisa()+"%'");//Sintaxe para pegar dados da tabela do MYSQL com uma variavel que vai ter o seu valor determinado pelo usuario
		try {
			//Atribuindo valores as variaveis da classe Usuario com os dados que foram selecionados na tabela do MYSQL
			conex.rs.first();
			usu.setId_Usuario(conex.rs.getInt("idUsuario"));
			usu.setNome(conex.rs.getString("nome"));
			usu.setEmail(conex.rs.getString("email"));
			usu.setSenha(conex.rs.getString("senha"));
			usu.setSexo(conex.rs.getString("sexo"));
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Usuario!\n"+ex);//Mostrando que houve algum erro na hora da busca para o usuario
		}
		conex.Desconectar();//Desconectando do BD
		return usu;
	}
	
	public void Salvar(Usuario usuario){
		conex.Conexao();//Conectando ao BD
		try{
			PreparedStatement pst = (PreparedStatement) conex.con.prepareStatement("INSERT INTO usuarios(nome_Usuario, email, senha, cargo) "
					+ "Values (?,?,?,?)");//Sintaxe para inserir dados em uma tabela do MYSQL
			
		//Atribundo valores aos '?' com os valores que foram atribuidos pelos usuarios 	
		pst.setString(1, usuario.getNome());
		pst.setString(2, usuario.getEmail());
		pst.setString(3, usuario.getSenha());
		pst.setString(4, usuario.getSexo());
		
		pst.execute();//Executando os valores atribuidos as variaveis e a sintaxe do MYSQL
		JOptionPane.showMessageDialog(null, "Usuario inserido com sucesso!");//Mostrando para o usuario que deu tudo certo na hora de inserir um novo user
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao inserir dados:\n"+ex);//Mostrando que houve algum erro na hora de inserir um novo user para o usuario
		}
		
	}
	}

