package tw.hibernate.model;

import java.util.List;

public interface IHouseBeanService {
	
	
	public HouseBean selectADataByID(HouseBean hBean);
	public List<HouseBean> selectAllData();
	public HouseBean insertAData(HouseBean hBean);
	public HouseBean upDataAData(int houseid, String housename);
	public boolean deleteAData(int houseid);

}
