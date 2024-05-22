package com.backend.banca.usersV4.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.banca.usersV4.Entity.ERol;
import com.backend.banca.usersV4.Entity.Role;

@Repository
public interface RolRepository extends CrudRepository<Role,String> {
    public Optional<Role> findByNombre(ERol nombre);
}
