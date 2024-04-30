package unah.edu.lenguajes1900.demo11.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.lenguajes1900.demo11.Entities.Equipo;
import unah.edu.lenguajes1900.demo11.Services.Impl.EquipoServiceImpl;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {

    @Autowired
    EquipoServiceImpl equipoServiceImpl;

    @PostMapping("/crear")
    public Equipo crearEquipo(@RequestBody Equipo equipo){
        return this.equipoServiceImpl.crearEquipo(equipo);
    }

    @DeleteMapping("/eliminar")
    public String eliminarEquipo(@RequestParam long codigoEquipo){
        return this.equipoServiceImpl.eliminarEquipo(codigoEquipo);
    }

    @GetMapping("/buscar")
    public Equipo buscarEquipo(@RequestParam long codigoEquipo){
        return this.equipoServiceImpl.buscarEquipo(codigoEquipo);
    }

    @PostMapping("/simular")
    public String simularPartidos(){
        return this.equipoServiceImpl.simularPartidos();
    }
    
}
