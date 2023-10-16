package model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.PrimaryKeyJoinColumn
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Fertilizante(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    val id: Long? = null,
    val nome: String,
    val quantidade: Number,
    val preco: Number,
)
