/**
 * 
 */
package pack.dto;

public class PatientDTO {
	private String userId;
	private String appointmentDate;
	private String doctorPrescription;
	private String docterFees;
	private String balanceFees;
	private String nextVisitDate;

	public String getUserId() {
		return userId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public String getDoctorPrescription() {
		return doctorPrescription;
	}

	public String getDocterFees() {
		return docterFees;
	}

	public String getBalanceFees() {
		return balanceFees;
	}

	public String getNextVisitDate() {
		return nextVisitDate;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public void setDoctorPrescription(String doctorPrescription) {
		this.doctorPrescription = doctorPrescription;
	}

	public void setDocterFees(String docterFees) {
		this.docterFees = docterFees;
	}

	public void setBalanceFees(String balanceFees) {
		this.balanceFees = balanceFees;
	}

	public void setNextVisitDate(String nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}
}
