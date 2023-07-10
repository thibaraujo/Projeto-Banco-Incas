package br.edu.unifei.ecot13.projeto.incas;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Casa extends Construcao {
	private static final long serialVersionUID = -6455371502406588495L;
	private int nicho;
	@OneToOne private Pessoa dono;

}
