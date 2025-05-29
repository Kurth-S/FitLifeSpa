package fit_life_Spa.cl.Usuario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, length = 13, nullable=false)  // Define las restricciones para la columna en la tabla.
    private String run;

    @Column(nullable=false) 
    private String nombre;

    @Column(nullable=false)
    private String contraseña;

}
