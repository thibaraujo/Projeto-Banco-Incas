package br.edu.unifei.ecot13.projeto.incas;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Regiao implements Serializable {
	private static final long serialVersionUID = -7540752147345583344L;
	@Id @GeneratedValue private int _id;
	private String nome;
	private String descricao;
}
