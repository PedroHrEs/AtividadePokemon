package com.projeto.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.domains.Pokemon;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class PokemonDTO {

    private Long id;

    @NotNull(message = "O campo nome não pode estar nulo!")
    @NotBlank(message = "O campo nome não pode estar vazio!")
    private String nome;

    private int tipoPokemon;
    private int nivelPokemon;

    @NotNull(message = "O campo pontos de vida não pode estar nulo!")
    private int pontosDeVida;

    @NotNull(message = "O campo ataque não pode estar nulo!")
    private int ataque;

    @NotNull(message = "O campo defesa não pode estar nulo!")
    private int defesa;

    @NotNull(message = "O campo velocidade não pode estar nulo!")
    private int velocidade;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCaptura;

    @NotNull(message = "O campo cpf do pokemon não pode estar nulo!")
    private String cpfPokemon;


    public PokemonDTO() {
    }

    public PokemonDTO(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.nome = pokemon.getNome();
        this.tipoPokemon = pokemon.getTipoPokemon().getId();
        this.nivelPokemon = pokemon.getNivelPokemon().getId();
        this.pontosDeVida = pokemon.getPontosDeVida();
        this.ataque = pokemon.getAtaque();
        this.defesa = pokemon.getDefesa();
        this.velocidade = pokemon.getVelocidade();
        this.dataCaptura = LocalDate.now();
        this.cpfPokemon = pokemon.getCpfPokemon();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nome não pode estar nulo!") @NotBlank(message = "O campo nome não pode estar vazio!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode estar nulo!") @NotBlank(message = "O campo nome não pode estar vazio!") String nome) {
        this.nome = nome;
    }

    public int getTipoPokemon() {
        return tipoPokemon;
    }

    public void setTipoPokemon(int tipoPokemon) {
        this.tipoPokemon = tipoPokemon;
    }

    public int getNivelPokemon() {
        return nivelPokemon;
    }

    public void setNivelPokemon(int nivelPokemon) {
        this.nivelPokemon = nivelPokemon;
    }

    public @NotNull(message = "O campo pontos de vida não pode estar nulo!") int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(@NotNull(message = "O campo pontos de vida não pode estar nulo!") int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public @NotNull(message = "O campo ataque não pode estar nulo!") int getAtaque() {
        return ataque;
    }

    public void setAtaque(@NotNull(message = "O campo ataque não pode estar nulo!") int ataque) {
        this.ataque = ataque;
    }

    public @NotNull(message = "O campo defesa não pode estar nulo!") int getDefesa() {
        return defesa;
    }

    public void setDefesa(@NotNull(message = "O campo defesa não pode estar nulo!") int defesa) {
        this.defesa = defesa;
    }

    public @NotNull(message = "O campo velocidade não pode estar nulo!") int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(@NotNull(message = "O campo velocidade não pode estar nulo!") int velocidade) {
        this.velocidade = velocidade;
    }

    public @JsonFormat(pattern = "dd/MM/yyyy")LocalDate getDataCaptura() {
        return dataCaptura;
    }

    public void setDataCaptura(@JsonFormat(pattern = "dd/MM/yyyy")LocalDate dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public @NotNull(message = "O campo cpf do pokemon não pode estar nulo!") String getCpfPokemon() {
        return cpfPokemon;
    }

    public void setCpfPokemon(@NotNull(message = "O campo cpf do pokemon não pode estar nulo!") String cpfPokemon) {
        this.cpfPokemon = cpfPokemon;
    }
}
