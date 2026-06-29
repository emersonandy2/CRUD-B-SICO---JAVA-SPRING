package dev.andy.CrudCadastro.Controller;

import dev.andy.CrudCadastro.DTOS.HeroisRequest;
import dev.andy.CrudCadastro.DTOS.HeroisResponse;
import dev.andy.CrudCadastro.SERVICE.HeroisService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/herois")
public class HeroisController {

    private final HeroisService heroisService;

    public HeroisController(HeroisService heroisService) {
        this.heroisService = heroisService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HeroisResponse criarHerois(@RequestBody HeroisRequest heroisRequest) {
        return heroisService.create(heroisRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<HeroisResponse> listarHerois(Pageable pageable) {
        return heroisService.getAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HeroisResponse buscarHeroiPorId(@PathVariable Long id) {
        return heroisService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HeroisResponse atualizarHerois(@PathVariable Long id, @RequestBody HeroisRequest heroisRequest) {
        return heroisService.updateById(heroisRequest, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarHerois(@PathVariable Long id) {
        heroisService.deleteById(id);
    }
}
