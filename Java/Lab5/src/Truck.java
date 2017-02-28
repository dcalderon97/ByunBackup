/**
 * Title: Truck.java
 * Abstract: This class implements the Truck subclass of 
 *           the Vehicle class. Trucks can have a towing 
 *           capacity and a load capacity.
 * Author: XXXX
 * ID: XXXX
 * Date: XX/XX/XX
 */
public class Truck extends Vehicle
{
    private double loadCapacity;
    private int towingCapacity;
    
    public Truck()
    {
        super();
        this.loadCapacity = 0.0;
        this.towingCapacity = 0;
    }
    public Truck(String name, int val,Person p)
    {
    	super(name,val, p);
    }
    public Truck(String name, int val,Person p,double load, int towing)
    {
    	super(name,val, p);
    	loadCapacity = load;
    	towingCapacity = towing;
    }
   
    public double getLoadCap()
    {
        return loadCapacity;
    }
    
    public void setLoadCap(double theLoadCapacity)
    {
        this.loadCapacity = theLoadCapacity;
    }
    
    public int getTowingCap()
    {
        return towingCapacity;
    }
    
    public void setTowingCap(int theTowingCapacity)
    {
        this.towingCapacity = theTowingCapacity;
    }
    
}