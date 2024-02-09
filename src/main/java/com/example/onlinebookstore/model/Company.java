package com.example.SpringCrud.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="company")
@Getter
@Setter
@ToString
public class Company {

    @Id
    @JsonProperty(value="Id")
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    int id;

    @JsonProperty(value="CompanyName")
    @Column(name = "company_name")
    String companyName;
}
