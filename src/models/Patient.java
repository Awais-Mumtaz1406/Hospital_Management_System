package src.models;

public class Patient{
    private int id;
    private String name;
    private int age;
    private String gender;
    private String phone;

    public Patient(){
        this.id = 404;
        this.name = "404";
        this.age = 404;
        this.gender = "404";
        this.phone = "404";
    }
    public Patient(String name,int age,String gender,String phone){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    //Setters for the Patient
    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setAge(int age){this.age=age;}
    public void setGender(String gender){this.gender=gender;}
    public void setPhone(String phone){this.phone=phone;}

    //Getters for the Patient
    public int getId() {return id;}
    public String getName() {return name;}
    public int getAge() {return age;}
    public String getGender() {return gender;}
    public String getPhone(){return phone;}
}