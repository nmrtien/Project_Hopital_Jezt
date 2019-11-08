package hospital.Entities;

public class Director {
	
	private int diId;
	private String diAcc;
	private String diPass;
	private String diFullName;
	private String diPhone;
	private String diContent;
	private boolean diStatus;
	private int rollId;
	
	public Director() {
		// TODO Auto-generated constructor stub
	}

	public Director(int diId, String diAcc, String diPass, String diFullName, String diPhone, String diContent,
			boolean diStatus, int rollId) {
		
		this.diId = diId;
		this.diAcc = diAcc;
		this.diPass = diPass;
		this.diFullName = diFullName;
		this.diPhone = diPhone;
		this.diContent = diContent;
		this.diStatus = diStatus;
		this.rollId = rollId;
	}

	public int getDiId() {
		return diId;
	}

	public void setDiId(int diId) {
		this.diId = diId;
	}

	public String getDiAcc() {
		return diAcc;
	}

	public void setDiAcc(String diAcc) {
		this.diAcc = diAcc;
	}

	public String getDiPass() {
		return diPass;
	}

	public void setDiPass(String diPass) {
		this.diPass = diPass;
	}

	public String getDiFullName() {
		return diFullName;
	}

	public void setDiFullName(String diFullName) {
		this.diFullName = diFullName;
	}

	public String getDiPhone() {
		return diPhone;
	}

	public void setDiPhone(String diPhone) {
		this.diPhone = diPhone;
	}

	public String getDiContent() {
		return diContent;
	}

	public void setDiContent(String diContent) {
		this.diContent = diContent;
	}

	public boolean isDiStatus() {
		return diStatus;
	}

	public void setDiStatus(boolean diStatus) {
		this.diStatus = diStatus;
	}
	
	public int getRollId() {
		return rollId;
	}
	
	public void setRollId(int rollId) {
		this.rollId = rollId;
	}
	
}
