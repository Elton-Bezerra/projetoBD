package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Fabricante;
import model.Fornecedor;
import persistence.GenericDAO;

public class FornecedorDAOImpl implements IDAOImpl<Fornecedor>{

	GenericDAO gd;
	Connection con;
	private List<Fornecedor> list;
	
	public FornecedorDAOImpl() {
		con = gd.getConnection();
	}
	
	@Override
	public void insert(Fornecedor classe) {
		String sql = "insert into Fornecedor values (?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getCnpj());
			stmt.setString(2, classe.getNome());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Fornecedor inserido com sucesso");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Fornecedor classe) {
		// TODO Auto-generated method stub
		String sql = "update Fornecedor set "
				+ "cnpj = ?, nome = ? where cnpj = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt( 1, classe.getCnpj() );
			stmt.setString(2, classe.getNome());
			stmt.setInt(3, classe.getCnpj());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Fornecedor atualizado");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Fornecedor classe) {
		// TODO Auto-generated method stub
		String sql = "delete Fornecedor where cnpj = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getCnpj());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Fornecedor deletado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Fornecedor searchById(int id) {
		String sql = "select * from Fornecedor where cnpj = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);		
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Fornecedor f = new Fornecedor();
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
	public List<Fornecedor> listarTodos() {
		String sql = "select * from Fornecedor";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);	
			
			ResultSet rs = stmt.executeQuery();
			list.clear();
			while(rs.next()){
				Fornecedor f = new Fornecedor();
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
