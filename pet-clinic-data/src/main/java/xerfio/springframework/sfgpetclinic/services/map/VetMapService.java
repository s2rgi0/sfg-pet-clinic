package xerfio.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import xerfio.springframework.sfgpetclinic.model.Specialty;
import xerfio.springframework.sfgpetclinic.model.Vet;
import xerfio.springframework.sfgpetclinic.services.SpecialtyService;
import xerfio.springframework.sfgpetclinic.services.VetService;

import java.util.Set;



@Service
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialties().size() > 0){
            object.getSpecialties().forEach( specialty -> {
                if(specialty.getId() == null){
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
