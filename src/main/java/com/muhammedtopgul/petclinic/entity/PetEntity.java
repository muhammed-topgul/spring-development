package com.muhammedtopgul.petclinic.entity;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 23:39
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_pet")
@Getter
@Setter
@ToString
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petClinicSeqGenerator")
    @SequenceGenerator(name = "petClinicSeqGenerator", sequenceName = "petclinic_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private Date birthDate;

    //
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OwnerEntity owner;
}
