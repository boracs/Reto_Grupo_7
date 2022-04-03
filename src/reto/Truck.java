package reto;

public class Truck extends Vehicle {

	private int load;
	private char merchandiseType;
	
	public Truck() {
		
	}
	
	public Truck(String brand, String model, int year, String registration, String numFrame,
			String colour, int numOfSeats, int price, int load, char merchandiseType) {
		
		super(brand, model, year, registration, numFrame, colour, numOfSeats, price);
		this.load = load;
		this.merchandiseType = merchandiseType;
		
		
		ConnectionToDB myConnectionToDB = null;
		
		try {
			myConnectionToDB = new ConnectionToDB();
			myConnectionToDB.myExeQuery("INSERT INTO truck VALUES ('" + registration.toUpperCase() + "', " + load + ", '" + Character.toUpperCase(merchandiseType) + "')");
			System.out.println("\nTruck succesfully added to database!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if(myConnectionToDB != null){
                try{
                	myConnectionToDB.disconnect();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
		}
	}

	
	public void sell(int serieNum, String registration) {
		
		ConnectionToDB myConnectionToDB = null;

		try {
			myConnectionToDB = new ConnectionToDB();
			myConnectionToDB.myExeQuery("DELETE FROM truck WHERE truckRegistration = '" + registration + "'");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if(myConnectionToDB != null){
                try{
                	myConnectionToDB.disconnect();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
		}
		
		super.sell(serieNum, registration);
	}
	
	
	public int getLoad() {
		return this.load;
	}

	public char getMerchandiseType() {
		return this.merchandiseType;
	}

	public void setLoad(int load) {
		this.load = load;
	}

	public void setMerchandiseType(char merchandiseType) {
		this.merchandiseType = merchandiseType;
	}
	
}
