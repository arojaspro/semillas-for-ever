package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe


class IntaTest : DescribeSpec({

    val menta = Menta(1.9, 2021)
    val mentita = Menta(0.3, 2021)
    val quinoa = Quinoa(2.0, 2001)
    val sojaTransgenica = SojaTransgenica(1.0, 2008)
    val soja = Soja(0.6, 2009)
    val plantas = mutableListOf(menta, mentita, soja, quinoa, sojaTransgenica)



    describe("Estadisticas de INTA") {

        it("Prmedio = 0") {
            val sinPlantas = mutableListOf<Planta>()
            val classParcela = Parcela(10.0, 20.0, 8.0, sinPlantas)
            Inta.agregarParcela(classParcela)
            Inta.promedioDePlantasPorParcela().shouldBe(0)
        }

        it("Promedio igual a 3") {
            val classParcela = Parcela(10.0, 20.0, 8.0, plantas)
            val classParcela2 = Parcela(4.3, 3.0, 2.0, plantas)
            Inta.agregarParcela(classParcela)
            Inta.agregarParcela(classParcela2)
            Inta.promedioDePlantasPorParcela().shouldBe(3)
        }

        it("Verificamos si tiene parcela sustentable"){

           // Inta.parcelaMasAutosustentable().should { Parcela(10.0,10.0,8.0,plantas) }
        }
    }


})

