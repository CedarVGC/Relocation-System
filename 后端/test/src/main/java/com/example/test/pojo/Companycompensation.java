package com.example.test.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "companycompensation")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
public class Companycompensation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mainid  ;
    private String name ;
    private double totalmoney=-1;
    private int asphaltroadnum=-1 ;
    private double asphaltroaduprice=-1 ;
    private double asphaltroadprice=-1  ;
    private int cementroadnum =-1  ;
    private double cementroaduprice=-1;
    private double cementroadprice =-1 ;
    private int concretenum=-1 ;
    private double concreteuprice=-1;
    private double concreteprice =-1;
    private int houseletnum=-1 ;
    private double houseletuprice=-1;
    private double houseletprice=-1    ;
    private int officenum=-1  ;
    private int officelv=-1 ;
    private double officeuprice=-1   ;
    private double officeprice=-1  ;
    private int plantnum=-1  ;
    private int plantlv=-1      ;
    private double plantuprice=-1 ;
    private double plantprice=-1  ;
    private int retainwallnum=-1;
    private double  retainwalluprice=-1 ;
    private double retainwallprice=-1;
    private int slopewallnum=-1   ;
    private double slopewalluprice=-1  ;
    private double slopewallprice=-1 ;
    private int tilenum=-1 ;
    private double tileuprice=-1 ;
    private double tileprice=-1;
    private int  wallnum=-1 ;
    private double  walluprice=-1 ;
    private double wallprice=-1;
    private int shednum=-1 ;
    private double sheduprice=-1 ;
    private double shedprice=-1  ;
    private int wellnum=-1  ;
    private double  welluprice=-1 ;
    private double wellprice=-1   ;
    private int doornum =-1   ;
    private double dooruprice =-1 ;
    private double doorpricre=-1;
    private int fencenum=-1;
    private double fenceuprice=-1   ;
    private double  fenceprice=-1  ;
    private int phonenum =-1    ;
    private double phoneuprice=-1;
    private double phoneprice=-1;
    private int  tvnum=-1;
    private double tvuprice=-1;
    private double tvprice=-1;
    private String remark;
    public void CulTotalmoney()
    {
totalmoney=asphaltroadprice+cementroadprice+concreteprice+houseletprice+officeprice+plantprice+retainwallprice+slopewallprice+tileprice+wallprice+shedprice+wellprice+doorpricre+fenceprice+phoneprice+tvprice;
    }
}
