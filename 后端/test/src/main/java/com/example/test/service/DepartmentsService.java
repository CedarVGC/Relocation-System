package com.example.test.service;
import com.example.test.pojo.Departments;
import com.example.test.dao.DepartmentsDAO;
import com.example.test.util.UpdateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DepartmentsService {
    @Autowired
    DepartmentsDAO departmentsDAO;
    public List<Departments> list() {
        return departmentsDAO.findAll(Sort.by("number"));
    }
    public boolean isExist(int dep_number) {
       Departments departments=departmentsDAO.findByNumber(dep_number);
        return null!=departments;
    }
    public void add(Departments departments)
    {
        departmentsDAO.relocaton();
        Departments d=departmentsDAO.save(departments);
        if(d.getNumber()!=departments.getNumber())
        {
            departmentsDAO.update(d.getNumber(),departments.getNumber());
        }
    }
    public void delete(int dep_number)
    {
        departmentsDAO.deleteByNumber(dep_number);
    }
    @Transactional
    public void update(Departments departments)throws Exception
    {
        Departments d=departmentsDAO.findByNumber(departments.getNumber());
        UpdateTool.copyNullProperties(d,departments);
        departmentsDAO.save(departments);
    }
}
