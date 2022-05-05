package model;

public class Empresa {
	private int id;
	private String  nomeEmpresa;
	private String userid;
	private int cnpj ;
	private String  ramo;
	private String  site;
	private String  pais;
	private String  estado;
	private String  cidade;
	private String  bairro;
	private String  telefone;
	private String  email;
	
	
	public Empresa(int id ,  String nomeEmpresa, String userid, int cnpj, String ramo, String site, String pais, String estado, String cidade, String bairro, String telefone, String email) {
		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		this.userid = userid;
		this.cnpj = cnpj;
		this.ramo = ramo;
		this.site = site;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.telefone = telefone;
		this.email = email;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}


	/**
	 * @return the cnpj
	 */
	public int getCnpj() {
		return cnpj;
	}


	/**
	 * @return the ramo
	 */
	public String getRamo() {
		return ramo;
	}


	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}


	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}


	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}


	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}


	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}


	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @return the nomeempresa
	 */
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}


	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}


	/**
	 * @param ramo the ramo to set
	 */
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}


	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}


	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}


	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}


	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @param nomeempresa the nomeempresa to set
	 */
	public void setNomeempresa(String nomeempresa) {
		this.nomeEmpresa = nomeempresa;
	}
}
