package br.edu.unifei.ecot13.projeto.incas;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Engenheiro extends Pessoa {
	private static final long serialVersionUID = -906359258652088665L;
	private int contrucoes;
	@OneToOne private Ferramenta ferramenta;
}
