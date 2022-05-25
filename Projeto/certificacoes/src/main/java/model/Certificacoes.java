package model;

public class Certificacoes {

	private Integer user_id;
	private Integer  candidato_id;
	private String titulo;
	private String  org_emissor;
	private String  url_credencial;
	private String  credencial;
	
	
	public Certificacoes(Integer user_id, Integer candidado_id, String titulo, String org_emissor, String url_credencial, String credencial) {
		super();
		this.user_id = user_id;
		this.candidato_id = candidato_id;
		this.titulo = titulo;
		this.org_emissor = org_emissor;
		this.url_credencial = url_credencial;
		this.credencial = credencial;

	}


	/**
	 * @return the user_id
	 */
	public Integer getUser_id() {
		return user_id;
	}


	/**
	 * @return the candidato_id
	 */
	public Integer getCandidato_id() {
		return candidato_id;
	}


	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * @return the org_emissor
	 */
	public String getOrg_emissor() {
		return org_emissor;
	}


	/**
	 * @return the url_credencial
	 */
	public String getUrl_credencial() {
		return url_credencial;
	}


	/**
	 * @return the credencial
	 */
	public String getCredencial() {
		return credencial;
	}


	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	/**
	 * @param candidato_id the candidato_id to set
	 */
	public void setCandidato_id(Integer candidato_id) {
		this.candidato_id = candidato_id;
	}


	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	/**
	 * @param org_emissor the org_emissor to set
	 */
	public void setOrg_emissor(String org_emissor) {
		this.org_emissor = org_emissor;
	}


	/**
	 * @param url_credencial the url_credencial to set
	 */
	public void setUrl_credencial(String url_credencial) {
		this.url_credencial = url_credencial;
	}


	/**
	 * @param credencial the credencial to set
	 */
	public void setCredencial(String credencial) {
		this.credencial = credencial;
	}


	@Override
	public String toString() {
		return "Certificacoes [user_id=" + user_id + ", candidato_id=" + candidato_id + ", titulo=" + titulo
				+ ", org_emissor=" + org_emissor + ", url_credencial=" + url_credencial + ", credencial=" + credencial
				+ "]";
	}
	

}
