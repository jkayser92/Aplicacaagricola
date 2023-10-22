package sistemaagricola.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import sistemaagricola.converter.FertilizanteConverter
import sistemaagricola.dtos.FertilizanteDTO
import sistemaagricola.dtos.FertilizanteResponseDTO
import sistemaagricola.exeptions.NotFoundException
import sistemaagricola.repository.FertilizanteRepository


private const val Fertilizante_NOT_FOUND_MESSAGE = "Fertilizante não encontrada!"

@Service
class FertilizanteService(
    private val repository: FertilizanteRepository,
    private val converter: FertilizanteConverter,
) {

    fun listar(
        nomeFertilizante: String?,
        paginacao: Pageable,
    ): Page<FertilizanteResponseDTO> {
        val fertilizante = if (nomeFertilizante == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeFertilizante, paginacao)
        }
        return fertilizante
            .map(converter::toFertilizanteResponseDTO)
    }

    fun buscarPorId(id: Long): FertilizanteResponseDTO {
        val fertilizante = repository.findById(id)
            .orElseThrow { NotFoundException(Fertilizante_NOT_FOUND_MESSAGE) }
        return converter.toFertilizanteResponseDTO(fertilizante)
    }

    fun cadastrar(dto: FertilizanteDTO): FertilizanteResponseDTO {
        return converter.toFertilizanteResponseDTO(
            repository.save(converter.toFertiliznte(dto))
        )
    }

    fun atualizar(id: Long, dto: FertilizanteDTO): FertilizanteResponseDTO {
        val fertilizante = repository.findById(id)
            .orElseThrow { NotFoundException(Fertilizante_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                quantidade = dto.quantidade,
                preco = dto.preco,

                )
        return converter.toFertilizanteResponseDTO(repository.save(fertilizante))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}