package br.com.sce.controle;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.conexao.InterfacePool;
import br.com.sce.conexao.Pool;
import br.com.sce.model.comando.InterfaceComando;
import br.com.sce.model.comando.VerificarAutorizacao;
import br.com.sce.model.dao.AcessoDAO;


public class UsuarioAutorizadoFilter implements Filter {

	private InterfaceComando verificarAutorizacao;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		String destino = verificarAutorizacao.execute((HttpServletRequest)request, (HttpServletResponse)response);
		if(destino != null)
			((HttpServletRequest)request).getRequestDispatcher(destino).include(request, response);
		else
			filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		InterfacePool pool = new Pool();
		filterConfig.getServletContext().setAttribute("pool", pool);
		verificarAutorizacao = new VerificarAutorizacao(new AcessoDAO(pool));
	}

}
