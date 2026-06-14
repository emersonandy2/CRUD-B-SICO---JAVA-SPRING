package dev.andy.CrudCadastro.service;

import dev.andy.CrudCadastro.Entity.Herois;
import dev.andy.CrudCadastro.dto.HeroisResponse;
import dev.andy.CrudCadastro.dto.HeroisRequest;
import dev.andy.CrudCadastro.exeptions.NotFoundEmail;
import dev.andy.CrudCadastro.repository.HeroisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HeroisService {

    @Autowired
    private final HeroisRepository repository;


    public HeroisService(HeroisRepository repository) {
        this.repository = repository;
    }


    public HeroisResponse create(HeroisRequest request) {
        if(request.email() != null && repository.existsByEmail(request.email())){
            throw new NotFoundEmail("Email não encontrado!");
        }
        Herois herois = request.toEntity();
        Herois heroisalvo = repository.save(herois);
        return HeroisResponse.fromEntity(heroisalvo);


    }

    public Page<HeroisResponse> getAll(HeroisRequest request, Pageable pageable) {
        return repository.findAll(pageable).map(HeroisResponse::fromEntity);}


    public HeroisResponse getById(Long id) {
        return repository.findById(id).map(HeroisResponse::fromEntity).orElseThrow(()
                -> new RuntimeException("Heroi não encontrado"));
    }
    public void deleteById(long id) {
        repository.deleteById(id);

    }
    public HeroisResponse updateById(HeroisRequest request, Long id) {
        Herois herois = searchEntityForId(id);
        request.preencher(herois);
        Herois heroiatualizado = repository.save(herois);
        return HeroisResponse.fromEntity(heroiatualizado);


    }

    private Herois searchEntityForId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Id não encontrado!")
        );
    }


}


