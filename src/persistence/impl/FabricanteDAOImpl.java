package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Fabricante;
import persistence.GenericDAO;

public class FabricanteDAOImpl implements IDAOImpl<Fabricante> {

	GenericDAO gd;
	Connection con;
	private List<Fabricante> list;
	
	public FabricanteDAOImpl() {
		// TODO Auto-generated constructor stub
		con = gd.getConnection();
	}
	
	@Override
	public void insert(Fabricante classe) {
		String sql = "insert into Fabricante values (?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getCnpj());
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
		String sql = "update Fabricante set "
				+ "cnpj = ?, nome = ? where cnpj = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt( 1, classe.getCnpj() );
			stmt.setString(2, classe.getNome());
			stmt.setInt(3, classe.getCnpj());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Fabricante atualizado");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Fabricante classe) {
		// TODO Auto-generated method stub
		String sql = "delete Fabricante where cnpj = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getCnpj());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Fabricante deletado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Fabricante searchById(int id) {
		String sql = "select * from Fabricante where cnpj = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);		
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Fabricante f = new Fabricante();
				f.setCnpj(rs.getInt("cnpj"));
				f.setNome(rs.getString("nome"));
				
				return f;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Fabricante> listarTodos() {
		String sql = "select * from Fabricante";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);	
			
			ResultSet rs = stmt.executeQuery();
			list.clear();
			while(rs.next()){
				Fabricante f = new Fabricante();
				f.setCnpj(rs.getInt("cnpj"));
				f.setNome(rs.getString("nome"));				
				
				list.add(f);
			}
			return list;
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return null;
	}
		

}
