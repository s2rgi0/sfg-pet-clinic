package xerfio.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xerfio.springframework.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
