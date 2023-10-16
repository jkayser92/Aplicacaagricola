package converter

import model.Fertilizante
import model.Sementes
import org.springframework.stereotype.Component

@Component
class SementesConverter
    fun toSementes (dto: Sementes.dto) : Sementes {return Sementes(
        nome = nome.dto,
        quantidade = quantidade.dto,
        preco = preco.dto,)
}




fun toSementesResponseDTO (sementes: Sementes): SementesResponseDTO  {
    return SementesResponseDTO(
        id = sementes.id,
        nome = sementes.nome,
        quantidade = sementes. quantidade,
        preco =  sementes.preco
    )
}