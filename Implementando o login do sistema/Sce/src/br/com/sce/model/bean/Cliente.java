package br.com.sce.model.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class Cliente 
{
	private Integer cli_codigo;
	private Cidade cidade;
	private String cli_bairro;
	private String cli_nome;
	private String cli_endereco;
	private String cli_numero;
	private String cli_complemento;
	private String cli_cep;
	private String cli_cpf;
	private String cli_rg;
	private String cli_cnpj;
	private String cli_insest;
	private String cli_foneres;
	private String cli_fonecel;
	private Date cli_datanasc;
	private Date cli_datacad;
	private String cli_email;
	private String cli_sexo;
	private String cli_estadocivil;
	private String cli_obs;
	
	

	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Integer getCli_codigo() {
		return cli_codigo;
	}
	public void setCli_codigo(Integer cli_codigo) {
		this.cli_codigo = cli_codigo;
	}

	public String getCli_bairro() {
		return cli_bairro;
	}
	public void setCli_bairro(String cli_bairro) {
		this.cli_bairro = cli_bairro;
	}
	
	public String getCli_nome() {
		return cli_nome;
	}
	public void setCli_nome(String cli_nome) {
		this.cli_nome = cli_nome;
	}
	public String getCli_endereco() {
		return cli_endereco;
	}
	public void setCli_endereco(String cli_endereco) {
		this.cli_endereco = cli_endereco;
	}
	public String getCli_numero() {
		return cli_numero;
	}
	public void setCli_numero(String cli_numero) {
		this.cli_numero = cli_numero;
	}
	public String getCli_complemento() {
		return cli_complemento;
	}
	public void setCli_complemento(String cli_complemento) {
		this.cli_complemento = cli_complemento;
	}
	public String getCli_cep() {
		return cli_cep;
	}
	public void setCli_cep(String cli_cep) {
		this.cli_cep = cli_cep;
	}
	public String getCli_cpf() {
		return cli_cpf;
	}
	public void setCli_cpf(String cli_cpf) {
		this.cli_cpf = cli_cpf;
	}
	public String getCli_rg() {
		return cli_rg;
	}
	public void setCli_rg(String cli_rg) {
		this.cli_rg = cli_rg;
	}
	public String getCli_cnpj() {
		return cli_cnpj;
	}
	public void setCli_cnpj(String cli_cnpj) {
		this.cli_cnpj = cli_cnpj;
	}
	public String getCli_insest() {
		return cli_insest;
	}
	public void setCli_insest(String cli_insest) {
		this.cli_insest = cli_insest;
	}
	public String getCli_foneres() {
		return cli_foneres;
	}
	public void setCli_foneres(String cli_foneres) {
		this.cli_foneres = cli_foneres;
	}
	public String getCli_fonecel() {
		return cli_fonecel;
	}
	public void setCli_fonecel(String cli_fonecel) {
		this.cli_fonecel = cli_fonecel;
	}
	public Date getCli_datanasc() {
		return cli_datanasc;
	}
	public void setCli_datanasc(Date cli_datanasc) {
		this.cli_datanasc = cli_datanasc;
	}
	public Date getCli_datacad() {
		return cli_datacad;
	}
	public void setCli_datacad(Date cli_datacad) {
		this.cli_datacad = cli_datacad;
	}
	public String getCli_email() {
		return cli_email;
	}
	public void setCli_email(String cli_email) {
		this.cli_email = cli_email;
	}
	public String getCli_sexo() {
		return cli_sexo;
	}
	public void setCli_sexo(String cli_sexo) {
		this.cli_sexo = cli_sexo;
	}
	public String getCli_estadocivil() {
		return cli_estadocivil;
	}
	public void setCli_estadocivil(String cli_estadocivil) {
		this.cli_estadocivil = cli_estadocivil;
	}
	public String getCli_obs() {
		return cli_obs;
	}
	public void setCli_obs(String cli_obs) {
		this.cli_obs = cli_obs;
	}
	
	
	//enviar os dados data para o formulário formatado
	
	public String getDataNascimentoFormatada(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(cli_datanasc);
	}
	
	public String getDataCadastroFormatada(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(cli_datacad);
	}
}
