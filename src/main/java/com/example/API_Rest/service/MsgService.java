package com.example.API_Rest.service;

import com.example.API_Rest.repository.MsgRepo;
import org.springframework.stereotype.Service;

@Service
public class MsgService {
    private final MsgRepo msgRepo;

    public MsgService(MsgRepo msgRepo) {
        this.msgRepo = msgRepo;
    }

    public String getMsg() {
        return msgRepo.getMsg();
    }
}
