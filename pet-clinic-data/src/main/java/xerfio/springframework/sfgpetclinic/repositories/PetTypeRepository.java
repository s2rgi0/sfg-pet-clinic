package xerfio.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xerfio.springframework.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {

}
