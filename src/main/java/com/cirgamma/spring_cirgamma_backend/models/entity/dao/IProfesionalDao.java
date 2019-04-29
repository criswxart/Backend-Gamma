package com.cirgamma.spring_cirgamma_backend.models.entity.dao;

import com.cirgamma.spring_cirgamma_backend.models.entity.Profesional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IProfesionalDao extends CrudRepository<Profesional, Long> {

    public Profesional findAllByUsername(String username);

    @Query("SELECT u FROM Profesional u WHERE u.username=?1")
    public Profesional findAllByUsername2(String username);

}
