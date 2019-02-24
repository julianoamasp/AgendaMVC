package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import model.UsuarioEntity;
import service.UsuarioService;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao.equals("Entrar")) {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			UsuarioService usuarioService = new UsuarioService();
			
			try {
			Usuario usuario = usuarioService.entrar(new Usuario(0, "", email, senha));
			if (usuario == null) {
				request.setAttribute("retorno", "Erro ao efetuar o login, volte e tente novamente!");
				request.setAttribute("retornoDescricao", "Tente recoperar sua senha!");
				request.setAttribute("link", "index.jsp");
				RequestDispatcher dispatcher = 
				request.getRequestDispatcher("Retorno.jsp");
				dispatcher.forward( request, response );
			}else {
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuario", usuario);
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("Principal.jsp");
						dispatcher.forward( request, response );
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		if(acao.equals("Cadastrar")) {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			UsuarioService usuarioService = new UsuarioService();
			
			try {
			
			usuarioService.cadastrarUsuario(new Usuario(0, nome, email, senha));
			response.sendRedirect("CadastroConcluido.jsp");
			}catch (Exception e) {
				request.setAttribute("retorno", "Erro ao efetuar o cadastro, volte e tente novamente!");
				request.setAttribute("retornoDescricao", "Verifique se seu mail já está cadastrado em recoperar senha!");
				request.setAttribute("link", "Cadastro.jsp");
				RequestDispatcher dispatcher = 
				request.getRequestDispatcher("Retorno.jsp");
				dispatcher.forward( request, response ); 
				System.out.println("Erro "+e.getMessage());
			}
		}
		
		if(acao.equals("Alterar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			UsuarioService usuarioService = new UsuarioService();
			Usuario usuario = new Usuario(id, nome, email, senha);
			
			try {
			usuarioService.atualizarUsuario(usuario);
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuario", usuario);
			response.sendRedirect("Principal.jsp");
			}catch (Exception e) {
				request.setAttribute("retorno", "Erro ao efetuar o cadastro, volte e tente novamente!");
				request.setAttribute("retornoDescricao", "Verifique se seu mail já está cadastrado em recoperar senha!");
				request.setAttribute("link", "Cadastro.jsp");
				RequestDispatcher dispatcher = 
				request.getRequestDispatcher("Retorno.jsp");
				dispatcher.forward( request, response ); 
				System.out.println("Erro "+e.getMessage());
			}
		}
	}

}
