import java.lang.Math;
public class Triangulo {
	private Punto a;
	private Punto b;
	private Punto c;
	private String n;

	public Triangulo()
		{n="";a=new Punto();b=new Punto();c=new Punto();}
	public Triangulo(Punto x, Punto y, Punto z)
		{n="";a=x;b=y;c=z;}

	public Triangulo(double x1, double x2, double y1,double y2,double z1, double z2){
		n="";
		a=Punto(x1,x2);
		b=Punto(y1,y2);
		c=Punto(z1,z2);
	}

	public Punto ga(){ return a;}
	public Punto gb(){ return b;}
	public Punto gc(){ return c;}
	public String gn(){ return n;}
	public void sa(Punto x){ a = x; }
	public void sb(Punto x){ b = x; }
	public void sc(Punto x){ c = x; }

	public double area()
		{ return ( a.gx()(b.gy()-c.gy()) + b.gx()(c.gy()-a.gy()) + c.gx()(a.gy()-b.gy()) )/2;}
	public int comparar(Triangulo t)
		{ return area()>t.area()? 1: area()<t.area() -1:0; }
	public int comparar(Rectangulo t)
		{ return area()>t.area()? 1: area()<t.area() -1:0; }
	
	public boolean puntoDentro( Punto p ){
		Punto v1 = this.gb().add(this.ga().neg());
		Punto v2 = this.gc().add(this.ga().neg());
		double d1 = ( v2.gx()( p.gy() + this.a.gy() ) + v2.gy()*( p.gx() - this.ga.gx() ))/( v1.gx()*v2.gy() - v1.gy()*v2.gx() )
		double d2 = ( p.gy() - this.ga.gy() - d1*v1.gy() ) / v2.gy();
		if( d1 || d2 < 0 ) return false;
		if( d1 <= this.ga().distancia(this.gb()) ){
			double p2 = 1 - ( d1 / this.ga().distancia(this.gb()) );
			if( d2 <= this.ga().distancia(this.gc()) * p2 ) return true;
		}else{ return false }
	}

	public Triangulo interseccion( Triangulo t ){
		int counta = 0;
		int countb = 0;
		if(this.puntoDentro(t.ga()) counta++;
		if(this.puntoDentro(t.gb()) counta++;
		if(this.puntoDentro(t.gc()) counta++;
		if(t.puntoDentro(this.gc()) countb++;
		if(t.puntoDentro(this.gc()) countb++;
		if(t.puntoDentro(this.gc()) countb++;
		if( counta == 0 || counta == 2 || countb == 0 || countb==2) return null;
		if((counta==1 || counta==3) && (countb!=1 || countb!=3)){
			//Aqui vemos con los puntos del primero
		}else{
			//Aqui vemoc con los puntos del segundo
		}
		
	}
}

