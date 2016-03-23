package br.edu.iffarroupilha.sca.controle;

import java.util.List;

import org.hibernate.Session;

import br.edu.iffarroupilha.sca.hibernate.HibernateUtil;

/**
 * <p>Classe abstrata que concentra as op��es padroes de opera��o para 
 * Entidades</p>
 * @author Rafael
 * @since 16/03/2016
 *
 */
public abstract class AControle {
	
	/**
	 * <p>
	 * Gravar ou atualizar uma infoma��o no BD, o que define em qual tabela
	 * os dados ser�o persistidos � o tipo da entidade, que por sua vez � passada
	 * como parametro nesta a��o
	 * </p>
	 */
	public void gravar(Object entidade){
		Session sessao = HibernateUtil.getFabrica().openSession();
		
		//abre a sessao
		sessao.beginTransaction();
		//salva ou atualiza a entidade
		sessao.saveOrUpdate(entidade);
		//commita a transa��o
		sessao.getTransaction().commit();
		sessao.close();
		
		
	}
	/**
	 * <p>Retorna uma lista com todos os registros de uma determinada
	 * tabela, o que define a tabela de origem dos dados � a classe que �
	 * informada como parametro para esta a��o. Este metodo equivale �:
	 * SELECT * FROM tabela
	 * @return
	 */
	public List listar(Class classeEntidade){
		Session sessao = HibernateUtil.getFabrica().openSession();
		List dados = sessao.createCriteria(classeEntidade).list();
		sessao.close();
		
		return dados;
	}

}
