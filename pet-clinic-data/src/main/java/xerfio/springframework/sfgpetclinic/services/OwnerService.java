package xerfio.springframework.sfgpetclinic.services;

import xerfio.springframework.sfgpetclinic.CrudService;
import xerfio.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

}
