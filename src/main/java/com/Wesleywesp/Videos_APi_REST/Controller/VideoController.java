package com.Wesleywesp.Videos_APi_REST.Controller;


import com.Wesleywesp.Videos_APi_REST.domain.videos.*;
import com.Wesleywesp.Videos_APi_REST.repository.VideosRepository;
import com.Wesleywesp.Videos_APi_REST.service.CategoriaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("videos")
public class VideoController {
    @Autowired
    private VideosRepository repository;
    @Autowired
    private CategoriaService categoriaService;

    //cadastrar
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastrarVideo dados){


        var categoria = categoriaService.verificarStringOuCor(dados);
        var video = new Video(dados);
        video.setCategoria(categoria);
        repository.save(video);

        System.out.println(video);

        return ResponseEntity.ok(new CadastroDetalhe(video));

    }

    // Listar em formato page videos.

    @GetMapping
    public ResponseEntity<Page<DadosListarVideos>> listar(@PageableDefault(size =10)Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListarVideos::new);
        System.out.println(page);
        return ResponseEntity.ok(page);
    }

    //get video detalhers por id individual.
    @GetMapping("/{id}")
    public ResponseEntity detalharVideo(@PathVariable Long id){
        var video = repository.findById(id).get();
        return ResponseEntity.ok(new VideoDetalhe(video));
    }

    @PutMapping
    @Transactional
    public ResponseEntity Atualizar(@RequestBody @Valid DadosAtualizar dados){
        var video = repository.getReferenceById(dados.id());

        video.atualizarinformacoes(dados);

        return ResponseEntity.ok(new DadosAtualizadosDetalhados(video));

    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity Deletar(@PathVariable Long id){
        var video = repository.getReferenceById(id);
        video.excluir();
        return ResponseEntity.noContent().build();
    }

}
