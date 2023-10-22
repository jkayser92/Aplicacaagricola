package sistemaagricola.controler


import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import sistemaagricola.dtos.SafraDTO
import sistemaagricola.dtos.safraResponseDTO
import sistemaagricola.service.SafraService

@RestController
@RequestMapping("/safra")
class SafraController(val service: SafraService) {

    @GetMapping
    fun listar(
        @RequestParam(required = false) safraCultura: String?,
        @PageableDefault(size = 10) paginacao: Pageable,
    )
            : Page<safraResponseDTO> {
        return service.listar(safraCultura, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): safraResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(
        @RequestBody dto: SafraDTO,
        uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<safraResponseDTO> {
        val safraResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/safra/${safraResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(safraResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(
        @PathVariable id: Long,
        @RequestBody dto: SafraDTO,
    ): safraResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }


}



