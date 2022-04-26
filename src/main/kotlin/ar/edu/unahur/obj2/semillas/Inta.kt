package ar.edu.unahur.obj2.semillas

object Inta {
    private val parcelas = mutableListOf<Parcela>()

    fun promedioDePlantasPorParcela(): Int {
        val cantPlantas = parcelas.sumBy { it.plantas.size }
        val cantParcelas = parcelas.size
        if (!parcelas.isEmpty()) {
            return cantPlantas / cantParcelas
        }
        return 0
    }

    fun agregarParcela(parcela: Parcela) {
        parcelas.add(parcela)
    }

    fun removerParcelas() {
        parcelas.clear()
    }

    fun parcelaMasAutosustentable(): Parcela? {
        val parcelasFiltradas = parcelas.filter { it.plantas.size > 4 }
        val parcelaAutosustentable = parcelasFiltradas.maxWithOrNull(compareBy{it.porcentajeBienAsociado})
        return parcelaAutosustentable
    }


}