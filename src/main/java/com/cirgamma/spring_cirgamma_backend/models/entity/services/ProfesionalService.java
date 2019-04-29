package com.cirgamma.spring_cirgamma_backend.models.entity.services;

import com.cirgamma.spring_cirgamma_backend.models.entity.Profesional;
import com.cirgamma.spring_cirgamma_backend.models.entity.dao.IProfesionalDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesionalService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(ProfesionalService.class);

    @Autowired
    private IProfesionalDao profesionalDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Profesional profesional = profesionalDao.findAllByUsername(username);

        if (profesional == null) {
            logger.error("Error en el login: no existe el usuario '"+ username+"' en el sistema!");
            throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+ username+"' en el sistema!");
        }
        List<GrantedAuthority> authorities = profesional.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek(authority -> logger.info("Role: "+ authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(profesional.getUsername(), profesional.getPassword(),
                profesional.getEnabled(),true,true,true,authorities);

    }
}




