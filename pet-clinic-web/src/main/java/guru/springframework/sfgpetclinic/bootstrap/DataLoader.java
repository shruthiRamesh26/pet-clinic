package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat =new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Shruthi");
        owner1.setLastName("Ramesh");
        owner1.setAddress("123");
        owner1.setCity("Ottawa");
        owner1.setTelephone("12312313");


        ownerService.save(owner1);

        Pet pet1=new Pet();
        pet1.setPetType(dog);
        pet1.setBirthDate(LocalDate.of(2022, 1, 27));
        pet1.setOwner(owner1);

        petService.save(pet1);
        owner1.getPets().add(pet1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Prashanth");
        owner2.setLastName("Devakumar");
        owner2.setAddress("456");
        owner2.setCity("Toronto");
        owner2.setTelephone("2342424324");

        ownerService.save(owner2);

        Pet pet2=new Pet();
        pet2.setPetType(dog);
        pet2.setBirthDate(LocalDate.of(2020, 1, 27));
        pet2.setOwner(owner2);

        petService.save(pet2);
        owner2.getPets().add(pet2);

        System.out.println("Loaded owners...............");

        Speciality speciality1= new Speciality();
        speciality1.setDescription("Chronic diseases");
        specialityService.save(speciality1);

        Speciality speciality2= new Speciality();
        speciality2.setDescription("Stomach issue");
        specialityService.save(speciality2);

        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Thompson");
        vet1.getSpecialties().add(speciality1);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ruth");
        vet2.setLastName("Thompson");
        vet2.getSpecialties().add(speciality2);

        vetService.save(vet2);
        System.out.println("Loaded Vets.......................");


    }
}
