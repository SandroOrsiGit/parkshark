package com.switchfully.parkshark.manager.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="MANAGER")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Manager() {
    }

    public Manager(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    

    // TODO - refactor

    public void setId(long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Manager manager = (Manager) o;
        return id == manager.id;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
