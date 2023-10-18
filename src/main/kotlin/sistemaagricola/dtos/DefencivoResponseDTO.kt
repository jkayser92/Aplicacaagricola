package sistemaagricola.dtos

data class DefencivoResponseDTO(
    val id: Long? = null,
    val nome: String,
    val quantidade: Number,
    val preco: Number,
)
