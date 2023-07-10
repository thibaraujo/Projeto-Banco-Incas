/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.ecot13.projeto.incas;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author thiago
 */
public class AppInsert {

	public static void main(String args[]) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("incasDB");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Random random = new Random();

        //persistindo Regiões
        Regiao reg[] = new Regiao[4];
        for (int i = 0; i < 4; i++) {
        	reg[i] = new Regiao();
            reg[i].setNome("Regiao " + i);
            reg[i].setDescricao("Descrição da Regiao " + i);
            em.persist(reg[i]);
        }
        
        Deus deus1 = new Deus();
        deus1.setCultosDedicados(5);
        deus1.setNome("Inti");
        em.persist(deus1);
        
        Deus deus2 = new Deus();
        deus2.setCultosDedicados(5);
        deus2.setNome("Mamaquilla");
        em.persist(deus2);
        
        Deus deus3 = new Deus();
        deus3.setCultosDedicados(5);
        deus3.setNome("Viracocha");
        em.persist(deus3);
        
        
        Batalha Bat[] = new Batalha[10];
        for (int i = 0; i < 10; i++) {
            Bat[i] = new Batalha();
            Bat[i].setNome("Batalha " + i);
            Bat[i].setDescricao("Descrição da Batalha " + i);
            Bat[i].setSaldoMortes(random.nextInt(100));
            Bat[i].setRegiao(reg[i % reg.length]);
            em.persist(Bat[i]);
        }
        
        PoderMilitar pm[] = new PoderMilitar[2];
        for (int i = 0; i < 2; i++) {
        	pm[i] = new PoderMilitar();
        	pm[i].setNome("Exercito "+i );
        	pm[i].setForca(i+90);
        	pm[i].setDefesa(80+i);
        	pm[i].setLado("Bem");
        	pm[i].setBatalha(Bat [i %Bat.length]);
            em.persist(pm[i]);
        }
        
        Ferramenta ferramenta[] = new Ferramenta[5];
        for (int i = 0; i < 5; i++) {
        	ferramenta[i] = new Ferramenta();
        	ferramenta[i].setNome("Ferramenta " + i);
        	ferramenta[i].setDecrição("Descrição " + i);
        	ferramenta[i].setMaterial("Ferro");
        	ferramenta[i].setDurabilidade(random.nextInt(100));
            em.persist(ferramenta[i]);
        }
        
        Pastor pastor[] = new Pastor[5];
        for (int i = 0; i < 5; i++) {
        	pastor[i] = new Pastor();
        	pastor[i].setNome("Pastor " + i);
        	pastor[i].setQuantidadeLhamas(random.nextInt(100));
        	pastor[i].setTerras(i);
        	pastor[i].setRegiao(reg[i % reg.length]);
        	pastor[i].setFerramenta(ferramenta [i %ferramenta.length]);
            em.persist(pastor[i]);
        }
        
        Engenheiro engenheiro[] = new Engenheiro[5];
        for (int i = 0; i < 5; i++) {
        	engenheiro[i] = new Engenheiro();
        	engenheiro[i].setNome("Engenheiro " + i);
        	engenheiro[i].setContrucoes(random.nextInt(20));
        	engenheiro[i].setRegiao(reg[i % reg.length]);
        	engenheiro[i].setFerramenta(ferramenta [i %ferramenta.length]);
            em.persist(engenheiro[i]);
        }
        
        Soldado soldado[] = new Soldado[5];
        for (int i = 0; i < 5; i++) {
        	soldado[i] = new Soldado();
        	soldado[i].setNome("Soldado " + i);
        	soldado[i].setBatalhasTravadas(random.nextInt(10));
        	soldado[i].setVida(random.nextInt(100));
        	soldado[i].setArma(ferramenta [i %ferramenta.length]);
        	soldado[i].setExercito(pm[0]);
            em.persist(soldado[i]);
        }
        
        Sacerdote sacerdote[] = new Sacerdote[5];
        for (int i = 0; i < 3; i++) {
        	sacerdote[i] = new Sacerdote();
        	soldado[i].setNome("Sacerdote " + i);
        	sacerdote[i].setCultosRealizados(i+1);
        	sacerdote[i].setDeus(deus1);
            em.persist(sacerdote[i]);
        }
               
        
        Casa cs[] = new Casa[3];
        for (int i = 0; i < 3; i++) {
        	cs[i] = new Casa();
        	cs[i].setNome("Nome " + i);
        	cs[i].setArea(322);
        	cs[i].setConstrutor(engenheiro [i %engenheiro.length]);
        	cs[i].setDono(pastor [i %pastor.length]);
            em.persist(cs[i]);
        }
        
        Templo tp[] = new Templo[3];
        for (int i = 0; i < 3; i++) {
        	tp[i] = new Templo();
        	tp[i].setNome("Nome " + i);
        	tp[i].setArea(322);
        	tp[i].setConstrutor(engenheiro [i %engenheiro.length]);
            em.persist(tp[i]);
        }
        
        Forte ft[] = new Forte[3];
        for (int i = 0; i < 3; i++) {
        	ft[i] = new Forte();
        	ft[i].setNome("Nome " + i);
        	ft[i].setArea(322);
        	ft[i].setConstrutor(engenheiro [i %engenheiro.length]);
        	ft[i].setPermanente(true);
        	ft[i].setPoderMilitar(pm [i%pm.length]);
            em.persist(ft[i]);
        }
       
        
        Culto culto1 = new Culto();
        culto1.setDeus(deus1);
        culto1.setRegiao(reg[0]);
        culto1.setSacerdote(sacerdote[0]);
        culto1.setTemplo(tp[0]);
        em.persist(culto1);
        
        Culto culto2 = new Culto();
        culto2.setDeus(deus2);
        culto2.setRegiao(reg[1]);
        culto2.setSacerdote(sacerdote[1]);
        culto2.setTemplo(tp[1]);
        em.persist(culto2);
        
 
        

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
