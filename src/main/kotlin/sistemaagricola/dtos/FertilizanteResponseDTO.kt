package sistemaagricola.dtos

data class FertilizanteResponseDTO(
    val id: Long? = null,
    val nome: String,
    val quantidade: Number,
    val preco: Number,
)
