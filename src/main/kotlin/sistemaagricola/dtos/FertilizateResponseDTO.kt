package sistemaagricola.dtos

import java.time.LocalDate

data class FertilizateResponseDTO(

    val nome  : String,
    val quantidade : Number,
    val preco : Number
)
