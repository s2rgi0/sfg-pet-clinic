package xerfio.springframework.sfgpetclinic.boostrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xerfio.springframework.sfgpetclinic.model.Owner;
import xerfio.springframework.sfgpetclinic.model.Vet;
import xerfio.springframework.sfgpetclinic.services.OwnerService;
import xerfio.springframework.sfgpetclinic.services.VetService;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Eston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Rubberland");

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
