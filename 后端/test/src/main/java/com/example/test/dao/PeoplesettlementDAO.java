package com.example.test.dao;
import com.example.test.pojo.Peoplesettlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
public interface PeoplesettlementDAO extends JpaRepository<Peoplesettlement,Integer>, JpaSpecificationExecutor<Peoplesettlement> {
    Peoplesettlement findById(int id);
    @Transactional
    void deleteById(int id);
    @Transactional
    @Modifying
    @Query( value ="ALTER TABLE `peoplesettlement` AUTO_INCREMENT =1",nativeQuery = true)
    void relocaton();
    @Transactional
    @Modifying
    @Query("update Peoplesettlement e set e.id=?1 where  e.id=?2")
    int  update(int s1,int s2);
}
