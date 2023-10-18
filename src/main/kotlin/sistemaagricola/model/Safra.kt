package sistemaagricola.model

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
data class Safra(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
      val id: Long? = null,
      val ano : LocalDate,
      val  cultura : String

   )

