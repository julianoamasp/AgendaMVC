package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

	public void cadastrarUsuario(Usuario usuario) throws Exception{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrarUsuario(usuario);
	}
	
	public Usuario entrar(Usuario usuario) throws Exception {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.entrar(usuario);
	}
	
	public void atualizarUsuario(Usuario usuario) throws Exception{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.atualizarUsuario(usuario);
	}
	
	public static void main(String args[]) {
		UsuarioService usuarioService = new UsuarioService();
		try {
		Usuario usuario = new Usuario(0, "a", "a", "a");
		usuario = usuarioService.entrar(usuario);
		if(usuario == null) {
			
		System.out.print("nulo");
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
