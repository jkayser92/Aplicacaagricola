package sistemaagricola.converter

import org.springframework.stereotype.Component
import sistemaagricola.dtos.SementesResponseDTO
import sistemaagricola.dtos.SemetesDTO
import sistemaagricola.model.Sementes

@Component
class SementesConverter {
    fun toSementes(dto: SemetesDTO): Sementes {
        return Sementes(
            nome = dto.nome,
            quantidade = dto.quantidade,
            preco = dto.preco,
        )
    }


    fun toSementesResponseDTO(sementes: Sementes): SementesResponseDTO {
        return SementesResponseDTO(
            id = sementes.id,
            nome = sementes.nome,
            quantidade = sementes.quantidade,
            preco = sementes.preco
        )
    }
}