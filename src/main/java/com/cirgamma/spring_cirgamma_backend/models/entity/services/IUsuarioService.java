package com.cirgamma.spring_cirgamma_backend.models.entity.services;
import com.cirgamma.spring_cirgamma_backend.models.entity.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUsuarioService {

    //devuelve todos los usuarios
    public List <Usuario> findAll();

    public Page <Usuario> findAll(Pageable pageable);


    // buscar por id
    public Usuario findById(Long id);

    //Recibe un usuario que va a almacenar en la BD, retorna el usuario ID
    public Usuario save (Usuario usuario);

    //elimina por id
    public void delete (Long id);
}
