package unah.edu.lenguajes1900.demo11.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.edu.lenguajes1900.demo11.Entities.Equipo;

@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Long>{
    
}
