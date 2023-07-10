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
public class Culto implements Serializable {
	private static final long serialVersionUID = -4154795014945219906L;
	@Id @GeneratedValue private int _id;
	private int duracao;
	@OneToOne private Templo templo;
	@OneToOne private Deus deus;
	@OneToOne private Regiao regiao;
	@OneToOne private Sacerdote sacerdote;
}
