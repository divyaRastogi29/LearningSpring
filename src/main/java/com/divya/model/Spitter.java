package com.divya.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by divya on 5/10/16.
 */
@Entity
@Table(name="spitter")
@org.hibernate.annotations.Entity(dynamicInsert = true)
public class Spitter{

    @Id
    @Column(name = "id" , unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "username" , nullable = true)
    @Type(type = "text")
    private String userName ;

    @Column(name = "password" , nullable = true)
    @Type(type = "text")
    private String password ;

    @Column(name = "firstName" , nullable = true)
    @Type(type = "text")
    private String firstName ;

    @Column(name = "lastName" , nullable = true)
    @Type(type = "text")
    private String lastName ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "\n id : "+id+" userName : "+userName+" password : "+password+" firstName : "+firstName+" lastName : "+lastName;
    }
}
