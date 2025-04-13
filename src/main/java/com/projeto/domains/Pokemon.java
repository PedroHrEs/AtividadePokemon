package com.projeto.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.domains.dtos.PokemonDTO;
import com.projeto.domains.enums.NivelPokemon;
import com.projeto.domains.enums.TipoPokemon;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pokemon")
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @Enumerated
    @JoinColumn(name = "tipopokemon")
    private TipoPokemon tipoPokemon;

    @Enumerated
    @JoinColumn(name = "nivelpokemon")
    private NivelPokemon nivelPokemon;

    @NotNull
    private int pontosDeVida;

    @NotNull
    private int ataque;

    @NotNull
    private int defesa;

    @NotNull
    private int velocidade;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCaptura;

    @Column(unique = true)
    private String cpfPokemon;

    public Pokemon() {
    }

    public Pokemon(Long id, String nome, TipoPokemon tipoPokemon, NivelPokemon nivelPokemon, int pontosDeVida, int ataque, int defesa, int velocidade,LocalDate dataCaptura, String cpfPokemon) {
        this.id = id;
        this.nome = nome;
        this.tipoPokemon = tipoPokemon;
        this.nivelPokemon = nivelPokemon;
        this.pontosDeVida = pontosDeVida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.dataCaptura = dataCaptura;
        this.cpfPokemon = cpfPokemon;
    }

    public Pokemon(PokemonDTO dto){
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.tipoPokemon = TipoPokemon.toEnum(dto.getTipoPokemon());
        this.nivelPokemon =  NivelPokemon.toEnum(dto.getNivelPokemon());
        this.pontosDeVida = dto.getPontosDeVida();
        this.ataque = dto.getAtaque();
        this.defesa = dto.getDefesa();
        this.velocidade = dto.getVelocidade();
        this.dataCaptura = dto.getDataCaptura();
        this.cpfPokemon = dto.getCpfPokemon();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPokemon getTipoPokemon() {
        return tipoPokemon;
    }

    public void setTipoPokemon(TipoPokemon tipoPokemon) {
        this.tipoPokemon = tipoPokemon;
    }

    public NivelPokemon getNivelPokemon() {
        return nivelPokemon;
    }

    public void setNivelPokemon(NivelPokemon nivelPokemon) {
        this.nivelPokemon = nivelPokemon;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public LocalDate getDataCaptura() {
        return dataCaptura;
    }

    public void setDataCaptura(LocalDate dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public String getCpfPokemon() {
        return cpfPokemon;
    }

    public void setCpfPokemon(String cpfPokemon) {
        this.cpfPokemon = cpfPokemon;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id) && Objects.equals(cpfPokemon, pokemon.cpfPokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpfPokemon);
    }

}
