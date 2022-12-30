package garagesystem;

import java.util.*;

public class Garage {
    protected ParkingSlot[] parkingSlots;
    protected ArrayList<Employee> employees = new ArrayList<Employee>();
    protected ArrayList<Client> clients = new ArrayList<Client>();
    private int slotPrice;                      //price per parking slot
    private double capital;                     //Garage capital value
    
    //constructor that accepts the number of parking slots
    Garage(int parkingSlots){
        this.parkingSlots = new ParkingSlot[parkingSlots];      //initializing parkingSlots array with a loop
        for (int i = 0; i < parkingSlots; i++) {
            this.parkingSlots[i] = new ParkingSlot();             
        }    
    }
    ArrayList<Employee> getEmployees(){
        return employees;
    }
    ArrayList<Client> getClients(){
        return clients;
    }
    //adds an array of clients 
    void addClients(Client[] clients){
        for (int i = 0; i < clients.length; i++) {      //loop to add every elements 
            this.clients.add(clients[i]);
        }
    }
    //adds a single client
    String addClient(Client client){
        this.clients.add(client);
        return client.getID();
    }
    //removes a specific client
    void removeClient(Client client){
        this.clients.remove(client);            
        for (int i = 0; i < parkingSlots.length; i++) {     //clears parking slot if it was owned by the removed client
            if(parkingSlots[i].getClient()==client){
                parkingSlots[i].clear();
            }
        }
    }
    //adds an array of employees
    void addEmployees(Employee[] employees){
        for (int i = 0; i < employees.length; i++) {      //loop to add every elements 
            this.employees.add(employees[i]);
        }
    }
    //adds a single employee
    void addEmployee(Employee employee){
        this.employees.add(employee);
    }
    //removes a employee
    void removeEmployee(Employee employee){
        this.employees.remove(employee);
        this.setCapitalValueAndEmployeeSalary();        //updates capital value
    }
    //setter
    void setSlotPrice(int slotPrice){
        this.slotPrice=slotPrice;
    }
    //searches for a empty parking lot and parks the client in it with all his vehicles
    void setClientToParking(Client client){
        ArrayList<Car> c=new ArrayList<Car>();                  //temprorary array to save deleted cars to return it
        ArrayList<Motorcycle> m=new ArrayList<Motorcycle>();    //temprorary array to save deleted motorcycles to return it
        for (int i = 0; i < parkingSlots.length; i++) {         //loop to search for empty parking lot and parks client in it
            if(parkingSlots[i].Empty){                          //checks if the parking is empty
                if(client.hasCar){                              //if the client has a car the it sets client to the empty parking 
                parkingSlots[i].setClient(client);
                }else if(client.hasMotorcycle){
                parkingSlots[i].setClient(client);              //if the client has a motorcycle the it sets client to the empty parking        
                }
                
                if(client.cars.size()>=1){                      //if the client has a car
                    c.add(client.cars.get(0));                  //saves the car in the temporary array before deleting it
                    client.cars.remove(0);                      //removes the car from client
                    if(client.cars.isEmpty()){                  //if no cars left then it sets client hasCar to false 
                        client.hasCar=false;                    
                    }
                }
                else if(client.motorcycles.size()>3){           //else if client has a motorcycles that are more than the maximum
                    m.add(client.motorcycles.get(0));           //then it adds the first 3 motorcycles to temporary array before deleting them
                    m.add(client.motorcycles.get(1));
                    m.add(client.motorcycles.get(2));
                    client.motorcycles.remove(0);               //deletes the first 3 motorcycles
                    client.motorcycles.remove(0);
                    client.motorcycles.remove(0);
                    if(client.motorcycles.isEmpty()){           //if no motorcycles left then it sets client hasMotorcycle to false
                        client.hasMotorcycle=false;
                    }
                
                }else{
                    client.hasMotorcycle=false;                 //if client's motorcycles are less than the maximum the it sets hasMotorcycles to false after parking them
                    client.hasCar=false;                        //sets hasCar to false in addition
                }
            }
        }
        client.ownCars((ArrayList<Car>) c.clone());                     //sets the removed cars back to the client object by cloning array
        client.ownMotorcycles((ArrayList<Motorcycle>) m.clone());       //sets the removed motorcycle back to the client object by cloning array
        c.clear();                                                      //clears the array to get used again
        m.clear();
        if(client.motorcycles.size()>=1 || client.cars.size()>=1){      //checks if the client has car or motorcycle to set it to parked
            client.parked = true;
        }
        this.setCapitalValueAndEmployeeSalary();                        //updates capital value
    } 
    //setting every client to the nearest empty slot
    void setAllClientsToParking(){
        for (int i = 0; i < clients.size(); i++) {      //loops between all clients
            setClientToParking(clients.get(i));         //uses the same method to set a single client
        }
    }
    //sets the capital value of the garage and the employee's salary
    void setCapitalValueAndEmployeeSalary(){
        int profit=0;                                                           //the sum of all the profits
        for (int i = 0; i < clients.size(); i++) {                              //loops to see if the client is parked then charge him and adds the fees to sum
            if(clients.get(i).parked){
                profit+=clients.get(i).getFees();
            }
        }
        for (int i = 0; i < employees.size(); i++) {                            //loops and sets the salary of every employee by 50% of the profit over the amount of employees
            employees.get(i).setSalary((0.5*profit)/employees.size());
        }
        capital= 0.5*profit;                                                    //sets the other 50% of the profit
    }
    //removes client from parking by searching his ID
    void removeClientFromParking(String clientID){
        for (int i = 0; i < parkingSlots.length; i++) {
            if(parkingSlots[i].getClientID()==clientID){    //loops and checks if it found the matching clientID
                parkingSlots[i].clear();                    //clears the parking slot that had his clientID
            }
        }
    }
    //searches where client parked by his ID and returns a arraylist of the slotsID
    ArrayList<String> searchWhereClientParked(String clientID){
        ArrayList<String> a=new ArrayList<String>();            //creates the arraylist to save the slotsID in it
        for (int i = 0; i < parkingSlots.length; i++) {         //loops and checks if it found the matching clientID    
            if(parkingSlots[i].getClientID()==clientID){        
                a.add(parkingSlots[i].getSlotID());             //adds the slotID to the created arraylist
            }
        }
        return a;                                               //returns the arraylist 
    }
    //searches for the client by his String name and returns his Client object
    Client searchForClientByName(String name){
        for (int i = 0; i < clients.size(); i++) {          
            if(name.equalsIgnoreCase(clients.get(i).name)){     //loops and checks if it found the matching name with ignoring cases
                return clients.get(i);                          //returns the client object if found
            }
        }
        return null;                                            //else returns null
    }
    //returns the number of filled parking slots 
    int getNumberOfFilledSlots(){
        int count=0;                                        //counting empty slots 
        for (int i = 0; i < parkingSlots.length; i++) {
            if(!parkingSlots[i].Empty){                     //checks if the parking slot isn't empty
               count++;                                     //then adds 1 to the counter
            }
        }
        return count;                                       //returns the filled slots
    }
    //returns the garage capital value
    double getGarageCapitalValue(){
        return capital;
    }
    //returns the sum of weight of all parked vehicles
    int getOnGarageWeight(){
        int sum=0;                                                                   //variable to collect weight
        for (int i = 0; i < parkingSlots.length; i++) {                              //loops and checks if the parking slot is not empty and has a vehicle
            if(!parkingSlots[i].Empty){                         
                if(parkingSlots[i].car!=null){                                       //if it is a car then it adds the car weight to sum
                    sum+=parkingSlots[i].car.getWeight();
                }
                else if(!parkingSlots[i].motorcycle.isEmpty()){                      //checks if the parking slot motocycles array is not empty
                    for (int j = 0; j < parkingSlots[i].motorcycle.size(); j++) {    //loops arround every motocycle elements then adds its weight to the sum
                        sum+=parkingSlots[i].motorcycle.get(j).getWeight();
                    }
                }
            }
        }
        return sum;                                                                 //returns the weight of all the vehicles
    }
    //returns salary per employee
    double getSalaryPerEmployee(){
        if(employees.size()!=0){                    //checks if there are employees in the array to pervent errors
            return employees.get(0).getSalary();    //returns the salary per any employee
        }else{
            return 0;
        }
    }
    //returns String with all garage data
    public String toString(){
        return  "NumOfParkingSlots:"+parkingSlots.length+
                "\nNumberOfFilledSlots:"+this.getNumberOfFilledSlots()+
                "\nNumOfEmployees:"+employees.size()+
                "\nNumOfClients:"+clients.size()+
                "\nVehiclesWeight:"+this.getOnGarageWeight()+"kg"+
                "\nPricePerSlot:"+slotPrice+
                "\nSalaryPerEmployee:"+this.getSalaryPerEmployee()+
                "\nGarageValue:"+capital+"\n";
    }
    
}
