import java.util.Scanner;

public class GameCar {
	//Constructo
	GameCar(){
		carName = null;
		carColor = null;
		carPos = 0;
	}
	//Overloaded Constructor
	GameCar(String name,String color,int position)
	{
		carName = name;
		carColor = color;
		carPos = position;
	}
	//Object Variables
	private String carName;
	private String carColor;
	private int carPos;
	//Object Setters
	void setColor(String newColor){
		carColor = newColor;
	}
	void setName(String newName){
		carName = newName;
	}
	void setCar(String name,String color,int pos)
	{
		carName = name;
		carColor = color;
		carPos = pos;
	}
	//Object Getters
	String getName(){
		return carName;
	}
	int getPos(){

		return carPos;
	}
	String getColor(){
		return carColor;
	}
	void getCarInfo(){
		Scanner keyboard = new Scanner(System.in);
		if(carName == null)
		{
			System.out.print("Enter Car name: ");
			carName = keyboard.nextLine();
		}
		if(carColor == null)
		{
			System.out.print("Enter Car Color: ");
			carColor = keyboard.nextLine();
		}
		if(carPos == 0)
		{
			System.out.print("Enter the starting position: ");
			carPos = keyboard.nextInt();
		}
		System.out.println("Car name is: " + carName);
		System.out.println("Car color is: " + carColor);
		System.out.println("Car current Postion is: " + carPos);	
	}
	//Object Member Methods
	void moveForward(int distance){
		carPos += distance;
	}
	void moveBackward(int distance){
		carPos -= distance;
	}
	void race(GameCar obj2){
		if(this.carPos < obj2.getPos()){
			System.out.println(obj2.getName() + " win: "+ this.carName+
			" ("+this.carPos+") vs. " +obj2.getName() + "(" + obj2.getPos() +")");
		}
		else if( this.carPos > obj2.getPos())
			System.out.println(this.getName() + " win: " +this.getName() + 
				"(" + this.getPos() +") vs. "+obj2.carName+
				" ("+obj2.carPos+")");
		else
			System.out.println("Tie: " + this.getName() +"("+this.carPos+") vs. " + 
		obj2.getName() + " (" + obj2.getPos()+")");
	}
	boolean equals(GameCar obj2){
		return (carName.equals(obj2.getName()) && carColor.equals(obj2.getColor()) 
				&&carPos == obj2.getPos());
	}
	//Overloaded to string
	@Override
	public String toString(){
		return "Car Information: " + this.carName+ " ("+this.carColor+"),"
		+ " Current Position: " + this.carPos;
	}
	public static void main(String[] args) {
		GameCar car1 = new GameCar("Mybuddy","Red",19);
		GameCar car2 = new GameCar ();
		
		car1.moveForward(5);
		car1.moveBackward(2);
		car1.setColor("Black");
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
