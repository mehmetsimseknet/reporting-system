package com.project.ozguryazilim.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="report")
@Data
public class Report {

    @Id
    @Column(unique = true, nullable = false)
    @SequenceGenerator(name="seq",sequenceName = "idSeq", initialValue=1000000, allocationSize=50)
    @GeneratedValue(generator = "seq")
    Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;
    

    


    @Column
    Long patienceId; // change to patient
    String patientName;
    String diseaseTitle;
    String diseaseDefinition;
    String reportDate;
}