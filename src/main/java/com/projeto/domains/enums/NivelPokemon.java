package com.projeto.domains.enums;

public enum NivelPokemon {
    INICIANTE(0, "INICIANTE"), INTERMEDIARIO(1, "INTERMEDIARIO"), AVANÇADO(2, "AVANÇADO"), LENDARIO(3, "LENDARIO");

    private Integer id;
    private String nivel;

    NivelPokemon(Integer id, String nivel) {
        this.id = id;
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public static NivelPokemon toEnum(Integer id){
        if(id==null) return null;
        for(NivelPokemon x: NivelPokemon.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Nivel Inválido");
    }
}
