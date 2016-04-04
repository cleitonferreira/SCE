package br.com.sce.model.bean;

import java.util.Collection;

public class Acesso {

	//registros da tabela acesso_usuario
	
	
	private Integer usu_codigo; //retirar
	private Integer codigo;
	
	//Isso deve ser substituido pelo usu_codigo. Pois, o usu_codigo não está representando um relacoinamento N:N
	//Para representar um relacionamento N:N em OO, é preciso que o atributo que represente o relacionamento seja
	// uma lista de um determinado objeto (no caso uma lista de Usuários)
	//private Collection<Usuario> usuarios;
	
	
	//registros da tabela acesso
	private String comando;
	private String descricao;
	
	
	
	public Integer getUsu_codigo() {
		return usu_codigo;
	}
	public void setUsu_codigo(Integer usu_codigo) {
		this.usu_codigo = usu_codigo;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

	

}
