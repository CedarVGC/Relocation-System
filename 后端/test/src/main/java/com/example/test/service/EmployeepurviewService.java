package com.example.test.service;
import com.example.test.dao.EmployeepurviewDAO;
import com.example.test.pojo.Employeepurview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeepurviewService {
    @Autowired
    EmployeepurviewDAO employeepurviewDAO;
    public List<Employeepurview> list()
    {
        return employeepurviewDAO.findAll();
    }
    public List<Employeepurview> FindByNumberList(int id)
    {
        return employeepurviewDAO.findAllByNumber(id);
    }
    public Employeepurview FindByNumberAndEpid(int id,int Epid)
    {
        return employeepurviewDAO.findByNumberAndEpid(id,Epid);
    }
    public void deleteByNumberAndEpid(int number,int epid)
    {
       employeepurviewDAO.deleteByNumberAndEpid(number,epid);
       employeepurviewDAO.relocaton();
    }
    public void Update(Employeepurview employeepurview)
    {
        employeepurviewDAO.relocaton();
        employeepurviewDAO.save(employeepurview);
    }

}
