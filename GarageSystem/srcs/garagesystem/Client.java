package garagesystem;


import java.util.ArrayList;
import static garagesystem.GarageSystem.*;

public class Client extends Person{
    protected ArrayList<Car> cars=new ArrayList<Car>();                         //his Cars
    protected ArrayList<Motorcycle> motorcycles=new ArrayList<Motorcycle>();    //his motorcycles
    protected int fees;                     //paid fees for parking
    protected boolean parked;               //if he already owns parking slot
    protected boolean hasCar;               //if he has a car
    protected boolean hasMotorcycle;        //if he has a motorcycle
    static protected int clientCounter;   
    
    //Constructor for name,phoneNum and emailAddress
    Client(String name,String phoneNum,String emailAddress){        
        clientCounter++;
        id = idGenerator("#C",clientCounter);                    //used the method idGenerator in main to get unique client ID
        this.name=name;
        this.phoneNum=phoneNum;
        this.emailAddress=emailAddress;     
        parked = false;                         //defualt values
        hasCar = false;
        hasMotorcycle = false;
    }
    //no-Args Constructor
    Client(){                                                       
        this("Client"+(clientCounter+1),"000-111-222","client"+(clientCounter+1)+"@cli.com");
    }
    //constructor that adds one car
    Client(Car car){
        this("Client"+(clientCounter+1),"000-111-222","client"+(clientCounter+1)+"@cli.com");
        cars.add(car);
    }
    //constructor that adds one motorcycle
    Client(Motorcycle motorcycle){
        this("Client"+(clientCounter+1),"000-111-222","client"+(clientCounter+1)+"@cli.com");
        motorcycles.add(motorcycle);
    }
    //add car
    void ownCar(Car car){
        cars.add(car);
        hasCar=true;                    //client has a car
    }
    //sets array of cars
    void ownCars(ArrayList<Car> car){
        this.cars = car;
        if(!car.isEmpty()){         //checks if the parameter has cars in it
            hasCar=true; 
        }else{
            hasCar=false;
        }
    }
    //add motorcycle
    void ownMotorcycle(Motorcycle motorcycle){                   
        motorcycles.add(motorcycle);
        hasMotorcycle=true;             //client has a motorcycle
    }
    //sets array of cars
    void ownMotorcycles(ArrayList<Motorcycle> motorcycle){
        this.motorcycles = motorcycle;
        if(!motorcycle.isEmpty()){          ////checks if the parameter has motorcycles in it
            hasMotorcycle=true;
        }else{
            hasMotorcycle=false;
        }
    }
    //remove car
    void disOwnCar(Car car){    
        cars.remove(car);
        if(cars.isEmpty()){
            hasCar=false;               //check if no cars left
        }else{
            hasCar=true;
        }
    }
    //remove motorcycle
    void disOwnMotorcycle(Motorcycle motorcycle){ 
        motorcycles.remove(motorcycle);
        if(motorcycles.isEmpty()){      //check if no motorcycle left
            hasMotorcycle=false;
        }else{
            hasMotorcycle=true;
        }
    }
    //calculating paid fees based on parking slot price
    void calcFeesPerParkingSlot(int fees){
        int n=0;                                            //the amount of parking slots that fits the amount of motorcycles
        if(motorcycles.size()>3){
            n=(int)Math.ceil(motorcycles.size()/3.0);       //rounds it to ceil so if he has 4 motorcycle then he has 2 parking slot and if he has 3 motorcycles then 1 parking slot
        }   
        this.fees=n*fees+cars.size()*fees;                  //sets this.fees after calculating it      
    }
    //returns client paid fees
    int getFees(){  
        return fees;
    }
    static int getClientCounter(){
        return clientCounter;
    }
    //returns client ID
    String getID(){               
        return id;             
    }
    // returns string with Client Data
    public String toString(){                                 
        return "Name:"+name+"\nPhoneNumber:"+phoneNum+"\nEmailAddress:"+emailAddress+"\nID:"+id+"\nCars:"+cars+"\nMotorcycles:"+motorcycles+"\nParked?:"+parked+"\nFees:"+fees+"$"+"\n";
    }
}
