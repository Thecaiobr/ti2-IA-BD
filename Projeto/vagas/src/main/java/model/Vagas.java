package model;

public class Vagas {

	private Integer vaga_id;
	private Integer candidato_id;
	private Integer user_id;
	private Integer empresa_id;
	private Integer id;
	private String tipo;
	private String descricao;
	private String empresa;
	private String tipo_candidato;
	
	
	/**
	 * @param vaga_id
	 * @param candidato_id
	 * @param user_id
	 * @param empresa_id
	 * @param id
	 * @param tipo
	 * @param descricao
	 * @param empresa
	 * @param tipo_candidato
	 */
	public Vagas(Integer vaga_id, Integer candidato_id, Integer user_id, Integer empresa_id, Integer id, String tipo,
			String descricao, String empresa, String tipo_candidato) {
		super();
		this.vaga_id = vaga_id;
		this.candidato_id = candidato_id;
		this.user_id = user_id;
		this.empresa_id = empresa_id;
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.empresa = empresa;
		this.tipo_candidato = tipo_candidato;
	}


	/**
	 * @return the vaga_id
	 */
	public Integer getVaga_id() {
		return vaga_id;
	}


	/**
	 * @return the candidato_id
	 */
	public Integer getCandidato_id() {
		return candidato_id;
	}


	/**
	 * @return the user_id
	 */
	public Integer getUser_id() {
		return user_id;
	}


	/**
	 * @return the empresa_id
	 */
	public Integer getEmpresa_id() {
		return empresa_id;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}


	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}


	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}


	/**
	 * @return the tipo_candidato
	 */
	public String getTipo_candidato() {
		return tipo_candidato;
	}


	/**
	 * @param vaga_id the vaga_id to set
	 */
	public void setVaga_id(Integer vaga_id) {
		this.vaga_id = vaga_id;
	}


	/**
	 * @param candidato_id the candidato_id to set
	 */
	public void setCandidato_id(Integer candidato_id) {
		this.candidato_id = candidato_id;
	}


	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	/**
	 * @param empresa_id the empresa_id to set
	 */
	public void setEmpresa_id(Integer empresa_id) {
		this.empresa_id = empresa_id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	/**
	 * @param tipo_candidato the tipo_candidato to set
	 */
	public void setTipo_candidato(String tipo_candidato) {
		this.tipo_candidato = tipo_candidato;
	}


	@Override
	public String toString() {
		return "Vagas [vaga_id=" + vaga_id + ", candidato_id=" + candidato_id + ", user_id=" + user_id + ", empresa_id="
				+ empresa_id + ", id=" + id + ", tipo=" + tipo + ", descricao=" + descricao + ", empresa=" + empresa
				+ ", tipo_candidato=" + tipo_candidato + "]";
	}
	
	
	
	
}
