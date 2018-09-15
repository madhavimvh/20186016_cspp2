class Item {
	private String productname;
	private int quantity;
	private double unitprice;
	public Item(final String productname, final int quantity, final double unitprice) {
		this.productname = productname;
		this.quantity = quantity;
		this.unitprice = unitprice;
	}
	public Item(final String productname, final int quantity) {
		this.productname = productname;
		this.quantity = quantity;
	}
	public String getproductname() {
		return productname;
	}
	public int getquantity() {
		return quantity;
	}
	public double getunitprice() {
		return unitprice;
	}
	public int setquantity(final int quant) {
		this.quantity = quant;
	}
}
class ShoppingCart {
	private Item[] catalogue;
	private Item[] cart;
	private int cataloguesize;
	private int cartsize;

	public ShoppingCart(Item[] catalogue, Item[] cart) {
		this.catalogue = new Item[10];
		this.cart = new Item[20];
		this.cataloguesize = 0;
		this.cartsize = 0;
	}
	public void resize() {
		catalogue = Arrays.copyOf(catalogue, cataloguesize);
		cart = Arrays.copyOf(cart, cartsize);
	}
	public void addToCatalog(Item item) {
		catalogue[cataloguesize++] = item; 
	}
	public void addToCart(Item item) {
		cart[cartsize] = item;
	}
	public removeFromCart(Item item) {
		for (int i = 0; i < cartsize; i++) {
			if (cart[i].getproductname().equals(item.getproductname())) {
				int quant = cart[i].getquantity() - item.getquantity();
				cart[i].setquantity(quant);
				if (cart[i].getquantity() <= 0) {
					for (int j = i; i < cartsize; i++) {
						cart[i] = cart[i + 1];	
					}
					cartsize--;
				}
			}
		}
	}
	public showCart() {

	}
	public showCatalogue() {

	}
	public getTotalAmount() {

	}
	public getPayableAmount() {

	}
	public applyCoupon() {

	}
	public printInvoice() {

	}
 }
public class Solutionprc {
	private Solutionprc() {
	}
	public static void main(String[] args) {
	ShoppingCart shopcart = new ShoppingCart();
	Scanner scan = new Scanner(System.in);
	int lines = Integer.parseInt(scan.nextLine());
	for (int i = 0; i < lines; i++) {
		String[] tokens = scan.nextLine().split(" ");
		switch(tokens[0]) {
			case "add":
			String[] items = tokens[1].split(",");
			shopcart.addToCart(items[0], Integer.parseInt(items[1]));
			break;
			case "Item":
			items = tokens[1].split(",");
			shopcart.addToCatalog(items[0], Integer.parseInt(items[1]), Integer.parseInt(items[2]));
			break;
			case "catalog":
			shopcart.showCatalogue();
			break;
			case "show":
			shopcart.shopcart();
			break;
			case "totalAmount":
			shopcart.getTotalAmount();
			break;
			case "payableAmount":
			shopcart.getPayableAmount();
			break;
			case "remove":
			items = tokens[1].split(",");
			shopcart.removeFromCart(items[0], Integer.parseInt(items[1]));
			break;
			case "coupon":
			shopcart.applyCoupon(tokens[1]);
			break;

		}


	}
	}
}