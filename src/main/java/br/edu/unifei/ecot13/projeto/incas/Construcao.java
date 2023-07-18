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
public class Construcao implements Serializable {
	private static final long serialVersionUID = 6366632630673621670L;
	@Id @GeneratedValue private int _id;
	private String nome;
	private String descricao;
	private float area;
	@OneToOne private Engenheiro construtor;
}
