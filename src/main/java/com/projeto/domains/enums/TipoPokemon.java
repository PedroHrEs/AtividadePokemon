package com.projeto.domains.enums;

public enum TipoPokemon {
    AGUA(0, "AGUA"), DRAGAO(1,"DRAGAO"), ELETRICO(2, "ELETRICO"), FADA(3, "FADA"), FANTASMA(4, "FANTASMA"), FOGO(5, "FOGO"), GELO(6, "GELO"), INSETO(7, "INSETO"), LUTADOR(8, "LUTADOR" ), NORMAL(9, "NORMAL"), PEDRA(10, "PEDRA"), PLANTA(11, "PLANTA"), PSIQUICO(12, "PSIQUICO"), SOMBRIO(13, "SOMBRIO"), TERRESTRE(14, "TERRESTRE"), VENENOSO(15,"VENENOSO"), VOADOR(16,"VOADOR");

    private Integer id;
    private String tipo;

    TipoPokemon(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static TipoPokemon toEnum(Integer id){
        if(id==null) return null;
        for(TipoPokemon x: TipoPokemon.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo Inválido");
    }
}
