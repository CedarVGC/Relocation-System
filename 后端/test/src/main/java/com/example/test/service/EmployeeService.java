package com.example.test.service;
import com.example.test.pojo.Employee;
import com.example.test.dao.EmployeeDAO;
import com.example.test.util.UpdateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;
    public List<Employee> list() {
        return employeeDAO.findAll(Sort.by("number"));
    }
    public List<Employee> findAllByDepnumber(int depnumber){return employeeDAO.findAllByDepnumber(depnumber);}
    public boolean isExist(int e_number) {
        Employee employee=employeeDAO.findByNumber(e_number);
        return null!=employee;
    }
    public Employee findUser(String username,String password)
    {
        return employeeDAO.findByUsernameAndPassword(username,password);
    }
    public Employee findByUsername(String username)
    {
        return employeeDAO.findByUsername(username);
    }
    public int getDepNumberByNumber(int number)
    {
        Employee e=employeeDAO.findByNumber(number);
        return e!=null?e.getDepnumber():0;
    }
    public void add(Employee employee)
    {
        employeeDAO.relocaton();
        Employee e=employeeDAO.save(employee);
        if(employee.getNumber()!=e.getNumber())
        {
           employeeDAO.update(employee.getNumber(),e.getNumber());
        }
    }
    public void delete(int e_number)
    {
        employeeDAO.deleteByNumber(e_number);
    }
    @Transactional
    public void update (Employee employee) throws Exception
    {
        Employee e=employeeDAO.findByNumber(employee.getNumber());
        UpdateTool.copyNullProperties(e,employee);
        System.out.println(employee);
        employeeDAO.save(employee);
    }

}
