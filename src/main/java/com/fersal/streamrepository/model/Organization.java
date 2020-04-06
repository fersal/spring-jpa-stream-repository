package com.fersal.streamrepository.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/*
     Coded by fernando.salazar on 4/6/20
*/
@Entity
@Table(schema = "public", name = "organization")
@NoArgsConstructor
public class Organization {
    @Id
    @Getter
    @SequenceGenerator(
            name = "OrganizationSeq",
            schema = "public",
            sequenceName = "organization_organization_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrganizationSeq")
    @Column(name = "organization_id")
    private Long orgId;

    @Column(name = "organization_name")
    @Setter
    @Getter
    private String orgName;
}
