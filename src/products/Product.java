package products;

public class Product {
	
	public Product(String productId, String productname, String productType, String discount, String forSex,
			String price) {
		this.productId = productId;
		this.productname = productname;
		this.productType = productType;
		this.discount = discount;
		this.forSex = forSex;
		this.price = price;
	}
	
	public Product() {
	}

	private String productId;
	private String productname;
	private String productType;  // new arrival or discount
	private String discount;     //discount in %
	private String forSex;       // for male or female
	private String price;
	
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getForSex() {
		return forSex;
	}
	public void setForSex(String forSex) {
		this.forSex = forSex;
	}
	
	
}
