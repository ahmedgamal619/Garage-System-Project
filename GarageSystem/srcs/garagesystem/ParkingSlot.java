package garagesystem;
import java.util.*;

import static garagesystem.GarageSystem.*;

public class ParkingSlot {
    protected Car car;      //1 car
    protected ArrayList<Motorcycle> motorcycle=new ArrayList<Motorcycle>();  //motorcycle array
    public boolean Empty;                           //check if the parking is empty
    static protected int slotCounter=0;
    protected String slotID;
    protected Client client;                        //Client who parked
    
    ParkingSlot(){                                              //no-Args constructor with defualt values
        slotCounter++;
        slotID = idGenerator("#P",slotCounter);                 // generates unique ID
        Empty=true;  //slot is empty
    }
    ParkingSlot(Client client){                        //constuctor to set a car and clientID
        this();
        this.setClient(client);                         //uses the method to set the owner of the parking slot
    }
    //method to set the owner of the parking slot
    void setClient(Client client){                       
        if(client.hasCar){                      //if the client has a car
            this.car=client.cars.get(0);        //then it sets the first car to parking
            Empty=false;
            this.client=client;
        }
        else if(client.hasMotorcycle){                                  //else if he has a motorcycle
            if(client.motorcycles.size()<=3){                           //checks if the array is less than or equal the maximum number of motocycles per slot
                for (int i = 0; i < client.motorcycles.size(); i++) {   //then adds all elements to the parking motorcycle array
                    this.motorcycle.add(client.motorcycles.get(i));
                }
            }else{                                                      //if it has more than 3 then it adds only the first 3
                for (int i = 0; i < 3; i++) {
                    this.motorcycle.add(client.motorcycles.get(i));
                }
            }
            Empty=false;                                                //sets to not empty
            this.client=client;
        }   
    }
    //getter
    Client getClient(){
        return client;
    }
    String getClientID(){
        if(client!=null){                                   //prevents error by making sure there is a client set
            return client.getID();
        }
        return null;
    }
    String getSlotID(){
        return slotID;
    }
    //clear slot to defualt values
    void clear(){              
        car=null;
        motorcycle=null;
        Empty=true;
        client=null;
    }
    // returns ParkingSlot data
    public String toString(){                               
        return "Is empty? "+Empty+
                "\nCar:"+car+
                "\nMotorcycles:"+motorcycle+
                "\nClientID:"+this.getClientID()+
                "\nSlotID:"+slotID+"\n"; 
    }
}
