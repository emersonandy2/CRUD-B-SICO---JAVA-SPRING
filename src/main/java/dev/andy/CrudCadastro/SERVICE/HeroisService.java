package dev.andy.CrudCadastro.SERVICE;

import dev.andy.CrudCadastro.ENTITYS.Herois;
import dev.andy.CrudCadastro.DTOS.HeroisResponse;
import dev.andy.CrudCadastro.DTOS.HeroisRequest;
import dev.andy.CrudCadastro.EXEPTIONS.NotFoundEmail;
import dev.andy.CrudCadastro.REPOSITORY.HeroisRepository;
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

    public Page<HeroisResponse> getAll(Pageable pageable) {
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


