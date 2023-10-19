package sistemaagricola.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import sistemaagricola.converter.DefencivoConverter
import sistemaagricola.dtos.DefencivoDTO
import sistemaagricola.dtos.DefencivoResponseDTO
import sistemaagricola.exeptions.NotFoundException
import sistemaagricola.repository.DefencivosRepository

private const val Defencivos_NOT_FOUND_MESSAGE = "Defencivo não encontrado!"
@Service
class DefencivosService(
    private val repository: DefencivosRepository,
    private val converter: DefencivoConverter
) {

    fun listar(
        nomeDefencivos: String?,
        paginacao: Pageable
    ): Page<DefencivoResponseDTO> {
        val defencivos = if (nomeDefencivos == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeDefencivos, paginacao)
        }
        return defencivos
            .map(converter::toDefencivosResponseDTO)
    }

    fun buscarPorId(id: Long): DefencivoResponseDTO {
        val defencivos = repository.findById(id)
            .orElseThrow { NotFoundException(Defencivos_NOT_FOUND_MESSAGE) }
        return converter.toDefencivosResponseDTO(defencivos)
    }

    fun cadastrar(dto: DefencivoDTO): DefencivoResponseDTO {
        return converter.toDefencivosResponseDTO(
            repository.save(converter.toDefencivo(dto))
        )
    }

    fun atualizar(id: Long, dto: DefencivoDTO): DefencivoResponseDTO {
        val defencivos = repository.findById(id)
            .orElseThrow { NotFoundException(Defencivos_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                quantidade = dto.quantidade,
                preco = dto.preco,

                )
        return converter.toDefencivosResponseDTO(repository.save(defencivos))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}