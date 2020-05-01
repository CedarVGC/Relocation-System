package com.example.test.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
@Entity
@Table(name = "companysettlement")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
public class Companysettlement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mainid  ;
    private String name    ;
    private String oldaddress  ;
    private String allocationaddress;
    private int housenum =-1;
    private double housearea=-1;
    private int houselv=-1;
    private double houseuprice=-1;
    private double houseprice =-1   ;
    private double facilitiesprice  =-1 ;
    private double  allprice1=-1 ;
    private int distributionnum =-1  ;
    private double distributionarea =-1 ;
    private double areacash =-1        ;
    private double areadivided =-1     ; ;
    private double areaadd  =-1        ;
    private double areaover =-1        ;
    private double upcash   =-1        ;
    private double updivided =-1       ;
    private double upadd     =-1      ;
    private double upover   =-1         ;
    private double downcash =-1         ;
    private double downdivided  =-1    ;
    private double downadd    =-1      ;
    private double downover =-1         ;
    private double  pricecash  =-1      ;
    private double pricedivided =-1    ;
    private double priceadd    =-1      ;
    private double priceover  =-1      ;
    private double upricecash   =-1    ;
    private double upricedivided  =-1  ;
    private double upriceadd    =-1     ;
    private double  upriceover  =-1     ;
    private double allprice2    =-1    ;
    private double otherprice   =-1    ;
    private double settlementprice1=-1 ;
    private String  settlementprice2  ;
    private String  remark           ;
    private String  director          ;
    private String  examine           ;
    private String  settlement      ;
    private String  people          ;
    public void culHouseprice(){
        houseprice=housearea*houselv*housenum*houseuprice;
    }
    public void culAllprice1()
    {
        allprice1=houseprice+facilitiesprice;
    }
    public void culPricecash()
    {
        pricecash=areacash*upricecash*(1+0.01*(upcash-downcash));
    }
    public void culPricedivided()
    {
        pricedivided=areadivided*upricedivided*(1+0.01*(updivided-downdivided));
    }
    public void culPriceadd()
    {
        priceadd=areaadd*upadd*(1+0.01*(upadd-downadd));
    }
    public void culPriceover()
    {
        priceover=areaover*upriceover*(1+0.01*(upover-downover));
    }
    public void culAllprice2()
    {
        allprice2=pricedivided+pricecash-priceadd-priceover;
    }
    public void culSettlementprice1()
    {
        settlementprice1=allprice2-allprice1-otherprice;
    }
    public void culSettlementprice2(){}


}
