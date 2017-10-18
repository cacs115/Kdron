package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Correa
 */
public class Part {
    private int partId;
    private String name;
    private int weightSupported;
    private int batteryCells;
    private String esc;
    private String propeller;
    private int status;

    public Part(int partId, String name, int weightSupported, int batteryCells, String esc, String propeller, int status) {
        this.partId = partId;
        this.name = name;
        this.weightSupported = weightSupported;
        this.batteryCells = batteryCells;
        this.esc = esc;
        this.propeller = propeller;
        this.status = status;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeightSupported() {
        return weightSupported;
    }

    public void setWeightSupported(int weightSupported) {
        this.weightSupported = weightSupported;
    }

    public int getBatteryCells() {
        return batteryCells;
    }

    public void setBatteryCells(int batteryCells) {
        this.batteryCells = batteryCells;
    }

    public String getEsc() {
        return esc;
    }

    public void setEsc(String esc) {
        this.esc = esc;
    }

    public String getPropeller() {
        return propeller;
    }

    public void setPropeller(String propeller) {
        this.propeller = propeller;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
