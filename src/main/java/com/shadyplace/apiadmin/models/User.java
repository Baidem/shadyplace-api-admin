package com.shadyplace.apiadmin.models;

import com.shadyplace.apiadmin.models.enums.Country;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "User's email cannot be blank.")
    @Email(message = "User's email format is invalid.")
    private String email;
    @Column(name = "password", nullable = false)
    @NotBlank(message = "User's password cannot be blank.")
    private String password; // TODO REGEX PASSWORD

    @Column(length = 50, nullable = false)
    @Length(max = 50, message = "The user's first name must be no more than 50 characters long.")
    @NotBlank(message = "User's firstname cannot be blank.")
    private  String firstname;
    @Column(length = 50, nullable = false)
    @Length(max = 50, message = "The user's last name must be no more than 50 characters long.")
    @NotBlank(message = "User's lastname cannot be blank.")
    private String lastname;

    @Transient
//    @NotBlank(message = "User's password confirm cannot be blank")
    private String confirmPassword;

    @Column(name = "registration_date",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar registrationDate;

    @Column(name = "residence_country", length = 20)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "User's country cannot be null.")
    private Country residenceCountry;

    @ManyToOne()
//    @JoinColumn(name = "family_link_id", referencedColumnName = "id")
    @JoinColumn(name = "family_link_id", referencedColumnName = "id")
    private FamilyLink familyLink;

    @ManyToOne()
    @JoinColumn(name = "current_fidelity_rank_id", referencedColumnName = "id")
    @NotNull(message = "User's currentFidelityRank cannot be null.")
    private FidelityRank currentFidelityRank;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "utilisateur_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public User() {
        this.roles = new ArrayList<Role>();
    }

    public void addRole(Role role){
        this.roles.add(role);
    }

    public void removeRole(Role role){
        this.roles.remove(role);
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User(String lastname, String firstname, String email, String password, String confirmPassword, Country residenceCountry) {
        this();
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.residenceCountry = residenceCountry;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public FamilyLink getFamilyLink() {
        return familyLink;
    }

    public void setFamilyLink(FamilyLink familyLink) {
        this.familyLink = familyLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Country getResidenceCountry() {
        return residenceCountry;
    }

    public void setResidenceCountry(Country residenceCountry) {
        this.residenceCountry = residenceCountry;
    }

    public FidelityRank getCurrentFidelityRank() {
        return currentFidelityRank;
    }

    public void setCurrentFidelityRank(FidelityRank currentFidelityRank) {
        this.currentFidelityRank = currentFidelityRank;
    }
}
