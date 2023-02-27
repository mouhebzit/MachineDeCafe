package com.dispensermachine.dispensermachine.Model;


import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "DispenserReport")
@NamedQuery(name = "DispenserReport.findAll", query = "SELECT r FROM DispenserReport r ORDER BY r.dispenserStatusId")
public class DispenserReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "report_id")
    private Integer reportID;

    @Id
    @Column(name = "dispenser_status_id")
    private Integer dispenserStatusId;

    @Column(name = "date_time_report")
    private String dataTimeOfReport;

    @ManyToOne
    @JoinColumn(name = "dispenser_status_id",referencedColumnName = "id",insertable=false, updatable=false)
    private Dispenser dispenserStatus;

    @Column(name = "report_data",columnDefinition = "TEXT")
    private String reportData;

    public DispenserReport(){};

    public DispenserReport(Integer dispenserStatusId, String dataTimeOfReport, Dispenser dispenserStatus, String reportData){
        this.dispenserStatus = dispenserStatus;
        this.dataTimeOfReport = dataTimeOfReport;
        //this.reportID = reportID;
        this.dispenserStatusId = dispenserStatusId;
        this.reportData = reportData;
    }


    public String getDataTimeOfReport() {
        return dataTimeOfReport;
    }

    public void setDataTimeOfReport(String dataTimeOfReport) {
        this.dataTimeOfReport = dataTimeOfReport;
    }

    public Dispenser getDispenserStatus() {
        return dispenserStatus;
    }

    public void setDispenserStatus(Dispenser dispenserStatus) {
        this.dispenserStatus = dispenserStatus;
    }

    public Integer getReportID() {
        return reportID;
    }

    public void setReportID(Integer reportID) {
        this.reportID = reportID;
    }

    public void setDispenserStatusId(Integer dispenserStatusId) {
        this.dispenserStatusId = dispenserStatusId;
    }

    public Integer getDispenserStatusId() {
        return dispenserStatusId;
    }

    public String getReportData() {
        return reportData;
    }

    public void setReportData(String reportData) {
        this.reportData = reportData;
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Dispenser Report: ").append("<br>");
        builder.append("reportID: ").append(reportID).append("<br>");
        builder.append("dispenser Id: ").append(dispenserStatusId).append("<br>");
        builder.append("data and time of Report: ").append(dataTimeOfReport).append("<br>");
        builder.append("dispenser Status: ").append(dispenserStatus.getDispenserStatus()).append("<br>");
        return builder.toString();
    }
}
