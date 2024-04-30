package unah.edu.lenguajes1900.demo11.Services.Impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.random.*;

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

    @Override
    public String simularPartidos() {

        List<Equipo> equipos = (List<Equipo>) this.equipoRepository.findAll();

        for (Equipo equipo : equipos) {

            Random random = new Random();

            String resultado = "";

            int golesLocal = random.nextInt(6);
            int golesVisitante = random.nextInt(6);

            if(golesLocal > golesVisitante){
                resultado = "victoria";
            }
            else if(golesLocal < golesVisitante){
                resultado = "derrota";
            }
            else{
                resultado = "empate";
            }

            Posicion posicionNueva = new Posicion();

            if(resultado == "victoria"){
                posicionNueva.setEquipo(equipo);
                posicionNueva.setEmpates(0);
                posicionNueva.setGanados(1);
                posicionNueva.setPerdidos(0);
                posicionNueva.setGolesFavor(golesLocal);
                posicionNueva.setGolesContra(golesVisitante);
                posicionNueva.setPuntos(3);
            }
            else if(resultado == "derrota"){
                posicionNueva.setEquipo(equipo);
                posicionNueva.setEmpates(0);
                posicionNueva.setGanados(0);
                posicionNueva.setPerdidos(1);
                posicionNueva.setGolesFavor(golesLocal);
                posicionNueva.setGolesContra(golesVisitante);
                posicionNueva.setPuntos(0);
            }
            else{
                posicionNueva.setEquipo(equipo);
                posicionNueva.setEmpates(1);
                posicionNueva.setGanados(0);
                posicionNueva.setPerdidos(0);
                posicionNueva.setGolesFavor(golesLocal);
                posicionNueva.setGolesContra(golesVisitante);
                posicionNueva.setPuntos(1);
            }

            this.posicionRepository.save(posicionNueva);
        }

        return "Partidos simulados exitosamente";
    }
}
