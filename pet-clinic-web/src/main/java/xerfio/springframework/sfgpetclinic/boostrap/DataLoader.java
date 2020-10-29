package xerfio.springframework.sfgpetclinic.boostrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xerfio.springframework.sfgpetclinic.model.Owner;
import xerfio.springframework.sfgpetclinic.model.Pet;
import xerfio.springframework.sfgpetclinic.model.PetType;
import xerfio.springframework.sfgpetclinic.model.Vet;
import xerfio.springframework.sfgpetclinic.services.OwnerService;
import xerfio.springframework.sfgpetclinic.services.PetTypeService;
import xerfio.springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {


        PetType dog = new PetType();
        dog.setName("dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");

        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Eston");
        owner1.setAddress("123 BrickLane");
        owner1.setCity("Miami");
        owner1.setCity("555 4566 4546");


        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("President Lincoln");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Rubberland");
        owner1.setAddress("Glockhane");
        owner1.setCity("Ontario");
        owner1.setCity("555 4545 4546");

        Pet fionnasPet = new Pet();
        fionnasPet.setPetType(savedCatPetType);
        fionnasPet.setOwner(owner2);
        fionnasPet.setBirthDate(LocalDate.now());
        fionnasPet.setName("Princess Carolyne");
        owner2.getPets().add(fionnasPet);
        ownerService.save(owner2);

        System.out.println("Loaded owners ... ");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded vets ... ");


    }
}
