package sistemaagricola.controler


import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import sistemaagricola.dtos.SementesResponseDTO
import sistemaagricola.dtos.SemetesDTO
import sistemaagricola.service.SementesService

@RestController
@RequestMapping("/sementes")
class SementesController(val service: SementesService) {

    @GetMapping
    fun listar(
        @RequestParam(required = false) nomeSementes: String?,
        @PageableDefault(size = 10) paginacao: Pageable,
    )
            : Page<SementesResponseDTO> {
        return service.listar(nomeSementes, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): SementesResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(
        @RequestBody dto: SemetesDTO,
        uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<SementesResponseDTO> {
        val SementesResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/sementes/${SementesResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(SementesResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(
        @PathVariable id: Long,
        @RequestBody dto: SemetesDTO,
    ): SementesResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }


}



