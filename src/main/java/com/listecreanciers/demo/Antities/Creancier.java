package com.listecreanciers.demo.Antities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Creancier implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String Nom;
    @Column
    private Date Date;
    @Column
    private Long idc;

}
