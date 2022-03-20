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
@Table(name = "tbl_consumo")
public class Consumo {

	@Id
	@SequenceGenerator(name = "consumo", sequenceName = "sq_tbl_consumo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumo")
	@Column(name = "id_consumo")
	private int id;

	@Column(name = "qtd_mililitro", precision = 8, scale = 2)
	private Float qtd_mililitro;

	@ManyToOne
	@JoinColumn(name = "id_visita")
	private Visita visita;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Calendar created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Calendar updated_at;

	public Consumo() {
		super();
	}

	public Consumo(int id, Float qtd_mililitro, Visita visita) {
		super();
		this.id = id;
		this.qtd_mililitro = qtd_mililitro;
		this.visita = visita;
	}

	public int getId() {
		return id;
	}

	public Float getQtdMililitro() {
		return qtd_mililitro;
	}

	public void setQtdMililitro(Float qtd_mililitro) {
		this.qtd_mililitro = qtd_mililitro;
	}

	public Visita getVisita() {
		return visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

	public Calendar getCreatedAt() {
		return created_at;
	}

	public Calendar getUpdatedAt() {
		return updated_at;
	}
}
