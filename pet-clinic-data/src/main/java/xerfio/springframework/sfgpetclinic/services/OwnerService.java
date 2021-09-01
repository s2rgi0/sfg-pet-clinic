package xerfio.springframework.sfgpetclinic.services;

import xerfio.springframework.sfgpetclinic.CrudService;
import xerfio.springframework.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
