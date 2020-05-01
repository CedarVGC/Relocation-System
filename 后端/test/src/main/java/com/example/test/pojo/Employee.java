package com.example.test.pojo;
 import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 import lombok.Data;
 import javax.persistence.*;
 import java.sql.*;
@Entity
@Table(name = "employee")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "e_number")
    private int number;
    @Column(name = "e_name")
    private String username;
    private String e_email;
    @Column(name = "dep_number")
    private int depnumber;
    private int e_gender;
    private String e_phone;
    private Date e_birthday;
    private String e_remark;
    private String e_job;
    private String password="123456";
}
