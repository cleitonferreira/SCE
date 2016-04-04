package br.com.sce.conexao;

import java.sql.Connection;

public interface InterfacePool {

	public abstract Connection getConnection();
	public void liberarConexao(Connection con);
}
