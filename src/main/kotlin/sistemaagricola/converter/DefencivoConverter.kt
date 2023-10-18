package sistemaagricola.converter

import org.springframework.stereotype.Component
import sistemaagricola.dtos.DefencivoDTO
import sistemaagricola.dtos.DefencivoResponseDTO
import sistemaagricola.model.Defencivos
import sistemaagricola.model.Fertilizante


@Component


class DefencivoConverter {
    fun toDefencivo(dto: DefencivoDTO): Defencivos {
        return Defencivos(

                nome = dto.nome,
                quantidade = dto.quantidade,
                preco = dto.preco,
        )
    }


    fun toDefencivosResponseDTO(defencivos: Defencivos): DefencivoResponseDTO {
        return DefencivoResponseDTO(
            id = defencivos.id,
            nome = defencivos.nome,
            quantidade = defencivos.quantidade,
            preco = defencivos.preco
        )
    }
}
