
public class Order extends Item{
private int opticalZoom;

	public Order(String assetTag, String description, int opticalZoom) {
		super(assetTag, description);
		this.opticalZoom = opticalZoom;
	}

	public int getOpticalZoom() {
		return opticalZoom;
	}
	
	public String toString(){
		String output = "";
		// Write your codes here
		return output;
	}
}
