package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Fabricante;
import persistence.GenericDAO;

public class FabricanteDAOImpl implements IDAOImpl<Fabricante> {

	GenericDAO gd;
	Connection con;
	
	public FabricanteDAOImpl() {
		// TODO Auto-generated constructor stub
		con = gd.getConnection();
	}
	
	@Override
	public void insert(Fabricante classe) {
		String sql = "insert into Fabricante values (?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, classe.getCnpj());
			stmt.setString(2, classe.getNome());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Fabricante inserido com sucesso");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Fabricante classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Fabricante classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fabricante searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fabricante> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
