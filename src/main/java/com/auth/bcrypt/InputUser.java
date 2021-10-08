package com.auth.bcrypt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InputUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String password;

    public InputUser()
    {

    }

    public InputUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
