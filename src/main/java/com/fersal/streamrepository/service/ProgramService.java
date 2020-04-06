package com.fersal.streamrepository.service;

import com.fersal.streamrepository.dto.ProgramSummary;
import com.fersal.streamrepository.model.Program;
import com.fersal.streamrepository.respository.ProgramReactiveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/*
     Coded by fernando.salazar on 4/6/20
*/

@Slf4j
@Service
public class ProgramService {
    private ProgramReactiveRepository programReactiveRepository;

    public ProgramService(ProgramReactiveRepository programReactiveRepository) {
        this.programReactiveRepository = programReactiveRepository;
    }

    @Transactional(readOnly = true)
    public List<ProgramSummary> getAllProgramsReactive() {
        return
                programReactiveRepository.findAllStream()
                        .map(this::toProgramSummary)
                        .collect(Collectors.toList())
                ;
    }

    private ProgramSummary toProgramSummary(final Program program) {
        log.info("Building summary for ProgramId: " + program.getProgramId());

        return ProgramSummary.builder()
                .organizationName(program.getOrganization().getOrgName())
                .programId(program.getProgramId())
                .programName(program.getProgramName())
                .programToken(UUID.randomUUID().toString())
                .build();
    }
}
