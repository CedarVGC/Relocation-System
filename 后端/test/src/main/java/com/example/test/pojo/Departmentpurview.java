package com.example.test.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
@Entity
@Table(name = "departmentpurview ")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
public class Departmentpurview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "dp_popedom")
    private int dpid;
    @Column(name = "dp_number")
    private int number;
    @Column(name = "dp_remark")
    private String remark;
}
