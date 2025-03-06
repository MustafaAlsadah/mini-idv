package com.miniidv.miniidv.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.miniidv.miniidv.enums.UserStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    private String firstName;
    private String lastName;
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Document> documents;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.status = UserStatus.REGISTERED;
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

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documentsUrls) {
        this.documents = documentsUrls;
    }

    public void addDocument(Document doc){
        this.documents.add(doc);
    }
}

