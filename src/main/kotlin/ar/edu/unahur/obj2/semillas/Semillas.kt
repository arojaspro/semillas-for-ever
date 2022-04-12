package ar.edu.unahur.obj2.semillas

class Menta( altura: Double,  anioSemilla: Int): Planta(altura, anioSemilla) {

    override fun espacio(): Double {
       return super.altura + 1;
    }

    override fun daSemillas(): Boolean {
        var alturaMenta = super.altura > 0.4;
        if(alturaMenta || esFuerte()){
            return true;
        }
        return false;
    }

}

class MentaPeperina( altura: Double,  anioSemilla: Int): Planta(altura, anioSemilla) {

    override fun espacio(): Double {
        return super.altura * 2;
    }

    override fun daSemillas(): Boolean {
        var alturaMenta = super.altura > 0.4;
        if(alturaMenta || esFuerte()){
            return true;
        }
        return false;
    }

}

class Soja( altura: Double, anioSemilla: Int): Planta(altura, anioSemilla) {

    override fun espacio(): Double {
        return super.altura/2;
    }

    override  fun daSemillas(): Boolean {
        var segundaCondicion = (super.altura>0.75 && super.altura<0.9) && (anioSemilla>2007);
        if(esFuerte() || segundaCondicion ){
            return true;
        }
        return false;
    }


    override fun horasSol(): Double {
        if(super.altura<0.5){
            return 6.0;
        }
        else if(super.altura>0.5 && super.altura<1){
            return 8.0;
        } else{
            return 12.0;
        }
    }
}

class SojaTransgenica( altura: Double, anioSemilla: Int): Planta(altura, anioSemilla) {

    override fun espacio(): Double {
        return super.altura/2;
    }

    override  fun daSemillas(): Boolean {
        return false;
    }


    override fun horasSol(): Double {
        if(super.altura<0.5){
            return 6.0;
        }
        else if(super.altura>0.5 && super.altura<1){
            return 8.0;
        } else{
            return 12.0;
        }
    }
}

class Quinoa(altura: Double, anioSemilla: Int): Planta(altura, anioSemilla){
    override fun espacio(): Double {
        return super.espacio()
    }

    override fun horasSol(): Double {
     if(espacio()<0.3){
        return 10.0
     }
        return espacio()
    }

    override fun daSemillas(): Boolean {
        var segundaCondicion =(super.anioSemilla>2001 && super.anioSemilla<2008) || esFuerte();
        return segundaCondicion;
    }
}


