package sistemaagricola.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class FertilizanteDTO(
    @field:NotBlank(message = " Fertilizante sempre deve ter um nome")
    val nomeFertilizante: String,
    @field:NotNull(message = "  Fertilizante sempre deve ter uma  qauntidade")
    val qtdFertilizante: Number,
    @field:NotNull(message = " Fertilizante sempre deve ter um  preço")
    val precoFertilizante: Number,

    val nome: String,
    val quantidade: Number,
    val preco: Number,
)
