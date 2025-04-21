package src.models;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String phone;
    private String email;
    private int experience;

    public Doctor(){
        this.id =404;
        this.name = "404";
        this.specialization = "404";
        this.phone = "404";
        this.email="404";
        this.experience=404;
    }
    public Doctor( String name, String specialization, String phone, String email, int experience){
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.email = email;
        this.experience = experience;
    }

    //Setters for the Doctor
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    //Getters for the Doctor
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getExperience() {
        return experience;
    }
}