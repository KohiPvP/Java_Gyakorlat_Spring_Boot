package hu.nje.cukraszda.diagram;

import hu.nje.cukraszda.database.Ar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArRepository extends JpaRepository<Ar, Integer> {

    @Query("SELECT a.suti.id, a.ertek FROM Ar a ORDER BY a.suti.id")
    List<Object[]> findChartData();
}