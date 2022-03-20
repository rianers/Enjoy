package br.com.fiap.enjoy.domains;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_bebida")
public class Bebida {

	@Id
	@SequenceGenerator(name = "bebida", sequenceName = "sq_tbl_bebida", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bebida")
	@Column(name = "id_bebida")
	private int id;

	@Column(name = "nm_bebida", length = 255)
	private String nome;

	@Column(name = "vl_mililitro", precision = 8, scale = 4)
	private Float vl_mililitro;

	@ManyToOne
	@JoinColumn(name = "id_tipo_bebida")
	private TipoBebida tipo;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Calendar created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Calendar updated_at;

	public Bebida() {
		super();
	}

	public Bebida(int id, String nome, Float vl_mililitro, TipoBebida tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.vl_mililitro = vl_mililitro;
		this.tipo = tipo;
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

	public Float getVlMililitro() {
		return vl_mililitro;
	}

	public void setVlMililitro(Float vl_mililitro) {
		this.vl_mililitro = vl_mililitro;
	}

	public TipoBebida getTipo() {
		return tipo;
	}

	public void setTipo(TipoBebida tipo) {
		this.tipo = tipo;
	}

	public Calendar getCreatedAt() {
		return created_at;
	}

	public Calendar getUpdatedAt() {
		return updated_at;
	}
}
