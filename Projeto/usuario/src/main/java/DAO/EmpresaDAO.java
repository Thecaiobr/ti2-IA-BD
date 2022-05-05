package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Empresa;

public class EmpresaDAO {

protected Connection conexao;
	
	public EmpresaDAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "teste";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão Não efetuada com o postgres -- Driver Não  encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão Não  efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean insert(Empresa empresa) {
		boolean status = false;
		System.out.println("ele entra sim");
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO empresa.empresa (id, nomeEmpresa, userid, cnpj, ramo, site, pais, estado, cidade, bairro, telefone, email) "
		               + "VALUES ("+empresa.getId()+ ", '" + empresa.getNomeEmpresa() + "','" + empresa.getUserid() + "', '"  
				       + empresa.getCnpj() + "', '" + empresa.getRamo() + "', '" + empresa.getSite() + "', '" 
		               + empresa.getPais() + "', '" + empresa.getEstado() + "', '" + empresa.getCidade() + "', '" 
				       + empresa.getBairro() + "', '" + empresa.getTelefone() + "', '"
		               + empresa.getEmail() + "');");
		  //  st.setTimestamp(1, Timestamp.valueOf(employee.firstName()));
			//st.setDate(2, Date.valueOf(employee.firstName()));
			//st.executeUpdate();
			
			st.close();
			status = true;
			System.out.println("deu erro não" + st);
		} catch (SQLException u) {  
			System.out.println("deu erro ao inserir dados na tabela mas n sei  "+ u);
			
		}
		return status;
	}
	
	public Empresa[] getEmpresa() {
		Empresa[] empresa = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM empresa.empresa");		
	         if(rs.next()){
	             rs.last();
	             empresa = new Empresa[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	            	 empresa[i] = new Empresa(rs.getInt("id"),rs.getString("nomeEmpresa"), rs.getString("userid"), rs.getInt("cnpj"), rs.getString("ramo"),
	            			 		rs.getString("site"), rs.getString("pais"), rs.getString("estado"), rs.getString("cidade"),
	                		        rs.getString("bairro"), rs.getString("telefone"), rs.getString("email"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return empresa;
	}
	
	public Empresa get(String id) {
		Empresa empresa = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM empresa.empresa WHERE id="+id;
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	empresa = new Empresa(rs.getInt("id"), rs.getString("nomeEmpresa"), rs.getString("userid"), rs.getInt("cnpj"), rs.getString("ramo"),
    			 		rs.getString("site"), rs.getString("pais"), rs.getString("estado"), rs.getString("cidade"),
        		        rs.getString("bairro"), rs.getString("telefone"), rs.getString("email"));
	        }
	        st.close();
		} catch (Exception e) {
			System.out.println("execao get " +e);
			System.err.println(e.getMessage());
		}
		return empresa;
	}
	
	public boolean delete(String id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM empresa.empresa WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarEmpresa(Empresa empresa) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE empresa.empresa SET nomeEmpresa = '" + empresa.getNomeEmpresa() + "', userid = '"  
				       + empresa.getUserid() + "', cnpj = '" + empresa.getCnpj() + "', ramo = '" + empresa.getRamo() + "', site = '"
				       + empresa.getSite() + "', pais = '" + empresa.getPais() + "', estado = '"
				       + empresa.getEstado() + "', cidade = '" + empresa.getCidade() + "', bairro = '"
				       + empresa.getBairro() + "', telefone = '" + empresa.getTelefone() + "' email = '" + empresa.getEmail() + "'"
					   + " WHERE id = " + empresa.getId();
			st.executeUpdate(sql);
			System.out.println("atualizado com sucesso " +st);
			st.close();
			status = true;
		} catch (SQLException u) {  
			System.out.println("execao put " +u);
			throw new RuntimeException(u);
		}
		return status;
	}
	
}
