package hospital.Entities;

public class Category {
	
	private int caId;
	private String caName;
	private String caContent;
	private boolean caStatus;
	private String caImage;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int caId, String caName, String caContent, boolean caStatus, String caImage) {
		
		this.caId = caId;
		this.caName = caName;
		this.caContent = caContent;
		this.caStatus = caStatus;
		this.caImage = caImage;
	}

	public int getCaId() {
		return caId;
	}

	public void setCaId(int caId) {
		this.caId = caId;
	}

	public String getCaName() {
		return caName;
	}

	public void setCaName(String caName) {
		this.caName = caName;
	}

	public String getCaContent() {
		return caContent;
	}

	public void setCaContent(String caContent) {
		this.caContent = caContent;
	}

	public boolean isCaStatus() {
		return caStatus;
	}

	public void setCaStatus(boolean caStatus) {
		this.caStatus = caStatus;
	}
	
	public String getCaImage() {
		return caImage;
	}
	
	public void setCaImage(String caImage) {
		this.caImage = caImage;
	}
	
}
