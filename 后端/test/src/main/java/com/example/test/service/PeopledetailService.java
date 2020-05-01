package com.example.test.service;
import com.example.test.pojo.People;
import com.example.test.pojo.Peopledetail;
import com.example.test.dao.PeopledetailDAO;
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
public class PeopledetailService {
    @Autowired
    PeopledetailDAO peopledetailDAO;
    public List<Peopledetail> list() {
        return peopledetailDAO.findAll(Sort.by("id"));
    }
    public boolean isExist(int id) {
        Peopledetail peopledetail=peopledetailDAO.findById(id);
        return null!=peopledetail;
    }
    public boolean isVerify(int id) {
        Peopledetail p=peopledetailDAO.findById(id);
        return 0!=p.getVerify();
    }
    public void add(Peopledetail peopledetail)
    {
        peopledetailDAO.relocaton();
        Peopledetail p =peopledetailDAO.save(peopledetail);
        if(p.getId()!=peopledetail.getId())
        {
            peopledetailDAO.update(p.getId(),peopledetail.getId());
        }
    }
    @Transactional
    public void update(Peopledetail peopledetail)throws Exception
    {
        Peopledetail p=peopledetailDAO.findById(peopledetail.getId());
        UpdateTool.copyNullProperties(p,peopledetail);
        peopledetailDAO.save(peopledetail);
    }
    public void delete(int id)
    {
        peopledetailDAO.deleteById(id);
    }
    public void updateVerify(int id,int v)
    {
        peopledetailDAO.updateVerifyById(id,v);
    }
    public List<Peopledetail> PeopledetailQuery(Peopledetail Param) {
        Specification<Peopledetail> specification=new Specification<Peopledetail>() {
            @Override
            public Predicate toPredicate(Root<Peopledetail> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if(Param.getName()!=null){
                    predicates.add(cb.equal(root.get("name").as(String.class),Param.getName()));
                }
                if(Param.getResidenceid()!=null){
                    predicates.add(cb.equal(root.get("residenceid").as(String.class),Param.getResidenceid()));
                }
                if(Param.getBirthday()!=null){
                    predicates.add(cb.equal(root.get("birthday").as(Date.class),Param.getBirthday()));
                }
                Predicate[] pre = new Predicate[predicates.size()];
                return query.where(predicates.toArray(pre)).getRestriction();
            }
        };
        List<Peopledetail> list=peopledetailDAO.findAll(specification);
        System.out.println("查询返回的结果为"+list);
        return list;
    }
}
