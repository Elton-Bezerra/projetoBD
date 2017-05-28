package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Carro;
import persistence.GenericDAO;

public class CarroDAOImpl implements IDAOImpl<Carro>{

	GenericDAO gd;
	Connection con;
	public CarroDAOImpl(){
		con = gd.getConnection();
	}
	@Override
	public void insert(Carro classe) {
		// TODO Auto-generated method stub
		String sql = "insert into Carro values (?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, classe.getNome());
			stmt.setInt(2, classe.getAno());
			stmt.setInt(3, classe.getMontadora().getId());
			if(stmt.executeUpdate() > 0){
				System.out.println("Carro inserido com sucesso");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Carro classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Carro classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Carro searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
