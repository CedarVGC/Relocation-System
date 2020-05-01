package com.example.test.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.sql.*;
@Entity
@Table(name = "people")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private Date registerdate;
    private String remark;
    private String autograph;
    private String head;
    private String agent;
    private Date writedate;
    private String preparer;
    private int verify;
}
