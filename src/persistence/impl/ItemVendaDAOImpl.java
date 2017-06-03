package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.ItemVenda;
import model.Peca;
import persistence.GenericDAO;

public class ItemVendaDAOImpl implements IDAOImpl<ItemVenda>{

	
	Connection con;
	List<ItemVenda> list = new ArrayList<ItemVenda>();
	
	public ItemVendaDAOImpl() {
		GenericDAO gd = GenericDAO.getInstance();
		con = gd.getConnection();
	}
	
	public void inserirItens(List<ItemVenda> l){
		for(ItemVenda iv : l){
			insert(iv);
		}
	}
	
	@Override
	public void insert(ItemVenda classe) {
		String sql = "insert into ItemVenda values (?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getPeca().getId());
			stmt.setInt(2, classe.getQtd());
			stmt.setDouble(3, classe.getSubTotal());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Item de venda inserido.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(ItemVenda classe) {
		// TODO Auto-generated method stub
		String sql = "update ItemVenda set peca = ?, set qtd = ?, set subTotal = ? "
				+ "where id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getPeca().getId());
			stmt.setInt(2, classe.getQtd());
			stmt.setDouble(3, classe.getSubTotal());
			stmt.setInt(4, classe.getId());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Item de venda atualizado.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(ItemVenda classe) {
		// TODO Auto-generated method stub
		String sql = "delete ItemVenda where id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getId());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Item de venda deletado.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	@Override
	public ItemVenda searchById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from ItemVenda where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				ItemVenda iv = new ItemVenda();
				PecaDAOImpl pdao = new PecaDAOImpl();
				Peca p = pdao.searchById(rs.getInt("peca"));
				
				iv.setId(rs.getInt("id"));
				iv.setPeca(p);
				iv.setQtd(rs.getInt("qtd"));
				iv.setSubTotal(rs.getDouble("subTotal"));
				return iv;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public List<ItemVenda> listarTodos() {
		String sql = "select p.nome as nome, iv.qtd as quantidade, iv.subtotal as subTotal"
				+ " from ItemVenda iv"
				+ " INNER JOIN Peca p"
				+ " ON iv.peca = p.id" 
				+ " INNER JOIN Venda v"
				+ " ON iv.venda = v.id";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			list.clear();
			
			while(rs.next()){
				ItemVenda iv = new ItemVenda();
				PecaDAOImpl pdao = new PecaDAOImpl();
				Peca p = pdao.searchById(rs.getInt("peca"));
				
				iv.setId(rs.getInt("id"));
				iv.setPeca(p);
				iv.setQtd(rs.getInt("qtd"));
				iv.setSubTotal(rs.getDouble("subTotal"));
				
				list.add(iv);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	

}
