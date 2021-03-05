package br.com.cem.Campeonato;

public class Clube {
	
	//Variaveis
	private String nome;
	private String estado;
	private int jogo;
	private int ponto;
	private int vitorias;
	private int derrotas;
	private int empates;
	private int golsPro;
	private int golsContra;
	private int difGols;
	private int idClube;
	
	//Variaveis usadas pela classe DAO
	String pesquisa;
	int Procura;

	//Setter & Getters usados pela classe DAO para pesquisar no BD
	public int getProcura() {
		return Procura;
	}
	public void setProcura(int procura) {
		Procura = procura;
	}
	public String getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	//Metodo Construtor
	public Clube(String nome,String estado,int jogo,int ponto,int vitorias,
		int derrotas,int empates,int golsPro,
		int golsContra,int difGols,int idClube){
	this.nome = nome;
	this.estado = estado;
	this.jogo = jogo;
	this.ponto = ponto;
	this.vitorias = vitorias;
	this.derrotas = derrotas;
	this.empates = empates;
	this.golsPro = golsPro;
	this.golsContra = golsContra;
	this.difGols = difGols;
	this.idClube = idClube;	
}

	//Setter & Getters
	public String getNome() {
	return nome;
}
	public void setNome(String nome) {
	this.nome = nome;
}
	public String getEstado() {
	return estado;
}
	public void setEstado(String estado) {
	this.estado = estado;
}
	public int getJogo() {
	return jogo;
}
	public void setJogo(int jogo) {
	this.jogo = jogo;
}
	public int getPonto() {
	return ponto;
}
	public void setPonto(int ponto) {
	this.ponto = ponto;
}
	public int getVitorias() {
	return vitorias;
}
	public void setVitorias(int vitorias) {
	this.vitorias = vitorias;
}
	public int getDerrotas() {
	return derrotas;
}
	public void setDerrotas(int derrotas) {
	this.derrotas = derrotas;
}
	public int getEmpates() {
	return empates;
}
	public void setEmpates(int empates) {
	this.empates = empates;
}
	public int getGolsPro() {
	return golsPro;
}
	public void setGolsPro(int golsPro) {
	this.golsPro = golsPro;
}
	public int getGolsContra() {
	return golsContra;
}
	public void setGolsContra(int golsContra) {
	this.golsContra = golsContra;
}
	public int getDifGols() {
	return difGols;
}
	public void setDifGols(int difGols) {
	this.difGols = difGols;
}
	public int getIdClube() {
	return idClube;
}
	public void setIdClube(int idClube) {
	this.idClube = idClube;
}
}


