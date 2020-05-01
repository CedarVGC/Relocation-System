package com.example.test.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
@Entity
@Table(name = "employeepurview")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
public class Employeepurview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ep_popedom")
    private int epid;
    @Column(name = "ep_number")
    private int number;
    @Column(name = "ep_remark")
    private String remark;
}
