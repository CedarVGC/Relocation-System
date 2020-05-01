package com.example.test.dao;
import com.example.test.pojo.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
public interface DepartmentsDAO extends JpaRepository<Departments,Integer> {
    Departments findByNumber(int dep_number);
    @Transactional
    void deleteByNumber(int dep_number);
    @Transactional
    @Modifying
    @Query( value ="ALTER TABLE `departments` AUTO_INCREMENT =1",nativeQuery = true)
    void relocaton();
    @Transactional
    @Modifying
    @Query("update Departments e set e.number=?1 where  e.number=?2")
    int  update(int s1,int s2);
}
