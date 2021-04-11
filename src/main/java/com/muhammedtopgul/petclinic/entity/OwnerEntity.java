package com.muhammedtopgul.petclinic.entity;

/*
 * created by Muhammed Topgul
 * on 05/04/2021
 * at 23:38
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_owner")
@Getter
@Setter
@ToString(of = {"id", "firstName", "lastName"})
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petClinicSeqGenerator")
    @SequenceGenerator(name = "petClinicSeqGenerator", sequenceName = "petclinic_sequence")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    //
    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private Set<PetEntity> pets = new HashSet<>();
}
