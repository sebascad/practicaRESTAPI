package com.uma.practicaREST.services;

import com.uma.practicaREST.dtos.Cancion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CancionService {
    private List<Cancion> listaCanciones = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Cancion> obtenerTodas(){
        return listaCanciones;
    }

    public Optional<Cancion> obtenerPorId(Long id){
        return listaCanciones.stream()
                .filter(cancion -> cancion.getId().equals(id))
                .findFirst();
    }

    public List<Cancion> obtenerPorCantante(String cantante){
        return listaCanciones.stream()
                .filter(cancion -> cancion.getCantante().equals(cantante))
                .toList();
    }

    public Optional<Cancion> crear(Cancion cancion){
        if(cancion == null){
            return Optional.empty();
        }
        cancion.setId(idCounter++);
        listaCanciones.add(cancion);

        return Optional.of(cancion);
    }

    public Optional<Cancion> actualizar(Long id,Cancion actualizada){
        return listaCanciones.stream()
                .filter(cancion -> cancion.getId().equals(id))
                .findFirst()
                .map(cancion -> {
                    cancion.setCantante(actualizada.getCantante());
                    cancion.setAnio(actualizada.getAnio());
                    cancion.setTitulo(actualizada.getTitulo());
                    cancion.setId(id);
                    return cancion;
                });
    }

    public boolean borrar(Long id){
        return listaCanciones.removeIf(cancion -> cancion.getId().equals(id));
    }

}
