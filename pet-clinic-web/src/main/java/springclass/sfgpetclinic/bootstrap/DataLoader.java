package springclass.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springclass.sfgpetclinic.model.Owner;
import springclass.sfgpetclinic.model.PetType;
import springclass.sfgpetclinic.model.Vet;
import springclass.sfgpetclinic.services.OwnerService;
import springclass.sfgpetclinic.services.PetTypeService;
import springclass.sfgpetclinic.services.VetService;
import springclass.sfgpetclinic.services.map.OwnerServiceMap;
import springclass.sfgpetclinic.services.map.VetServiceMap;

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

        PetType petType = new PetType();
        petType.setName("Dog");
        PetType savedDogPetType = petTypeService.save(petType);

        PetType petType2 = new PetType();
        petType.setName("Cat");
        PetType savedCatPetType = petTypeService.save(petType2);

        petTypeService.save(petType2);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Myers");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Britanny");
        owner2.setLastName("Collins");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Michele");
        vet1.setLastName("Rockings");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bryan");
        vet2.setLastName("Lins");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
