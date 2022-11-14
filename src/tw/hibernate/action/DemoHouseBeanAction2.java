package tw.hibernate.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernate.Util.HibernateUtil;
import tw.hibernate.model.HouseBean;

public class DemoHouseBeanAction2 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			HouseBean hBean = new HouseBean();
			hBean.setHouseName("Fashion House");
			session.save(hBean);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
