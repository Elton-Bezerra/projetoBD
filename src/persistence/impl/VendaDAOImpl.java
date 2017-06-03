package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.ItemVenda;
import model.Venda;
import persistence.GenericDAO;

public class VendaDAOImpl implements IDAOImpl<Venda>{

	
	Connection con;
	private List<Venda> list = new ArrayList<Venda>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public VendaDAOImpl() {
		GenericDAO gd = GenericDAO.getInstance();
		con = gd.getConnection();
	}
	
	@Override
	public void insert(Venda classe) {
		// TODO Auto-generated method stub
		String sql = "insert into Venda (valorTotal) values (?)";
		
		try {					
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDouble(1, classe.getValorTotal());	
			if(stmt.executeUpdate() > 0){
				System.out.println("Venda inserida.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Venda classe) {
		// TODO Auto-generated method stub
		String sql = "update Venda set 	valorTotal = ?"
				+ "where id = ?	";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDouble(1, classe.getValorTotal());
			stmt.setInt(4, classe.getId());
				
			if(stmt.executeUpdate() > 0){
				System.out.println("Venda atualizada.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Venda classe) {
		// TODO Auto-generated method stub
		String sql = "delete Venda where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getId());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Venda deletada.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Venda searchById(int id) {
		return null;
	}

	@SuppressWarnings("null")
	public List<Venda> searchByIds(int id){
		String sql = "select * from Venda where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs =	stmt.executeQuery();
			
			list.clear();
			
			List<ItemVenda> listaItens = null;
			
			while(rs.next()){
				ItemVendaDAOImpl ivdao = new ItemVendaDAOImpl();
				ItemVenda iv =  ivdao.searchById(rs.getInt("itens"));
				listaItens.add(iv);
				Venda v = new Venda();
				v.setDataVenda(rs.getDate("dataVenda"));
				v.setId(rs.getInt("id"));
				
				list.add(v);
			}
			
			return list;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Venda> listarTodos() {
		String sql = "select * from Venda";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs =	stmt.executeQuery();
			
			list.clear();			
			while(rs.next()){
				Venda v = new Venda();
				v.setId(rs.getInt("id"));
				v.setDataVenda(rs.getDate("dataVenda"));				
				v.setValorTotal(rs.getDouble("valorTotal"));
				System.out.println(rs.getDouble("valorTotal"));
				list.add(v);
			}
			
			return list;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	

}
