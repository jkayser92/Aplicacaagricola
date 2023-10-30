package sistemaagricola.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class SemetesDTO(
    @field:NotBlank(message = " Sementes sempre deve ter um nome")
    val nomeSementes: String,
    @field:NotNull(message = " Sementes sempre deve ter uma  qauntidade")
    val qtdSementes: Number,
    @field:NotNull(message = " Sementes sempre deve ter um  preço")
    val precoSementes: Number,


    val nome: String,
    val quantidade: Number,
    val preco: Number,
)
