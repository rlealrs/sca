package br.edu.iffarroupilha.sca.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.iffarroupilha.sca.modelo.Aluno;
import br.edu.iffarroupilha.sca.modelo.Turma;

/**
 * <p>
 * CLASSE UTILITARIA PARA GERIR OBJETOS DE CONEXAO COM O BANCO DE DADOS
 * RELACIONAL. UTILIZA-SE COMO BASE PARA A INFRAESTRUTURA O FRAMEWORK HIBERNATE
 * APLICANDO-SE O PADRÃO SINGLETON 
 * </p>
 * @author Rafael
 * @since 15/04/2016
 *
 */
public class HibernateUtil {

	private static final SessionFactory fabrica = construirFabrica();
	
	/**
	 * <p> Método que cria uma fábrica a partir do arquivo de configuração
	 * hibernate.properties localizado em src/main/resources
	 * </p>
	 * @return
	 */
	private static SessionFactory construirFabrica() {
		
		Configuration cfg = new Configuration();
		//adiciona as classes (entidades) anotadas
		cfg.addAnnotatedClass(Aluno.class);
		cfg.addAnnotatedClass(Turma.class);
		cfg.configure();
		
		return cfg.buildSessionFactory();
	}
	/**
	 * <p>Retorna a Fabrica de Sessão, através desta é possivel criar
	 * e gerenciar sessões de acesso ao banco de dados.</p>
	 * @return
	 */
	public static SessionFactory getFabrica(){
		return fabrica;
	}
}
