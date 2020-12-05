package xerfio.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xerfio.springframework.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
