package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import persistence.GenericDAO;
import persistence.impl.PecaDAOImpl;

public class PecaModel implements TableModel {
	GenericDAO gd = new GenericDAO();
	Connection con;
	List<Peca> lista = new ArrayList<Peca>();
	
	
	public PecaModel() {
		// TODO Auto-generated constructor stub
		con = gd.getConnection();
		PecaDAOImpl pdao = new PecaDAOImpl();
		lista = pdao.listarTodos();
		
		
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex){
			case 0 : return "ID";
			case 1 : return "Tipo";
			case 2 : return "Nome";
			case 3 : return "Aplicação";
			case 4 : return "Valor";
			case 5 : return "Carro";
			case 6 : return "Fabricante";
		}
		return "";
	}

	@Override
	public Class<?> getColumnClass(int index) {
		// TODO Auto-generated method stub
		switch(index){
		case 0 : return Integer.class;
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4 : return Float.class;
		case 5 : return Integer.class;
		case 6 : return Integer.class;
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
		// TODO Auto-generated method stub
		Peca p = lista.get(rowIndex);
		switch(columnIndex){
		case 0 : return p.getId();
		case 1 : return p.getTipo();
		case 2 : return p.getNome();
		case 3 : return p.getAplicacao();
		case 4 : return p.getValor();
		case 5 : return p.getCarro();
		case 6 : return p.getFabricante();
		}		
		
		return "";
	}

	public void adicionar(Peca p){
		try {
			PecaDAOImpl pdao = new PecaDAOImpl();
			pdao.insert(p);		
			
			System.out.println("Consulta gravada com sucesso");
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void pesquisarPorNome(String nome){
		PecaDAOImpl pdao = new PecaDAOImpl();
		lista = pdao.listarTodos();
	}
	
	public void deletar(Peca p){
		PecaDAOImpl pdao = new PecaDAOImpl();
		pdao.delete(p);
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

	public Peca getPecaByRow(int row){
		return lista.get(row);
	}
	
	
}
