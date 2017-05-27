package persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO implements IGenericDAO {

	private static Connection con;

	public Connection getConnection() { 

		try { 
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;"
					+ "DatabaseName=projetoBD;namedPipe=true","elton","Elton@1997");
			System.out.println("Conexao ok");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return con; 
	}

	public static void main(String[] args) {
		GenericDAO gd = new GenericDAO();
		Connection con = gd.getConnection();
		
	}

	public void fechaConexao(){
		try {
			if(con!=null) con.close();
			con =null;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

