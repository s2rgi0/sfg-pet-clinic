package xerfio.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xerfio.springframework.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
