package br.edu.iffarroupilha.sca.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p> Entidade para persistencia de turmas </p>
 * @author Rafael
 * @since 09/03/2016
 *
 */

@Entity
public class Turma {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTurma;
	@Column(length=150)
	private String descricao;
	
	
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
