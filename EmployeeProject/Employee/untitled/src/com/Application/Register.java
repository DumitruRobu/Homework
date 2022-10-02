package com.Application;

public class Register extends Employees{

    public Register (String name, String surname, String title)
    {
        this.name = name;
        this.surname = surname;
        this.title=title;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getName()
    {
       return this.name;
    }

    public String getSurname()
    {
        return this.surname;
    }

    public String getTitle()
    {
        return this.title;
    }
}
