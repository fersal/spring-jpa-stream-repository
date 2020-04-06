package com.fersal.streamrepository.dto;

import lombok.Builder;
import lombok.Getter;

/*
     Coded by fernando.salazar on 4/6/20
*/
@Getter
@Builder
public class ProgramSummary {
    private long programId;
    private String programName;
    private String organizationName;
    private String programToken;
}
