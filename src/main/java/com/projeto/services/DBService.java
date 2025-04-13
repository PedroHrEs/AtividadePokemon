package com.projeto.services;

import com.projeto.domains.Pokemon;
import com.projeto.domains.enums.NivelPokemon;
import com.projeto.domains.enums.TipoPokemon;
import com.projeto.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private PokemonRepository pokemonRepo;

    public void initDB(){

        Pokemon pokemon01 = new Pokemon(null,"cavalo", TipoPokemon.NORMAL, NivelPokemon.INTERMEDIARIO, 100, 50, 100, 250,null , "123123213");

        pokemonRepo.save(pokemon01);
    }

}
