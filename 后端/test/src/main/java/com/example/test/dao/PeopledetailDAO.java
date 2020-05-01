package com.example.test.dao;
import com.example.test.pojo.Peopledetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
public interface PeopledetailDAO extends JpaRepository<Peopledetail,Integer> , JpaSpecificationExecutor<Peopledetail> {
    Peopledetail findById(int id);
    @Transactional
    void deleteById(int id);
    @Transactional
    @Modifying
    @Query("update Peopledetail e set e.verify=?2 where  e.id=?1")
    void updateVerifyById(int id,int verify);
    @Transactional
    @Modifying
    @Query( value ="ALTER TABLE `peopledetail` AUTO_INCREMENT =1",nativeQuery = true)
    void relocaton();
    @Transactional
    @Modifying
    @Query("update Peopledetail e set e.id=?1 where  e.id=?2")
    int  update(int s1,int s2);
}
