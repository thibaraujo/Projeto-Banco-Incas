/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.ecot13.projeto.incas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class AppQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eleicaoPU");
        EntityManager em  = emf.createEntityManager();
        
        List<Deputado> l1 = em.createQuery(
        "from Deputado d "
        + "where d.anoReservista>1970"
        ).getResultList();
        for(Deputado d : l1) {
        	System.out.println(d.getNome());
        }

        /*
        List<Senador> l2 = em.createQuery(
        "from Senador s "
        + "where s.campanha.partido.sigla='PMDB'"
        ).getResultList();
        for(Senador s : l2) {
        	System.out.println(s.getNome() + " " +
        	s.getCampanha().getPartido().getSigla());
        }
        
        Deputado d = (Deputado)em.createQuery(
        "select e.voto.deputado "
        + "from Eleitor e "
        + "where e.nome='Zozimo' and "
        + "e.voto.eleicao.ano=2006"
        ).getSingleResult();
        System.out.println(d.getNome() + " " +
        d.getCampanha().getPartido().getNome());
        
        List<Deputado> l4 = em.createQuery(
        "from Deputado d2 "
        + "where d2.apuracao.eleicao.ano=2006 and "
        + "d2.apuracao.totalVotos in "
        + "(select max(d1.apuracao.totalVotos) "
        + "from Deputado d1 "
        + "where d1.apuracao.eleicao.ano=2006)"
        ).getResultList();
        for(Deputado d : l4) {
        	System.out.println(d.getNome());
        }
        
        List<Object[]>l5 = em.createQuery(
          "select v.senador.campanha.partido.sigla, "
        + "count(*) " 
        + "from Voto v "
        + "where v.eleicao.ano=2006 and "
        + "v.eleitor.alfabetizado = false "
        + "group by v.senador.campanha.partido.sigla "
        + "order by count(*) desc"
        ).getResultList();
        for(Object[] v : l5) {
        	System.out.println(v[0] + " " + v[1]);
        }
        
        List<Object[]> l6 = em.createQuery(
              "select v.senador.nome, count(*) " +
              "from Voto v " +
              "where v.eleicao.ano = 2006 " +
              "group by v.senador.nome " +
              "order by count(*) desc"
          ).getResultList();
        for (Object[] v : l6) {
        	System.out.println(v[0] + " - " + v[1] );
        }
        Long i7s = (Long) em.createQuery(
              "select count(*) " +
              "from Voto v " +
              "where v.eleicao.ano = 2006 and " +
              "v.senador.campanha.partido.sigla = 'PMDB' "
        ).getSingleResult();
        Long i7d = (Long) em.createQuery(
              "select count(*) " +
              "from Voto v " +
              "where v.eleicao.ano = 2006 and " +
              "v.deputado.campanha.partido.sigla = 'PMDB' "
          ).getSingleResult();
        System.out.println("senador="+i7s);
        System.out.println("deputado="+i7d);
        System.out.println("total="+(i7s+i7d));
      */

        em.close();
        emf.close();
    }
}
