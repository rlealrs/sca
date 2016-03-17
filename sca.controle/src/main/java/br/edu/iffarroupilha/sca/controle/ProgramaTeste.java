package br.edu.iffarroupilha.sca.controle;

import java.util.Date;

import org.hibernate.Session;

import br.edu.iffarroupilha.sca.hibernate.HibernateUtil;
import br.edu.iffarroupilha.sca.modelo.Aluno;
import br.edu.iffarroupilha.sca.modelo.Turma;

public class ProgramaTeste {
	public static void main(String[] args) {
		
					
		Turma t = new Turma();
		Aluno a = new Aluno();
		
		a.setNome("Rafael");
		a.setDataNascimento(new Date());
		a.setTurma(t);
		t.setDescricao("Turma SI 2013");
		
		//grava os dados
		new TurmaControle().gravar(t);
		new AlunoControle().gravar(a);
		
		//Fecha a fabrica de conexão
		HibernateUtil.getFabrica().close();
	}

}
