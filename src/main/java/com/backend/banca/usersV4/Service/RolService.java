package com.backend.banca.usersV4.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.banca.usersV4.Entity.ERol;
import com.backend.banca.usersV4.Entity.Role;
import com.backend.banca.usersV4.Repository.RolRepository;



@Service
public class RolService {
    
    @Autowired
    RolRepository rolRepository;

    public List<Role> findAll(){
        return (List<Role>) rolRepository.findAll();
    }

    public Optional<Role> findByNombre(ERol nombre){
        return rolRepository.findByNombre(nombre);
    }

    public Role save(Role role){
        return rolRepository.save(role);
    }
}
