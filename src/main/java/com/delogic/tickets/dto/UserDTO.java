package com.delogic.tickets.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
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