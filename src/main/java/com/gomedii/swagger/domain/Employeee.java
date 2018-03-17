package com.gomedii.swagger.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Employeee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated employeee ID")
    private Integer id;
    @Version
    @ApiModelProperty(notes = "The auto-generated version of the employeee")
    private Integer version;
    @ApiModelProperty(notes = "The application-specific employeee ID")
    private String EmployeeeId;
    @ApiModelProperty(notes = "The product description")
    private String description;
    @ApiModelProperty(notes = "The image URL of the employeee")
    private String imageUrl;
    @ApiModelProperty(notes = "The salary of the employeee", required = true)
    private BigDecimal Salary;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeeId() {
        return EmployeeeId;
    }

    public void setEmployeeeId(String employeeeId) {
        this.EmployeeeId = employeeeId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getSalary() {
        return Salary;
    }

    public void setSalary(BigDecimal salary) {
        this.Salary = salary;
    }
}
