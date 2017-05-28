package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		String sql = "Insert into Cliente values (?, ?, ?, ?, ?) ";
		
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getCpf());
			stmt.setString(2, classe.getNome());
			stmt.setString(3, classe.getTelefone());
			stmt.setString(4, classe.getLogradouro());
			stmt.setInt(5, classe.getNumero());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Cliente inserido.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Cliente classe) {
		// TODO Auto-generated method stub
		String sql = "update Cliente "
				+ "set cpf = ?, set nome = ?, set telefone = ?, set logradouro = ?, set numero = ?"
				+ "where cpf = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getCpf());
			stmt.setString(2, classe.getNome());
			stmt.setString(3, classe.getTelefone());
			stmt.setString(4, classe.getLogradouro());
			stmt.setInt(5, classe.getNumero());
			stmt.setInt(6, classe.getCpf());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Cliente atualizado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public void delete(Cliente classe) {
		// TODO Auto-generated method stub
		String sql = "delete Cliente where cpf = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getCpf());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Cliente deletado.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Cliente searchById(int id) {
		String sql = "Select * From Cliente where cpf = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Cliente c = new Cliente();
				
				c.setCpf(rs.getInt("cpf"));
				c.setNome(rs.getString("nome"));
				c.setTelefone(rs.getString("telefone"));
				c.setLogradouro(rs.getString("logradouro"));
				c.setNumero(rs.getInt("numero"));
				
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> listarTodos() {
		String sql = "Select * From Cliente";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);			
			ResultSet rs = stmt.executeQuery();
			
			list.clear();
			while(rs.next()){
				Cliente c = new Cliente();
				
				c.setCpf(rs.getInt("cpf"));
				c.setNome(rs.getString("nome"));
				c.setTelefone(rs.getString("telefone"));
				c.setLogradouro(rs.getString("logradouro"));
				c.setNumero(rs.getInt("numero"));	
				
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
