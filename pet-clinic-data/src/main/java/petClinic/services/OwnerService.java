package petClinic.services;

import petClinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudServcie<Owner,Long>{

    Owner findByLastName(String lastName);

}
