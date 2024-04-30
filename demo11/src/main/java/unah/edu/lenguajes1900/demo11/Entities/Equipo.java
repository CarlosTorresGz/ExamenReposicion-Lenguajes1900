package unah.edu.lenguajes1900.demo11.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "equipos")
@Data
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoequipo")
    private long codigoEquipo;
    
    private String nombre;

    private double ataque;

    private double defensa;

    @JsonIgnore
    @OneToOne(mappedBy = "equipo")
    private Posicion posicion;
}
