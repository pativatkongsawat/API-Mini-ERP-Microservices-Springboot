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

    public String getAction(){return action;}
    public void setAction(String action){this.action = action;}


    public String getDescription(){return description;}
    public void setDescription(String description ){this.description = description;}

    public String getIpAddress(){return ip_address;}
    public void setIpAddress(String ip_address){this.ip_address = ip_address;}

    public String getUserAgent(){return user_agent;}
    public void setUserAgent(String user_agent){this.user_agent = user_agent;}

    public LocalDateTime getCreateAt(){return created_at;}
    public void setCreateAt(LocalDateTime created_at){this.created_at = created_at;}

}
