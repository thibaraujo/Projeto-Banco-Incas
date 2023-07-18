package br.edu.unifei.ecot13.projeto.incas;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Ferramenta implements Serializable {
	private static final long serialVersionUID = 6690453737551280725L;
	@Id @GeneratedValue private int _id;
	private String nome;
	private String decrição;
	private String material;
	private int durabilidade;
}
