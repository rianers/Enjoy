package br.com.fiap.enjoy.domains;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_tipo_bebida")
public class TipoBebida {
	@Id
	@SequenceGenerator(name = "tipo_bebida", sequenceName = "sq_tbl_tipo_bebida", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_bebida")
	@Column(name = "id_tipo_bebida")
	private int id;

	@Column(name = "nm_tipo", length = 255)
	private String nome;

	@Column(name = "pct_alcoolico", precision = 8, scale = 3)
	private Float pct_alcoolico;

	@OneToMany(mappedBy = "tipo", fetch = FetchType.LAZY)
	private List<Bebida> bebidas;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Calendar created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Calendar updated_at;

	public TipoBebida() {
		super();
	}

	public TipoBebida(int id, String nome, Float pct_alcoolico, List<Bebida> bebidas) {
		super();
		this.id = id;
		this.nome = nome;
		this.pct_alcoolico = pct_alcoolico;
		this.bebidas = bebidas;
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

	public Float getPctAlcoolico() {
		return pct_alcoolico;
	}

	public void setPctAlcoolico(Float pct_alcoolico) {
		this.pct_alcoolico = pct_alcoolico;
	}

	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	public Calendar getCreatedAt() {
		return created_at;
	}

	public Calendar getUpdatedAt() {
		return updated_at;
	}
}
