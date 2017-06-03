package model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import persistence.GenericDAO;
import persistence.impl.ItemVendaDAOImpl;
import persistence.impl.PecaDAOImpl;

public class ItemVendaModel implements TableModel {

	private List<ItemVenda> lista = new ArrayList<ItemVenda>();
	private List<ItemVenda> lst;
	Connection con;
	public ItemVendaModel() {
		// TODO Auto-generated constructor stub
		GenericDAO gd = GenericDAO.getInstance();
		con = gd.getConnection();
		ItemVendaDAOImpl ivdao = new ItemVendaDAOImpl();
		lista = ivdao.listarTodos();		
	}
	
	public ItemVendaModel(ArrayList<ItemVenda> lst) {
		// TODO Auto-generated constructor stub
		GenericDAO gd = GenericDAO.getInstance();
		con = gd.getConnection();
		ItemVendaDAOImpl ivdao = new ItemVendaDAOImpl();
		this.lst = ivdao.listarTodos();		
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
		case 0 : return "Peça";
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
	
	public void addRow(ItemVenda iv){
		this.addRow(iv);
	}
	

}
