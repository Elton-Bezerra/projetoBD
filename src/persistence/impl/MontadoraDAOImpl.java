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
	private List<Montadora> list;
	public MontadoraDAOImpl(){
		con = gd.getConnection();
	}
	@Override
	public void insert(Montadora classe) {
		String sql = "insert into Montadora values (?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, classe.getNome());
			stmt.setString(2, classe.getDescricao());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Montadora adicionada com sucesso");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Montadora classe) {
		String sql = "update Montadora set "
				+ "nome = ?, descricao = ? where id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, classe.getNome());
			stmt.setString(2, classe.getDescricao());
			stmt.setInt(3, classe.getId());
			if(stmt.executeUpdate() > 0){
				System.out.println("Montadora atualizada com sucesso");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Montadora classe) {
		String sql = "delete Montadora where id = ? ";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getId());
			if(stmt.executeUpdate() > 0){
				System.out.println("Montadora deletada com sucesso");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		String sql = "SELECT * FROM Montadora";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			list.clear();
			while(rs.next()){
				Montadora m = new Montadora();
				m.setId(rs.getInt("id"));
				m.setNome(rs.getString("nome"));
				m.setDescricao(rs.getString("descricao"));
				list.add(m);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
