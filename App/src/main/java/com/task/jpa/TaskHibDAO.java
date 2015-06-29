package com.task.jpa;
import javax.persistence.*;
import java.util.List;
import java.util.Properties;


public class TaskHibDAO {
	private EntityManager em = null;
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
	
}
