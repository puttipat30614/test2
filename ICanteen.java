package logic;
import java.io.*; 
import java.util.*; 
import java.util.Scanner;


public class ICanteen {
	static List <Store> Stores=new ArrayList <Store>();
	static Scanner kb;
	

	public static void main(String[] args) {
		while (true) {
			//FILL CODE
			printMain();
			System.out.print("Select a program to do : ");
			Scanner i= new Scanner (System.in);
			int cm=i.nextInt();
			
			switch (cm) {
			case 1:
				System.out.println("---------------------------");
				addStoreHandle();
				System.out.println("---------------------------");
				break;
			case 2:
				System.out.println("---------------------------");
				manageStoreHandle();
				System.out.println("---------------------------");
				break;
			case 3:
				System.out.println("---------------------------");
				buyFoodHandle();
				System.out.println("---------------------------");
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Invalid input!!");
			}

		}

	}

	private static boolean addStoreHandle() {		
		System.out.print("Store Name : ");
		String name;
		Scanner i= new Scanner (System.in);
		name = i.nextLine();
		Store new_store;
		new_store= new Store(name);
		Stores.add(new_store);
		System.out.println("The store named " + name + " was added!");
		return true;
		
	}

	private static boolean manageStoreHandle() {
		if(!showStores()) {
			return false;
		}
		System.out.println("\nPlease select store :");
		Scanner sc=new Scanner (System.in);
		int num_store=sc.nextInt();
		Stores.get(num_store-1).manageProcessHandle();
		return true;
	}

	private static boolean buyFoodHandle() {
	if(!showStores()) {
		return false;
	}
		System.out.print("\nPlease select store :");
		kb=new Scanner(System.in);
		int num_store=kb.nextInt();
		Stores.get(num_store-1).sellProcessHandle();
		return true;
	}

	public static void printMain() {
		System.out.println("=========== Main Menu ==========");
		System.out.println("What to do?");
		System.out.println("1. Add Store");
		System.out.println("2. Manage Store");
		System.out.println("3. Buy food");
		System.out.println("4. Exit program");
	}

	public static boolean showStores() {
		//FILL CODE
		if (Stores.size()==0) {
			System.out.println("Please add store first!!");
			return false;
		}
		System.out.println("Here are all stores");
		int count;
		count=0;
		for (Store i:Stores) {
			System.out.printf("[%d] %s",count+1,i.getName());
			count++;
		}
		return true;
	}
}
