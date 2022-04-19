package ar.edu.unahur.obj2.semillas

open class Planta(var altura: Double, val anioSemilla: Int) {

    open fun espacio(): Double {
        return altura
    }

    open fun horasSol(): Double {
        return 7.0;
    }

    open fun esFuerte(): Boolean {
        return horasSol() > 9.0;
    }

    open fun daSemillas(): Boolean {
        return esFuerte();
    }

    open fun parcelaIdeal(parcela: Parcela): Boolean {
        return true;
    }

    open fun parcelaEcologica(parcela: Parcela): Boolean {
        return (!parcela.tieneComplicaciones() && parcelaIdeal(parcela))

    }

    open fun parcelaIndustrial(parcela: Parcela): Boolean {
        return (parcela.plantas.size <= 2.0 && esFuerte())
    }
}