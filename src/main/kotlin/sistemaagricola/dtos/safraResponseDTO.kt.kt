package sistemaagricola.dtos

import java.time.LocalDate

data class safraResponseDTO(
    val id: Long? = null,
    val ano : LocalDate,
    val  cultura : String
)
