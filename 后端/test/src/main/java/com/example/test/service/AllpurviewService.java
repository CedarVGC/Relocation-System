package com.example.test.service;

import com.example.test.dao.AllpurviewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AllpurviewService {
    @Autowired
    AllpurviewDAO allpurviewDAO;
    public int AllSize()
    {
        return allpurviewDAO.findAll().size();
    }
    public String IdtoName(int id)
    {
        return allpurviewDAO.findById(id).getName();
    }
}
