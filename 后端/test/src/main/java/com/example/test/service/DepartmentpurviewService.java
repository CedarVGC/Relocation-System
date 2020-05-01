package com.example.test.service;
import com.example.test.dao.DepartmentpurviewDAO;
import com.example.test.pojo.Departmentpurview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DepartmentpurviewService {
    @Autowired
    DepartmentpurviewDAO departmentpurviewDAO;
    public List<Departmentpurview> list()
    {
        return departmentpurviewDAO.findAll();
    }
    public List<Departmentpurview> FindByNumberList(int number)
    {
        return departmentpurviewDAO.findAllByNumber(number);
    }
    public Departmentpurview FindByNumberAndDpid(int number,int dpid)
    {
        return departmentpurviewDAO.findByNumberAndDpid(number,dpid);
    }
    public void deleteByNumberAndDpid(int number,int dpid)
    {
        departmentpurviewDAO.deleteByNumberAndDpid(number,dpid);
    }
    public void Update(Departmentpurview departmentpurview)
    {
        departmentpurviewDAO.relocaton();
       departmentpurviewDAO.save(departmentpurview);
    }
}
