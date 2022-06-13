package br.com.duxusdesafio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_Composicao_times", initialValue = 1, allocationSize = 1)
@Table(name = "composicaoTime")
public class ComposicaoTime implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_composicao_id")
	private long id;

	@Column(name = "seq_times", nullable = false, length = 100)
	@ManyToOne
	private Time time;

	@Column(name = "seq_integrantes")
	@ManyToOne
	private Integrante integrante;
	
	
	

	public ComposicaoTime() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

	@Override
	public String toString() {
		return "ComposicaoTime [id=" + id + ", time=" + time + ", integrante=" + integrante + "]";
	}

}
