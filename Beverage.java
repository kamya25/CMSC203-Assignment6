import java.util.Objects;

public abstract class Beverage {
	private String name;
	private TYPE type;
	private SIZE size;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_PRICE = 1.0;
	
	public Beverage(String name, TYPE type, SIZE s) {
		this.name = name;
		this.size = s;
		this.type = type;
	}
	
	public TYPE getBevType() {
		return this.type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beverage other = (Beverage) obj;
		return Objects.equals(name, other.name) && size == other.size && type == other.type;
	}

	public String getName() {
		return this.name;
	}

	public TYPE getType() {
		return this.type;
	}

	public SIZE getSize() {
		return this.size;
	}

	public String getBevName() {
		return this.name;
	} 
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSize(SIZE size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "name=" + name + ", type=" + type + ", size=" + size;
	}

	public double getBASE_PRICE() {
		return BASE_PRICE;
	}

	public double getSIZE_PRICE() {
		return SIZE_PRICE;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public abstract double calcPrice();


	
}
