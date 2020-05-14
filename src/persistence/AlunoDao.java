package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Aluno;

public class AlunoDao {
	
	Session session;
	Transaction transaction;
	Query query;
	
	public void create(Aluno a)throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(a);
		transaction.commit();
		session.close();
	}
	
	public void update(Aluno a)throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(a);
		transaction.commit();
		session.close();
	}
	
	public void delete(Aluno a)throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(a);
		transaction.commit();
		session.close();
	}
	
	public Aluno findByCode(Long id) {
		session = HibernateUtil.getSessionFactory().openSession();
		Aluno aluno = (Aluno) session.get(Aluno.class, id);
		session.close();
		return aluno;
	}
	
	public List<Aluno> findAll()throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		List<Aluno> lista = session.createQuery("select a from Aluno a").list();
		session.close();
		return lista;
	}

}
