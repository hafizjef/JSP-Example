/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wis.datastore;

import java.io.Serializable;

/**
 *
 * @author Falcon
 */
public class patientBean implements Serializable {
    
    private int id;
    private String name;
    private String dob;
    private String ic;
    private String address;
    private String building;
    private String room;
    private String bed;
    private String description;
    private boolean status;

    public String getBed() {
        return bed;
    }

    public String getBuilding() {
        return building;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public String getIc() {
        return ic;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public boolean isStatus() {
        return status;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String patientAddress) {
        this.address = patientAddress;
    }

    public void setDob(String patientDOB) {
        this.dob = patientDOB;
    }

    public void setIc(String patientIC) {
        this.ic = patientIC;
    }

    public void setId(int patientId) {
        this.id = patientId;
    }

    public void setName(String patientName) {
        this.name = patientName;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setStatus(int status) {
        this.status = status==1;
    }
    
    
}
