package springclass.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springclass.sfgpetclinic.model.Owner;
import springclass.sfgpetclinic.model.Vet;
import springclass.sfgpetclinic.services.OwnerService;
import springclass.sfgpetclinic.services.VetService;
import springclass.sfgpetclinic.services.map.OwnerServiceMap;
import springclass.sfgpetclinic.services.map.VetServiceMap;

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
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Myers");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Britanny");
        owner2.setLastName("Collins");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Michele");
        vet1.setLastName("Rockings");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Bryan");
        vet2.setLastName("Lins");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
