package xerfio.springframework.sfgpetclinic.services.map;

import xerfio.springframework.sfgpetclinic.CrudService;
import xerfio.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet,Long>  implements CrudService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        this.deleteById(id);
    }
}
