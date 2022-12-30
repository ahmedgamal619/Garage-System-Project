package garagesystem;


class  Vehicle {
    protected String licensePlate;
    protected String color;
    protected int weight;

    //no-Args constructor for default values
    Vehicle (){                  
        licensePlate = "ABC-123";
        color = "white";
        weight = 1300;
        }
    //setter
    void setLicensePlate(String licensePlate){      
        this.licensePlate = licensePlate;
    }
    void setColor (String color){
        this.color = color;
    }
    void setWeight (int weight){
        this.weight = weight;
    }
    //getter
    String getLicensePlate(){ 
        return licensePlate;
    }
    String getColor(){
        return color;
    }
    int getWeight(){
        return weight;
    }
    //returns vehicle data
    public String toString(){
          return "licensePlate:"+licensePlate+"\nColor:"+color+"\nWeight:"+weight;
    }
}
