package br.edu.unifei.ecot13.projeto.incas;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Deus implements Serializable {
	private static final long serialVersionUID = 3320744332119963154L;
	@Id private String nome;
	private int cultosDedicados;
}
