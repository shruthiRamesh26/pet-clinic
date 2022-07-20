package guru.springframework.sfgpetclinic.services;


import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudServcie<Owner,Long>{

    Owner findByLastName(String lastName);

}
