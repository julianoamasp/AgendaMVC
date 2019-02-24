package dao;

import java.sql.*;
import java.util.ArrayList;

import model.Usuario;

public class UsuarioDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet res = null;
	
	public void cadastrarUsuario(Usuario usuario) throws Exception {
		String sql = "INSERT INTO usuario VALUES ("+usuario.getId()+", '"+usuario.getNome()+"','"+usuario.getEmail()+"','"+usuario.getSenha()+"');";
		conn = ConnectionFactory.conectar();
		pstm = conn.prepareStatement(sql);
		pstm.execute();
	}
	
	public Usuario entrar(Usuario usuario) throws Exception {
		String sql = "select * from usuario where email = '"+usuario.getEmail()+"' and senha = '"+usuario.getSenha()+"';";
		conn = ConnectionFactory.conectar();
		pstm = conn.prepareStatement(sql);
		res = pstm.executeQuery();
		
		Usuario usu = null;
		
		while(res.next()) {
			usu = new Usuario(
					res.getInt("idusuario"),
					res.getString("nome"),
					res.getString("email"),
					res.getString("senha")
					);
		}
		return usu;
	}
	
	public ArrayList<Usuario> buscarUsuarios() throws Exception {
		String sql = "select * from usuario;";
		conn = ConnectionFactory.conectar();
		pstm = conn.prepareStatement(sql);
		res = pstm.executeQuery();
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		while(res.next()) {
			usuarios.add(new Usuario(
					res.getInt("idusuario"),
					res.getString("nome"),
					res.getString("email"),
					res.getString("senha")
					));
		}
		return usuarios;
	}
	
	public void atualizarUsuario(Usuario usuario) throws Exception {
		String sql = "UPDATE usuario SET `nome` = '"+usuario.getNome()+"', `email` = '"+usuario.getEmail()+"', `senha` = '"+usuario.getSenha()+"' WHERE `idusuario` = "+usuario.getId()+";";
		conn = ConnectionFactory.conectar();
		pstm = conn.prepareStatement(sql);
		pstm.execute();
	}
	
	public void excluirAnotador(Usuario usuario) throws Exception {
		String sql = "delete from usuario where idusuario = "+usuario.getId()+";";
		conn = ConnectionFactory.conectar();
		pstm = conn.prepareStatement(sql);
		pstm.execute();
	}
	
	public static void main(String args[]) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		try {
		ArrayList<Usuario> usuarios = usuarioDAO.buscarUsuarios();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getNome());
		}
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
