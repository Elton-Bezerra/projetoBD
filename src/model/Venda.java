package model;

import java.util.Date;
import java.util.List;

public class Venda {

	private int id;
	private Date dataVenda;
	private double valorTotal;
	private Cliente cliente;
	private List<ItemVenda> itens;
	
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemVenda> getItens() {
		return itens;
	}
	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
