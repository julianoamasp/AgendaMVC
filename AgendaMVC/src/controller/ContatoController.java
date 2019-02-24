package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.Usuario;
import service.ContatoService;

@WebServlet("/ContatoController")
public class ContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao.equals("Adicionar")) {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String telefone = request.getParameter("telefone");
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Contato contato = new Contato(0,usuario.getId(), nome, descricao, telefone);
		ContatoService contatoService = new ContatoService();

		try {
		contatoService.cadastrarContato(contato);
		response.sendRedirect("Principal.jsp");
		}catch (Exception e) {
			// TODO: handle exception
		}
		}
		
		if(acao.equals("x")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Contato contato = new Contato();
			contato.setId(id);
			ContatoService contatoService = new ContatoService();
			try {
			contatoService.excluirContato(contato);
			response.sendRedirect("Principal.jsp");
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("erro                "+e.getMessage());
			}
		}
		if(acao.equals("v")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			String telefone = request.getParameter("telefone");
			Contato contato = new Contato();
			contato.setId(id);
			contato.setNome(nome);
			contato.setDescricao(descricao);
			contato.setNumero(telefone);
			ContatoService contatoService = new ContatoService();
			try {
			contatoService.atualizarContato(contato);
			response.sendRedirect("Principal.jsp");
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("erro                "+e.getMessage());
			}
		}
	}

}
