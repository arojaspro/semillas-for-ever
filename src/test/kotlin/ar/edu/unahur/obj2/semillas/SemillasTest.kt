package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import kotlin.math.ceil

class SemillasTest : DescribeSpec({
    // hay una clase Planta que tiene por atributos
    // anioSemilla, altura
    describe("Creación de las plantas") {
        val menta = Menta(1.0, 2021)
        val mentita = MentaPeperina(0.3, 2021)
        val soja = Soja(0.6, 2009)
        val sojaTransgenica = SojaTransgenica(0.6,2007)
        val quinoa = Quinoa(1.0,2022)

        it("probamos los atributos altura  y anioSemilla") {
            menta.altura.shouldBe(1.0)
            menta.anioSemilla.shouldBe(2021)
        }

        it("verificar si da semillas") {
            menta.daSemillas().shouldBeTrue()
            mentita.daSemillas().shouldBeFalse()
            soja.daSemillas().shouldBeFalse()
            sojaTransgenica.daSemillas().shouldBeFalse()
            quinoa.daSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            menta.esFuerte().shouldBeFalse()
            mentita.esFuerte().shouldBeFalse()
            soja.esFuerte().shouldBeFalse()
            sojaTransgenica.esFuerte().shouldBeFalse()
            quinoa.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            menta.espacio().shouldBe(2.0)
            mentita.espacio().shouldBe(0.6)
            soja.espacio().shouldBe(0.3)
            sojaTransgenica.espacio().shouldBe(0.3)
            quinoa.espacio().shouldBe(1.0)
        }

        it("verifico la suma de varias") {
            val superficie = mutableListOf(
                soja.espacio(),
                sojaTransgenica.espacio(),
                menta.espacio(),
                mentita.espacio(),
                quinoa.espacio()
            ).sum()
            ceil(superficie).shouldBe(5)
        }
    }
})

