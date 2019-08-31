package logic;
import java.io.*; 
import java.util.*; 
import java.util.Scanner;


public class Store {
	private	String name;
	private int totalSales;
	private List<Record> records;
	private List<Menu> menus;
	
	public Store(String name) {
		this.name=name;
		int totalSales;
		this.records = new ArrayList<>();
		this.menus= new ArrayList<>();
	}
	public void showAllmenu() {
		for(Menu i:menus) {
			System.out.println(menus);
		}
	}
	public boolean addMenu(Menu menu) {
		if (menus.contains(menu)) {
			return false;
		}
		else {
			menus.add(menu);
			return true;
		}
	}
	public void addRecord(Record record) {
		records.add(record);
	}
	
	public void sell(Menu menu, boolean isSpecial) {
		if(!menus.contains(menu)) {
			System.out.println("Please select invalid menu.");
		}
		int price;
		String new_name=menu.getName();
		if(isSpecial) {
			price=menu.getSpecialPrice();
			this.totalSales+=price;
		}
		else {
			price=menu.getPrice();
			this.totalSales+=price;
		}
		Record new_record=new Record(new_name,price);
		records.add(new_record);
		System.out.println("Thank you for buying " + menu.getName() + " " + Integer.toString(price) + " Bath");
	}
	public void showRecord() {
		for(Record i:records) {
			System.out.println(i);
		}
	}

	public void sellProcessHandle() {
		System.out.println("---------------------------");
		System.out.println("Welcome to "+this.name);
		System.out.println("---------------------------");
		if(menus.size()==0) {
			System.out.println("Please add menu first");
			return;
		}
		else {
			for (int i=0;i<menus.size();i++) {
				System.out.println("["+Integer.toString(i+1)+"]"+menus.get(i));
			}
		}
		System.out.print("Please select menu : ");
		Scanner sc;
		Boolean spemenu;
		sc=new Scanner(System.in);
		int num_menu=sc.nextInt();
		Menu ordermenu=menus.get(num_menu-1);
		System.out.print("Upgrade to special ? (Y/N) :");
		sc=new Scanner(System.in);
		String special=sc.nextLine();
		if (special.equals("Y")) {
			spemenu=true;
		}
		else {
			spemenu=false;
		}
		this.sell(ordermenu,spemenu);
	}

	public void manageProcessHandle() {
		System.out.println("---------------------------");
		System.out.println("Welcome to "+this.name);
		System.out.println("---------------------------");
		System.out.println("1. Add menu");
		System.out.println("2. Show summary");
		System.out.println("Select a program to do : ");
		Scanner sc;
		sc = new Scanner (System.in);
		int comm=sc.nextInt();
		if (comm==1) {
			this.addMenuHandle();
		}
		else if(comm==2) {
			this.showSummary();
		}
	}
	
	private void addMenuHandle() {
		System.out.println("Please enter menu name :");
		Scanner sc=new Scanner (System.in);
		String new_name=sc.nextLine();
		System.out.println("Please enter price :");
		sc=new Scanner (System.in);
		int new_price=sc.nextInt();
		Menu new_menu=new Menu(new_name,new_price);
		if (this.addMenu(new_menu)==true) {
			System.out.println("New menu " + name + " added!");
		}
	
	}

	private void showSummary() {
		System.out.println("Total Sales : " + Integer.toString(this.totalSales));
		for (Record i:records) {
			System.out.println(i);
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	public List<Record> getRecords() {
		return records;
	}
	public void setRecords(List<Record> records) {
		this.records = records;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
}
