package sistemaagricola.service


import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sistemaagricola.model.Defencivos

@Repository
interface DefencivosRepository: JpaRepository<Defencivos, Long> {

    fun findByNome(nomeDefencivos : String, paginacao: Pageable): Page<Defencivos>
}