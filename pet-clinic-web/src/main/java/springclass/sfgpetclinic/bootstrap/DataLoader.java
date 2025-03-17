package springclass.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springclass.sfgpetclinic.model.*;
import springclass.sfgpetclinic.services.OwnerService;
import springclass.sfgpetclinic.services.PetTypeService;
import springclass.sfgpetclinic.services.SpecialtyService;
import springclass.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType petType = new PetType();
        petType.setName("Dog");
        PetType savedDogPetType = petTypeService.save(petType);

        PetType petType2 = new PetType();
        petType.setName("Cat");
        PetType savedCatPetType = petTypeService.save(petType2);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Myers");
        owner1.setAddress("1324 stree anywhere");
        owner1.setCity("Miami");
        owner1.setTelephone("1234567854");

        Pet michalPet = new Pet();
        michalPet.setPetType(savedDogPetType);
        michalPet.setName("Fluffly");
        michalPet.setBirthDate(LocalDate.now());

        michalPet.setOwner(owner1);
        owner1.getPets().add(michalPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Britanny");
        owner2.setLastName("Collins");
        owner2.setAddress("1324 stree anywhere");
        owner2.setCity("Miami");
        owner2.setTelephone("1234567854");

        Pet britannyPet = new Pet();
        britannyPet.setPetType(savedCatPetType);
        britannyPet.setName("Bosco");
        britannyPet.setBirthDate(LocalDate.now());

        britannyPet.setOwner(owner2);
        owner2.getPets().add(britannyPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Michele");
        vet1.setLastName("Rockings");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bryan");
        vet2.setLastName("Lins");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
