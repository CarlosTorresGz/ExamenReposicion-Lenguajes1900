package unah.edu.lenguajes1900.demo11.Entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "posiciones")
@Data
public class Posicion {

    @Id
    @Column(name = "idposicion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPosicion;
    
    private long empates;

    private long ganados;

    private long perdidos;

    @Column(name = "golesfavor")
    private long golesFavor;

    @Column(name = "golescontra")
    private long golesContra;

    private long puntos;

    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigoequipo", referencedColumnName = "codigoequipo")
    private Equipo equipo;
}
