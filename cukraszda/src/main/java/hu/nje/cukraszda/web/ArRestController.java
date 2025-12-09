package hu.nje.cukraszda.web;

import hu.nje.cukraszda.database.Ar;
import hu.nje.cukraszda.database.ArRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/arak")
public class ArRestController {

    private final ArRepo arRepo;

    public ArRestController(ArRepo arRepo) {
        this.arRepo = arRepo;
    }

    // GET /api/arak  – összes ár
    @GetMapping
    public List<Ar> getAll() {
        List<Ar> result = new ArrayList<>();
        arRepo.findAll().forEach(result::add); // CrudRepository → Iterable
        return result;
    }

    // GET /api/arak/{id} – egy ár
    @GetMapping("/{id}")
    public ResponseEntity<Ar> getOne(@PathVariable Integer id) {
        return arRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/arak/suti/{sutiId} – adott sütihez tartozó árak
    @GetMapping("/suti/{sutiId}")
    public List<Ar> getBySuti(@PathVariable Integer sutiId) {
        return arRepo.findBySuti_Id(sutiId);   // ← a te metódusod, változtatás nélkül
    }

    // POST /api/arak – új ár
    @PostMapping
    public Ar create(@RequestBody Ar ar) {
        // JSON-ben pl.:
        // { "ertek": 500, "egyseg": "db", "suti": { "id": 32 } }
        return arRepo.save(ar);
    }

    // PUT /api/arak/{id} – meglévő ár módosítása
    @PutMapping("/{id}")
    public ResponseEntity<Ar> update(@PathVariable Integer id, @RequestBody Ar ar) {
        return arRepo.findById(id)
                .map(existing -> {
                    existing.setErtek(ar.getErtek());
                    existing.setEgyseg(ar.getEgyseg());
                    existing.setSuti(ar.getSuti());
                    Ar updated = arRepo.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/arak/{id} – törlés
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!arRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        arRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}