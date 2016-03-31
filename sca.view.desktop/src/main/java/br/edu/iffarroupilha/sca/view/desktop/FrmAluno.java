package br.edu.iffarroupilha.sca.view.desktop;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.iffarroupilha.sca.controle.AlunoControle;
import br.edu.iffarroupilha.sca.controle.TurmaControle;
import br.edu.iffarroupilha.sca.modelo.Aluno;
import br.edu.iffarroupilha.sca.modelo.Turma;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

/**
 * <p> Interface para cadastro e edição de Alunos </p>
 * @author Rafael
 * @since 29/03/2016
 * 
 */

public class FrmAluno extends JFrame{
	private JTextField jtfNome;
	private JTextField jtfEmail;
	private JTextField jtfTelefone;
	private JTextField jtfNascimento;
	private JTable table;

	
	public FrmAluno() {
		setTitle("Cadastro Alunos");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		desenhaComponentes();
		populaTabela();
		setVisible(true);
	}	
	private void populaTabela() {
		
		AlunoControle controle = new AlunoControle();
		
		List alunos = controle.listar(Aluno.class);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		modelo.setRowCount(0);
		
		for (Object obj : alunos) {
			Aluno aux = (Aluno) obj;
			Object linha[] = new Object[4];
			linha[0] = aux.getNome();
			linha[1] = aux.getEmail();
			linha[2] = aux.getTelefone();
			linha[3] = aux.getDataNascimento();
			modelo.addRow(linha);
		}
	}
	
	public void desenhaComponentes(){
		
		JLabel lblNome = new JLabel("Nome:");
		
		jtfNome = new JTextField();
		jtfNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		
		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		
		jtfTelefone = new JTextField();
		jtfTelefone.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nascimento:");
		
		jtfNascimento = new JTextField();
		jtfNascimento.setColumns(10);
		
		JButton btnGravar = new JButton("GRAVAR");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEmail)
										.addComponent(lblNome))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(jtfNome, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
										.addComponent(jtfEmail, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblTelefone))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(jtfTelefone, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
										.addComponent(jtfNascimento, Alignment.LEADING))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGravar)
							.addContainerGap(184, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(jtfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEmail)
						.addComponent(jtfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefone)
						.addComponent(jtfTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(jtfNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGravar))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOME", "EMAIL", "TELEFONE", "DT NASCIMENTO"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Date.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		btnGravar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Aluno a = new Aluno();
				a.setNome(jtfNome.getText());
				a.setEmail(jtfEmail.getText());
				a.setTelefone(jtfTelefone.getText());
				
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				try {
					Date d = formato.parse(jtfNascimento.getText());
					a.setDataNascimento(d);					
				} catch (Exception e2) {
					System.err.println(e2.getMessage());
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				
				
				new AlunoControle().gravar(a);
				JOptionPane.showMessageDialog(null, "Gravado com sucesso");
				populaTabela();
				
			}
		});
		
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
	}



	public static void main(String[] args) {
		new FrmAluno();

	}
	}
