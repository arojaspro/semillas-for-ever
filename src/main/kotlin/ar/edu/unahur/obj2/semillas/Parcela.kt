package ar.edu.unahur.obj2.semillas

class Parcela(var ancho:Double,var largo:Double,var horasSol: Double, var plantas:MutableCollection<Planta>) {

    fun superficie():Double{
        return ancho*largo;
    }

    fun cantidadMaxPlantas():Double{
        if(ancho>largo){
            return  superficie()/5;
        }else{
            return( superficie()/3)+largo;
        }
    }

    fun tieneComplicaciones():Boolean{
        val plantasIterador = plantas.iterator();
        while (plantasIterador.hasNext()){
            var planta:Planta = plantasIterador.next();
            if(planta.horasSol()<horasSol){
                return true;
            }
        }
        return false;
    }

    fun plantarUnaPlanta(planta: Planta){
        var condicionDos = horasSol - planta.horasSol();
        if(plantas.size> cantidadMaxPlantas() ||  condicionDos >= 2.0){
            throw Error("No se puede plantar");
        }
        plantas.add(planta);
    }

}