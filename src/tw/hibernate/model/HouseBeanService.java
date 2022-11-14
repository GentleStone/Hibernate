package tw.hibernate.model;

import java.util.List;

import org.hibernate.Session;

public class HouseBeanService implements IHouseBeanService {
	private HouseBeanDAO hDAO;
	
	public HouseBeanService(Session session) {
		hDAO = new HouseBeanDAO(session);
	}

	@Override
	public HouseBean selectADataByID(HouseBean hBean) {
		return hDAO.selectADataByID(hBean);
	}

	@Override
	public List<HouseBean> selectAllData() {
		return hDAO.selectAllData();
	}

	@Override
	public HouseBean insertAData(HouseBean hBean) {
		return hDAO.insertAData(hBean);
	}

	@Override
	public HouseBean upDataAData(int houseid, String housename) {
		return hDAO.upDataAData(houseid, housename);
	}

	@Override
	public boolean deleteAData(int houseid) {
		return hDAO.deleteAData(houseid);
	}

}
