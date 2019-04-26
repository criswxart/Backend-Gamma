package com.cirgamma.spring_cirgamma_backend.controllers;
import com.cirgamma.spring_cirgamma_backend.models.entity.services.IUsuarioService;
import com.cirgamma.spring_cirgamma_backend.models.entity.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<Usuario> index(){
        return usuarioService.findAll();

    }

    @GetMapping("/usuario/page/{page}")
    public Page<Usuario> index(@PathVariable Integer page){
        Pageable pageable = PageRequest.of(page, 10);
        return usuarioService.findAll(pageable);

    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

        Usuario usuario = null;
        //Tipo Map que almacena objetos o valores asociados a un nombre para asignar el error
        Map<String, Object> response = new HashMap<>();
        try {
            usuario = usuarioService.findById(id);
        }catch(DataAccessException e) {
            response.put("Mensaje:","Error al realizar la consulta en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (usuario == null) {
            response.put("mensaje","El cliente ID ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <?> create(@Valid @RequestBody Usuario usuario, BindingResult result) {

        Usuario usuarionew = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '"+ err.getField() + "' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.BAD_REQUEST);
        }
        try {
            usuarionew = usuarioService.save(usuario);

        }catch(DataAccessException e) {
            response.put("Mensaje:","Error al realizar la inserción en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El usuario se ha creado con exito!");
        response.put("usuario", usuarionew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity <?> update(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id) {

        Usuario usuarioActual = usuarioService.findById(id);

        Usuario usuarioUpdated = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '"+ err.getField() + "' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object> >(response, HttpStatus.BAD_REQUEST);
        }

        if (usuario == null) {
            response.put("mensaje","Error: No se pudo editar, el cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {

            usuarioActual.setNombre(usuario.getNombre());
            usuarioActual.setApellidos(usuario.getApellidos());
            usuarioActual.setDireccion(usuario.getDireccion());
            usuarioActual.setTelefono(usuario.getTelefono());
            usuarioActual.setFechaNac(usuario.getFechaNac());
            usuarioUpdated = usuarioService.save(usuarioActual);
        }catch(DataAccessException e) {
            response.put("Mensaje:","Error al actualizar en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El usuario ha sido actualizado con exito!");
        response.put("usuario", usuarioUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        try {
            usuarioService.delete(id);


        }catch(DataAccessException e) {
            response.put("Mensaje:","Error al eliminar el usuario en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El usuario ha sido eliminado con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);


    }


}