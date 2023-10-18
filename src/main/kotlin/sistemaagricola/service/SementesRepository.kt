package sistemaagricola.service


import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sistemaagricola.model.Sementes

@Repository
interface SementesRepository: JpaRepository<Sementes, Long> {

    fun findByNome(nomeSementes: String, paginacao: Pageable): Page<Sementes>
}