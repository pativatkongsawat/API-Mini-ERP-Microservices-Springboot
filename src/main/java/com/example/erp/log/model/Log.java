package com.example.erp.log.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer log_id;

    private Integer user_id;
    
    private String action;
    
    private String description;
    
    private String ip_address;
    
    private String user_agent;

    private LocalDateTime created_at;

    public Log(){}

    public Integer getLogID(){return log_id;}
    public void setLogID(Integer log_id){this.log_id = log_id;}

    public Integer getUserID(){return user_id;}
    public void setUserID(Integer user_id){this.user_id = user_id;}

}
