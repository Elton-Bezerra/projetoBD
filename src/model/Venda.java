package model;

import java.util.Date;
import java.util.List;

public class Venda {

	private int id;
	private Date dataVenda;
	private double valorTotal;

	
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public void setValorTotal(double valorTotal){
		this.valorTotal = valorTotal;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
