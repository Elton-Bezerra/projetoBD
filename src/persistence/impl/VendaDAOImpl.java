package persistence.impl;

import java.sql.Connection;
import java.util.List;

import model.Venda;
import persistence.GenericDAO;

public class VendaDAOImpl implements IDAOImpl<Venda>{

	GenericDAO gd;
	Connection con;
	private List<Venda> list;
	
	@Override
	public void insert(Venda classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Venda classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Venda classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Venda searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venda> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
