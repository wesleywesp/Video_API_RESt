package com.Wesleywesp.Videos_APi_REST.domain.videos;

import com.Wesleywesp.Videos_APi_REST.domain.categoria.Categoria;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity(name = "Video")
@Table(name = "videos")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@AllArgsConstructor
@Setter
public class Video {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String url;
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name ="categoria_id")
    private Categoria categoria;


    public Video(@Valid CadastrarVideo dados) {
        this.ativo = true;
       this.titulo=dados.titulo();
       this.descricao=dados.descricao();
       this.url=dados.url();
    }

    public void atualizarinformacoes(@Valid DadosAtualizar dados) {
        if(dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if(dados.descricao() != null){
            this.descricao= dados.descricao();
        }
       if(dados.url() != null){
           this.url = dados.url();;
       }
    }

    public void excluir(){
        this.ativo = false;
    }

}
