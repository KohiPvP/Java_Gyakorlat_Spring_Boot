package hu.nje.cukraszda.database;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SutiRepo extends CrudRepository<Suti, Integer> {
    Optional<Suti> findBynev(String nev);
}
