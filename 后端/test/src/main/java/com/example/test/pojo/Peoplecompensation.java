package com.example.test.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "peoplecompensation")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
public class Peoplecompensation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id  ;
    private int mainid;
    private String  name;
    private String address;
    private Date measuredate;
    private double  totalmoney=-1;
    private int housenum=-1;
    private double housearea=-1;
    private int houselv=-1;
    private double houseuprice=-1;
    private double houseprice=-1;
    private int cellanum=-1;
    private double cellaarea=-1;
    private int  cellalv=-1;
    private double cellauprice=-1;
    private double cellaprice=-1;
    private int wellnum=-1;
    private double welluprice=-1;
    private double wellprice=-1;
    private int phonenum=-1;
    private double  phoneuprice=-1;
    private double  phoneprice=-1;
    private int  digesternum=-1;
    private double digesteruprice=-1;
    private double  digesterprice=-1;
    private int wallnum=-1;
    private double walluprice=-1;
    private double wallprice=-1;
    private int pigpennum=-1;
    private double  pigpenuprice=-1;
    private double  pigpenprice=-1;
    private int wcnum=-1;
    private double  wcuprice=-1;
    private double wcprice=-1;
    private int concretenum=-1;
    private double concreteuprice=-1;
    private double  concreteprice=-1;
    private int cellarnum=-1;
    private double cellaruprice=-1;
    private double cellarprice=-1;
    private int shacknum=-1;
    private double shackuprice=-1;
    private double shackprice=-1;
    private int waternum=-1;
    private double wateruprice=-1;
    private double  waterprice=-1;
    private int tvnum=-1;
    private double tvuprice=-1;
    private double  tvprice=-1;
    private int archnum=-1;
    private double  archuprice=-1;
    private double  archprice=-1;
    private int  tree7num=-1;
    private double  tree7uprice=-1;
    private double tree7price=-1;
    private int tree8num=-1;
    private double tree8uprice=-1;
    private double tree8price=-1;
    private int treespnum=-1;
    private double treespuprice=-1;
    private double treespprice=-1;
    private String remark   ;
    public void CulTotalmoney()
    {
        totalmoney=houseprice+cellaprice+wellprice+ phoneprice+digesterprice+wallprice+pigpenprice+wcprice+concreteprice+cellarprice+ shackprice+waterprice+ tvprice+ archprice+tree7price+tree8price+treespprice;
    }
}
