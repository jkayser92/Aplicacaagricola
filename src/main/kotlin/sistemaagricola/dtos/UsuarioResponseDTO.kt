package sistemaagricola.dtos

data class UsuarioResponseDTOUsuarioResponseDTO(
    val id: Long? = null,
    val nome: String,
    val cidade: String,
    val telefone: String,
    val email: String
)
