package sistemaagricola.service
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import sistemaagricola.controler.SafraConverter
import sistemaagricola.dtos.SafraDTO
import sistemaagricola.dtos.safraResponseDTO
import sistemaagricola.exeptions.NotFoundException
import sistemaagricola.repository.SafraRepository
private const val SAFRA_NOT_FOUND_MESSAGE = "Safa não encontrada!"
@Service
class SafraService(
    private val repository: SafraRepository,
    private val converter: SafraConverter
) {

    fun listar(
        culturaSafra: String?,
        paginacao: Pageable): Page<safraResponseDTO> {
        val safra  = if (culturaSafra == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByCultura(culturaSafra, paginacao)
        }
        return safra
            .map(converter::toSafraResponseDTO)
    }

    fun buscarPorId(id: Long):  safraResponseDTO {
        val safra = repository.findById(id)
            .orElseThrow { NotFoundException(SAFRA_NOT_FOUND_MESSAGE) }
        return converter.toSafraResponseDTO(safra)
    }

    fun cadastrar(dto: SafraDTO): safraResponseDTO {
        return converter.toSafraResponseDTO(
            repository.save(converter.toSafra(dto))
        )
    }

    fun atualizar(id: Long, dto: SafraDTO): safraResponseDTO{
        val safra = repository.findById(id)
            .orElseThrow { NotFoundException(SAFRA_NOT_FOUND_MESSAGE) }
            .copy(
                ano = dto.ano,
                cultura = dto.cultura,
                )
        return converter.toSafraResponseDTO(repository.save(safra))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}