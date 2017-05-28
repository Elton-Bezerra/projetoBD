package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		String sql = "update Carro	set "
				+ "nome = ?, ano = ?, montadora = ?"
				+ " where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, classe.getNome());
			stmt.setInt(2,classe.getAno());
			stmt.setInt(3, classe.getMontadora().getId());
			if(stmt.executeUpdate() > 0){
				System.out.println("Carro atualizado com sucesso");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Carro classe) {
		// TODO Auto-generated method stub
		String sql = "Delete Carro where id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getId());
			if(stmt.executeUpdate() > 0){
				System.out.println("Carro deletado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Carro searchById(int id) {
		String sql = "select * from Carro where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Carro c = null;
			while(rs.next()){
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setAno(rs.getInt("ano"));
				
				//c.setMontadora(rs.getInt("montadora"));
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
