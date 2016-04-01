package br.com.sce.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sce.model.comando.InterfaceComando;
import br.com.sce.model.helper.SceHelper;

/**
 * Servlet implementation class SceControle
 */
public class SceControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SceControle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}
	
	//deverá acessar o link http://localhost:8080/Sce/SceControle
	//para ver o Servlet funcionando
	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Processar requisição");
		
		/*
		 * Isso é basicamente o fluxo das requisições na minha aplicação
		 */
		
		//envia a requisição para Classe SceHelper realizar algum procedimento 
		SceHelper sceHelper = new SceHelper(request);
		InterfaceComando comando = sceHelper.getComando();
		String pagina = comando.execute(request, response);//a execução deste comando é a página de destino
		request.getRequestDispatcher(pagina).include(request, response);
		
		
	}

}
