package br.com.fiap.enjoy.domains;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_visita")
public class Visita {

	@Id
	@SequenceGenerator(name = "visita", sequenceName = "sq_tbl_visita", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visita")
	@Column(name = "id_visita")
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario user;

	@ManyToOne
	@JoinColumn(name = "id_estabelecimento")
	private Estabelecimento estabelecimento;

	@OneToMany(mappedBy = "visita", fetch = FetchType.LAZY)
	private List<Consumo> consumos;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Calendar created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Calendar updated_at;

	public Visita() {
		super();
	}

	public Visita(int id, Usuario user, Estabelecimento estabelecimento, List<Consumo> consumos) {
		super();
		this.id = id;
		this.user = user;
		this.estabelecimento = estabelecimento;
		this.consumos = consumos;
	}

	public int getId() {
		return id;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	public Calendar getCreatedAt() {
		return created_at;
	}

	public Calendar getUpdatedAt() {
		return updated_at;
	}

}
