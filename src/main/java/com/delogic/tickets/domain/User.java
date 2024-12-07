package com.delogic.tickets.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String email;
    private String phone;
    private Boolean sports;
    private Boolean theatre;
    private Boolean concerts;
    private Boolean jazz;
    private Boolean classical;
    private Boolean opera;
    private Boolean rock;
    private Boolean vegas;
    private Boolean broadway;
    private Boolean musicals;
}
