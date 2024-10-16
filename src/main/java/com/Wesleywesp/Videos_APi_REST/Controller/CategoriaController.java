package com.Wesleywesp.Videos_APi_REST.Controller;

import com.Wesleywesp.Videos_APi_REST.domain.categoria.Categoria;
import com.Wesleywesp.Videos_APi_REST.domain.dto.CategoriaDTO;
import com.Wesleywesp.Videos_APi_REST.domain.dto.VideoDTO;
import com.Wesleywesp.Videos_APi_REST.domain.videos.Video;
import com.Wesleywesp.Videos_APi_REST.infra.exception.CategoriaNotFoundException;
import com.Wesleywesp.Videos_APi_REST.repository.CategoriaRepository;
import com.Wesleywesp.Videos_APi_REST.repository.VideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("categoria")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private VideosRepository videoRepository;


        @GetMapping
        public Map<String, List<VideoDTO>> getVideos(Pageable pageable) {
            Page<Video> videoPage = videoRepository.findAllByAtivoTrue(pageable);

            Map<String, List<VideoDTO>> groupedVideos = new HashMap<>();

            for (Video video : videoPage.getContent()) {
                String categoria = video.getCategoria().getCategoriaEnum().name(); // Pega o nome da categoria

                // Adiciona o vídeo ao grupo correspondente
                groupedVideos
                        .computeIfAbsent(categoria, k -> new ArrayList<>())
                        .add(new VideoDTO(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl(), video.getAtivo(), categoria));
            }

            return groupedVideos;
        }

        @GetMapping("/{id}")
        public ResponseEntity<CategoriaDTO> detalharVideo(@PathVariable Long id) throws CategoriaNotFoundException {
            Categoria categoria = categoriaRepository.findByIdCaracteristica(id);

            if (categoria == null) {
                // Retorna 404 com uma mensagem personalizada
                throw new CategoriaNotFoundException("Categoria não encontrada com ID: " + id);
                 }

            // Construa um DTO para retornar a categoria e seus vídeos
            CategoriaDTO categoriaDTO = new CategoriaDTO(categoria);

            return ResponseEntity.ok(categoriaDTO);
        }
}
