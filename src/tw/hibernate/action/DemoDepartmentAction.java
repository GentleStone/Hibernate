package tw.hibernate.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernate.model.Department;

public class DemoDepartmentAction {
	
	public static void main(String[]args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		Department dBean = new Department();
		dBean.setDeptname("Magage");
		session.save(dBean);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
