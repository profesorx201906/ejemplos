package com.backend.banca.usersV3.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.backend.banca.usersV3.Entity.User3;


@Repository
public interface UserRepository3 extends CrudRepository<User3, String> {
    public User3 findByName(String valor);

    @Query(value = "select * from users where name like %:nombre%", nativeQuery = true)
    public List<User3> findByNombrePartialManual(@Param("nombre") String nombre);

}

