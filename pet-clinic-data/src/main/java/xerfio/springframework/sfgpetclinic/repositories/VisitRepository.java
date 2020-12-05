package xerfio.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xerfio.springframework.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
