package com.example.test.service;
import com.example.test.pojo.Company;
import com.example.test.dao.CompanyDAO;
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
public class CompanyService {
    @Autowired
    CompanyDAO companyDAO;
    public List<Company> list() {
        return companyDAO.findAll(Sort.by("id"));
    }
    public boolean isExist(int id) {
       Company company=companyDAO.findById(id);
        return null!=company;
    }
    public boolean isVerify(int id)
    {
        Company c=companyDAO.findById(id);
        return 0!=c.getVerify();
    }
    public void add(Company company)
    {
        companyDAO.relocaton();
        Company c=companyDAO.save(company);
        if(c.getId()!=company.getId())
        {
            companyDAO.update(c.getId(),company.getId());
        }
    }
    @Transactional
    public void update(Company company)throws Exception
    {
        Company c=companyDAO.findById(company.getId());
        UpdateTool.copyNullProperties(c,company);
        companyDAO.save(company);
    }
    public void delete(int id)
    {
        companyDAO.deleteById(id);
    }
    public void updateVerify(int id,int v)
    {
        companyDAO.updateVerifyById(id,v);
    }
    public List<Company> CompanyQuery(Company Param) {
        Specification<Company> specification=new Specification<Company>() {
            @Override
            public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if(Param.getName()!=null){
                    System.out.println(0);
                    predicates.add(cb.equal(root.get("name").as(String.class),Param.getName()));
                }
                if(Param.getAddress()!=null){
                    System.out.println(1);
                    predicates.add(cb.equal(root.get("address").as(String.class),Param.getAddress()));
                }
                if(Param.getMeasuredate()!=null){
                    System.out.println(2);
                    predicates.add(cb.equal(root.get("measuredate").as(Date.class),Param.getMeasuredate()));
                }
                Predicate[] pre = new Predicate[predicates.size()];
                return query.where(predicates.toArray(pre)).getRestriction();
            }
        };
        List<Company> list= companyDAO.findAll(specification);
        System.out.println("查询返回的结果为"+list);
        return list;
    }
}
