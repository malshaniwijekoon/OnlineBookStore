package com.example.SpringCrud.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employee")
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @JsonProperty(value="Id")
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonProperty(value="FirstName")
    @Column(name = "firstname")
    String firstname;

    @JsonProperty(value="LastName")
    @Column(name = "lastname")
    String lastname;

    @JsonProperty(value="ExtensionName")
    @Column(name = "extension_name")
    String extensionname;

    @JsonProperty(value="Birthday")
    @Column(name = "birthday")
    Date birthday;

    @JsonProperty(value="CivilStatus")
    @Column(name = "civil_status")
    String civilstatus;

    @JsonProperty(value="Religion")
    @Column(name = "religion")
    String religion;

    @JsonProperty(value="Nationality")
    @Column(name = "nationality")
    String nationality;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", extensionname='" + extensionname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", civilstatus='" + civilstatus + '\'' +
                ", religion='" + religion + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
