package pack.service;

import java.sql.SQLException;

import java.util.List;

import com.Dao.SpecalistDao;

import pack.Dto.Specalist;

public class SpecalistRegistionServiceImpl implements SpecalistRegistionService  {

	@Override
	public boolean addSpecialiist(Specalist s) throws ClassNotFoundException, SQLException {
		SpecalistDao specalistDao=new SpecalistDao();
		String insert_specalist="insert into specialist(spec_name) values(?)";
		return  specalistDao.specialist_List(s,insert_specalist);
		
	}

	/*
	 * @Override public List<Specalist> getAllspecalistList() throws
	 * ClassNotFoundException, SQLException { // TODO Auto-generated method stub
	 * SpecalistDao specalistsDao=new SpecalistDao(); String
	 * result_ListOfspecalist="Select * from specialist"; return
	 * specalistsDao.allSpecalistList(result_ListOfspecalist); }
	 */
		
	
	

}
