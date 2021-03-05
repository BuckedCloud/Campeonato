package br.com.cem.Campeonato;

public class Usuario {
	
	//Variaveis
	private String nome;
	private String senha;
	private String email;
	private String sexo;
	private int id_Usuario;
	
	//Variavel para a Classe DAO
	String pesquisa;

	//Setters & Getters usados pela classe DAO para pesquisar no BD
	public String getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	//Metodo Construtor
	public Usuario(String nome, String senha, String email, String sexo, int id_Usuario){
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.sexo = sexo;
		this.id_Usuario = id_Usuario;
	}
	
	//Getters & Setters
	public void setNome(String novoNome){
		this.nome = novoNome;
	}
	public String getNome(){
		return nome;
	}
	public void setSenha(String novaSenha){
		this.senha = novaSenha;
	}
	public String getSenha(){
		return senha;
	}
	public void setEmail(String novoEmail){
		this.email = novoEmail;
	}
	public String getEmail(){
		return email;
	}
	public void setSexo(String novoSexo){
		this.sexo = novoSexo;
	}
	public String getSexo(){
		return sexo;
	}
	public void setId(int novoId_Usuario){
		this.id_Usuario = novoId_Usuario;
	}
	public int getId(){
		return id_Usuario;
	}	
	public int getId_Usuario() {
		return id_Usuario;
	}
	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
}
