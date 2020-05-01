package com.example.test.dao;
import com.example.test.pojo.Allpurview;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AllpurviewDAO extends JpaRepository<Allpurview,Integer> {
    Allpurview findById(int id);
}
