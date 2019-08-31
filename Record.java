package logic;

public class Record {
	private String foodName;
	private int soldPrice;
	public Record(String Menu,int price) {
		foodName=Menu;
		soldPrice=price;
	}
	public String toString() {
		return "Menu : "+foodName+" sold in "+Integer.toString(soldPrice)+" THB";
	}
	public String getFoodName() {
		return foodName;
	}
	public int getSoldPrice() {
		return soldPrice;
	}
}
