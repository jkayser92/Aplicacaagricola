package converter

import br.upf.sistemaeventos.dtos.EventoDTO
import br.upf.sistemaeventos.dtos.EventoResponseDTO
import br.upf.sistemaeventos.model.Evento
import org.springframework.stereotype.Component

@Component
class FertilizateConverter
    fun toFertiliznte (dto: Fertilizante.dto) : Fertilizante {return Fertilizante(
        nome = nome.dto,
        quantidade = quantidade.dto,
        preco = preco.dto,)
}


fun toFertilizanteResponseDTO (fertilizante: Fertilizante): FertilizanteResponseDTO  {
    return FertilizanteResponseDTO(
        id = Fertilizante.id,
        nome = Fertilizante.nome,
        quantidade = fertilizante. quantidade,
        preco =  fertilizante.preco
    )
}