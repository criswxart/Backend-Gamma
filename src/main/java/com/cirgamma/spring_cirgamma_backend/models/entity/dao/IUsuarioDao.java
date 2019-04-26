package com.cirgamma.spring_cirgamma_backend.models.entity.dao;
import com.cirgamma.spring_cirgamma_backend.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsuarioDao extends JpaRepository <Usuario, Long> {

}
