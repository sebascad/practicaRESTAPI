package com.uma.practicaREST.dtos;

import lombok.*;

//Hacemos uso de la libreria Lombok para ayudarnos a reducir el "boilerplate" caracteristico de Java
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Cancion {
    private Long id;
    private String titulo;
    private String cantante;
    private int anio;
}
