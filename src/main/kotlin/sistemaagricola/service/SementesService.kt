package sistemaagricola.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import sistemaagricola.converter.SementesConverter
import sistemaagricola.dtos.SementesResponseDTO
import sistemaagricola.dtos.SemetesDTO
import sistemaagricola.exeptions.NotFoundException
import sistemaagricola.repository.SementesRepository

private const val SEMENTES_NOT_FOUND_MESSAGE = "Semente não encontrada!"

@Service
class SementesService(
    private val repository: SementesRepository,
    private val converter: SementesConverter,
) {

    fun listar(
        nomeSementes: String?,
        paginacao: Pageable,
    ): Page<SementesResponseDTO> {
        val sementes = if (nomeSementes == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeSementes, paginacao)
        }
        return sementes
            .map(converter::toSementesResponseDTO)
    }

    fun buscarPorId(id: Long): SementesResponseDTO {
        val sementes = repository.findById(id)
            .orElseThrow { NotFoundException(SEMENTES_NOT_FOUND_MESSAGE) }
        return converter.toSementesResponseDTO(sementes)
    }

    fun cadastrar(dto: SemetesDTO): SementesResponseDTO {
        return converter.toSementesResponseDTO(
            repository.save(converter.toSementes(dto))
        )
    }

    fun atualizar(id: Long, dto: SemetesDTO): SementesResponseDTO {
        val sementes = repository.findById(id)
            .orElseThrow { NotFoundException(SEMENTES_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                quantidade = dto.quantidade,
                preco = dto.preco,
            )
        return converter.toSementesResponseDTO(repository.save(sementes))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}