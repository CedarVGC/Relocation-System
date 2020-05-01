package com.example.test.service;
import com.example.test.pojo.Peoplecompensation;
import com.example.test.dao.PeoplecompensationDAO;
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
public class PeoplecompensationService {
    @Autowired
    PeoplecompensationDAO peoplecompensationDAO;
    public List<Peoplecompensation> list()
    {
        return peoplecompensationDAO.findAll(Sort.by("id"));
    }
    public boolean isExist(int id)
    {
        Peoplecompensation p=peoplecompensationDAO.findById(id);
        return null!=p;
    }
    public int findMainIdById(int id)
    {
        Peoplecompensation p=peoplecompensationDAO.findById(id);
        return p!=null?p.getMainid():0;
    }
    public void add(Peoplecompensation peoplecompensation)
    {
        peoplecompensationDAO.relocaton();
        Peoplecompensation p=peoplecompensationDAO.save(peoplecompensation);
        if(p.getId()!=peoplecompensation.getId())
        {
            peoplecompensationDAO.update(p.getId(),peoplecompensation.getId());
        }
    }
    @Transactional
    public void update(Peoplecompensation peoplecompensation)throws Exception
    {
        Peoplecompensation p=peoplecompensationDAO.findById(peoplecompensation.getId());
        UpdateTool.copyZeroProperties(p,peoplecompensation);
        peoplecompensation.CulTotalmoney();
        System.out.println(peoplecompensation);
        peoplecompensationDAO.save(peoplecompensation);
    }
    public void delete(int id)
    {
        peoplecompensationDAO.deleteById(id);
    }
    public List<Peoplecompensation> PeoplecompensationQuery(Peoplecompensation Param) {
        Specification<Peoplecompensation> specification=new Specification<Peoplecompensation>() {
            @Override
            public Predicate toPredicate(Root<Peoplecompensation> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if(Param.getId()!=0){
                    predicates.add(cb.equal(root.get("id").as(Integer.class),Param.getId()));
                }
                if(Param.getMainid()!=0){
                    predicates.add(cb.equal(root.get("mainid").as(Integer.class),Param.getMainid()));
                }
                if(Param.getMeasuredate()!=null){
                    predicates.add(cb.equal(root.get("measuredate").as(Date.class),Param.getMeasuredate()));
                }
                Predicate[] pre = new Predicate[predicates.size()];
                return query.where(predicates.toArray(pre)).getRestriction();
            }
        };
        List<Peoplecompensation> list= peoplecompensationDAO.findAll(specification);
        System.out.println("查询返回的结果为"+list);
        return list;
    }
}
