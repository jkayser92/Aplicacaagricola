package  sistemaagricola.controler

import org.springframework.stereotype.Component
import sistemaagricola.dtos.SafraDTO
import sistemaagricola.dtos.safraResponseDTO
import sistemaagricola.model.Safra


@Component
class SafraConverter {

    fun toSafra(dto: SafraDTO): Safra {
        return Safra(
            ano = dto.ano,
            cultura = dto.cultura
        )
    }


    fun toSafraResponseDTO(safra: Safra): safraResponseDTO {
        return safraResponseDTO(
            id = safra.id,
            cultura = safra.cultura,
            ano = safra.ano

        )
    }
}