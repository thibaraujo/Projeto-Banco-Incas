package br.edu.unifei.ecot13.projeto.incas;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Templo extends Construcao {
	private static final long serialVersionUID = 6675500786019049154L;
	private int salasAdoracao;

}
