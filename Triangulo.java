import java.lang.Math;
import java.util.Arrays;
public class Triangulo {
	private Punto a;
	private Punto b;
	private Punto c;
	private String n;
	private Punto[] ps;
	private Recta[] rs;

	public Triangulo(){
		this("", new Punto(), new Punto(), new Punto() );
	}

	public Triangulo(double x1, double x2, double y1,double y2,double z1, double z2){
		this("", new Punto(x1,x2), new Punto(y1,y2), new Punto(z1,z2) );
	}

	public Triangulo( Punto x, Punto y, Punto z){
		this( "", x, y, z);
	}

	public Triangulo(String s, Punto x, Punto y, Punto z){
		n=s; a=x; b=y; c=z;
		ps = new Punto[]{a,b,c};
		rs = new Recta[]{
				new Recta( a,b ),
				new Recta( b,c ),
				new Recta( c,a )
			 };
	}


	public Punto ga(){ return a;}
	public Punto gb(){ return b;}
	public Punto gc(){ return c;}
	public String gn(){ return n;}
	public Punto[] gps(){ return ps;}
	public Recta[] grs(){ return rs;}
	public void sa(Punto x){ a = x; }
	public void sb(Punto x){ b = x; }
	public void sc(Punto x){ c = x; }

	public double area() { 
		return Trigo.abs( 
				Trigo.cruz( 
					new double[]{ ps[0].gx() - ps[1].gx(), ps[0].gy() - ps[1].gy(), 0 },
					new double[]{ ps[0].gx() - ps[2].gx(), ps[0].gy() - ps[2].gy(), 0 }
				)
			);
	}

	public int comparar(Triangulo r){
		double T = this.area(), R = r.area();
		return T > R ? 1: T < R ? -1 : 0;
	}

	public int comparar(Rectangulo r){
		double T = this.area(), R = r.area();
		return T > R ? 1: T < R ? -1 : 0;
	}
	
	public boolean puntoDentro( Punto p ){
		Punto v1 = this.gb().add(this.ga().neg());
		Punto v2 = this.gc().add(this.ga().neg());
		double d1 = ( v2.gx()*( p.gy() + this.a.gy() ) + v2.gy()*( p.gx() - this.ga().gx() ))/( v1.gx()*v2.gy() - v1.gy()*v2.gx() );
		double d2 = ( p.gy() - this.ga().gy() - d1*v1.gy() ) / v2.gy();
		if( d1 < 0 || d2 < 0 ) return false;
		if( d1 <= this.ga().distancia(this.gb()) ){
			double p2 = 1 - ( d1 / this.ga().distancia(this.gb()) );
			if( d2 <= this.ga().distancia(this.gc()) * p2 ) return true;
		} return false;
	}

	public Triangulo interseccion( Triangulo A, Triangulo B ){
		Recta r[] = new Recta[2];
		Punto p[] = new Punto[2];
		for( int i = 0; i < 3 ; i++ ) {
			if( ! B.puntoDentro( A.gps()[i] ) ) continue;

			r[0] = new Recta( A.gps()[i], A.gps()[ i == 0 ? 2: i - 1 ] );
			r[1] = new Recta( A.gps()[i], A.gps()[ i == 2 ? 0: i + 1 ] );
			
			for( int j = 0 ; j < 3 ; j++ ) {
				p[0] = B.grs()[j].inter( r[0] );
				p[1] = B.grs()[j].inter( r[1] ) ;
				if( p[0] == null || p[1] == null ) return null;
				return new Triangulo( A.gps()[i], p[0], p[1] );
			}
		} return null;
	}


}

