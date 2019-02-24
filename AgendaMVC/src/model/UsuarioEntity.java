package model;

import javax.persistence.*;

@Entity(name = "UsuarioEntity")
@Table(name = "usuario")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuario;
	private String nome;
	private String email;
	private String senha;
	
	public UsuarioEntity () {
		super();
	}

	public int getId() {
		return idusuario;
	}

	public void setId(int id) {
		this.idusuario = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
