package com.example.erp.Users.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String user_id;

    private String username;

    private String email;

    private String password;

    private String first_name;

    private String last_name;

    private Integer department_id;

    private Integer role_id;

    private LocalDateTime hire_date;

    private Double salary;

    private boolean is_active;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    public User() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUserId() { return user_id; }
    public void setUserId(String user_id) { this.user_id = user_id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFname() { return first_name; }
    public void setFname(String first_name) { this.first_name = first_name; }

    public String getLname() { return last_name; }
    public void setLname(String last_name) { this.last_name = last_name; }

    public Integer getDepartmentId() { return department_id; }
    public void setDepartmentId(Integer department_id) { this.department_id = department_id; }

    public Integer getRoleId() { return role_id; }
    public void setRoleId(Integer role_id) { this.role_id = role_id; }

    public LocalDateTime getHireDate() { return hire_date; }
    public void setHireDate(LocalDateTime hire_date) { this.hire_date = hire_date; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public boolean isIsActive() { return is_active; }
    public void setIsActive(boolean is_active) { this.is_active = is_active; }

    public LocalDateTime getCreatedAt() { return created_at; }
    public void setCreatedAt(LocalDateTime created_at) { this.created_at = created_at; }

    public LocalDateTime getUpdatedAt() { return updated_at; }
    public void setUpdatedAt(LocalDateTime updated_at) { this.updated_at = updated_at; }
}
