package sistemaagricola.dtos


import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class SafraDTO(
    @field:NotNull(message = " Safra  sempre deve ter uma data")
    val anoSafra: LocalDate,
    @field:NotBlank(message = " Safra sempre deve ter um nome")
    val culturaSafra: String ,
    
    
   
    val ano: LocalDate,
    val cultura: String,
)
