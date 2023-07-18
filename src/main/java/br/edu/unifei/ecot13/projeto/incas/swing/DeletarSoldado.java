package br.edu.unifei.ecot13.projeto.incas.swing;

import java.awt.EventQueue;
import java.awt.Font;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import br.edu.unifei.ecot13.projeto.incas.Soldado;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;


public class DeletarSoldado {

	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("incasDB");
	private EntityManager em = emf.createEntityManager();

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletarSoldado window = new DeletarSoldado();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeletarSoldado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 343, 216);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Titulo = new JLabel("Deletar Soldado");
		Titulo.setForeground(new Color(255, 128, 0));
		Titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		Titulo.setBounds(10, 11, 249, 25);
		frame.getContentPane().add(Titulo);
		
		
		JLabel lblSoldado = new JLabel("Soldado:");
		lblSoldado.setForeground(Color.BLACK);
		lblSoldado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoldado.setBounds(10, 58, 88, 17);
		frame.getContentPane().add(lblSoldado);
		
		JComboBox comboBox_soldado = new JComboBox();
		comboBox_soldado.setBounds(84, 57, 157, 22);
		frame.getContentPane().add(comboBox_soldado);
		
		List<String> nomesSoldados = em.createQuery("SELECT f.nome FROM Soldado f", String.class).getResultList();
		for (String nomeSoldado : nomesSoldados) {
		    comboBox_soldado.addItem(nomeSoldado);
		}
		
			
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				em.getTransaction().begin();
				         
				String nomeSoldado = (String) comboBox_soldado.getSelectedItem();				 
	            Soldado soldadoSelecionado = em.createQuery("SELECT f FROM Soldado f WHERE f.nome = :nome", Soldado.class)
	                    .setParameter("nome", nomeSoldado)
	                    .getSingleResult();
	            
	            if (soldadoSelecionado != null) {
	                em.remove(soldadoSelecionado);
	                JOptionPane.showMessageDialog(null, "Soldado deletado com sucesso!");
	            } else {
	                JOptionPane.showMessageDialog(null, "Falha ao deletar: Soldado não encontrado.");
	            }
			
				
				

				em.getTransaction().commit();
				em.close();
			}
		});
		btnDeletar.setForeground(new Color(255, 128, 0));
		btnDeletar.setBounds(50, 129, 218, 33);
		frame.getContentPane().add(btnDeletar);		
		
	}
}
