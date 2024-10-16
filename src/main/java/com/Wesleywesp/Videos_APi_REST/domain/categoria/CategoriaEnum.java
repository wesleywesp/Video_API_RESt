package com.Wesleywesp.Videos_APi_REST.domain.categoria;


public enum CategoriaEnum {
    GAME("game","Azul"),
    PROGRAMACAO("programação","Preto"),
    MUSICA("musica", "verde"),
    FILMES("filmes", "vermelho"),
    ANIMACA("animes", "rosa"),
    SEM_CATEGORIA("default", "branco");

    private final String titulo;
    private final  String cor;

    CategoriaEnum(String titulo, String cor){
        this.titulo = titulo;
        this.cor = cor;
    }
    public static CategoriaEnum fromString(String text) {
        for (CategoriaEnum categoria : CategoriaEnum.values()) {
            if (categoria.titulo.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
    public static CategoriaEnum fromCor(String text) {
        for (CategoriaEnum categoria : CategoriaEnum.values()) {
            if (categoria.cor.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a Cor fornecida: " + text);
    }

}
