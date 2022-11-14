package tw.hibernate.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.hibernate.Util.HibernateUtil;
import tw.hibernate.model.HouseBean;

public class DemoHouseBeanAction3 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
//		HouseBean reBean = session.get(HouseBean.class,1005);
//		
//		if(reBean!=null) {
//			System.out.println(reBean.getHouseID()+":"+reBean.getHouseName());
//		}else {
//			System.out.println(reBean);
//		}
//		
//		System.out.println("-------------------------------------------------------");
//		
//		Query<HouseBean> q = session.createQuery("from HouseBean",HouseBean.class);
//		List<HouseBean> listAllData = q.list();
//		Iterator<HouseBean> l1 = listAllData.iterator();
//		while(l1.hasNext()) {
//			HouseBean house = l1.next();
//			System.out.println(house.getHouseID()+":"+house.getHouseName());
//		}
		
//		for(HouseBean house:listAllData) {
//			System.out.println(house.getHouseID()+":"+house.getHouseName());
//		}
		HouseBean deleteBean = new HouseBean();
		
		deleteBean.setHouseID(1004);
		
		session.delete(deleteBean);
		
		
		session.getTransaction().commit();

		HibernateUtil.closeSessionFactory();

	}
}
