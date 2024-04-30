package unah.edu.lenguajes1900.demo11.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.lenguajes1900.demo11.Entities.Equipo;
import unah.edu.lenguajes1900.demo11.Entities.Posicion;
import unah.edu.lenguajes1900.demo11.Repositories.EquipoRepository;
import unah.edu.lenguajes1900.demo11.Repositories.PosicionRepository;
import unah.edu.lenguajes1900.demo11.Services.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService{

    @Autowired
    EquipoRepository equipoRepository;

    @Autowired
    PosicionRepository posicionRepository;

    @Override
    public Equipo crearEquipo(Equipo equipo) {
        return this.equipoRepository.save(equipo);
    }

    @Override
    public String eliminarEquipo(long codigoEquipo) {

        List<Posicion> posiciones = (List<Posicion>) this.posicionRepository.findAll();
        boolean bandera = true;

        // Verifica si hay creado un registro en posiciones
        for (Posicion posicion : posiciones) {
            if(posicion.getEquipo().getCodigoEquipo() == codigoEquipo){
                bandera = false;
            }
        }

        if(this.equipoRepository.findById(codigoEquipo).isPresent() && bandera == true){
            this.equipoRepository.deleteById(codigoEquipo);
            return "equipo eliminado exitosamente";
        }

        return "equipo no encontrado o está creado un registro en posiciones";
    }

    @Override
    public Equipo buscarEquipo(long codigoEquipo) {
        return this.equipoRepository.findById(codigoEquipo).get();
    }
}
