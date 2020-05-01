package com.example.test.pojo;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
@Entity
@Table(name = "departments")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dep_number")
    private int number;
    @Column(name = "dep_name")
    private String name;
    @Column(name = "dep_describe")
    private String describe;
    @Column(name = "dep_managename")
    private String managename;
}
