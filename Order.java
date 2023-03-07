import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable {
	private ArrayList<Beverage> beverages;
	private Customer customer;
	private DAY day;
	private int orderNum;
	private double time;

	public Order(int time, DAY day, Customer customer) {
		this.time = time;
		this.day = day;
		this.customer = customer;
		this.orderNum = generateOrderNumber();
		this.beverages = new ArrayList<>();
	}

	private int generateOrderNumber() {
		Random random = new Random();
		int randInt = random.nextInt((90_000 - 10_000) + 10_000);
		return randInt;
	}
	
	private void setOrderTime(int time) {
		this.time = time;
	}

	@Override
	public boolean isWeekend() {
		if(day==DAY.SATURDAY || day==DAY.SUNDAY) {
			return true;
		}else
		{
			return false;
		}
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee cafe = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(cafe);
		
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		Alcohol alco = new Alcohol(bevName, size, this.isWeekend());
		beverages.add(alco);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie juice = new Smoothie(bevName, size, numOfFruits, addPRotien);
		beverages.add(juice);
	}

	@Override
	public double calcOrderTotal() {
		double total = 0.0;
		for(Beverage beverage:beverages) {
			total +=beverage.calcPrice();
		}
		return total;
	}
	
	public void Customer(Customer customer) {
		this.customer = new Customer(customer);
	}
	
	public void setListOfBeverage(ArrayList<Beverage> bevo) {
		this.beverages = bevo;
	}

	@Override
	public int findNumOfBeveType(TYPE type) {
		int bevType = 0;
		for(Beverage beverage:beverages) {
			if(beverage.getBevType()==type) {
				bevType++;
			}
		}
		return bevType;
	}

	public int getTotalItems() {
		return beverages.size();
	}

	public int getOrderNo() {
		return this.orderNum;
	}
	
	@Override
	public Beverage getBeverage(int i) {
		return beverages.get(i);
	}

//	public Customer getCustomer() {
//		return new Customer(customer);
//	}

	public double getOrderTime() {
		return time;
	}

	public DAY getOrderDay() {
		return day;
	}

	@Override
	public int compareTo(Object o) {
		if(((Order) o).getOrderNo() == this.getOrderNo()) {
			return 0;
		}
		else if(((Order) o).getOrderNo() < this.getOrderNo()) {
			return 1;
		}
		else {
			return -1;
		}
	}

	public Customer getCustomer() {
		return new Customer(customer);
		}

	@Override
	public String toString() {
		return super.toString()+ "Order [beverage=" + beverages + ", customer=" + customer + ", day=" + day + ", orderNum=" + orderNum
				+ ", time=" + time + ", orderTotal=" + calcOrderTotal() + "]";
	}
}
