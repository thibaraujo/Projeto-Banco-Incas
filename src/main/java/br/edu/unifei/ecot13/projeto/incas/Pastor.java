package br.edu.unifei.ecot13.projeto.incas;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Pastor extends Pessoa {
	private static final long serialVersionUID = -8409815469455259877L;
	private int quantidadeLhamas;
	private int terras;
	@OneToOne private Ferramenta ferramenta;
}
