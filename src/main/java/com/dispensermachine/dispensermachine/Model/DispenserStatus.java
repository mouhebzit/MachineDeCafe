package com.dispensermachine.dispensermachine.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "DispenserStatus")
@NamedQuery(name = "DispenserStatus.findAll", query = "SELECT s FROM DispenserStatus s ORDER BY s.id")
public class DispenserStatus {
    @Id
    @Column(name = "id")
    private Integer dispenserStatusId;
    @Column(name = "operatingStatus")
    private String operatingStatus;
    @Column(name = "current_state")
    private String currentState;
    @Column(name = "temperature")
    private String temperature;
    @Column(name = "payment_state_cash")
    private String paymentStateCash;
    @Column(name = "payment_state_card")
    private String paymentStateCard;
    @Column(name = "payment_state_contact_less_card")
    private String paymentStateContactLessCard;

    @Column(name = "last_errors")
    private String lastErrors;
    @OneToMany(mappedBy = "dispenserStatus")
    @JsonManagedReference(value="dispenserStatus-articles")
    private Set<Article> dispenserArticles;
    @OneToMany(mappedBy = "dispenserStatus")
    @JsonManagedReference(value="dispenserStatus-sales")
    private Set<Sales> sales;

    @OneToOne(mappedBy = "dispenserStatus",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value="dispenser-dispenserStatus")
    private Dispenser dispenser;

    public DispenserStatus(){}

    public DispenserStatus(Integer dispenserStatusId, String operatingStatus, String currentState, String temperature, String paymentStateCard, String paymentStateCash, String paymentStateContactLessCard, String lastErrors, Set<Article> dispenserArticles, Set<DispenserReport> dispenserReports, Dispenser dispenser,Set<Sales> sales ){
        this.dispenserArticles = dispenserArticles;
        this.dispenserStatusId = dispenserStatusId;
        this.paymentStateCard = paymentStateCard;
        this.paymentStateCash = paymentStateCash;
        this.paymentStateContactLessCard = paymentStateContactLessCard;
        this.temperature = temperature;
        this.operatingStatus = operatingStatus;
        this.currentState = currentState;
        this.lastErrors = lastErrors;
        this.dispenser = dispenser;
        this.sales = sales;
    }

    public Set<Article> getDispenserArticles() {
        return dispenserArticles;
    }

    public String getCurrentState() {
        return currentState;
    }

    public String getLastErrors() {
        return lastErrors;
    }

    public String getOperatingStatus() {
        return operatingStatus;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getPaymentStateCard() {
        return paymentStateCard;
    }

    public String getPaymentStateCash() {
        return paymentStateCash;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public void setDispenserArticles(Set<Article> dispenserArticles) {
        this.dispenserArticles = dispenserArticles;
    }

    public String getPaymentStateContactLessCard() {
        return paymentStateContactLessCard;
    }

    public void setLastErrors(String lastErrors) {
        this.lastErrors = lastErrors;
    }

    public void setOperatingStatus(String operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    public void setPaymentStateCard(String paymentStateCard) {
        this.paymentStateCard = paymentStateCard;
    }

    public void setPaymentStateCash(String paymentStateCash) {
        this.paymentStateCash = paymentStateCash;
    }

    public void setPaymentStateContactLessCard(String paymentStateContactLessCard) {
        this.paymentStateContactLessCard = paymentStateContactLessCard;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Integer getDispenserStatusId() {
        return dispenserStatusId;
    }

    public void setDispenserStatusId(Integer dispenserStatusId) {
        this.dispenserStatusId = dispenserStatusId;
    }

    public Dispenser getDispenser() {
        return dispenser;
    }

    public void setDispenser(Dispenser dispenser) {
        this.dispenser = dispenser;
    }

    public Set<Sales> getSales() {
        return sales;
    }

    public void setSales(Set<Sales> sales) {
        this.sales = sales;
    }

    @JsonIgnore
    public double getTotalPrice(){
        double totalPrice = 0;
        for (Sales sale: this.sales) {
            totalPrice+= sale.getTotalPrice();
        }
        return totalPrice;
    }

    @JsonIgnore
    public String getSalesDataString(){
        StringBuilder builder = new StringBuilder();
        for (Sales sale: this.sales) {
            builder.append("Sale: ").append(sale).append("<br>");
        }
        return builder.toString();
    }

    @JsonIgnore
    public String getArticlesDataString(){
        StringBuilder builder = new StringBuilder();
        for (Article article: this.dispenserArticles) {
            builder.append("article: ").append(article).append("<br>");
        }
        return builder.toString();
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("operating Status: ").append(operatingStatus).append("<br>");
        builder.append("current State: ").append(currentState).append("<br>");
        builder.append("temperature: ").append(temperature).append("<br>");
        builder.append("payment State Cash: ").append(paymentStateCash).append("<br>");
        builder.append("payment State Card: ").append(paymentStateCard).append("<br>");
        builder.append("payment State Contact LessCard: ").append(paymentStateContactLessCard).append("<br>");
        builder.append("lastErrors: ").append(lastErrors).append("<br>");
        builder.append("Left articles: ").append(getArticlesDataString()).append("<br>");
        builder.append("Sales: ").append(getSalesDataString()).append("<br>");
        return builder.toString();
    }

}
