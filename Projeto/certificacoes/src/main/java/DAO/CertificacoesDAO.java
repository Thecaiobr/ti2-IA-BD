package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Certificacoes;

public class CertificacoesDAO extends DAO{

	public CertificacoesDAO() {
		super();
		conectar();
	}
	
	
	public void finalize() {
		close();
	}
	
	public boolean insert(Certificacoes certificacoes) {
		boolean status = false;
		System.out.println("ele entra sim");
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO certificacoes.certificacoes (user_id, candidato_id, titulo, org_emissor, url_credencial, credencial) "
		               + "VALUES ("+certificacoes.getUser_id()+ ", '" + certificacoes.getCandidato_id() + "','" + certificacoes.getTitulo() + "', '"  
				       + certificacoes.getOrg_emissor() + "', '" + certificacoes.getUrl_credencial() + "', '" 
		               + certificacoes.getCredencial() + "');");
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
	
	public Certificacoes[] getCertificacoes() {
		Certificacoes[] certificacoes = null;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM certificacoes.certificacoes");
			if (rs.next()) {
				rs.last();
				certificacoes = new Certificacoes[rs.getRow()];
				rs.beforeFirst();

				for (int i = 0; rs.next(); i++) {
					certificacoes[i] = new Certificacoes(rs.getInt("user_id"), rs.getInt("candidato_id"), rs.getString("titulo"), rs.getString("org_emissor"),
							rs.getString("url_credencial"), rs.getString("credencial"));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return certificacoes;
	}

	public Certificacoes get(Integer id) {
		Certificacoes certificacoes = null;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM certificacoes.certificacoes WHERE id=" + id;
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				certificacoes = new Certificacoes(rs.getInt("user_id"), rs.getInt("candidato_id"), rs.getString("titulo"), rs.getString("org_emissor"),
						rs.getString("url_credencial"), rs.getString("credencial"));
			}
			st.close();
		} catch (Exception e) {
			System.out.println("execao get " + e);
			System.err.println(e.getMessage());
		}
		return certificacoes;
	}
	
	public boolean delete(Integer user_id) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM certificacoes.certificacoes WHERE id = " + user_id);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarCertificacoes(Certificacoes certificacoes) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE certificacoes.certificacoes SET titulo = '" + certificacoes.getTitulo() + "', org_emissor = '"  
				       + certificacoes.getOrg_emissor() + "', url_credencial = '" + certificacoes.getUrl_credencial() + "', credencial = '" + certificacoes.getCredencial() + "'"
					   + " WHERE id = " + certificacoes.getUser_id();
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
