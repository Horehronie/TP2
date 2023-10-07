package punto9;

abstract class Figura{
    abstract double getArea();
}
abstract class Figura2D extends Figura{
}
abstract class Figura3D extends Figura{
    abstract double getVolumen();
}

class Circulo extends Figura2D{
    private double radio;
    public Circulo(double radio){
        this.radio = radio;
    }
    double getArea(){
        return Math.PI * (Math.pow(radio,2));
    }
}

class Rectangulo extends Figura2D{
    private double base;
    private double altura;
    public Rectangulo(double base, double altura){
        this.altura = altura;
        this.base = base;
    }

    double getArea(){
        return base * altura;
    }
}

class Cuadrado extends Rectangulo{
    public Cuadrado(double base){
        super(base, base);
    }
}

class Triangulo extends Rectangulo{ //esto no, un triangulo no ES UN rectangulo
    public Triangulo(double base, double altura){
        super(base,altura);
    }
    double getArea(){
        return super.getArea()/2;
    }
}



public class Main {
    public static void main(String[] args){

    }
}
