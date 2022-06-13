package br.com.duxusdesafio.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "seq_times", initialValue = 1, allocationSize = 1)
@Table(name = "time")
public class Integrante implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_integrantes_id")
	private long id;
	
	@NotNull(message = "Franquia não pode ser em branco")
	@Column(name = "seq_franquia",insertable = false,length = 100)
	private String franquia;
	
	@NotNull(message = "Nome não pode ser em branco")
	@Column(name = "seq_nome",insertable = false,length = 100)
	private String nome;
	
	@NotNull(message = "Nome não pode ser em branco")
	@Column(name = "seq_funcao",insertable = false,length = 100)
	private String funcao;
	
	
	@NotNull
	@Column(name = "seq_ComposicaoTimes_list",insertable = false,length = 100)
	@OneToMany(mappedBy = "integrante")
	private List<ComposicaoTime> composicaoTime;


	public Integrante() {
	}

	public Integrante(String franquia, String nome, String funcao, List<ComposicaoTime> composicaoTime) {
		this.franquia = franquia;
		this.nome = nome;
		this.funcao = funcao;
		this.composicaoTime = composicaoTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFranquia() {
		return franquia;
	}

	public void setFranquia(String franquia) {
		this.franquia = franquia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public List<ComposicaoTime> getComposicaoTime() {
		return composicaoTime;
	}

	public void setComposicaoTime(List<ComposicaoTime> composicaoTime) {
		this.composicaoTime = composicaoTime;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Integrante)) return false;
		Integrante that = (Integrante) o;
		return id == that.id && Objects.equals(franquia, that.franquia) && Objects.equals(nome, that.nome) && Objects.equals(funcao, that.funcao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, franquia, nome, funcao);
	}

	@Override
	public String toString() {
		return "Integrante{" +
				"id=" + id +
				", franquia='" + franquia + '\'' +
				", nome='" + nome + '\'' +
				", funcao='" + funcao + '\'' +
				'}';
	}
}
