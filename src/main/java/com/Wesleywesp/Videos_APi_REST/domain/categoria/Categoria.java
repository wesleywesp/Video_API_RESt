package com.Wesleywesp.Videos_APi_REST.domain.categoria;


import com.Wesleywesp.Videos_APi_REST.domain.videos.Video;
import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode(of= "id")
@Getter
@Entity(name = "Categoria")
@Table(name = "categorias")
@Setter
public class Categoria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoriaEnum;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Video> videos = new ArrayList<>();

}
