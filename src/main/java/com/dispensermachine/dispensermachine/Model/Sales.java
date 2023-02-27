package com.dispensermachine.dispensermachine.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Sales")
@NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s ORDER BY s.salesDispenserID")
public class Sales {

    @Id
    @Column(name = "sales_dispenser_id")
    private Integer salesDispenserID;

    @Id
    @Column(name = "sales_article_id")
    private Integer salesArticleId;

    @Column(name = "total_sold_articles")
    private Integer totalSoldArticles;

    @Column(name = "total_price")
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "sales_dispenser_id",referencedColumnName = "id",insertable=false, updatable=false)
    @JsonBackReference(value="dispenserStatus-sales")
    private DispenserStatus dispenserStatus;
    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "sales_article_id",referencedColumnName = "article_id",insertable=false, updatable=false),
            @JoinColumn(name = "sales_dispenser_id",referencedColumnName = "dispenser_status_id",insertable=false, updatable=false)
    })
    private Article article;


    public Sales(){}
    public Sales(Integer salesDispenserID,Integer totalSoldArticles, Double totalPrice,Article article, Integer salesArticleId, DispenserStatus dispenserStatus){
        this.salesDispenserID = salesDispenserID;
        this.totalSoldArticles= totalSoldArticles;
        this.totalPrice = totalPrice;
        this.article = article;
        this.salesArticleId = salesArticleId;
        this.dispenserStatus = dispenserStatus;
    }


    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalSoldArticles() {
        return totalSoldArticles;
    }

    public void setTotalSoldArticles(Integer totalSoldArticles) {
        this.totalSoldArticles = totalSoldArticles;
    }

    public Integer getSalesDispenserID() {
        return salesDispenserID;
    }

    public void setSalesDispenserID(Integer salesDispenserID) {
        this.salesDispenserID = salesDispenserID;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }

    public Integer getSalesArticleId() {
        return salesArticleId;
    }

    public void setSalesArticleId(Integer salesArticleId) {
        this.salesArticleId = salesArticleId;
    }


    public DispenserStatus getDispenserStatus() {
        return dispenserStatus;
    }

    public void setDispenserStatus(DispenserStatus dispenserStatus) {
        this.dispenserStatus = dispenserStatus;
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("sales Article Id: ").append(salesArticleId).append("<br>");
        builder.append("total Sold Articles: ").append(totalSoldArticles).append("<br>");
        builder.append("total Price: ").append(totalPrice).append("<br>");
        builder.append("article name: ").append(article.getName()).append("<br>");
        return builder.toString();
    }
}
