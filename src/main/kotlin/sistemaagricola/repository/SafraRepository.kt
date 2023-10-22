package sistemaagricola.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sistemaagricola.model.Safra

@Repository
interface SafraRepository : JpaRepository<Safra, Long> {

    fun findByCultura(culturaSafra: String, paginacao: Pageable): Page<Safra>
}