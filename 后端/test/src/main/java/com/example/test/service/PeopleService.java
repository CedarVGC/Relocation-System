package com.example.test.service;
import com.example.test.pojo.People;
import com.example.test.dao.PeopleDAO;
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
public class PeopleService {
    @Autowired
    PeopleDAO peopleDAO;
    public List<People> list() {
        return peopleDAO.findAll(Sort.by("id"));
    }
    public boolean isExist(int id) {
        People people=peopleDAO.findById(id);
        return null!=people;
    }
    public boolean isVerify(int id) {
        People people=peopleDAO.findById(id);
        return 0!=people.getVerify();
    }
    public void add(People people)
    { peopleDAO.relocaton();
       People p= peopleDAO.save(people);
       if(p.getId()!=people.getId())
       {
           peopleDAO.update(p.getId(),people.getId());
       }
    }
    @Transactional
    public void update(People people)throws Exception
    {
        People p=peopleDAO.findById(people.getId());
        UpdateTool.copyNullProperties(p,people);
        peopleDAO.save(people);
    }
    public void delete(int id)
    {
        peopleDAO.deleteById(id);
    }
    public void updateVerify(int id,int v)
    {
        peopleDAO.updateVerifyById(id,v);
    }
    public List<People> PeopleQuery(People Param) {
        Specification<People> specification=new Specification<People>() {
            @Override
            public Predicate toPredicate(Root<People> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if(Param.getName()!=null){
                    predicates.add(cb.equal(root.get("name").as(String.class),Param.getName()));
                }
                if(Param.getAddress()!=null){
                    predicates.add(cb.equal(root.get("address").as(String.class),Param.getAddress()));
                }
                if(Param.getRegisterdate()!=null){
                    predicates.add(cb.equal(root.get("registerdate").as(Date.class),Param.getRegisterdate()));
                }
                Predicate[] pre = new Predicate[predicates.size()];
                return query.where(predicates.toArray(pre)).getRestriction();
            }
        };
        List<People> list= peopleDAO.findAll(specification);
        System.out.println("查询返回的结果为"+list);
        return list;
    }
}
