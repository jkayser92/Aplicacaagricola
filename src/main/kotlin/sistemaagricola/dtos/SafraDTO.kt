package sistemaagricola.dtos

import java.time.LocalDate

data class SafraDTO(

    val ano: LocalDate,
    val cultura: String,
)
