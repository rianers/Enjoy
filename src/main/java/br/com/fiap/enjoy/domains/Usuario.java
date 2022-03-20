package br.com.fiap.enjoy.domains;

import java.util.Calendar;
import java.util.Date;
//import java.util.List;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_usuario")
public class Usuario {

	@Id
	@SequenceGenerator(name = "usuario", sequenceName = "sq_tbl_usuario", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	@Column(name = "id_usuario")
	private int id;

	@Column(name = "nm_usuario", length = 100)
	private String nome;

	@Column(name = "email_usuario", length = 255)
	private String email;

	@Column(name = "senha_usuario", length = 255)
	private String senha;

	@Column(name = "nr_telefone", length = 255)
	private String telefone;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento")
	private Date dt_nascimento;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Visita> visitas;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Calendar created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Calendar updated_at;

	public Usuario() {
		super();
	}

	public Usuario(int id, String nome, String email, String senha, String telefone, Date dt_nascimento,
			List<Visita> visitas) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.dt_nascimento = dt_nascimento;
		this.visitas = visitas;
	}

	public int getId() {
		return id;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDtNascimento() {
		return dt_nascimento;
	}

	public void setDtNascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public List<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
	}

	public Calendar getCreatedAt() {
		return created_at;
	}

	public Calendar getUpdatedAt() {
		return updated_at;
	}
}
