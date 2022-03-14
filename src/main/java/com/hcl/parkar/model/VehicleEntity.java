package com.hcl.parkar.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "vehicle")
public class VehicleEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "vehicle_id" , nullable = false, unique = true, length = 30)
    private int vehicleId;
    @Column(name = "vehicle_category" , nullable = false, length = 10)
    private String vehicleCategory;
    @Column(name = "vehicle_city" , nullable = false, length = 50)
    private String vehicleCity;
    public int getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String getVehicleCategory() {
        return vehicleCategory;
    }
    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }
    public String getVehicleCity() {
        return vehicleCity;
    }
    public void setVehicleCity(String vehicleCity) {
        this.vehicleCity = vehicleCity;
    }
    public String getVehicleState() {
        return vehicleState;
    }
    public void setVehicleState(String vehicleState) {
        this.vehicleState = vehicleState;
    }
    @Column(nullable = false, length = 50)
    private String vehicleState;
    @Override
    public String toString() {
        return "VehicleEntity [vehicleId=" + vehicleId + ", vehicleCategory=" + vehicleCategory + ", vehicleCity="
                + vehicleCity + ", vehicleState=" + vehicleState + "]";
    }
}