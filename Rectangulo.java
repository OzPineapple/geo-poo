import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rectangulo{
    private String n;
    private Punto a;    
    private Punto b;
    
    public Rectangulo()
        {n="";a= new Punto();b= new Punto();}
    public Rectangulo(String s)
        {n=s;a= new Punto();b= new Punto();}
    public Rectangulo(String s, Punto x)
        {n=s;a=x;b= new Punto();}
    public Rectangulo(String s, Punto x, Punto y)
        {n=s;a=x;b=y;}
    public Rectangulo(String s, double x, double y)
        {n=s;a= new Punto(x,y);b= new Punto();}
    public Rectangulo(String s, double x1, double x2, double y1, double y2)
        {n=s;a= new Punto(x1,y1);b= new Punto(x2,y2);}
    public Rectangulo(Punto x)
        {n="";a=x;b= new Punto();}
    public Rectangulo(Punto x, Punto y)
        {n="";a=x;b=y;}
    public Rectangulo(double x, double y)
        {n="";a= new Punto(x,y);b= new Punto();}
    public Rectangulo(double x1, double x2, double y1, double y2)
        {n="";a= new Punto(x1,y1);b= new Punto(x2,y2);}

    public void moverRect( Punto A, Punto B ){
	a = A; b = B;
    }
    
    public Punto ga() { return a; }
    public Punto gb() { return b; }
    public String gn() {return n; }

    public void sa(Punto x) {  a=x; }
    public void sb(Punto y) {  b=y; }
    public void sn(String s) { n=s; }

    public String toString()
        {return n+":["+a.toString()+","+b.toString()+"]";}

    public Rectangulo inter(Rectangulo r){
        List<Double> ex = new ArrayList<Double>(
            Arrays.asList(a.gx(), b.gx(), r.a.gx(), r.b.gx() )
        );
        List<Double> ey = new ArrayList<Double>(
            Arrays.asList(a.gy(), b.gy(), r.a.gy(), r.b.gy() )
        );
        Collections.sort(ex);
        Collections.sort(ey);
        return new Rectangulo( ex.get(1), ex.get(2), ey.get(1), ey.get(2) );
    }

    public Rectangulo union(Rectangulo r){
        List<Double> ex = new ArrayList<Double>(
            Arrays.asList(a.gx(), b.gx(), r.a.gx(), r.b.gx() )
        );
        List<Double> ey = new ArrayList<Double>(
            Arrays.asList(a.gy(), b.gy(), r.a.gy(), r.b.gy() )
        );
        Collections.sort(ex);
        Collections.sort(ey);
        return new Rectangulo( ex.get(0), ex.get(3), ey.get(0), ey.get(3) );
    }

    public boolean dentroDe( Punto p ){
	return ( p.gx() > a.gx() && p.gx() < b.gx() &&
		 p.gy() > a.gy() && p.gy() < b.gy() );
    }

    public double area(){
	double ar = b.gx() - a.gx() * b.gy() - a.gy();
	return ar<0? ar*-1:ar;
    }

    public int comparar(Rectangulo r)
	    { return T==R? 0: T<R? -1: 1; }

    public int comparar(Triangulo r)
	    { return T==R? 0: T<R? -1: 1; }

    public int cuadRect(){ return a.cuadrante(); }


}
