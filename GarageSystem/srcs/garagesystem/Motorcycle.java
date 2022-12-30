package garagesystem;


public class Motorcycle extends Vehicle{
    String motorcycleModel;
    
    //no-Args constructor
    Motorcycle(){
        this("ABC-123","Red",300,"Halawa");
    }
    //constructor that accepts plate
    Motorcycle(String plate, String color, int weight, String motorcycleModel){
        this.motorcycleModel = motorcycleModel;
        this.licensePlate= plate;
        this.color=color;
        this.weight=weight;
    }
    //setter
    void setMotorcycleModel(String motorcycleModel){
        this.motorcycleModel = motorcycleModel;
    }
    //getter
    String getMotorcycleModel(){
        return motorcycleModel;
    }
    //returns motorcycle data
    public String toString(){
        return motorcycleModel;
    }
}