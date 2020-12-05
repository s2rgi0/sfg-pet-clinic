package xerfio.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xerfio.springframework.sfgpetclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {


}
