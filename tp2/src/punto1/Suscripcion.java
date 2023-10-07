package punto1;

//basica intermedia destacada

abstract class Suscripcion {
    abstract String getTipoDeSuscripcion();
    abstract String getActividades();

}

class Basica extends Suscripcion{
    public String getTipoDeSuscripcion(){
        return "Basica";
    }
    public String getActividades(){
        return "A, B, C";
    }
}
class Intermedia extends Basica{
    public String getTipoDeSuscripcion(){
        return "Intermedia";
    }
    public String getActividades(){
        return super.getActividades() + ", D, F, G";
    }
}
class Destacada extends Intermedia{
    public String getTipoDeSuscripcion(){
        return "Destacada";
    }
    public String getActividades(){
        return super.getActividades() + ", H, I, J, K, L, M";
    }
}
