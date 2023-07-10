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
public class Batalha implements Serializable {
	private static final long serialVersionUID = 5292028040574824062L;
	@Id @GeneratedValue private int _id;
	private String nome;
	private String descricao;
	private int saldoMortes;
	@OneToOne Regiao regiao;
}
