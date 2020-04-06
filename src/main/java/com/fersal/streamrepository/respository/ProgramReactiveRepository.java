package com.fersal.streamrepository.respository;

import com.fersal.streamrepository.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.stream.Stream;

import static org.hibernate.annotations.QueryHints.CACHEABLE;
import static org.hibernate.annotations.QueryHints.READ_ONLY;

/*
     Coded by fernando.salazar on 3/31/20
*/
public interface ProgramReactiveRepository extends JpaRepository<Program, Long> {
    @QueryHints(value = {
            @QueryHint(name = READ_ONLY, value = "true"),
            @QueryHint(name = CACHEABLE, value = "false")
    })
    @Query(nativeQuery = true, value = "SELECT p.* from public.Program p ORDER BY p.program_Id")
    Stream<Program> findAllStream();
}
