package br.com.duxusdesafio.model;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "seq_times", initialValue = 1, allocationSize = 1)
@Table(name = "time")
public class Time implements Serializable{

	private static final long serialVersionUID = 1L;
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Times_id")
	private long id;

	@Column(name = "seq_datas",length = 100,nullable = false)
	@Temporal(TemporalType.DATE)
    private LocalDate data;
	
	
	@OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
	@JoinColumn(name = "seq_time_composicoes")
	private List<ComposicaoTime> composicaoTime;
	
	
	
	
	

	public Time() {
	}

	public Time(LocalDate data, List<ComposicaoTime> composicaoTime) {
		this.data = data;
		this.composicaoTime = composicaoTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<ComposicaoTime> getComposicaoTime() {
		return composicaoTime;
	}

	public void setComposicaoTime(List<ComposicaoTime> composicaoTime) {
		this.composicaoTime = composicaoTime;
	}


	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Time)) return false;
		Time time = (Time) o;
		return id == time.id && Objects.equals(data, time.data);
	}

	@Override
	public final int hashCode() {
		return Objects.hash(id, data);
	}

	@Override
	public String toString() {
		return "Time{" +
				"id=" + id +
				", data=" + data +
				'}';
	}
}
