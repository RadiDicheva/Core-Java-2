
public class Car {
	protected int mileage;
	protected long vin;
	
	public Car () {}
	
	public Car(int mileage, int vin) {
		this.mileage = mileage;
		this.vin = vin;
	}

	public int getMileage() {
		return mileage;
	}

	public long getVin() {
		return vin;
	}

	@Override
	public String toString() {
		return "This is a car";
	}
}

class Audi extends Car {
	public Audi(int mileage, int vin) {
		this.mileage = mileage;
		this.vin = vin;
	}
	
	@Override
	public int getMileage() {
		return mileage;
	}

	@Override
	public long getVin() {
		return vin;
	}
	
	@Override
	public String toString() {
		return "Audi@" + getMileage() + ", vehicle identification number is " + getVin();
	}
}

class Bmw extends Car {
	public Bmw(int mileage, int vin) {
		this.mileage = mileage;
		this.vin = vin;
	}
	
	@Override
	public int getMileage() {
		return mileage;
	}

	@Override
	public long getVin() {
		return vin;
	}
	
	@Override
	public String toString() {
		return "BMW@" + getMileage() + ", vehicle identification number is " + getVin();
	}
}

class Wolkswagen extends Car {
	public Wolkswagen(int mileage, int vin) {
		this.mileage = mileage;
		this.vin = vin;
	}
	
	@Override
	public int getMileage() {
		return mileage;
	}

	@Override
	public long getVin() {
		return vin;
	}
	
	@Override
	public String toString() {
		return "Wolkswagen@" + getMileage() + ", vehicle identification number is " + getVin();
	}
}
