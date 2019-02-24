package service;

import java.util.ArrayList;

import dao.ContatoDAO;
import model.Contato;
import model.Usuario;

public class ContatoService {
	
	public ArrayList<Contato> listarContatos(Usuario usuario) throws Exception{
		ContatoDAO contatoDAO = new ContatoDAO();
		return contatoDAO.listarContatos(usuario);
	}
	public void cadastrarContato(Contato contato) throws Exception{
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.cadastrarContato(contato);
	}
	
	public void excluirContato(Contato contato) throws Exception {
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.excluirContato(contato);
	}
	
	public void atualizarContato(Contato contato) throws Exception {
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.atualizarContato(contato);
	}
	
	public static void main(String args[]) {
		ContatoService c = new ContatoService();
		Contato contato = new Contato(1, 6, "","","");
		try {
		c.excluirContato(contato);
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
