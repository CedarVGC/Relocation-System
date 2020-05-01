package com.example.test.dao;
import com.example.test.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee,Integer> {
   List<Employee> findAllByDepnumber(int depnumber);
    Employee findByNumber(int number);
    Employee findByUsername(String username);
    Employee findByUsernameAndPassword(String username,String Password);
    @Transactional
    void deleteByNumber(int e_number);
    @Transactional
    @Modifying
    @Query( value ="ALTER TABLE `employee` AUTO_INCREMENT =1",nativeQuery = true)
    void relocaton();
    @Transactional
    @Modifying
    @Query("update Employee e set e.number=?1 where  e.number=?2")
    int  update(int s1,int s2);
}
