package com.example.erp.Users.dto;



public class CreateUser {
    
    private String user_id;

    private String username;

    private String email;

    private String password;

    private String first_name;

    private String last_name;

    private Integer department_id;

    private Integer role_id;

    private Double salary;

    public CreateUser(){}

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

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
