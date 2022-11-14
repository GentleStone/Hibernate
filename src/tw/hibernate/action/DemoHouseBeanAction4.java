package tw.hibernate.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernate.Util.HibernateUtil;
import tw.hibernate.model.HouseBean;
import tw.hibernate.model.HouseBeanDAO;
import tw.hibernate.model.HouseBeanService;

public class DemoHouseBeanAction4 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			HouseBeanDAO hDAO =new HouseBeanDAO(session);
			HouseBean h = new HouseBean();
			h.setHouseName("Great House");
			hDAO.insertAData(h);
			
			List<HouseBean> list = hDAO.selectAllData();
			
			for(HouseBean h2:list) {
				System.out.println(h2.getHouseID()+":"+h2.getHouseName());
			}
			
			
			HouseBeanService hService = new HouseBeanService(session);
			List<HouseBean> rs2 = hService.selectAllData();
			
			for(HouseBean h2:rs2) {
				System.out.println(h2.getHouseID()+":"+h2.getHouseName());
			}

			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
