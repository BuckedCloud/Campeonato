package br.com.cem.Campeonato;

public class Partida {
	
	//Variaveis
	private int id_Casa;
	private int id_Visitante;
	private int golsCasa;
	private int golsVisitante;
	private int cartA_Casa;
	private int cartV_Casa;
	private int cartA_Visitante;
	private int cartV_Visitante;
	private int rodada;
	private int numPartida;
	
	//Variaveis usadas pela classe DAO
	int pesquisa;
	int idPartida;
	int procura;
	
	//Setters & Getters usados pela classe DAO para pesquisar no BD
	public int getProcura() {
		return procura;
	}
	public void setProcura(int procura) {
		this.procura = procura;
	}
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public int getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(int pesquisa) {
		this.pesquisa = pesquisa;
	}

	//Metodo Construtor
	public Partida(int id_Casa,int id_Visitante,int golsCasa,int golsVisitante,int cartA_Casa,int cartV_Casa,int cartA_Visitante,int cartV_Visitante,int rodada,int numPartida){
		this.id_Casa = id_Casa;
		this.id_Visitante = id_Visitante;
		this.golsCasa = golsCasa;
		this.golsVisitante = golsVisitante;
		this.cartA_Casa = cartA_Casa;
		this.cartA_Visitante = cartA_Visitante;
		this.cartV_Casa = cartV_Casa;
		this.cartV_Visitante = cartV_Visitante;
		this.rodada = rodada;
		this.numPartida = numPartida;
	}
	
	//Setters & Getters
	public int getId_Casa() {
		return id_Casa;
	}
	public void setId_Casa(int id_Casa) {
		this.id_Casa = id_Casa;
	}
	public int getId_Visitante() {
		return id_Visitante;
	}
	public void setId_Visitante(int id_Visitante) {
		this.id_Visitante = id_Visitante;
	}
	public int getGolsCasa() {
		return golsCasa;
	}
	public void setGolsCasa(int golsCasa) {
		this.golsCasa = golsCasa;
	}
	public int getGolsVisitante() {
		return golsVisitante;
	}
	public void setGolsVisitante(int golsVisitante) {
		this.golsVisitante = golsVisitante;
	}
	public int getCartA_Casa() {
		return cartA_Casa;
	}
	public void setCartA_Casa(int cartA_Casa) {
		this.cartA_Casa = cartA_Casa;
	}
	public int getCartV_Casa() {
		return cartV_Casa;
	}
	public void setCartV_Casa(int cartV_Casa) {
		this.cartV_Casa = cartV_Casa;
	}
	public int getCartA_Visitante() {
		return cartA_Visitante;
	}
	public void setCartA_Visitante(int cartA_Visitante) {
		this.cartA_Visitante = cartA_Visitante;
	}
	public int getCartV_Visitante() {
		return cartV_Visitante;
	}
	public void setCartV_Visitante(int cartV_Visitante) {
		this.cartV_Visitante = cartV_Visitante;
	}
	public int getRodada() {
		return rodada;
	}
	public void setRodada(int rodada) {
		this.rodada = rodada;
	}
	public int getNumPartida() {
		return numPartida;
	}
	public void setNumPartida(int numPartida) {
		this.numPartida = numPartida;
	}
	
	

}
