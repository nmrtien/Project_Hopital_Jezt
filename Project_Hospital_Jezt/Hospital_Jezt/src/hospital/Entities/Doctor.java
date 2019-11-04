package hospital.Entities;

public class Doctor {
	
	private int doId;
	private String doAcc;
	private String doPass;
	private String doFullName;
	private String doPhone;
	private int doAge;
	private String doEmail;
	private String doAvatar;
	private String doAddress;
	private String doContent;
	private boolean doStatus;
	private int caId;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(int doId, String doAcc, String doPass, String doFullName, String doPhone, int doAge, String doEmail,
			String doAvatar, String doAddress, String doContent, boolean doStatus, int caId) {
		
		this.doId = doId;
		this.doAcc = doAcc;
		this.doPass = doPass;
		this.doFullName = doFullName;
		this.doPhone = doPhone;
		this.doAge = doAge;
		this.doEmail = doEmail;
		this.doAvatar = doAvatar;
		this.doAddress = doAddress;
		this.doContent = doContent;
		this.doStatus = doStatus;
		this.caId = caId;
	}

	public int getDoId() {
		return doId;
	}

	public void setDoId(int doId) {
		this.doId = doId;
	}

	public String getDoAcc() {
		return doAcc;
	}

	public void setDoAcc(String doAcc) {
		this.doAcc = doAcc;
	}

	public String getDoPass() {
		return doPass;
	}

	public void setDoPass(String doPass) {
		this.doPass = doPass;
	}

	public String getDoFullName() {
		return doFullName;
	}

	public void setDoFullName(String doFullName) {
		this.doFullName = doFullName;
	}

	public String getDoPhone() {
		return doPhone;
	}

	public void setDoPhone(String doPhone) {
		this.doPhone = doPhone;
	}

	public int getDoAge() {
		return doAge;
	}

	public void setDoAge(int doAge) {
		this.doAge = doAge;
	}

	public String getDoEmail() {
		return doEmail;
	}

	public void setDoEmail(String doEmail) {
		this.doEmail = doEmail;
	}

	public String getDoAvatar() {
		return doAvatar;
	}

	public void setDoAvatar(String doAvatar) {
		this.doAvatar = doAvatar;
	}

	public String getDoAddress() {
		return doAddress;
	}

	public void setDoAddress(String doAddress) {
		this.doAddress = doAddress;
	}

	public String getDoContent() {
		return doContent;
	}

	public void setDoContent(String doContent) {
		this.doContent = doContent;
	}

	public boolean isDoStatus() {
		return doStatus;
	}

	public void setDoStatus(boolean doStatus) {
		this.doStatus = doStatus;
	}
	
	public int getCaId() {
		return caId;
	}
	
	public void setCaId(int caId) {
		this.caId = caId;
	}
	
}
