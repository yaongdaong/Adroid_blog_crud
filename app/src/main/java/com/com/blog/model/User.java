package com.com.blog.model;

/*{
        "id": 2,
        "username": "cos",
        "password": "1234",
        "email": "cos@nate.com",
        "created": "2021-26-11T09:26:05",
        "updated": "2021-26-11T09:26:05"
},*/

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String created;
    private String updated;

    public Timestamp getCreated(){
        return Timestamp.valueOf(this.created);
    }

    public Timestamp getUpdated(){
        return Timestamp.valueOf(this.updated);
    }
}
