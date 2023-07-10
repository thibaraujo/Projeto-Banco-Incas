package br.edu.unifei.ecot13.projeto.incas;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Soldado extends Pessoa {
	private static final long serialVersionUID = -1608732136416174631L;
	private int batalhasTravadas;
	private int vida;
	@OneToOne private Ferramenta arma;
	@ManyToOne private PoderMilitar exercito;
}
