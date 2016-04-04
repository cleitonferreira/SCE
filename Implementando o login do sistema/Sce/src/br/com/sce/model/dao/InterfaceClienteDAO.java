package br.com.sce.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.sce.model.bean.Cliente;

public interface InterfaceClienteDAO {

	public abstract void excluir(Integer codigo) throws SQLException;
	public abstract void salvar(Cliente cliente) throws SQLException;
	public abstract void atualizar(Cliente cliente) throws SQLException;
	public abstract Cliente getCliente(Integer codigo) throws SQLException;
	public abstract List<Cliente> getClientes() throws SQLException;
}
