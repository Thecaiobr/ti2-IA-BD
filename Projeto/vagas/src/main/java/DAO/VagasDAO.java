package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Vagas;

public class VagasDAO extends DAO{

	public VagasDAO() {
		super();
		conectar();
	}
	
	
	public void finalize() {
		close();
	}
	
	public boolean insert(Vagas vagas) {
		boolean status = false;
		System.out.println("ele entra sim");
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO vagas.vagas (vaga_id, candidato_id, user_id, empresa_id, id, tipo, descricao, empresa, tipo_candidato) "
		               + "VALUES ("+vagas.getVaga_id()+ ", '" + vagas.getCandidato_id() + "','" + vagas.getUser_id() + "', '"  
				       + vagas.getEmpresa_id() + "', '" + vagas.getId() + "', '" + vagas.getTipo() + "', '" + vagas.getDescricao() + "', '" + vagas.getEmpresa() + "', '" 
		               + vagas.getTipo_candidato() + "');");
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
	
	
	public Vagas[] getVagas() {
		Vagas[] vagas = null;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM vagas.vagas");
			if (rs.next()) {
				rs.last();
				vagas = new Vagas[rs.getRow()];
				rs.beforeFirst();

				for (int i = 0; rs.next(); i++) {
					vagas[i] = new Vagas(rs.getInt("vaga_id"), rs.getInt("candidato_id"), rs.getInt("user_id"), rs.getInt("empresa_id"), rs.getInt("id"), rs.getString("tipo"),
							rs.getString("descricao"), rs.getString("empresa"),rs.getString("tipo_candidato"));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return vagas;
	}
	
	
	public Vagas get(Integer id) {
		Vagas vagas = null;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM vagas.vagas WHERE id=" + id;
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				vagas = new Vagas(rs.getInt("vaga_id"), rs.getInt("candidato_id"), rs.getInt("user_id"), rs.getInt("empresa_id"), rs.getInt("id"), rs.getString("tipo"),
						rs.getString("descricao"), rs.getString("empresa"),rs.getString("tipo_candidato"));
			}
			st.close();
		} catch (Exception e) {
			System.out.println("execao get " + e);
			System.err.println(e.getMessage());
		}
		return vagas;
	}
	
	
	public boolean delete(Integer vaga_id) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM vagas.vagas WHERE id = " + vaga_id);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean atualizarVagas(Vagas vagas) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE vagas.vagas SET id = '" + vagas.getId() + "', tipo = '"  
				       + vagas.getTipo() + "', descricao = '" + vagas.getDescricao() + "', empresa = '" + vagas.getEmpresa() + "', tipo_candidato = '" + vagas.getTipo_candidato() + "'"
					   + " WHERE id = " + vagas.getVaga_id();
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
