package unah.edu.lenguajes1900.demo11.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.lenguajes1900.demo11.Entities.Posicion;
import unah.edu.lenguajes1900.demo11.Repositories.PosicionRepository;
import unah.edu.lenguajes1900.demo11.Services.PosicionService;

@Service
public class PosicionServiceImpl implements PosicionService{

    @Autowired
    PosicionRepository posicionRepository;

    @Override
    public List<Posicion> obtenerPosiciones() {
        return (List<Posicion>) this.posicionRepository.findAll();
    }
    
}
