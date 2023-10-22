package sistemaagricola.controler


import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import sistemaagricola.dtos.FertilizanteDTO
import sistemaagricola.dtos.FertilizanteResponseDTO
import sistemaagricola.service.FertilizanteService

@RestController
@RequestMapping("/fertilizate")
class FertilizanteController(val service: FertilizanteService) {

    @GetMapping
    fun listar(
        @RequestParam(required = false) nomeFertilizante: String?,
        @PageableDefault(size = 10) paginacao: Pageable,
    )
            : Page<FertilizanteResponseDTO> {
        return service.listar(nomeFertilizante, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): FertilizanteResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(
        @RequestBody dto: FertilizanteDTO,
        uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<FertilizanteResponseDTO> {
        val fertilizanteResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/fertilizante/${fertilizanteResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(fertilizanteResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(
        @PathVariable id: Long,
        @RequestBody dto: FertilizanteDTO,
    ): FertilizanteResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }


}



