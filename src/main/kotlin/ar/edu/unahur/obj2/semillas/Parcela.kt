package ar.edu.unahur.obj2.semillas

class Parcela(
    var ancho: Double,
    var largo: Double,
    var horasSol: Double,
    var plantas: MutableCollection<Planta>,
    var tipoParcela: String = "",
    var contadorBienAsociada: Int = 0,
    var porcentajeBienAsociado: Double = 0.0
) {

    private fun clasificarParcela(planta: Planta) {
        if (!tieneComplicaciones() && planta.parcelaIdeal(this)) {
            tipoParcela = "Ecologica"
            contadorBienAsociada++
        }
        if (plantas.size <= 2 && planta.esFuerte()) {
            tipoParcela = "Industrial"
            contadorBienAsociada++
        }
        porcentajeBienAsociado = (contadorBienAsociada/plantas.size).toDouble()
    }

    private fun validarAnchoLargo(ancho: Double, largo: Double) {
        if (ancho <= 0 || largo < 0) {
            throw Error("Parametro invalido")
        }
    }

    private fun validarHorasDeSol(horasSol: Double) {
        if (horasSol <= 0) {
            throw Error("Parametro invalido")
        }
    }

    fun superficie(): Double {
        validarAnchoLargo(ancho, largo)
        return ancho * largo
    }

    fun cantidadMaxPlantas(): Double {
        validarAnchoLargo(ancho, largo)
        if (ancho > largo) {
            return superficie() / 5
        } else {
            return (superficie() / 3) + largo
        }
    }

    fun tieneComplicaciones(): Boolean {
        validarHorasDeSol(horasSol)
        val plantasIterador = plantas.iterator()
        while (plantasIterador.hasNext()) {
            val planta: Planta = plantasIterador.next()
            if (planta.horasSol() < horasSol) {
                return true
            }
        }
        return false
    }

    fun plantarUnaPlanta(planta: Planta) {
        validarHorasDeSol(horasSol)
        val condicionDos = horasSol - planta.horasSol()
        if (plantas.size > cantidadMaxPlantas() || condicionDos >= 2.0) {
            throw Error("No se puede plantar")
        }
        clasificarParcela(planta)
        plantas.add(planta)
    }


}