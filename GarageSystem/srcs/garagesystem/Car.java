package garagesystem;

public class Car extends Vehicle{
    String carModel;
    
    //no-Args constructor
    Car(){
        this("ABC-123","black",1300,"Kasrawy");
    }
    //constructor that accepts license plate, color, weight and car model
    Car(String plate, String color, int weight, String carModel){
        this.licensePlate=plate;
        this.color=color;
        this.weight=weight;
        this.carModel = carModel;
    }
    //setter
    void setCarModel(String carModel){
        this.carModel = carModel;
    }
    //getter
    String getCarModel(){
        return carModel;
    }
    //returns car data
    public String toString(){
        return carModel;
    }
}
