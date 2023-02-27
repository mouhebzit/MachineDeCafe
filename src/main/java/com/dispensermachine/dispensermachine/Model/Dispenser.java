package com.dispensermachine.dispensermachine.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

enum DrinkType {
    HotDrink, ColdDrink, Encas
}

@Entity
@Table(name = "Dispenser")
@NamedQuery(name = "Dispenser.findAll", query = "SELECT d FROM Dispenser d INNER JOIN DispenserStatus s ON d.id = s.dispenserStatusId ORDER BY d.id")
public class Dispenser {


    @Column(name = "drink_type")
    private String drinkType;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "installation_address")
    private String installationAddress;

    @Column(name = "gps_coordinates")
    private String gpsCoordinates;

    @Column(name = "location")
    private String location;
    @Column(name = "intervention_date")
    private String interventionDate;
    @Column(name = "comment")
    private String comment;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "id")
    @JsonManagedReference(value="dispenser-dispenserStatus")
    private DispenserStatus dispenserStatus;

    @OneToMany(mappedBy = "dispenserStatus")
    @JsonIgnore
    private Set<DispenserReport> dispenserReports;

    public Dispenser(){}
    public Dispenser(String drinkType,  String installationAddress, String gpsCoordinates, String location, String interventionDate, String comment,Set<DispenserReport> dispenserReports) {
        this.drinkType = drinkType;
        this.interventionDate = interventionDate;
        this.installationAddress = installationAddress;
        this.gpsCoordinates = gpsCoordinates;
        this.comment = comment;
        this.location = location;
        dispenserReports = dispenserReports;
    }

    public void setDispenserReports(Set<DispenserReport> dispenserReports) {
        this.dispenserReports = dispenserReports;
    }

    public Set<DispenserReport> getDispenserReports() {
        return dispenserReports;
    }


    public String getDrinkType() {
        return this.drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstallationAddress() {
        return this.installationAddress;
    }

    public void setInstallationAddress(String installationAddress) {
        this.installationAddress = installationAddress;
    }

    public String getGpsCoordinates() {
        return this.gpsCoordinates;
    }

    public void setGpsCoordinates(String gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComment(){
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getInterventionDate(){
        return this.interventionDate;
    }

    public void setInterventionDate(String interventionDate) {
        this.interventionDate = interventionDate;
    }

    public void setDispenserStatus(DispenserStatus dispenserStatus) {
        this.dispenserStatus = dispenserStatus;
    }

    public DispenserStatus getDispenserStatus() {
        return dispenserStatus;
    }


    @Override
    public String toString() {
        return "Dispenser{" +
                "drinkType='" + drinkType + '\'' +
                ", id=" + id +
                ", installationAddress='" + installationAddress + '\'' +
                ", gpsCoordinates='" + gpsCoordinates + '\'' +
                ", location='" + location + '\'' +
                ", interventionDate='" + interventionDate + '\'' +
                ", comment='" + comment + '\'' +
                ", dispenserStatus=" + dispenserStatus +
                '}';
    }

}