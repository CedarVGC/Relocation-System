package com.example.test.service;
import com.example.test.pojo.Companycompensation;
import com.example.test.dao.CompanycompensationDAO;
import com.example.test.pojo.Peoplecompensation;
import com.example.test.util.UpdateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanycompensationService {
    @Autowired
    CompanycompensationDAO companycompensationDAO;
    public List<Companycompensation> list()
    {
        return companycompensationDAO.findAll(Sort.by("id"));
    }
    public boolean isExist(int id)
    {
        Companycompensation p=companycompensationDAO.findById(id);
        return null!=p;
    }
    public int findMainIdById(int id)
    {
        Companycompensation c=companycompensationDAO.findById(id);
        return c!=null?c.getMainid():0;
    }
    public void add(Companycompensation companycompensation)
    {
        companycompensationDAO.relocaton();
        Companycompensation p=companycompensationDAO.save(companycompensation);
        if(p.getId()!=companycompensation.getId())
        {
            companycompensationDAO.update(p.getId(),companycompensation.getId());
        }
    }
    @Transactional
    public void update(Companycompensation companycompensation)throws Exception
    {
        Companycompensation c=companycompensationDAO.findById(companycompensation.getId());
        UpdateTool.copyZeroProperties(c,companycompensation);
        companycompensation.CulTotalmoney();
        companycompensationDAO.save(companycompensation);
    }
    public void delete(int id)
    {
        companycompensationDAO.deleteById(id);
    }
    public List<Companycompensation> CompanycompensationQuery(Companycompensation Param) {
        Specification<Companycompensation> specification=new Specification<Companycompensation>() {
            @Override
            public Predicate toPredicate(Root<Companycompensation> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if(Param.getId()!=0){
                    predicates.add(cb.equal(root.get("id").as(Integer.class),Param.getId()));
                }
                if(Param.getMainid()!=0){
                    predicates.add(cb.equal(root.get("mainid").as(Integer.class),Param.getMainid()));
                }
                Predicate[] pre = new Predicate[predicates.size()];
                return query.where(predicates.toArray(pre)).getRestriction();
            }
        };
        List<Companycompensation> list= companycompensationDAO.findAll(specification);
        System.out.println("查询返回的结果为"+list);
        return list;
    }
}
