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

	public String toString()
		{return n+":{"+a.toString()+","+b.toString()+","+c.toString()+"}";}

	public double area() 
		{return ( a.gx() * ( b.gy() -	c.gy() ) + b.gx() * (	c.gy() - a.gy()	) + c.gx() * ( a.gy() - b.gy()	) ) / 2;}

	public int comparar(Triangulo r){
		double T = this.area(), R = r.area();
		return T > R ? 1: T < R ? -1 : 0;
	}

	public int comparar(Rectangulo r){
		double T = this.area(), R = r.area();
		return T > R ? 1: T < R ? -1 : 0;
	}
	
	public boolean puntoDentro( Punto p ){
		Punto ab = a.vec( b );
		Punto ac = a.vec( c );
		double	c0 = (  ac.gy() * ( a.gx() - p.gx() ) + ac.gx() * ( p.gy() - a.gy()	)	)/
						/*-----------------------------------------------------------*/
					 (				ab.gy()*ac.gx() - ab.gx()*ac.gy()					);

		double	c1 = (  p.gy() - a.gy() - c0 * ab.gy() ) / ( ac.gy() );

		return c0 > 0 && c1 > 0 && c0 + c1 < 1;
	}

	public Triangulo inter( Triangulo t ){
		Triangulo r = inter( this, t );
		if( r == null ) r = inter( t, this );
		return r;
	}
	public Triangulo inter( Triangulo A, Triangulo B ){
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

