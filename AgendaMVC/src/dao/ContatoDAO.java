package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Contato;
import model.Usuario;

public class ContatoDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet res = null;
	
	public void cadastrarContato(Contato contato) throws Exception {
		String sql = "INSERT INTO contato VALUES ("+contato.getId()+", "+contato.getIdusuario()+", '"+contato.getNome()+"', '"+contato.getDescricao()+"', '"+contato.getNumero()+"');";
		conn = ConnectionFactory.conectar();
		pstm = conn.prepareStatement(sql);
		pstm.execute();
	}
	
	public void excluirContato(Contato contato) throws Exception {
		String sql = "delete from contato where idcontato = "+contato.getId()+";";
		conn = ConnectionFactory.conectar();
		pstm = conn.prepareStatement(sql);
		pstm.execute();
	}
	
	public void atualizarContato(Contato contato) throws Exception {
		String sql = "UPDATE contato SET `nome` = '"+contato.getNome()+"', `descricao` = '"+contato.getDescricao()+"', `numero` = '"+contato.getNumero()+"' WHERE `idcontato` = "+contato.getId()+";";
		conn = ConnectionFactory.conectar();
		pstm = conn.prepareStatement(sql);
		pstm.execute();
	}
	
	public ArrayList<Contato> listarContatos(Usuario usuario) throws Exception{
		String sql = "select * from contato where idusuario = "+usuario.getId()+";";
		conn = ConnectionFactory.conectar();
		pstm = conn.prepareStatement(sql);
		res = pstm.executeQuery();
		
		ArrayList<Contato> contatos = new ArrayList<Contato>();
		
		while(res.next()) {
			contatos.add(new Contato(
					res.getInt("idcontato"),
					res.getInt("idusuario"),
					res.getString("nome"),
					res.getString("descricao"),
					res.getString("numero")
					));
		}
		return contatos;
	}
	
	public static void main(String args[]) {
		ContatoDAO contatoDAO = new ContatoDAO();
		Usuario usuario = new Usuario();
		usuario.setId(6);
		try {
		ArrayList<Contato> contatos = contatoDAO.listarContatos(usuario);
		for(Contato c : contatos) {
			System.out.println(c.getNome());
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
