package sistemaagricola.dtos

data class SementesResponseDTO(
    val id: Long? = null,
    val nome: String,
    val quantidade: Number,
    val preco: Number,
)
