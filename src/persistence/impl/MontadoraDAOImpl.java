package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Montadora;
import persistence.GenericDAO;

public class MontadoraDAOImpl implements IDAOImpl<Montadora>{

	GenericDAO gd;
	Connection con;
	
	public MontadoraDAOImpl(){
		con = gd.getConnection();
	}
	@Override
	public void insert(Montadora classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Montadora classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Montadora classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Montadora searchById(int id) {
		String sql = "SELECT * FROM Montadora where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			Montadora m = null;
			while(rs.next()){
				m = new Montadora();
				m.setId(rs.getInt("id"));
				m.setNome(rs.getString("nome"));
				m.setDescricao(rs.getString("descricao"));
			}			
			return m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Montadora> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
