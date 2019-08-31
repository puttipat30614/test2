package logic;

public class Menu {
	private String name;
	private int price;
	private int specialPrice;	
	public Menu(String name,int price) {
		this.name=name;
		this.price=price;
		this.setPrice(price);
	}
	public String toString() {
		return name+" Price : "+Integer.toString(price)+" (special "+Integer.toString(specialPrice)+")";
	}
	public void setPrice(int setprice) {
		price=setprice;
		this.setSpecialPrice();
		if(price<0) {
			price=0;
		}
		if(price>200) {
			price=200;
		}
		if(specialPrice<0) {
			specialPrice=0;
		}
		if(specialPrice>200) {
			specialPrice=200;
		}
	}
	private void setSpecialPrice() {
		if(price<=50) {
			specialPrice=price+5;
		}
		else if(price<=100) {
			specialPrice=price+10;
		}
		else if(price>100) {
			specialPrice=price+20;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public int getSpecialPrice() {
		return specialPrice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}