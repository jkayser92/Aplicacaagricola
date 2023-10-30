package sistemaagricola.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class DefencivoDTO(
    @field:NotBlank(message = " Defencivo sempre deve ter um nome")
    val nomeDefencivo: String,
    @field:NotNull(message = "  Defencivo sempre deve ter uma  qauntidade")
    val qtdDefencivo: Number,
    @field:NotNull(message = " Defencivo sempre deve ter um  preço")
    val precoDefencivo: Number,

    val nome: String,
    val quantidade: Number,
    val preco: Number,
)
