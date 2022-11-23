package com.abc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Dtls")
public class UserDtls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int udId;
    @NotNull
    @Size(min = 2, message = "User First Name must be at least min 2 character")
    private String firstName;
    @Pattern(regexp = "[A-Za-z]*",message = "Last name should not contain space and special character")
    private String lastName;
    private String address;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usercd")
    private UserCredentials userCredentials;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "udId")
    private List<UserContact> userContacts;


}

