package br.com.sce.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.sce.conexao.InterfacePool;
import br.com.sce.model.bean.Cliente;

public class ClienteDAO implements InterfaceClienteDAO {
	
	private InterfacePool pool;
	
	public ClienteDAO(InterfacePool pool)
	{
		this.pool = pool;
	}

	@Override
	public void excluir(Integer codigo) throws SQLException {
		// TODO Implementar excluir

	}

	@Override
	public void salvar(Cliente cliente) throws SQLException {
		
		Connection con = pool.getConnection();
		PreparedStatement ps;
		
		String sqlInsert = "INSERT INTO cliente(cli_obs, cli_estadocivil, cli_sexo, cli_email, " +
				"cli_datacad, cli_datanasc, cli_fonecel, cli_foneres, cli_insest, cli_cnpj, " +
				"cli_rg, cli_cpf, cli_cep, cli_complemento, cli_numero, cli_endereco, " +
				"cli_nome, cli_bairro, cid_codigo) VALUES " +
				"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
		
		try {
			ps = con.prepareStatement(sqlInsert);
			
			ps.setString(1, cliente.getCli_obs());
			ps.setString(2, cliente.getCli_estadocivil());
			ps.setString(3, cliente.getCli_sexo());
			ps.setString(4, cliente.getCli_email());
			ps.setDate(5, (Date) cliente.getCli_datacad());
			ps.setDate(6, (Date) cliente.getCli_datanasc());
			ps.setString(7, cliente.getCli_fonecel());
			ps.setString(8, cliente.getCli_foneres());
			ps.setString(9, cliente.getCli_insest());
			ps.setString(10, cliente.getCli_cnpj());
			ps.setString(11, cliente.getCli_rg());
			ps.setString(12, cliente.getCli_cpf());
			ps.setString(13, cliente.getCli_cep());
			ps.setString(14, cliente.getCli_complemento());
			ps.setString(15, cliente.getCli_numero());
			ps.setString(16, cliente.getCli_endereco());
			ps.setString(17, cliente.getCli_nome());
			ps.setString(18, cliente.getCli_bairro());
			ps.setInt(19, cliente.getCidade().getCid_codigo());
			
			
			ps.executeUpdate();
			ps.close();
		} finally {
			//depois de realizar a aoperação, deverá liberar a conexão
			pool.liberarConexao(con);
		}


	}

	@Override
	public void atualizar(Cliente cliente) throws SQLException {
		// TODO Implementar atualizar
	}

	@Override
	public Cliente getCliente(Integer codigo) throws SQLException {
		// TODO Implementar getCliente
		return null;
	}

	@Override
	public List<Cliente> getClientes() throws SQLException {
		// TODO Implementar getClientes
		return null;
	}

}
