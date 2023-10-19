package sistemaagricola.repository


import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sistemaagricola.model.Fertilizante

@Repository
interface FertilizanteRepository: JpaRepository<Fertilizante, Long> {

    fun findByNome( nomeFertilizante : String, paginacao: Pageable): Page<Fertilizante>
}