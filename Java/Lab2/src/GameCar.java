import java.util.Scanner;

public class GameCar{
	//************ Object Variables ***************
	private String carName;
	private String carColor;
	private int carPosition;
	
	//************** Constructor ******************
	GameCar(){
		carName = null;
		carColor = null;
		carPosition = 0;
	}
	
	//*************** Overloaded Constructor *****************
	GameCar(String name, String color, int position){
		carName = name;
		carColor = color;
		carPosition = position;
	}
	
	//*********************** Getters *************************
	String getCarName(){
		return carName;
	}
	
	String getCarColor(){
		return carColor;
	}
	
	int getCarPosition(){
		return carPosition;
	}
	
	void getCarInfo(){
		Scanner keyboard = new Scanner(System.in);
		if(carName == null){
			System.out.print("Enter the car name: ");
			carName = keyboard.nextLine();
		}
		if(carColor == null){
			System.out.print("Enter the color: ");
			carColor = keyboard.nextLine();
		}
		if(carPosition == 0){
			System.out.print("Enter the starting position: ");
			carPosition = keyboard.nextInt();
		}
	}
	
	//*********************** Setters *************************
	void setCarName(String newCarName){
		carName = newCarName;
	}
	
	void setCarColor(String newCarColor){
		carColor = newCarColor;
	}

	void setCarName(int newPosition){
		carPosition = newPosition;
	}
	
	void setCar(String name, String color, int position){
		carName = name;
		carColor = color;
		carPosition = position;
	}
	
	//******************** Member Methods **********************
	void moveForward(int distance){
		carPosition = distance + carPosition;
	}
	
	void moveBackword(int distance){
		carPosition = carPosition - distance;
	}
	
	public String toString(){
		return "Car Information: " + this.carName + " ("+this.carColor+"),"+ " Current Position: " + this.carPosition;
	}
	
	//find which car is win car1 or car2 or tie
	void race(GameCar anotherCar){
		if(this.carPosition > anotherCar.getCarPosition()){
			System.out.println(this.getCarName() + " win: " +this.getCarName() + "(" + this.getCarPosition() +") vs. "
			+ anotherCar.carName + " ("+ anotherCar.carPosition +")");
		}else if(this.carPosition < anotherCar.getCarPosition()){
			System.out.println(anotherCar.getCarName() + " win: "+ this.carName +" ("+this.getCarPosition()+") vs. " 
		    + anotherCar.getCarName() + "(" + anotherCar.getCarPosition() +")");
		}else{
			System.out.println("Tie: " + this.getCarName() +"("+this.getCarPosition()+") vs. " + anotherCar.getCarName() 
			+ " (" + anotherCar.getCarPosition() +")");
		}
	}
	
	boolean equals(GameCar anotherCar){
		return (carName.equals(anotherCar.getCarName()) && carColor.equals(anotherCar.getCarColor()) 
				&&carPosition == anotherCar.getCarPosition());
	}
	
	//*********************** Main *************************
	public static void main(String[] args) {
		GameCar car1 = new GameCar("Mybuddy","Red",19);
		GameCar car2 = new GameCar ();
		
		car1.moveForward(5);
		car1.moveBackword(2);
		car1.setCarName("Black");
		System.out.println(car1);
		  
		car2.getCarInfo();
		car2.moveForward(7);
		car2.moveForward(3);
		System.out.println(car2);
		car1.race(car2);        
		  
		car1.moveForward(10);   
		car1.race(car2);        
		
		car1.setCar("BlueJay", "Blue", 30);   
		car1.race(car2);    
		System.out.println("Same cars? " + car1.equals(car2));
	}
}






