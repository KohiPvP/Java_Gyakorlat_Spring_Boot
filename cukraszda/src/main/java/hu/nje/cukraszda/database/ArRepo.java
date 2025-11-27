package hu.nje.cukraszda.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArRepo extends CrudRepository<Ar, Integer> {
    List<Ar> findBySuti_Id(Integer sutiId);
}
