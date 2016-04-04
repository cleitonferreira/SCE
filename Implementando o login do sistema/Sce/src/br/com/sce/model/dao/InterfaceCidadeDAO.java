package br.com.sce.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.sce.model.bean.Cidade;

public interface InterfaceCidadeDAO {

	public abstract void excluir(Integer codigo) throws SQLException;
	public abstract void salvar(Cidade cidade) throws SQLException;
	public abstract void atualizar(Cidade cidade) throws SQLException;
	public abstract Cidade getCidade(Integer codigo) throws SQLException;
	public abstract List<Cidade> getCidades() throws SQLException;
}
