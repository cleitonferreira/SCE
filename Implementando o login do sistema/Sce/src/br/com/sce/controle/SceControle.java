package br.com.sce.controle;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.conexao.InterfacePool;
import br.com.sce.conexao.Pool;
import br.com.sce.model.comando.InterfaceComando;
import br.com.sce.model.helper.SceHelper;

/**
 * Servlet implementation class SceControle
 */
public class SceControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private InterfacePool pool = new Pool();
	private SceHelper sceHelper = new SceHelper(pool);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SceControle() {
        super();

    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	this.pool = (InterfacePool)getServletContext().getAttribute("pool");
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	private void processarRequisicao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		sceHelper.setRequest(request);
		InterfaceComando comando = sceHelper.getComando();
		String pagina = comando.execute(request, response);
		request.getRequestDispatcher(pagina).include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}

}
