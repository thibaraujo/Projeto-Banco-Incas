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
import br.edu.unifei.ecot13.projeto.incas.Ferramenta;
import br.edu.unifei.ecot13.projeto.incas.PoderMilitar;
import br.edu.unifei.ecot13.projeto.incas.Regiao;
import br.edu.unifei.ecot13.projeto.incas.Soldado;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;



public class AtualizarSoldado {

	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("incasDB");
	private EntityManager em = emf.createEntityManager();

	private JFrame frame;
	private JTextField textField_nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarSoldado window = new AtualizarSoldado();
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
	public AtualizarSoldado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Titulo = new JLabel("Atualizar Soldado");
		Titulo.setForeground(new Color(255, 128, 0));
		Titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		Titulo.setBounds(10, 21, 249, 25);
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
		textField_nome.setBounds(89, 123, 157, 20);
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
		Nome.setBounds(20, 124, 68, 14);
		frame.getContentPane().add(Nome);
		
		JSpinner spinner_batalha = new JSpinner();
		spinner_batalha.setBounds(386, 134, 50, 20);
		frame.getContentPane().add(spinner_batalha);		
		
		JLabel lblFerramenta = new JLabel("Arma:");
		lblFerramenta.setForeground(Color.BLACK);
		lblFerramenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFerramenta.setBounds(20, 186, 88, 17);
		frame.getContentPane().add(lblFerramenta);
		
		JComboBox comboBox_ferramenta = new JComboBox();
		comboBox_ferramenta.setBounds(89, 185, 157, 22);
		frame.getContentPane().add(comboBox_ferramenta);
		
		List<String> nomesFerramentas = em.createQuery("SELECT f.nome FROM Ferramenta f", String.class).getResultList();
		for (String nomeFerramenta : nomesFerramentas) {
		    comboBox_ferramenta.addItem(nomeFerramenta);
		}
		
		JLabel lblExercito = new JLabel("Exército:");
		lblExercito.setForeground(Color.BLACK);
		lblExercito.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExercito.setBounds(20, 154, 88, 17);
		frame.getContentPane().add(lblExercito);

		JComboBox<String> comboBox_exercito = new JComboBox<>();
		comboBox_exercito.setBounds(89, 153, 157, 22);
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
		lblRegiao.setBounds(20, 218, 88, 17);
		frame.getContentPane().add(lblRegiao);
		
		JComboBox comboBox_regiao = new JComboBox();
		comboBox_regiao.setBounds(89, 217, 157, 22);
		frame.getContentPane().add(comboBox_regiao);
		
		List<String> regioes = em.createQuery("SELECT p.nome FROM Regiao p", String.class).getResultList();
		for (String regiao : regioes) {
			comboBox_regiao.addItem(regiao);
		}
		
		JLabel lblDeus = new JLabel("Deus:");
		lblDeus.setForeground(Color.BLACK);
		lblDeus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeus.setBounds(20, 250, 88, 17);
		frame.getContentPane().add(lblDeus);
		
		JComboBox comboBox_deus = new JComboBox();
		comboBox_deus.setBounds(89, 249, 157, 22);
		frame.getContentPane().add(comboBox_deus);
		
		List<String> deuses = em.createQuery("SELECT p.nome FROM Deus p", String.class).getResultList();
		for (String deus : deuses) {
			comboBox_deus.addItem(deus);
		}
		
		JComboBox<String> comboBox_soldado = new JComboBox<String>();
		comboBox_soldado.setBounds(89, 77, 157, 22);
		frame.getContentPane().add(comboBox_soldado);
		
		JLabel lblSoldado = new JLabel("Soldado");
		lblSoldado.setForeground(Color.BLACK);
		lblSoldado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoldado.setBounds(20, 78, 88, 17);
		frame.getContentPane().add(lblSoldado);

		List<String> nomesSoldados = em.createQuery("SELECT f.nome FROM Soldado f", String.class).getResultList();
		for (String nomeSoldado : nomesSoldados) {
		    comboBox_soldado.addItem(nomeSoldado);
		}
		
		// Set initial value for the comboboxes (null)
		comboBox_ferramenta.setSelectedItem(null);
		comboBox_exercito.setSelectedItem(null);
		comboBox_regiao.setSelectedItem(null);
		comboBox_deus.setSelectedItem(null);
		comboBox_soldado.setSelectedItem(null);

		// Set initial values for numeric fields (-1)
		spinner_renda.setValue(-1);
		spinner_batalha.setValue(-1);
		spinner_vida.setValue(-1);
		

		// JButton btnEnviar code (as shown in your original code)
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnviar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        em.getTransaction().begin();

		        String nomeSoldado = (String) comboBox_soldado.getSelectedItem();
		        Soldado soldadoSelecionado = em.createQuery("SELECT f FROM Soldado f WHERE f.nome = :nome", Soldado.class)
		                .setParameter("nome", nomeSoldado)
		                .getSingleResult();

		        if (soldadoSelecionado != null) {
		            // Get the values entered by the user
		            String novoNome = textField_nome.getText();
		            String novoSexo = "";
		            if (rdbtnMasculino.isSelected()) {
		                novoSexo = "Masculino";
		            } else if (rdbtnFeminino.isSelected()) {
		                novoSexo = "Feminino";
		            }
		            int novaRenda = (int) spinner_renda.getValue();
		            int novasBatalhas = (int) spinner_batalha.getValue();
		            int novaVida = (int) spinner_vida.getValue();
		            String novoNomeFerramenta = (String) comboBox_ferramenta.getSelectedItem();
		            String novoNomeExercito = (String) comboBox_exercito.getSelectedItem();
		            String novoNomeRegiao = (String) comboBox_regiao.getSelectedItem();
		            String novoNomeDeus = (String) comboBox_deus.getSelectedItem();

		            // Update only the non-null fields
		            if (!novoNome.isEmpty()) {
		                soldadoSelecionado.setNome(novoNome);
		            }
		            if (!novoSexo.isEmpty()) {
		                soldadoSelecionado.setSexo(novoSexo);
		            }
		            if (novaRenda != -1) {
		                soldadoSelecionado.setRenda(novaRenda);
		            }
		            if (novasBatalhas != -1) {
		                soldadoSelecionado.setBatalhasTravadas(novasBatalhas);
		            }
		            if (novaVida != -1) {
		                soldadoSelecionado.setVida(novaVida);
		            }
		            if (novoNomeFerramenta != null) {
		                Ferramenta ferramentaSelecionada = em.createQuery("SELECT f FROM Ferramenta f WHERE f.nome = :nome", Ferramenta.class)
		                        .setParameter("nome", novoNomeFerramenta)
		                        .getSingleResult();
		                soldadoSelecionado.setArma(ferramentaSelecionada);
		            }
		            if (novoNomeExercito != null) {
		                PoderMilitar exercitoSelecionado = em.createQuery("SELECT p FROM PoderMilitar p WHERE p.nome = :nome", PoderMilitar.class)
		                        .setParameter("nome", novoNomeExercito)
		                        .getSingleResult();
		                soldadoSelecionado.setExercito(exercitoSelecionado);
		            }
		            if (novoNomeRegiao != null) {
		                Regiao regiaoSelecionada = em.createQuery("SELECT p FROM Regiao p WHERE p.nome = :nome", Regiao.class)
		                        .setParameter("nome", novoNomeRegiao)
		                        .getSingleResult();
		                soldadoSelecionado.setRegiao(regiaoSelecionada);
		            }
		            if (novoNomeDeus != null) {
		                Deus deusSelecionado = em.createQuery("SELECT p FROM Deus p WHERE p.nome = :nome", Deus.class)
		                        .setParameter("nome", novoNomeDeus)
		                        .getSingleResult();
		                soldadoSelecionado.setDeus(deusSelecionado);
		            }

		            // The soldier is already managed by the EntityManager, so no need to persist again
		            JOptionPane.showMessageDialog(null, "Soldado atualizado com sucesso!");
		        } else {
		            JOptionPane.showMessageDialog(null, "Falha ao atualizar: Soldado não encontrado.");
		        }

		        em.getTransaction().commit();
		        em.close();
		    }
		});
		btnEnviar.setForeground(new Color(255, 128, 0));
		btnEnviar.setBounds(87, 307, 296, 33);
		frame.getContentPane().add(btnEnviar);

	}
}
