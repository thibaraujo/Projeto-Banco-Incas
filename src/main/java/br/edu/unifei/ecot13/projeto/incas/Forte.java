package br.edu.unifei.ecot13.projeto.incas;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Forte extends Construcao {
	private static final long serialVersionUID = -8328524149586322992L;
	private boolean permanente;
	@OneToOne private PoderMilitar poderMilitar;
}
