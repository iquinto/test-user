package edu.uoc.epcsd.user.domain.repository;

import edu.uoc.epcsd.user.domain.Performance;
import edu.uoc.epcsd.user.domain.Show;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository {

    List<Show> findAllShows();

    Optional<Show> findShowById(Long id);

    List<Show> findShowsByName(String name);

    List<Show> findShowsByCategory(Long id);

    Long createShow(Show show);

    void updateShow(Show show);

    void addShowPerformance(Long id, Performance performance);

}
