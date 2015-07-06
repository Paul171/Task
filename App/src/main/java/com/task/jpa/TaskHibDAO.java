package com.task.jpa;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;

import com.task.model.Task;
@Component
public class TaskHibDAO {
	@PersistenceContext(unitName = "TaskApp")
	private EntityManager em;
	private EntityManagerFactory emf = null;
	public TaskHibDAO(){
		emf = Persistence.createEntityManagerFactory("TaskApp");
	}
	public TaskHibDAO(String dbHost, String dbName, String dbUser, String dbPassword){
		Properties config = new Properties();
		config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
		config.setProperty("hibernate.connection.url", "jdbc:mysql://" + dbHost + "/" + dbName);
		config.setProperty("hibernate.connection.username", dbUser);
        config.setProperty("hibernate.connection.password", dbPassword);
        emf = Persistence.createEntityManagerFactory("TaskApp", config);		
	}
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	public void create(Task task) throws Exception{
//		try{
//			em = getEntityManager();
//			em.getTransaction().begin();
			TypedQuery<Long> q = em.createQuery("Select count(t.id) from Task t",Long.class);
			task.setId(q.getSingleResult()+1);
			this.em.persist(task);
//			em.getTransaction().commit();
//		}catch(Exception e){
//			if(findTask(task.getId())!= null){
//				throw new Exception("Task not found");
//			}
//			throw e;
//		}finally{
//			if(em != null){
//				em.close();
//			}
//		}		
	}
	public Task findTask(Integer id){
		em = getEntityManager();
		try{
			return em.find(Task.class, id);
		}finally{
			em.close();
		}
	}
	public String getTaskName(Integer id){
		em = getEntityManager();
		try{
			TypedQuery<String> q = em.createQuery("Select t.name from TaskApp t where t.ID = :id",String.class);
			return q.setParameter("id", id).getSingleResult();
		}finally{
			em.close();
		}
	}
	public Task getTask(Integer id){
		em = getEntityManager();
		try{
			TypedQuery<Task> q = em.createQuery("Select t from TaskApp t where t.ID = :id",Task.class);
			return q.setParameter("id", id).getSingleResult();
		}finally{
			em.close();
		}
	}
	public int getTaskCount() {
        em = getEntityManager();
        try {
            TypedQuery<Integer> q = em.createQuery("select count(o) from TaskApp as o", Integer.class);
            return q.getSingleResult().intValue();
        } finally {
            em.close();
        }
    }
	public void createTask(String name, String content, String priority){
		em = getEntityManager();
		try{
			Task t = new Task(name, content, priority);
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		}finally{
			em.close();
		}
	}
}
