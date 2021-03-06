package model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import persistence.GenericDAO;
import persistence.impl.ItemVendaDAOImpl;
import persistence.impl.VendaDAOImpl;

public class ItemVendaModel implements TableModel {

	private List<ItemVenda> lista = new ArrayList<ItemVenda>();
	Connection con;
	public ItemVendaModel() {
		// TODO Auto-generated constructor stub
		GenericDAO gd = GenericDAO.getInstance();
		con = gd.getConnection();
		ItemVendaDAOImpl ivdao = new ItemVendaDAOImpl();
		lista = ivdao.listarTodos();		
	}
	
	public void atualizaLista(int venda){
		ItemVendaDAOImpl ivdao = new ItemVendaDAOImpl();
		lista = ivdao.searchByVendas(venda);			
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex){
		case 0 : return String.class;
		case 1 : return Integer.class;
		case 2 : return Float.class;
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex){
		case 0 : return "Pe�a";
		case 1 : return "Quantidade";
		case 2 : return "Subtotal";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
	
	public void adicionarItens(List<ItemVenda> l){
		ItemVendaDAOImpl ivdao = new ItemVendaDAOImpl();
		VendaDAOImpl vdao = new VendaDAOImpl();
		Venda v = new Venda();
		v = vdao.listarTodos().get(vdao.listarTodos().size()-1);
		for(ItemVenda iv: l){
			iv.setVenda(v);
		}
		ivdao.inserirItens(l);
	}
		
	
	public ItemVenda getItemVendaByRow(int row) { 
		return lista.get(row);
	}

}
