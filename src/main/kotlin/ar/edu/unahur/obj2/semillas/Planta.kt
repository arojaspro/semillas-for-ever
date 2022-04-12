package ar.edu.unahur.obj2.semillas

 open class Planta (var altura: Double, val anioSemilla: Int) {

    open fun espacio(): Double  {return altura}

   open fun horasSol (): Double {
        return 7.0;
    }

     open fun esFuerte(): Boolean {
       return horasSol()>9.0;
    }

     open fun daSemillas(): Boolean {
       return esFuerte();
    }
}