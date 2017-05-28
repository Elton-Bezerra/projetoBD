package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.Cliente;
import model.ItemVenda;
import model.Venda;
import persistence.GenericDAO;

public class VendaDAOImpl implements IDAOImpl<Venda>{

	GenericDAO gd;
	Connection con;
	private List<Venda> list;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public VendaDAOImpl() {
		con = gd.getConnection();
	}
	
	@Override
	public void insert(Venda classe) {
		// TODO Auto-generated method stub
		String sql = "insert into Venda values (?,?,?,?)";
		
		try {					
			PreparedStatement stmt = con.prepareStatement(sql);
			for(ItemVenda iv: classe.getItens()){				
				stmt.setString(1, sdf.format(classe.getDataVenda()));
				stmt.setDouble(2, classe.getValorTotal());
				stmt.setInt(3,classe.getCliente().getCpf());	
				stmt.setInt(4, iv.getId());
				
				if(stmt.executeUpdate() > 0){
					System.out.println("Venda inserida.");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Venda classe) {
		// TODO Auto-generated method stub
		String sql = "update Venda set 	valorTotal = ?, set cliente = ?, set itens = ?"
				+ "where id = ?	";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			for(ItemVenda iv: classe.getItens()){				
				stmt.setDouble(1, classe.getValorTotal());
				stmt.setInt(2,classe.getCliente().getCpf());	
				stmt.setInt(3, iv.getId());
				stmt.setInt(4, classe.getId());
				
				if(stmt.executeUpdate() > 0){
					System.out.println("Venda atualizada.");
				}
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
		String sql = "select * from Venda where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			/*while(rs.next()){
				Venda v = new Venda();
				ClienteDAOImpl cdao = new ClienteDAOImpl();
				Cliente c = cdao.searchById(rs.getInt("cliente"));
				
				List<ItemVenda> listaVenda;
				ItemVendaDAOImpl ivdao = new ItemVendaDAOImpl();
				for(ItemVenda iv: listaVenda){
					
				}
				ItemVenda iv = ivdao.searchById(rs.getInt("itens"));
				
				v.setDataVenda(rs.getDate("dataVenda"));
				v.setId(rs.getInt("id"));
				v.setValorTotal(rs.getDouble("valorTotal"));
				v.setCliente(c);
				v.setItens(iv);
				*/
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<Venda> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
