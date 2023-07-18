package br.edu.unifei.ecot13.projeto.incas.swing;

import java.awt.EventQueue;
import java.awt.Font;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.unifei.ecot13.projeto.incas.Deus;
import br.edu.unifei.ecot13.projeto.incas.Engenheiro;
import br.edu.unifei.ecot13.projeto.incas.Ferramenta;
import br.edu.unifei.ecot13.projeto.incas.Pastor;
import br.edu.unifei.ecot13.projeto.incas.PoderMilitar;
import br.edu.unifei.ecot13.projeto.incas.Regiao;
import br.edu.unifei.ecot13.projeto.incas.Sacerdote;
import br.edu.unifei.ecot13.projeto.incas.Soldado;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class InserirSoldado {

	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("incasDB");
	private EntityManager em = emf.createEntityManager();
	private Soldado soldado;
	private JFrame frame;
	private JTextField textField_nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserirSoldado window = new InserirSoldado();
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
	public InserirSoldado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Titulo = new JLabel("Adicionar Soldado");
		Titulo.setForeground(new Color(255, 128, 0));
		Titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		Titulo.setBounds(10, 11, 249, 25);
		frame.getContentPane().add(Titulo);
		
		JLabel Sexo = new JLabel("Sexo:");
		Sexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		Sexo.setForeground(new Color(0, 0, 0));
		Sexo.setBounds(315, 179, 68, 14);
		frame.getContentPane().add(Sexo);
		
		JLabel lblVida = new JLabel("Vida:");
		lblVida.setForeground(Color.BLACK);
		lblVida.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVida.setBounds(315, 95, 68, 14);
		frame.getContentPane().add(lblVida);
		
		textField_nome = new JTextField();
		textField_nome.setColumns(10);
		textField_nome.setBounds(89, 58, 157, 20);
		frame.getContentPane().add(textField_nome);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(315, 200, 109, 23);
		frame.getContentPane().add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(315, 226, 109, 23);
		frame.getContentPane().add(rdbtnFeminino);
		
		JLabel Nome = new JLabel("Nome:");
		Nome.setForeground(Color.BLACK);
		Nome.setFont(new Font("Tahoma", Font.BOLD, 14));
		Nome.setBounds(20, 60, 68, 14);
		frame.getContentPane().add(Nome);
		
		JSpinner spinner_batalha = new JSpinner();
		spinner_batalha.setBounds(386, 134, 50, 20);
		frame.getContentPane().add(spinner_batalha);		
		
		JLabel lblFerramenta = new JLabel("Arma:");
		lblFerramenta.setForeground(Color.BLACK);
		lblFerramenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFerramenta.setBounds(20, 135, 88, 17);
		frame.getContentPane().add(lblFerramenta);
		
		JComboBox comboBox_ferramenta = new JComboBox();
		comboBox_ferramenta.setBounds(89, 134, 157, 22);
		frame.getContentPane().add(comboBox_ferramenta);
		
		List<String> nomesFerramentas = em.createQuery("SELECT f.nome FROM Ferramenta f", String.class).getResultList();
		for (String nomeFerramenta : nomesFerramentas) {
		    comboBox_ferramenta.addItem(nomeFerramenta);
		}
		
		JLabel lblExercito = new JLabel("Exército:");
		lblExercito.setForeground(Color.BLACK);
		lblExercito.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExercito.setBounds(20, 97, 88, 17);
		frame.getContentPane().add(lblExercito);

		JComboBox<String> comboBox_exercito = new JComboBox<>();
		comboBox_exercito.setBounds(89, 97, 157, 22);
		frame.getContentPane().add(comboBox_exercito);

		List<String> exercitos = em.createQuery("SELECT p.nome FROM PoderMilitar p", String.class).getResultList();
		for (String exercito : exercitos) {
		    comboBox_exercito.addItem(exercito);
		}
		
		JLabel lblRenda = new JLabel("Renda:");
		lblRenda.setForeground(Color.BLACK);
		lblRenda.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRenda.setBounds(315, 59, 68, 14);
		frame.getContentPane().add(lblRenda);
		
		JSpinner spinner_renda = new JSpinner();
		spinner_renda.setBounds(374, 58, 62, 20);
		frame.getContentPane().add(spinner_renda);
		
		JLabel lblBatalhas = new JLabel("Batalhas:");
		lblBatalhas.setForeground(Color.BLACK);
		lblBatalhas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBatalhas.setBounds(315, 135, 68, 14);
		frame.getContentPane().add(lblBatalhas);
		
		JSpinner spinner_vida = new JSpinner();
		spinner_vida.setBounds(374, 94, 62, 20);
		frame.getContentPane().add(spinner_vida);
		
		JLabel lblRegiao = new JLabel("Regiao:");
		lblRegiao.setForeground(Color.BLACK);
		lblRegiao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegiao.setBounds(20, 172, 88, 17);
		frame.getContentPane().add(lblRegiao);
		
		JComboBox comboBox_regiao = new JComboBox();
		comboBox_regiao.setBounds(89, 171, 157, 22);
		frame.getContentPane().add(comboBox_regiao);
		
		List<String> regioes = em.createQuery("SELECT p.nome FROM Regiao p", String.class).getResultList();
		for (String regiao : regioes) {
			comboBox_regiao.addItem(regiao);
		}
		
		JLabel lblDeus = new JLabel("Deus:");
		lblDeus.setForeground(Color.BLACK);
		lblDeus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeus.setBounds(20, 205, 88, 17);
		frame.getContentPane().add(lblDeus);
		
		JComboBox comboBox_deus = new JComboBox();
		comboBox_deus.setBounds(89, 204, 157, 22);
		frame.getContentPane().add(comboBox_deus);
		
		List<String> deuses = em.createQuery("SELECT p.nome FROM Deus p", String.class).getResultList();
		for (String deus : deuses) {
			comboBox_deus.addItem(deus);
		}
		
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				em.getTransaction().begin();
				soldado = new Soldado();
				if (textField_nome.getText().isEmpty() == false) {
				    soldado.setNome(textField_nome.getText());
				    soldado.setSexo(rdbtnMasculino.isSelected() ? "Masculino" : "Feminino");
				    soldado.setRenda((int) spinner_renda.getValue());
				    soldado.setBatalhasTravadas((int) spinner_batalha.getValue());
				    soldado.setVida((int) spinner_vida.getValue());
				    
				    String nomeFerramenta = (String) comboBox_ferramenta.getSelectedItem();				 
		            Ferramenta ferramentaSelecionada = em.createQuery("SELECT f FROM Ferramenta f WHERE f.nome = :nome", Ferramenta.class)
		                    .setParameter("nome", nomeFerramenta)
		                    .getSingleResult();
		            soldado.setArma(ferramentaSelecionada);
		            		   
		            String nomeExercito = (String) comboBox_exercito.getSelectedItem();
		            PoderMilitar exercitoSelecionado = em.createQuery("SELECT p FROM PoderMilitar p WHERE p.nome = :nome", PoderMilitar.class)
		                    .setParameter("nome", nomeExercito)
		                    .getSingleResult();

		            soldado.setExercito(exercitoSelecionado);
		            
		            String nomeRegiao = (String) comboBox_regiao.getSelectedItem();
		            Regiao regiaoSelecionada = em.createQuery("SELECT p FROM Regiao p WHERE p.nome = :nome", Regiao.class)
		                    .setParameter("nome", nomeRegiao)
		                    .getSingleResult();

		            soldado.setRegiao(regiaoSelecionada);
		            
		            String nomeDeus = (String) comboBox_deus.getSelectedItem();
		            Deus deusSelecionado = em.createQuery("SELECT p FROM Deus p WHERE p.nome = :nome", Deus.class)
		                    .setParameter("nome", nomeDeus)
		                    .getSingleResult();

		            soldado.setDeus(deusSelecionado);
			
		            
				    em.persist(soldado);
				    JOptionPane.showMessageDialog(null, "Soldado criado com sucesso!");
				} else {
				    JOptionPane.showMessageDialog(null, "Nome vazio!");
				}

				
				

				em.getTransaction().commit();
				em.close();
			}
		});
		btnEnviar.setForeground(new Color(255, 128, 0));
		btnEnviar.setBounds(87, 270, 296, 33);
		frame.getContentPane().add(btnEnviar);		
		
	}
}
