package model;

public class Contato {
	private int id;
	private int idusuario;
	private String nome;
	private String descricao;
	private String numero;
	
	public Contato() {}

	public Contato(int id, int idusuario, String nome, String descricao, String numero) {
		super();
		this.id = id;
		this.idusuario = idusuario;
		this.nome = nome;
		this.descricao = descricao;
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
