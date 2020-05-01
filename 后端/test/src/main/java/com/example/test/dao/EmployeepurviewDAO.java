package com.example.test.dao;
import com.example.test.pojo.Employeepurview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public interface EmployeepurviewDAO extends JpaRepository<Employeepurview,Integer> {
    List<Employeepurview> findAllByNumber(int number);
    Employeepurview findByNumberAndEpid(int id,int Epid);
    @Transactional
    void deleteByNumberAndEpid(int number,int epid);
    @Transactional
    @Modifying
    @Query( value ="ALTER TABLE `employeepurview` AUTO_INCREMENT =1",nativeQuery = true)
    void relocaton();
}
