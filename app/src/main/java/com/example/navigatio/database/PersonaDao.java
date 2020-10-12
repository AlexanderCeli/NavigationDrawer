package com.example.navigatio.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/*
* LA SIGUIENTE INTERFACE ES DONDE SE IMPLEMENTA LAS SETENCIA DE ROOM'
* PARA MANIPULAR LA BASE DE DATOS
* COMO LAS CONSULTAS, EL INSERTAR, EL BORRAR
*
* */
@Dao
public interface PersonaDao {

    @Query("SELECT * FROM persona")
    List<Persona> getPersona();

    @Query("SELECT * FROM persona WHERE id LIKE :uuid")
    Persona getPersona(String uuid);

    @Insert
    void addPersona(Persona p);

    @Delete
    void deletePersona(Persona p);

    @Update
    void updatePersona(Persona p);

    @Query("DELETE FROM persona")
    void deleteAllPersona();

    @Query("SELECT * FROM persona WHERE nombre LIKE :search " )
    public List<Persona> findUserWithName(String search);


}
