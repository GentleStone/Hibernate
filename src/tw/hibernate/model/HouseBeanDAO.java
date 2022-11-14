package tw.hibernate.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class HouseBeanDAO implements IHouseBeanDAO {
	
	private Session session;
	
	public HouseBeanDAO(Session session) {
		this.session = session;
	}

	public HouseBean selectADataByID(HouseBean hBean) {
		
		return session.get(HouseBean.class,hBean.getHouseID());	
	}
	
	public List<HouseBean> selectAllData(){
		Query<HouseBean> q = session.createQuery("from HouseBean",HouseBean.class);
		return q.list();
	}
	
	public HouseBean insertAData(HouseBean hBean) {
		HouseBean rs = session.get(HouseBean.class,hBean.getHouseID());
		
		if(rs == null) {
			
			session.save(hBean);
			return hBean;
		}
		
		return null;
	}
	
	public HouseBean upDataAData(int houseid, String housename) {
		HouseBean rs = session.get(HouseBean.class,houseid);
		
		if(rs!=null) {
			rs.setHouseName(housename);
		}
		
		return rs;
	}
	
	public boolean deleteAData(int houseid) {
		HouseBean rs = session.get(HouseBean.class,houseid);
		
		if(rs!=null) {
			session.delete(rs);
			return true;
		}
		
		return false;
	}
}
