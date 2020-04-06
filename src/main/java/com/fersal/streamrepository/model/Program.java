package com.fersal.streamrepository.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
     Coded by fernando.salazar on 4/6/20
*/
@Entity
@Table(schema = "public", name = "program")
@NoArgsConstructor
public class Program {
    @Id
    @Getter
    @Column(name = "program_id")
    @SequenceGenerator(
            name = "ProgramProgramSeq",
            schema = "public",
            sequenceName = "program_program_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProgramProgramSeq")
    private Long programId;

    @Getter
    @Column(name = "program_name")
    private String programName;

    @Getter
    @Column(name = "origin")
    private String origin;

    @Getter
    @Transient
    private String accessToken;

    @Getter
    @OneToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
