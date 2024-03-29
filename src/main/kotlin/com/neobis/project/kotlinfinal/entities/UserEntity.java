package com.neobis.project.kotlinfinal.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user", schema = "shop", catalog = "")
public class UserEntity {
    private int userId;
    private String userName;
    private String password;
    private Timestamp registerDate;
    private String role;

    public UserEntity() {
    }

    public UserEntity(String userName, String password, Timestamp registerDate, String role) {
        this.userName = userName;
        this.password = password;
        this.registerDate = registerDate;
        this.role = role;
    }

    public UserEntity(int userId, String userName, String password, Timestamp registerDate, String role) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.registerDate = registerDate;
        this.role = role;
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "register_date")
    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (!userName.equals(that.userName)) return false;
        if (!password.equals(that.password)) return false;
        if (!registerDate.equals(that.registerDate)) return false;
        return role.equals(that.role);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + userName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + registerDate.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
