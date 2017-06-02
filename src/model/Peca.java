package model;

import java.util.Date;

public class Peca {

	private int id;
	private String tipo;
	private String nome;
	private String aplicacao;
	private double valor;
	private Date dtAdc;
	private int carro;
	private int fabricante;
	private int quantidade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAplicacao() {
		return aplicacao;
	}
	public void setAplicacao(String aplicacao) {
		this.aplicacao = aplicacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getDtAdc() {
		return dtAdc;
	}
	public void setDtAdc(Date dtAdc) {
		this.dtAdc = dtAdc;
	}
	public int getCarro() {
		return carro;
	}
	public void setCarro(int carro) {
		this.carro = carro;
	}
	public int getFabricante() {
		return fabricante;
	}
	public void setFabricante(int fabricante) {
		this.fabricante = fabricante;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
