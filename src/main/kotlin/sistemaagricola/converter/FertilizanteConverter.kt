package sistemaagricola.converter

import org.springframework.stereotype.Component
import sistemaagricola.dtos.FertilizanteDTO
import sistemaagricola.dtos.FertilizanteResponseDTO
import sistemaagricola.model.Fertilizante

@Component
class FertilizanteConverter{
    fun toFertiliznte(dto: FertilizanteDTO): Fertilizante {
        return Fertilizante(
            nome = dto.nome,
            quantidade = dto.quantidade,
            preco = dto.preco,
        )
    }


    fun toFertilizanteResponseDTO(fertilizante: Fertilizante): FertilizanteResponseDTO {
        return FertilizanteResponseDTO(
            id = fertilizante.id,
            nome = fertilizante.nome,
            quantidade = fertilizante.quantidade,
            preco = fertilizante.preco
        )
    }
}