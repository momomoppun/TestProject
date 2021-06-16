package bean;
import java.io.Serializable;

public class ShohinBean implements Serializable{
	private String ID;
	private String NAME;
	private int PRICE;
	
	public ShohinBean() {
		
	}
	
	public ShohinBean(String ID, String NAME, int PRICE) {
		setId(ID);
		setName(NAME);
		setPrice(PRICE);
	}
	
	public void setId(String ID) {
		this.ID = ID;
	}
	
	public String getId() {
		return ID;
	}
	
	public void setName(String NAME) {
		this.NAME = NAME;
	}
	
	public String getName() {
		return NAME;
	}
	
	public void setPrice(int PRICE) {
		this.PRICE = PRICE;
	}
	
	public int getPrice() {
		return PRICE;
	}
}
