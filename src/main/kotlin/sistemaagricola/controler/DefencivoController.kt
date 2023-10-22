package sistemaagricola.controler


import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import sistemaagricola.dtos.DefencivoDTO
import sistemaagricola.dtos.DefencivoResponseDTO
import sistemaagricola.service.DefencivosService

@RestController
@RequestMapping("/defencivos")
class DefencivoController(val service: DefencivosService) {

    @GetMapping
    fun listar(
        @RequestParam(required = false) nomeDefencivos: String?,
        @PageableDefault(size = 10) paginacao: Pageable,
    )
            : Page<DefencivoResponseDTO> {
        return service.listar(nomeDefencivos, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): DefencivoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(
        @RequestBody dto: DefencivoDTO,
        uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<DefencivoResponseDTO> {
        val defencivosResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/defencivos/${defencivosResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(defencivosResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(
        @PathVariable id: Long,
        @RequestBody dto: DefencivoDTO,
    ): DefencivoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }


}



