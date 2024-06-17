package pack.service;

import java.sql.SQLException;


import pack.Dto.Specalist;

public interface SpecalistRegistionService {
       public boolean addSpecialiist(Specalist s) throws ClassNotFoundException, SQLException;
       /* public List<Specalist> getAllspecalistList() throws ClassNotFoundException, SQLException;*/
}
