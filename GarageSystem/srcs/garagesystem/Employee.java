package garagesystem;

import static garagesystem.GarageSystem.*;

public class Employee extends Person{
    private double salary;
    static private int employeeCounter=0;
    
    //Constructor accepts name,phoneNum,emailAddress
    Employee(String name,String phoneNum,String emailAdress){           
        employeeCounter++;
        id = idGenerator("#E",employeeCounter);                      //used the method idGenerator in main to get unique ID
        this.name=name;
        this.phoneNum=phoneNum;
        this.emailAddress=emailAdress;
    }
    //no-Args Constructor
    Employee(){    
        this("Employee"+employeeCounter,"000-111-222","employee"+employeeCounter+"@emp.com");  
    }
    
    //setter
    void setSalary(double salary){
        this.salary=salary;
    }
    //getter
    double getSalary(){
        return salary;
    }
    //returns universal object employee created
    static int getEmployeeCounter(){ 
        return employeeCounter;
    }
    //returns employee ID
    String getID(){ 
        return id;                                  
    }
    //returns Employee data
    public String toString(){     
        return "Name:"+name+"\nPhoneNumber:"+phoneNum+"\nEmailAddress:"+emailAddress+"\nID:"+id+"\nSalary:"+salary+"$"+"\n";
    }
}
