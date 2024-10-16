package com.Wesleywesp.Videos_APi_REST.service;

import com.Wesleywesp.Videos_APi_REST.domain.categoria.Categoria;
import com.Wesleywesp.Videos_APi_REST.domain.categoria.CategoriaEnum;
import com.Wesleywesp.Videos_APi_REST.repository.CategoriaRepository;
import com.Wesleywesp.Videos_APi_REST.domain.videos.CadastrarVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    public Categoria verificarStringOuCor(CadastrarVideo dados){

        String valorCategoria = dados.categoria().valor(); // Acesse o valor da categoria
        CategoriaEnum categoriaEnum;

        try{
             categoriaEnum = CategoriaEnum.fromString(valorCategoria);
           return salvarCateroria(categoriaEnum);

        }catch (IllegalArgumentException e){
            categoriaEnum = CategoriaEnum.fromCor(valorCategoria);
            return salvarCateroria(categoriaEnum);
        }
    }

    private Categoria salvarCateroria(CategoriaEnum categoriaEnum) {
        Categoria categoria = categoriaRepository.findByCategoriaEnum(categoriaEnum)
                .orElseGet(() -> {
                    // Se a categoria não existir, cria uma nova
                    Categoria novaCategoria = new Categoria();
                    novaCategoria.setCategoriaEnum(categoriaEnum);  // Agora funciona corretamente
                    return categoriaRepository.save(novaCategoria);  // Salva a nova categoria
                });
        return categoria;
    }


}
