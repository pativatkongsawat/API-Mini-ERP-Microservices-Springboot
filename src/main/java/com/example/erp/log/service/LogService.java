package com.example.erp.Log.service;

import java.time.LocalDateTime;

import com.example.erp.Log.model.Log;
import com.example.erp.Log.repository.LogRepository;

public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository){
        this.logRepository = logRepository;
    }
    

    public Log CreateLog(Log data){
        
        LocalDateTime now = LocalDateTime.now();

        Log log = new Log();

        log.setUserID(data.getUserID());
        log.setAction(data.getAction());
        log.setDescription(data.getDescription());
        log.setIpAddress(data.getIpAddress());
        log.setUserAgent(data.getUserAgent());
        

        log.setCreateAt(now);

        return logRepository.save(log);
    }
    
}
