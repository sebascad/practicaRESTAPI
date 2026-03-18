package com.uma.practicaREST.controllers;

import com.uma.practicaREST.dtos.Cancion;
import com.uma.practicaREST.services.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/canciones")
public class CancionController {
    @Autowired
    private CancionService cancionService;

    @GetMapping //Se corresponde con GET /canciones
    public ResponseEntity<List<Cancion>> listaCanciones(){
        List<Cancion> listaCanciones = cancionService.obtenerTodas();
        //Devolvemos 200 OK
        return ResponseEntity.ok(listaCanciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cancion> listaPorId(@PathVariable Long id){
        Optional<Cancion> cancion = cancionService.obtenerPorId(id);

        return cancion.isEmpty() ? ResponseEntity.notFound().build() :
                ResponseEntity.ok(cancion.get());
    }

    @GetMapping("/")
    public ResponseEntity<List<Cancion>> listaPorCantante(@RequestParam(name = "cantante", required = false) String cantante){
        return ResponseEntity.ok(cancionService.obtenerPorCantante(cantante));
    }

    @PostMapping
    public ResponseEntity<Cancion> crear(@RequestBody Cancion cancion,
                                        UriComponentsBuilder uriComponentsBuilder){
        Optional<Cancion> aux = cancionService.crear(cancion);
        if(aux.isEmpty()) return ResponseEntity.badRequest().build();

        URI location = uriComponentsBuilder.path("/canciones/{id}")
                .buildAndExpand(aux.get().getId())
                .toUri();

        return ResponseEntity.created(location).body(aux.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cancion> actualizar(@PathVariable Long id, @RequestBody Cancion cancionActualizada) {
        Optional<Cancion> cancion = cancionService.actualizar(id, cancionActualizada);
        return cancion.isEmpty() ? ResponseEntity.notFound().build() :
                ResponseEntity.ok(cancionActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cancion> borrar(@PathVariable Long id){
        return cancionService.borrar(id) ? ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
