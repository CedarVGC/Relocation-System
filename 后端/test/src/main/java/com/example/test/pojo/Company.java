package com.example.test.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "company")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private Date measuredate;
   private String name;
   private String address;
   private String project;
   private String recorder;
   private String measurer;
   private String autograph;
   private String dautograph;
   private Date writedate;
   private String writer;
   private int verify;
}
