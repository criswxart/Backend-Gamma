package com.cirgamma.spring_cirgamma_backend.models.entity.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.cirgamma.spring_cirgamma_backend.models.entity.dao.IUsuarioDao;
import com.cirgamma.spring_cirgamma_backend.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired //inyeccion de independencias en spring
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)//manejar transacciones en el metodo, opcion de lectura"readOnly"
    public List<Usuario> findAll() {

        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)

    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioDao.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }
    //Recibe el cliente que almacenará y retornará el usuario guardado

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {

        return usuarioDao.save(usuario);
    }

    //Eliminará al Usuario por si ID
    @Override
    @Transactional
    public void delete(Long id) {

        usuarioDao.deleteById(id);
    }

}