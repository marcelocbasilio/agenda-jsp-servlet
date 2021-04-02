package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update" })
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		// System.out.println(action);

		if (action.equals("/main")) {
			this.contatos(request, response);
		} else if (action.equals("/insert")) {
			this.novoContato(request, response);
		} else if (action.equals("/select")) {
			this.listarContato(request, response);
		} else if (action.equals("/update")) {
			this.editarContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();
		// Encaminhar a lista ao documento agenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	// Novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis JavaBeans.
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));

		// Invocar o método inserirContato passando o objeto contato.
		dao.inserirContato(contato);

		// Redirecionar para o documento agenda.jsp
		response.sendRedirect("main");
	}

	// Editar contato
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id do contato que será editado
		String id = request.getParameter("id");
		// Setar a variável JavaBeans
		contato.setId(Long.parseLong(id));
		// Executar o método selecionarContato (DAO)
		dao.selecionarContato(contato);
		// Setar os atributos do formulário com o conteúdo JavaBeans
		request.setAttribute("id", contato.getId());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		// Encaminhar ao documento editar.js
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	// Editar contato
		protected void editarContato(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Setar as variáveis JavaBeans
			contato.setId(Long.parseLong(request.getParameter("id")));
			contato.setNome(request.getParameter("nome"));
			contato.setFone(request.getParameter("fone"));
			contato.setEmail(request.getParameter("email"));
		}

}
