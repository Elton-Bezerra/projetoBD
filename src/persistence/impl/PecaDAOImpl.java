package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Peca;
import persistence.GenericDAO;

public class PecaDAOImpl implements IDAOImpl<Peca>{

	GenericDAO gd = new GenericDAO();
	Connection con;
	private List<Peca> list = new ArrayList<Peca>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public PecaDAOImpl() {
		con = gd.getConnection();		
	}
	@Override
	public void insert(Peca classe) {
		// TODO Auto-generated method stub
		String sql = "Insert into Peca (tipo, nome, aplicacao, valor, dtAdc, fabricante, carro) values (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, classe.getTipo());
			stmt.setString(2, classe.getNome());
			stmt.setString(3, classe.getAplicacao());
			stmt.setDouble(4, classe.getValor());
			stmt.setString(5, sdf.format(classe.getDtAdc()));
			stmt.setInt(6, classe.getFabricante());
			stmt.setInt(7, classe.getCarro());
			
			
			if(stmt.executeUpdate() > 0 ){
				System.out.println("Peça inserida.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Peca classe) {
		// TODO Auto-generated method stub
		String sql = "update Peca set "
				+ "tipo = ?, nome = ?, aplicacao = ?, valor = ?, set dtAdc = ?, fabricante = ? "
				+ "forenecedor = ?, carro = ? where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, classe.getTipo());
			stmt.setString(2, classe.getNome());
			stmt.setString(3, classe.getAplicacao());
			stmt.setDouble(4, classe.getValor());
			stmt.setString(5, sdf.format(classe.getDtAdc()));
			stmt.setInt(9,  classe.getId());
			
			if(stmt.executeUpdate() > 0){
				System.out.println("Peça atualizada.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Peca classe) {
		// TODO Auto-generated method stub
		String sql = "delete Peca where id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, classe.getId());
			
			if (stmt.executeUpdate() > 0) {
				System.out.println("Peça deletada.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Peca searchById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from Peca where id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Peca p = new Peca();
				
				p.setId(rs.getInt("id"));
				p.setTipo(rs.getString("tipo"));
				p.setNome(rs.getString("nome"));
				p.setAplicacao(rs.getString("aplicacao"));
				p.setValor(rs.getDouble("valor"));
				p.setDtAdc(rs.getDate("dtAdc"));
				
				return p;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Peca> listarTodos() {
		String sql = "select * from Peca";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			list.clear();
			while(rs.next()){
				Peca p = new Peca();
				
				p.setId(rs.getInt("id"));
				p.setTipo(rs.getString("tipo"));
				p.setNome(rs.getString("nome"));
				p.setAplicacao(rs.getString("aplicacao"));
				p.setValor(rs.getDouble("valor"));
				p.setDtAdc(rs.getDate("dtAdc"));
				p.setCarro(rs.getInt("carro"));
				p.setFabricante(rs.getInt("fabricante"));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
