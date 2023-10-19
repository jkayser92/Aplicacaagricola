package sistemaagricola.exeptions

import java.lang.RuntimeException

class NotFoundException(override val message: String)
    : RuntimeException()