package com.example.API_Rest.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MsgRepo {
    public String getMsg() {
        return "From Repo!";
    }
}
