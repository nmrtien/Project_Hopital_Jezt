package hospital.Entities;

public class Patients {
	
	private int paId;
	private String paAcc;
	private String paPass;
	private String paFullName;
	private String paPhone;
	private int paAge;
	private String paEmail;
	private String paAvatar;
	private String paAddress;
	private String paContent;
	private boolean paStatus;
	private int doId;
	private int rollId;
	
	public Patients() {
		// TODO Auto-generated constructor stub
	}

	public Patients(int paId, String paAcc, String paPass, String paFullName, String paPhone, int paAge, String paEmail,
			String paAvatar, String paAddress, String paContent, boolean paStatus, int doId, int rollId) {
		
		this.paId = paId;
		this.paAcc = paAcc;
		this.paPass = paPass;
		this.paFullName = paFullName;
		this.paPhone = paPhone;
		this.paAge = paAge;
		this.paEmail = paEmail;
		this.paAvatar = paAvatar;
		this.paAddress = paAddress;
		this.paContent = paContent;
		this.paStatus = paStatus;
		this.doId = doId;
		this.rollId = rollId;
	}

	public int getPaId() {
		return paId;
	}

	public void setPaId(int paId) {
		this.paId = paId;
	}

	public String getPaAcc() {
		return paAcc;
	}

	public void setPaAcc(String paAcc) {
		this.paAcc = paAcc;
	}

	public String getPaPass() {
		return paPass;
	}

	public void setPaPass(String paPass) {
		this.paPass = paPass;
	}

	public String getPaFullName() {
		return paFullName;
	}

	public void setPaFullName(String paFullName) {
		this.paFullName = paFullName;
	}

	public String getPaPhone() {
		return paPhone;
	}

	public void setPaPhone(String paPhone) {
		this.paPhone = paPhone;
	}

	public int getPaAge() {
		return paAge;
	}

	public void setPaAge(int paAge) {
		this.paAge = paAge;
	}

	public String getPaEmail() {
		return paEmail;
	}

	public void setPaEmail(String paEmail) {
		this.paEmail = paEmail;
	}

	public String getPaAvatar() {
		return paAvatar;
	}

	public void setPaAvatar(String paAvatar) {
		this.paAvatar = paAvatar;
	}

	public String getPaAddress() {
		return paAddress;
	}

	public void setPaAddress(String paAddress) {
		this.paAddress = paAddress;
	}

	public String getPaContent() {
		return paContent;
	}

	public void setPaContent(String paContent) {
		this.paContent = paContent;
	}

	public boolean isPaStatus() {
		return paStatus;
	}

	public void setPaStatus(boolean paStatus) {
		this.paStatus = paStatus;
	}
	
	public void setDoId(int doId) {
		this.doId = doId;
	}
	
	public int getDoId() {
		return doId;
	}
	
	public void setRollId(int rollId) {
		this.rollId = rollId;
	}
	
	public int getRollId() {
		return rollId;
	}
}
