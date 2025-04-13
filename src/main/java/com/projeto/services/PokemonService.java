package com.projeto.services;


import com.projeto.domains.Pokemon;
import com.projeto.domains.dtos.PokemonDTO;
import com.projeto.repositories.PokemonRepository;
import com.projeto.services.exceptions.DataIntegrityViolationException;
import com.projeto.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepo;

    public List<PokemonDTO> findAll(){
        return pokemonRepo.findAll().stream().map(obj -> new PokemonDTO(obj)).collect(Collectors.toList());

    }

    public Pokemon findById(Long id){
        Optional<Pokemon> obj = pokemonRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pokemon não encontrado! id: "+id));
    }
    public Pokemon findByCpfPokemon(String cpfPokemon){
        Optional<Pokemon> obj = pokemonRepo.findByCpfPokemon(cpfPokemon);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pokemon não encontrado cpf:"+cpfPokemon));
    }
    public Pokemon create(PokemonDTO dto){
        dto.setId(null);
        validaPokemon(dto);
        Pokemon obj = new Pokemon(dto);
        return pokemonRepo.save(obj);
    }
    public Pokemon update(Long id, PokemonDTO objDto){
        objDto.setId(id);
        validaPokemon(objDto);
        Pokemon oldObj = findById(id);
        oldObj = new Pokemon(objDto);
        return pokemonRepo.save(oldObj);
    }
    public void delete(Long id){
        Pokemon obj = findById(id);
        pokemonRepo.deleteById(id);
    }

    private void validaPokemon(PokemonDTO dto) {
        Optional<Pokemon> obj = pokemonRepo.findByCpfPokemon(dto.getCpfPokemon());
        if (obj.isPresent() && obj.get().getId() != dto.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado!");
        }
    }
}
