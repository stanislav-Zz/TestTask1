package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "users312")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;
    @Column(name = "age")
    @Min(value = 0, message = "Age cannot be less than zero")
    private int age;
    @Column(name = "name")
    @Pattern(regexp = "[A-zА-я]+", message = "Invalid surname")
    private String name;
    @Column(name = "last_name")
    @Pattern(regexp = "[A-zА-я]+", message = "Invalid surname")
    private String lastname;

    public User(){
    }

    public User(int id, int age, String name, String lastname) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.lastname = lastname;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //




}
