package petClinic.services;

import petClinic.model.Owner;

public interface OwnerService extends CrudServcie<Owner,Long>{

    Owner findByLastName(String lastName);

}
