package com.example.test.service;
import com.example.test.dao.PeoplesettlementDAO;
import com.example.test.pojo.Peoplesettlement;
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
public class PeoplesettlementService {
    @Autowired
    PeoplesettlementDAO peoplesettlementDAO;
    public List<Peoplesettlement> list() {
        return peoplesettlementDAO.findAll(Sort.by("id"));
    }
    public boolean isExist(int id)
    {
        Peoplesettlement p=peoplesettlementDAO.findById(id);
        return null!=p;
    }
    public int findMainIdById(int id)
    {
        Peoplesettlement p=peoplesettlementDAO.findById(id);
        return p!=null?p.getMainid():0;
    }
    public void add(Peoplesettlement peoplesettlement)
    {
        peoplesettlementDAO.relocaton();
        Peoplesettlement p=peoplesettlementDAO.save(peoplesettlement);
        if(p.getId()!=peoplesettlement.getId())
        {
            peoplesettlementDAO.update(p.getId(),peoplesettlement.getId());
        }
    }
    @Transactional
    public void update(Peoplesettlement peoplesettlement)throws Exception
    {
        Peoplesettlement p=peoplesettlementDAO.findById(peoplesettlement.getId());
        UpdateTool.copyZeroProperties(p,peoplesettlement);
        peoplesettlement.culHouseprice();
        peoplesettlement.culAllprice1();
        peoplesettlement.culPriceadd();
        peoplesettlement.culPricedivided();
        peoplesettlement.culPricecash();
        peoplesettlement.culPriceover();
        peoplesettlement.culAllprice2();
        peoplesettlement.culSettlementprice1();
        peoplesettlement.culSettlementprice2();
        peoplesettlementDAO.save(peoplesettlement);
    }
    public void delete(int id)
    {
        peoplesettlementDAO.deleteById(id);
    }
    public List<Peoplesettlement> PeoplesettlementQuery(Peoplesettlement Param) {
        Specification<Peoplesettlement> specification=new Specification<Peoplesettlement>() {
            @Override
            public Predicate toPredicate(Root<Peoplesettlement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
        List<Peoplesettlement> list= peoplesettlementDAO.findAll(specification);
        System.out.println("查询返回的结果为"+list);
        return list;
    }
}
