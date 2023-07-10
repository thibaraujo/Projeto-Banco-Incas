package br.edu.unifei.ecot13.projeto.incas;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 3690143497827447129L;
	@Id @GeneratedValue private int _id;
	private String nome;
	private String sexo;
	private float renda;
	@OneToOne private Regiao regiao;
	@OneToOne private Deus deus;
}
