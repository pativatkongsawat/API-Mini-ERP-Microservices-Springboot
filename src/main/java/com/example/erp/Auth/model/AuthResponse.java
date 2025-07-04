package com.example.erp.Auth.model;

public class AuthResponse {

    private String status;

    private String token;

    private String user_id;

    private String emaill;

    private Integer role_id;

    private Integer department_id;

    private String first_name;

    private String last_name;

    public AuthResponse(){};

    public String getStatus(){return status;}
    public void setStatus(String status){this.status = status;}

    public String getToken(){return token;}
    public void setToken(String token){this.token = token;}

    public String getUserID(){return user_id;}
    public void setUserID(String user_id){this.user_id = user_id;}

    public String getEmail(){return emaill;}
    public void setEmail(String email){this.emaill = email;}

    public Integer getRoleID(){return role_id;}
    public void setRoleID(Integer role_id){this.role_id = role_id;}

    public Integer getDepartmentID(){return department_id;}
    public void setDepartmentId(Integer department_id){this.department_id =department_id;}

    public String getFirstName(){return first_name;}
    public void setFirstName(String first_name){this.first_name = first_name;}

    public String getLastName(){return last_name;}
    public void setLastName(String last_name){this.last_name = last_name;}
   

    

}
