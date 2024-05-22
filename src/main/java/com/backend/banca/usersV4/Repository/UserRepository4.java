package com.backend.banca.usersV4.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.backend.banca.usersV4.Entity.User4;


@Repository
public interface UserRepository4 extends CrudRepository<User4, String> {
    public User4 findByName(String valor);

    @Query(value = "select * from users where name like %:nombre%", nativeQuery = true)
    public List<User4> findByNombrePartialManual(@Param("nombre") String nombre);

}

