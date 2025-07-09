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
    private Long log_id;

    private Integer user_id;
    
    private String action;
    
    private String description;
    
    private String ip_address;
    
    private String user_agent;

    private LocalDateTime created_at;

}
