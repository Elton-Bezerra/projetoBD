package persistence.impl;

import java.sql.Connection;
import java.util.List;

import model.Cliente;
import persistence.GenericDAO;

public class ClienteDAOImpl implements IDAOImpl<Cliente>{

	GenericDAO gd;
	Connection con;
	private List<Cliente> list;
	
	public ClienteDAOImpl() {
		con = gd.getConnection();		
	}
	
	@Override
	public void insert(Cliente classe) {
		String sql = "Insert into Cliente ";
		
	}

	@Override
	public void update(Cliente classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cliente classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
