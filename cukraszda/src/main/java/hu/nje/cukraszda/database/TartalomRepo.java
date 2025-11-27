package hu.nje.cukraszda.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TartalomRepo extends CrudRepository<Tartalom, Integer> {
    List<Tartalom> findByMentes(String mentes);
}
