package model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import persistence.GenericDAO;
import persistence.impl.ItemVendaDAOImpl;
import persistence.impl.VendaDAOImpl;

public class VendaModel implements TableModel {

	List<Venda> lista = new ArrayList<Venda>();
	private Connection con;
	public VendaModel() {
		// TODO Auto-generated constructor stub
		GenericDAO gd = GenericDAO.getInstance();
		con = gd.getConnection();
		VendaDAOImpl vdao = new VendaDAOImpl();
		lista = vdao.listarTodos();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex){
		case 0 : return "ID";
		case 1 : return "Data Venda";
		case 2 : return "Valor total";
		}
		return " ";
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex){
		case 0 : return Integer.class;
		case 1 : return Date.class;
		case 2 : return Float.class;
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Venda v = lista.get(0);
		switch(columnIndex){
		case 0 : return v.getId();
		case 1 : return v.getDataVenda();
		case 2 : return v.getValorTotal();
		}		
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	
	public void adicionarVenda(Venda v){
		VendaDAOImpl vdao = new VendaDAOImpl();		
		vdao.insert(v);
	}
	
	public Venda getLast(){
		VendaDAOImpl vdao = new VendaDAOImpl();
		Venda v = vdao.listarTodos().get(vdao.listarTodos().size() -1);
		return v;
	}

}
