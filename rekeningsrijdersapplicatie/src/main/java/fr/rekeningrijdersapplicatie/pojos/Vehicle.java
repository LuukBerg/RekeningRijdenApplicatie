package fr.rekeningrijdersapplicatie.pojos;

public class Vehicle {
    private long id;
    private String brand;
    private String model;
    private String licenseNumber;
    private short Year;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public short getYear() {
        return Year;
    }

    public void setYear(short Year) {
        this.Year = Year;
    }

}
