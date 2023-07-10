package br.edu.unifei.ecot13.projeto.incas;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class PoderMilitar implements Serializable {
	private static final long serialVersionUID = -4841238509142467123L;
	@Id @GeneratedValue private int _id;
	private String descricao;
	private int forca;
	private int defesa;
	private String nome;
	private String lado;
	@OneToOne private Batalha batalha;
}
