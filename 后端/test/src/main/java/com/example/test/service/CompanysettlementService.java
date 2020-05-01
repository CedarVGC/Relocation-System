package com.example.test.service;
import com.example.test.dao.CompanysettlementDAO;
import com.example.test.pojo.Companysettlement;
import com.example.test.pojo.Peoplesettlement;
import com.example.test.util.UpdateTool;
import org.elasticsearch.common.recycler.Recycler;
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
public class CompanysettlementService {
    @Autowired
    CompanysettlementDAO companysettlementDAO;
    public List<Companysettlement> list()
    {return companysettlementDAO.findAll(Sort.by("id"));}
    public boolean isExist(int id)
    {
        Companysettlement c=companysettlementDAO.findById(id);
        return null!=c;
    }
    public int findMainIdById(int id)
    {
        Companysettlement p=companysettlementDAO.findById(id);
        return p!=null?p.getMainid():0;
    }
    public void add(Companysettlement companysettlement)
    {
        companysettlementDAO.relocaton();
       Companysettlement p= companysettlementDAO.save(companysettlement);
        if(p.getId()!=companysettlement.getId())
        {
            companysettlementDAO.update(p.getId(),companysettlement.getId());
        }
    }
    @Transactional
    public void update(Companysettlement companysettlement)throws Exception
    {
        Companysettlement p=companysettlementDAO.findById(companysettlement.getId());
        UpdateTool.copyZeroProperties(p,companysettlement);
        companysettlement.culHouseprice();
        companysettlement.culAllprice1();
        companysettlement.culPriceadd();
        companysettlement.culPricedivided();
        companysettlement.culPricecash();
        companysettlement.culPriceover();
        companysettlement.culAllprice2();
        companysettlement.culSettlementprice1();
        companysettlement.culSettlementprice2();
        companysettlementDAO.save(companysettlement);
    }
    public void delete(int id)
    {
        companysettlementDAO.deleteById(id);
    }
    public List<Companysettlement> CompanysettlementQuery(Companysettlement Param) {
        Specification<Companysettlement> specification=new Specification<Companysettlement>() {
            @Override
            public Predicate toPredicate(Root<Companysettlement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if(Param.getId()!=0){
                    predicates.add(cb.equal(root.get("id").as(Integer.class),Param.getId()));
                }
                if(Param.getMainid()!=0){
                    predicates.add(cb.equal(root.get("mainid").as(Integer.class),Param.getMainid()));
                }
                if(Param.getName()!=null){
                    predicates.add(cb.equal(root.get("name").as(Date.class),Param.getName()));
                }
                Predicate[] pre = new Predicate[predicates.size()];
                return query.where(predicates.toArray(pre)).getRestriction();
            }
        };
        List<Companysettlement> list= companysettlementDAO.findAll(specification);
        System.out.println("查询返回的结果为"+list);
        return list;
    }
}
