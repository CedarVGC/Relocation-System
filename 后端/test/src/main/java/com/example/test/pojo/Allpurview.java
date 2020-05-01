package com.example.test.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
@Entity
@Table(name = " allpurview ")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
public class Allpurview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ap_popedom")
    private int id;
    @Column(name = "ap_name")
    private String name;
    @Column(name = "ap_remark")
    private String remark;
}
