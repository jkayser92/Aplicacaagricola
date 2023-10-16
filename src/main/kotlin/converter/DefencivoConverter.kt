package converter

import br.upf.sistemaeventos.dtos.EventoDTO
import br.upf.sistemaeventos.dtos.EventoResponseDTO
import br.upf.sistemaeventos.model.Evento
import org.springframework.stereotype.Component

@Component


class DefencivoConverterter
    fun toDefencivo (dto: Defencivos.dto) : Defencivos {return Defencivos(
        nome = nome.dto,
        quantidade = quantidade.dto,
        preco = preco.dto,)
}



fun toDefencivosResponseDTO(defencivos: Defencivos): DefencivosResponseDTO  {
    return DefencivosResponseDTO(
        id = defencivos.id,
        nome = defencivos.nome,
        quantidade = defencivos.quantidade,
        preco = defencivos.preco
    )
}
