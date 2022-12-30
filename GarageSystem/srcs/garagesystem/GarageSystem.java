package garagesystem;


import java.util.*;

public class GarageSystem {
    public static void main(String[] args) {
        Scanner console =new Scanner(System.in);
        int z=0,y=0,v=0,accessEmp=0,accessCli=0;                                 
        Employee tempEmp = null;                  //to clone emp for future use
        Client tempCli = null;                    //to clone client for future use
        System.out.print("How many parking slots does the garage has?: ");
        int slots = console.nextInt();
        System.out.print("Price per parking slot?: ");
        int slotPrice = console.nextInt();
        Garage garage= new Garage(slots);               //creates garage and sets given slots number
        garage.setSlotPrice(slotPrice);                 //sets slot price
        //infinite loop that keeps repeating garage menu and inputs data
        while(true){        
            if(z==0){       //made z for getting back to garage menu whenever i want to
                //garage menu
                System.out.println("1-Add employee");
                System.out.println("2-Add client");
                System.out.println("3-Remove employee");
                System.out.println("4-Remove client");
                System.out.println("5-Edit employee");
                System.out.println("6-Edit client");
                System.out.println("7-Set slot price");
                System.out.println("8-Set single client to parking");
                System.out.println("9-Set all clients to parking");
                System.out.println("10-Remove client from parking");
                System.out.println("11-Search where client parked");
                System.out.println("12-Search for client to get ID");
                System.out.println("13-Get garage data");
                z= console.nextInt();

            }else if(z==1){             //adds employee
                Employee employee=null;         //creats temp emp to put data on and add it
                if(accessEmp==0){                               //if z==1 got accessed by pressing 1 
                    System.out.print("Employee name: ");
                    String name=console.next();
                    System.out.print("Phone number: ");
                    String phone=console.next();
                    System.out.print("Email address: ");
                    String email=console.next();
                    employee= new Employee(name,phone,email);
                    garage.addEmployee(employee);
                }if(accessEmp==1){                             //else if accessed by pressing 3 to just reuse the edit menu instead of retyping it
                    employee = tempEmp;     //sets the employee that will be used to get edited
                }
                while(v!=4){                                    //menu for editing the employee
                    System.out.println("1-Change name");
                    System.out.println("2-Change phone number");
                    System.out.println("3-Change email address");
                    System.out.println("4-Back to the garage menu");
                    v = console.nextInt();
                    if(v==1){
                        System.out.print("The new name: ");
                        String a= console.next();
                        employee.setName(a);
                    }else if(v==2){
                        System.out.print("The new phone number: ");
                        String a= console.next();
                        employee.setPhoneNum(a);
                    }else if(v==3){
                        System.out.print("The new email address: ");
                        String a= console.next();
                        employee.setEmailAddress(a);
                    }
                }  
                System.out.println("Employee data:-");          //returns latest employee data
                System.out.println(employee.toString());
                accessEmp=0;          //resets accessEmp to 0 so next time it access the adding employee normally
                v=0;                    //resets the editing menu employee selection                          
                z=0;                    //gets back to garage menu
            }else if(z==2){ //adds client
                //same idea as adding employee (z==1) plus more editing options
                Client client = null;                           
                if(accessCli==0){                               
                    System.out.print("Client name: ");
                    String name=console.next();
                    System.out.print("Phone number: ");
                    String phone=console.next();
                    System.out.print("Email address: ");
                    String email=console.next();
                    client =new Client(name,phone,email);
                    garage.addClient(client);
                }else if(accessCli==1){
                    client =tempCli;
                }
                while(y!=8){
                    System.out.println("1-Change name");
                    System.out.println("2-Change phone number");
                    System.out.println("3-Change email address");
                    System.out.println("4-Add a car");
                    System.out.println("5-Add a motorcycle");
                    System.out.println("6-Remove Car");
                    System.out.println("7-Remove motorcycle");
                    System.out.println("8-Back to the garage menu");
                    y = console.nextInt();
                    if(y==1){
                        System.out.print("The new name: ");
                        String a= console.next();
                        client.setName(a);
                    }else if(y==2){
                        System.out.print("The new phone number: ");
                        String a= console.next();
                        client.setPhoneNum(a);
                    }else if(y==3){
                        System.out.print("The new email address: ");
                        String a= console.next();
                        client.setEmailAddress(a);
                    }else if(y==4){ 
                        System.out.print("Car plat: ");
                        String p=console.next();
                        System.out.print("Color: ");
                        String c=console.next();
                        System.out.print("Weight: ");
                        int w=console.nextInt();
                        System.out.print("Car Model: ");
                        String m=console.next();
                        client.ownCar(new Car(p,c,w,m));
                    }
                    else if(y==5){
                        System.out.print("Motorcycle plat: ");
                        String p=console.next();
                        System.out.print("Color: ");
                        String c=console.next();
                        System.out.print("Weight: ");
                        int w=console.nextInt();
                        System.out.print("Motorcycle Model: ");
                        String m=console.next();
                        client.ownMotorcycle(new Motorcycle(p,c,w,m));
                    }
                    else if(y==6){
                        System.out.print("The license plate of the car you want to remove?: ");
                        String p = console.next();
                        for (int i = 0; i < client.cars.size(); i++) {
                            if(client.cars.get(i).getLicensePlate()==p){
                                client.disOwnCar(client.cars.get(i));
                            }
                        }
                    }
                    else if(y==7){
                        int r=0;
                        while(r!=1){
                            System.out.print("The license plate of the motorcycle you want to remove?: ");
                            String c=console.next();
                            for (int i = 0; i < client.motorcycles.size(); i++) {
                                    if(client.motorcycles.get(i).getLicensePlate()==c){
                                        client.disOwnMotorcycle(client.motorcycles.get(i));
                                    r=1;
                                }
                            }
                            if(r!=1){
                                System.out.print("Cannot find! 1 to break else to repeat: ");
                                r = console.nextInt();
                            }
                        }
                    }
                 }
                System.out.println("Client data:-");
                System.out.println(client.toString());
                accessCli=0;
                y=0;
                z=0;
            }else if(z==3){ 
                //removes employee
                int r=0;
                while(r!=1){
                    System.out.print("ID of the Employee you want to remove?: ");
                    String c=console.next();
                    for (int i = 0; i < garage.employees.size(); i++) {
                        if(c.equalsIgnoreCase(garage.employees.get(i).getID())){
                            garage.removeEmployee(garage.employees.get(i));
                            r=1;
                        }
                    }
                    if(r!=1){
                        System.out.print("Cannot find! 1 to break else to repeat: ");
                        r = console.nextInt();
                    }
                }
                z=0;
              }else if(z==4){           //removes client
                  //same as (z==1)
                int r=0;
                while(r!=1){
                    System.out.print("ID of the Client you want to remove?: ");
                    String c=console.next();
                    for (int i = 0; i < garage.clients.size(); i++) {
                        if(c.equalsIgnoreCase(garage.clients.get(i).getID())){
                            garage.removeClient(garage.clients.get(i));
                            r=1;
                        }
                    }
                    if(r!=1){
                        System.out.print("Cannot find! 1 to break else to repeat: ");
                        r = console.nextInt();
                    }
                }
                z=0;
            }else if(z==5){         //edits employee
                //same as (z==3) with some twists
                int r=0;
                while(r!=1){
                    System.out.print("ID of the Employee you want to Edit: ");
                    String c=console.next();
                    for (int i = 0; i < garage.employees.size(); i++) {
                        if(c.equalsIgnoreCase(garage.employees.get(i).getID())){
                            tempEmp=garage.employees.get(i);        //sets the searched empolyee in the temp variable so it can be edited in add employee menu
                            z=1;            //sets z=1 so it goes to the same edit menu in add employee
                            accessEmp=1;    //helps the if condition in add employee menu
                            r=1;            //sets r to 1 so it breaks the loop
                        }
                    }
                    if(r!=1){
                        System.out.print("Cannot find! 1 to break else to repeat: ");
                        r = console.nextInt();
                        if(r==1){   //had to put it inside of here because if it was outside like in z==3 then its going to garage everytime
                            z=0;    //if the user wants to break cause nothing found then back to garage menu
                        }
                    }
                }  
            }else if(z==6){     //edits client
                //smae as (z==5)
                int r=0;
                while(r!=1){
                    System.out.print("ID of the Client you want to Edit: ");
                    String c=console.next();
                    for (int i = 0; i < garage.clients.size(); i++) {
                        if(c.equalsIgnoreCase(garage.clients.get(i).getID())){
                            tempCli=garage.clients.get(i);
                            z=2;
                            accessCli=1;
                            r=1;
                        }
                    }
                    if(r!=1){
                        System.out.print("Cannot find! 1 to break else to repeat: ");
                        r = console.nextInt();
                        if(r==1){
                            z=0;
                        }
                    }
                }   
            }else if(z==7){     //sets new price per parking slot
                System.out.print("The new Price per slot: ");
                int sp = console.nextInt();
                garage.setSlotPrice(sp);
                garage.setCapitalValueAndEmployeeSalary();      //recalculates capital value
                z=0;        //gets back to garage menu
            }else if(z==8){ 
                //same as (z==3)
                int r=0;
                while(r!=1){
                    System.out.print("ID of the Client you want to set to park: ");
                    String c=console.next();
                    for (int i = 0; i < garage.clients.size(); i++) {
                        if(c.equalsIgnoreCase(garage.clients.get(i).getID())){
                            garage.setClientToParking(garage.clients.get(i));
                            r=1;
                        }
                    }
                    if(r!=1){
                        System.out.print("Cannot find! 1 to break else to repeat: ");
                        r = console.nextInt();
                    }
                }
                z=0;
            }else if(z==9){ //sets all  clients to parking
                garage.setAllClientsToParking();
                z=0;        
            }else if(z==10){        //searches for client by ID then removes him from parking
                //same as (z==3)
                int r=0;
                while(r!=1){
                    System.out.print("ID of the Client you want to remove from parking: ");
                    String c=console.next();
                    for (int i = 0; i < garage.clients.size(); i++) {
                        if(c.equalsIgnoreCase(garage.clients.get(i).getID())){
                            garage.removeClientFromParking(garage.clients.get(i).getID());
                            r=1;
                        }
                    }
                    if(r!=1){
                        System.out.print("Cannot find! 1 to break else to repeat: ");
                        r = console.nextInt();
                    }
                }
                z=0;
            }else if(z==11){        //searches for client then finds where he parked
                //same as (z==3)
                int r=0;
                while(r!=1){
                    System.out.print("ID of the Client you want to search where parked: ");
                    String c=console.next();
                    for (int i = 0; i < garage.clients.size(); i++) {
                        if(c.equalsIgnoreCase(garage.clients.get(i).getID())){
                            System.out.println(garage.searchWhereClientParked(garage.clients.get(i).getID()));
                            r=1;
                        }
                    }
                    if(r!=1){
                        System.out.print("Cannot find! press 1 to break else to repeat: ");
                        r = console.nextInt();
                    }
                }
                z=0;
            }else if(z==12){            //searches for client ID
                //same as (z==3)
                int r=0;
                while(r!=1){
                    System.out.print("Name of the Client you want to get his ID: ");
                    String c=console.next();
                    for (int i = 0; i < garage.clients.size(); i++) {
                        if(c.equalsIgnoreCase(garage.clients.get(i).getName())){
                            System.out.println(garage.clients.get(i).getID());
                            r=1;
                        }
                    }
                    if(r!=1){
                        System.out.print("Cannot find! press 1 to break else to repeat: ");
                        r = console.nextInt();
                    }
                }
                z=0;
            }else if(z==13){  //returns garage data    
                System.out.println(garage);
                z=0;
            }  
        }    
    }
    //generates a random ID and returns it
    public static String idGenerator(String a,int counter){   
    //String a is for the starting of the ID for example: #E or #C, and counter is the object created counter
        int temp =counter;
        int count=0;
        while(temp!=0){     //loop to check how many digit
            temp/=10;
            count++;
        }
        //ID format after knowing how many digit
        if(count==1){
            return (a+"00"+counter);
        }
        else if(count==2){
            return (a+"0"+counter);
        }
        else{
            return (a+counter);
        }
    }   
    
//    public Object loop(String name,int size,ArrayList<Person> empOrCli){
//        Scanner console = new Scanner (System.in);
//        int r=0;
//        while(r!=1){
//            System.out.print("Name of the Client you want to get his ID: ");
//            String c=console.next();
//            for (int i = 0; i < size; i++) {
//                if(c.equalsIgnoreCase(empOrCli.get(i).getID())){
//                    return empOrCli.get(i);
//                }
//            }
//            if(r!=1){
//                System.out.print("Cannot find! press 1 to break else to repeat: ");
//                r = console.nextInt();
//            }
//        }
//        return null;
//    }
}

