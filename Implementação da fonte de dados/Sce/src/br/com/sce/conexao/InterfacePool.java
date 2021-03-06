package br.com.sce.conexao;

import java.sql.Connection;

public interface InterfacePool {

	/*Este método é para identificar da onde vem a conexão*/
	public abstract void setDataSource(InterfaceDataSource ds);
	
	/*Entregar uma conexão para o objeto que chamar*/
	public abstract Connection getConnection();
	
	/*devolve a conexão para o Pool de conexão*/
	public void liberarConexao(Connection con);
	
}
