package com.training.platform.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.training.validators.Extended;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Data
@Entity
@Table(name = "users")

@com.training.platform.validators.FieldsValueMatch(field = "password",
        fieldMatch = "confirm_password",
        message = "The password fields must match",
        groups={ Extended.class })
@EqualsAndHashCode(exclude="shop")
@ToString(exclude = {"shop"})

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name is a required field", groups={ com.training.platform.validators.Default.class })
    @Size(min=2,  message="Name should have atleast 2 characters", groups={ com.training.platform.validators.Default.class })
    @Size(max = 100,  message="Name should have not over 5 characters", groups={ com.training.platform.validators.Default.class })
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "Surname is a required field", groups={ com.training.platform.validators.Default.class })
    @Size(min=2,  message="Surname should have atleast 2 characters", groups={ com.training.platform.validators.Default.class })
    @Size(max = 100,  message="Surname should have not over 5 characters", groups={ com.training.platform.validators.Default.class })
    private String surname;

    @Column(name = "email")
    @NotEmpty(message = "Email is a required field", groups={ Extended.class })
    @Email(message = "Email is a email pattern", groups={ Extended.class })
    @com.training.platform.validators.UniqueEmail(message = "There is already user with this email!", groups={ Extended.class })
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "Password is a required field", groups={ Extended.class })
    private String password;


    @Transient
    @NotEmpty(message = "Confirm Password is a required field", groups={ Extended.class })
    private String confirm_password;

    @Column(name = "age")
    @Digits(integer=2, fraction=0, message = "Age is a only numeric and between 15 to 60 years old", groups={ com.training.platform.validators.Default.class })
    private Integer age;

    @Column(name = "address")
    @NotEmpty(message = "Address is a required field")
    private String address;

    @Column(name = "city")
    @NotEmpty(message = "City is a required field", groups={ com.training.platform.validators.Default.class })
    private String city;

    @Column(name = "mobile")
    @NotEmpty(message = "Mobile is a required field")
    private String mobile;

    @Column(name = "active")
    private Integer active;

    @Column(name = "api_token")
    private String api_token;

    @Column(name = "remember_token")
    private String rememberToken;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToOne(mappedBy = "user")
    private Shop shop;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;



}
