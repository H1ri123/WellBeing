package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pack.Dto.Doctor;
import pack.jdbc.Connection.JdbcConnection;

public class DoctorDao {
	public boolean registerDoctor(Doctor d) {
		boolean doctorDetails = false;
		try {

			String Doctor_Details_Query = "insert into doctor(full_name,dob,qualification,specialist,email,mob_no,password)values(?,?,?,?,?,?,?)";
			// JdbcConnection dBConnect= new JdbcConnection();
			Connection mysqlConn = JdbcConnection.getMySqlConnection();
			PreparedStatement ps = mysqlConn.prepareStatement(Doctor_Details_Query);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobno());
			ps.setString(7, d.getPassword());

			int i = ps.executeUpdate();

			if (i == 1) {
				doctorDetails = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctorDetails;

	}

	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;
		try {
			Connection mysqlConn = JdbcConnection.getMySqlConnection();
			String doctor_Row = "select*from doctor order by id desc";

			PreparedStatement ps = mysqlConn.prepareStatement(doctor_Row);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobno(rs.getNString(7));
				d.setPassword(rs.getString(8));
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public Doctor getDoctorById(int id) {
		Doctor d = null;
		try {
			String doctor_Row = "select * from doctor where id=?";
			Connection mysqlConn = JdbcConnection.getMySqlConnection();
			PreparedStatement ps = mysqlConn.prepareStatement(doctor_Row);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobno(rs.getNString(7));
				d.setPassword(rs.getString(8));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;

	}

	public boolean ubdateDoctor(Doctor d) {
		boolean doctorUpdateDetails = false;
		try {

			String DoctorDetails_Update_Query = "update doctor set full_name=?,dob=?,qualification=?,specialist=?,email=?,mob_no=?,password=? where id=?";
			// JdbcConnection dBConnect= new JdbcConnection();
			Connection mysqlConn = JdbcConnection.getMySqlConnection();
			PreparedStatement ps = mysqlConn.prepareStatement(DoctorDetails_Update_Query);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobno());
			ps.setString(7, d.getPassword());
			ps.setInt(8, d.getId());
			;
			int i = ps.executeUpdate();

			if (i == 1) {
				doctorUpdateDetails = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctorUpdateDetails;

	}

	public boolean deleteDoctor(int id) {
		boolean delete_Doctor = false;
		try {
			String Delete_Doctor_Details = "delete from doctor where id=?";
			Connection mysqlConn = JdbcConnection.getMySqlConnection();
			PreparedStatement ps = mysqlConn.prepareStatement(Delete_Doctor_Details);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				delete_Doctor = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return delete_Doctor;

	}

	public Doctor doctorLogin(String email, String password) {
		Doctor d = null;
		try {
			Connection mySqlConn = JdbcConnection.getMySqlConnection();
			String doctor_Login_Query = "select * from doctor where email=? and password=?";
			PreparedStatement ps = mySqlConn.prepareStatement(doctor_Login_Query);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobno(rs.getNString(7));
				d.setPassword(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;

	}

	public int countDoctor() {
		int i = 0;
		try {
			Connection mySqlConn = JdbcConnection.getMySqlConnection();
			String Count_Doctor_Query = "select*from doctor";
			PreparedStatement ps = mySqlConn.prepareStatement(Count_Doctor_Query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	public int countAppointment() {
		int i = 0;
		try {
			Connection mySqlConn = JdbcConnection.getMySqlConnection();
			String appoint_Count_Query = "select*from appointment";
			PreparedStatement ps = mySqlConn.prepareStatement(appoint_Count_Query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	public int countAppointmentByDoctorId(int did) {
		int i = 0;
		try {
			Connection mySqlConn = JdbcConnection.getMySqlConnection();
			String Doctor_Id_Count_Query = "select*from appointment where doctor_id=?";
			PreparedStatement ps = mySqlConn.prepareStatement(Doctor_Id_Count_Query);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	public int countUser() {
		int i = 0;
		try {
			Connection mySqlConn = JdbcConnection.getMySqlConnection();
			String user_Count_Query = "select*from user_Dets";
			PreparedStatement ps = mySqlConn.prepareStatement(user_Count_Query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	public int countSpecialist() {
		int i = 0;
		try {
			Connection mySqlConn = JdbcConnection.getMySqlConnection();
			String specialist_Count_Query = "select*from specialist";
			PreparedStatement ps = mySqlConn.prepareStatement(specialist_Count_Query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	public boolean checkOldPassword(int userId, String oldPassword) {
		boolean oldPs = false;

		try {
			String old_password_edit_doctor = "select * from doctor where id=? and password=?";
			Connection mysqlConn = JdbcConnection.getMySqlConnection();
			PreparedStatement ps = mysqlConn.prepareStatement(old_password_edit_doctor);
			ps.setInt(1, userId);
			ps.setString(2, oldPassword);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				oldPs = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return oldPs;
	}

	public boolean changePassword(int userId, String newPassword) {
		boolean updatePs = false;

		try {
			String Update_password_check = "update doctor set password=? where id=?";
			Connection mysqlConn = JdbcConnection.getMySqlConnection();
			PreparedStatement ps = mysqlConn.prepareStatement(Update_password_check);
			ps.setString(1, newPassword);
			ps.setInt(2, userId);
			int i = ps.executeUpdate();
			if (i == 1) {
				updatePs = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return updatePs;
	}

	public boolean edit_Doctor_Profile(Doctor d) {
		boolean doctorUpdateDetails = false;
		try {

			String DoctorDetails_Update_Query = "update doctor set full_name=?,dob=?,qualification=?,specialist=?,email=?,mob_no=? where id=?";
			// JdbcConnection dBConnect= new JdbcConnection();
			Connection mysqlConn = JdbcConnection.getMySqlConnection();
			PreparedStatement ps = mysqlConn.prepareStatement(DoctorDetails_Update_Query);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobno());
			ps.setInt(7, d.getId());
			int i = ps.executeUpdate();

			if (i == 1) {
				doctorUpdateDetails = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctorUpdateDetails;

	}
}
