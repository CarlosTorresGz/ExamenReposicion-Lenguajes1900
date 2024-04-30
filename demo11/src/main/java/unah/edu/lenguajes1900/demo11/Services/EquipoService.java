package unah.edu.lenguajes1900.demo11.Services;

import unah.edu.lenguajes1900.demo11.Entities.Equipo;

public interface EquipoService {
    
    public Equipo crearEquipo(Equipo equipo);

    public String eliminarEquipo(long codigoEquipo);

    public Equipo buscarEquipo(long codigoEquipo);
}
