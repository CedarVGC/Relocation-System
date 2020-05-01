package com.example.test.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "peopledetail")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
public class Peopledetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mainid;
    private String name;
    private String relationship;
    private int gender;
    private int onlychild;
    private Date birthday;
    private String residencefrom;
    private String residenceid;
    private Date residencedate;
    private String marryfrom;
    private String marryid;
    private Date marrydate;
    private String remark;
    private int verify;
}
