package com.example.navigatio.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Persona.class},version = 1)
public abstract class PersonaDatabase extends RoomDatabase {

    public abstract PersonaDao getPersonaDao();

}
