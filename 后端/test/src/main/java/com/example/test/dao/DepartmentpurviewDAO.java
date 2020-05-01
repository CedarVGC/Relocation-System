package com.example.test.dao;
import com.example.test.pojo.Departmentpurview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DepartmentpurviewDAO extends JpaRepository<Departmentpurview,Integer> {
    List<Departmentpurview> findAllByNumber(int number);
    Departmentpurview findByNumberAndDpid(int number,int dpid);
    @Transactional
    void deleteByNumberAndDpid(int number,int dpid);
    @Transactional
    @Modifying
    @Query( value ="ALTER TABLE `departmentpurview` AUTO_INCREMENT =1",nativeQuery = true)
    void relocaton();
}
