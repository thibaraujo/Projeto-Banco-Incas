package br.edu.unifei.ecot13.projeto.incas;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Sacerdote extends Pessoa {
	private static final long serialVersionUID = 1431073621957360137L;
	private int cultosRealizados;
}
