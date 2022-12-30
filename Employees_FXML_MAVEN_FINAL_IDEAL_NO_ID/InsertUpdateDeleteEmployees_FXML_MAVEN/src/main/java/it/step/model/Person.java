package it.step.model;

import java.time.LocalDate;

public class Person {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthdate;
//    private String birthdate1;
//
//    public String getBirthdate1() {
//        return birthdate1;
//    }

//    public Person(int id, String name, String surname, String email, String birthdate1) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.email = email;
//        this.birthdate1 = birthdate1;
//    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String Name){
        this.name = Name;
    }

    public void setSurname(String Surname){
        this.surname = Surname;
    }

    public void setEmail(String Email){
        this.email = Email;
    }

    public void setBirthdate(LocalDate Birthdate){
        this.birthdate = Birthdate;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getEmail(){
        return this.email;
    }

    public LocalDate getBirthdate(){
        return this.birthdate;
    }

    public Person(String name, String surname, String email, LocalDate birthdate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "\n"+name + " " + surname + " " + ", id ="+id;
    }

    public Person(Integer id, String name, String surname, String email, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
    }
}
