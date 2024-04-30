package unah.edu.lenguajes1900.demo11.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.lenguajes1900.demo11.Entities.Posicion;
import unah.edu.lenguajes1900.demo11.Services.Impl.PosicionServiceImpl;

@RestController
@RequestMapping("/api/posicion")
public class PosicionController {

    @Autowired
    PosicionServiceImpl posicionServiceImpl;

    @GetMapping("/obtener")
    public List<Posicion> obtenerPosiciones(){
        return this.posicionServiceImpl.obtenerPosiciones();
    }
}
