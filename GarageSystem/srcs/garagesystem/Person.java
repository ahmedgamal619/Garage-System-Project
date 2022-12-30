package garagesystem;



public class Person{
   protected String name;
   protected String emailAddress;
   protected String phoneNum;
   protected String id;
   
   //no-Args Constructor for default values
   Person(){                                     
       name="unknown";
       emailAddress="unknown@abc.com";
       phoneNum="000-111-222";
   }
   //setter
   void setName(String name){                     
       this.name=name;
   }
   void setPhoneNum(String phoneNum){
       this.phoneNum=phoneNum;
   }
   void setEmailAddress(String emailAdress){
       this.emailAddress=emailAdress;
   }
    //getter
   String getID(){
       return id;
   }
   String getName(){                             
       return name;
   }
   String getPhoneNum(){
       return phoneNum;
   }
   String getEmailAddress(){
       return emailAddress;
   }
   //returns the person data
   public String toString(){  
       return "Name:"+name+"\nPhoneNumber:"+phoneNum+"\nEmailAddress:"+emailAddress+"\n";
   }
}
