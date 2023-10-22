package sistemaagricola.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Defencivos(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val nome: String,
    val id: Long? = null,
    val quantidade: Number,
    val preco: Number,

    )
