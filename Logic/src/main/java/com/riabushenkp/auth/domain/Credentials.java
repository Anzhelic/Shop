package com.riabushenkp.auth.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Credentials {
    @Id
    private String email;
    private String password;


    @OneToOne(mappedBy = "credentials")
    private Client client;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client user) {
        this.client = client;
    }
}
