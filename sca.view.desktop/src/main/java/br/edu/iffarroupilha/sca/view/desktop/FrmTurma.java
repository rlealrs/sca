package br.edu.iffarroupilha.sca.view.desktop;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.iffarroupilha.sca.controle.TurmaControle;
import br.edu.iffarroupilha.sca.modelo.Turma;

/**
 * <p> Interface para cadastro e edição de turmas</p>
 * @author Rafael
 * @since 22/03/2016
 * 
 */
public class FrmTurma extends JFrame{
	
	public FrmTurma() {
		setTitle("Cadastro Turma");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		desenhaComponentes();
		setVisible(true);
	}
	
	private void desenhaComponentes(){
		JLabel lbl = new JLabel("Descrição: ");
		final JTextField jtfDescrição = new JTextField("", 20);
		JButton btnGravar = new JButton("Gravar");
		
		setLayout(new FlowLayout());
		
		add(lbl);
		add(jtfDescrição);
		add(btnGravar);
		
		
		btnGravar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Turma t = new Turma();
				t.setDescricao(jtfDescrição.getText());
				
				new TurmaControle().gravar(t);
				JOptionPane.showMessageDialog(null, "Gravado com sucesso");
				
			}
		});
	}
	
	public static void main(String[] args) {
		new FrmTurma();
	
	}

}
