package com.dispensermachine.dispensermachine.Model;

import com.dispensermachine.dispensermachine.servlets.WeatherAPI;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Article")
@NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a ORDER BY a.dispenserStatus.dispenserStatusId")
public class Article {

    @Id
    @Column(name = "dispenser_status_id")
    private Integer dispenserStatusId;
    @ManyToOne
    @JoinColumn(name = "dispenser_status_id",referencedColumnName = "id",insertable=false, updatable=false)
    @JsonBackReference(value="dispenserStatus-articles")
    private DispenserStatus dispenserStatus;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Integer articleID;

    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;


    public Article(){}
    public Article(DispenserStatus dispenserStatus,Integer dispenserStatusId, Integer articleID,String name, Integer quantity, Double price){
        this.dispenserStatus = dispenserStatus;
        this.articleID = articleID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.dispenserStatusId = dispenserStatusId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
    public Double getPrice(){
        return this.price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Integer getArticleID() {
        return articleID;
    }

    public void setArticleID(Integer articleID) {
        this.articleID = articleID;
    }

    public void setDispenserStatus(DispenserStatus dispenserStatus) {
        this.dispenserStatus = dispenserStatus;
    }

    public DispenserStatus getDispenserStatus() {
        return dispenserStatus;
    }


    public Integer getDispenserStatusId() {
        return dispenserStatusId;
    }

    public void setDispenserStatusId(Integer dispenserStatusId) {
        this.dispenserStatusId = dispenserStatusId;
    }

    @Override
    public String toString() {
        double temp = WeatherAPI.tempC;
        Integer tmp =quantity;
        StringBuilder builder = new StringBuilder();
        builder.append("article ID: ").append(articleID).append("<br>");
        builder.append("name: ").append(name).append("<br>");
        if (quantity<30 && this.dispenserStatus.getDispenser().getDrinkType()=="ColdDrink" && temp>=25)
            tmp= 0;
        else if (quantity<30 && this.dispenserStatus.getDispenser().getDrinkType()=="HotDrink" && temp<5) {
            tmp=0;
        } else if (quantity<10) {
            tmp=0;
        }
        builder.append("quantity: ").append(tmp).append("<br>");
        builder.append("price: ").append(price).append("<br>");
        return builder.toString();
    }
}
