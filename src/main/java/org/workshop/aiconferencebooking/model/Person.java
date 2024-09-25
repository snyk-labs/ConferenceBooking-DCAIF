package org.workshop.aiconferencebooking.model;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Person {

    @JsonView(JsonViews.Sparse.class)
    @Id
    @GeneratedValue
    private Long id;

    @JsonView(JsonViews.Sparse.class)
    private String username;

    @JsonView(JsonViews.Sparse.class)
    private String firstName;

    @JsonView(JsonViews.Sparse.class)
    private String lastName;

    @JsonView(JsonViews.Sparse.class)
    private String email;

    @Transient
    private String password;

    @Transient
    private String passwordConfirm;

    private String encryptedPassword;

    private String phone;

    private Boolean enable = true;


    private String address;

    private Role role = Role.ROLE_ATTENDEE;

    private String profilePic = "default-profile-picture.jpg";

    public Person() {
    }

    public Person(String username, String firstName, String lastName, String email, String phone, String address) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role roles) {
        this.role = roles;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", encryptedPassword='" + encryptedPassword + '\'' +
                ", phone='" + phone + '\'' +
                ", enable=" + enable +
                ", address='" + address + '\'' +
                ", roles=" + role +
                ", profilePic='" + profilePic + '\'' +
                '}';
    }
}