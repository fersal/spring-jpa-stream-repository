package com.fersal.streamrepository.controller;

import com.fersal.streamrepository.dto.ProgramSummary;
import com.fersal.streamrepository.service.ProgramService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
     Coded by fernando.salazar on 4/6/20
*/
@RestController
@RequestMapping("/v1")
public class ProgramController {
    private ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("/programs")
    public List<ProgramSummary> getProgramSummaries() {
        return programService.getAllProgramsReactive();
    }
}
