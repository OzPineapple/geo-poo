import java.lang.Math;

public class Recta{
    private Punto a;
    private Punto b;
    public Recta( Punto a, Punto b ){
        this.a = a;
		this.b = b;
        this.flip();
    }
    public Punto ga(){return this.a;}
    public Punto gb(){return this.b;}
	public double gxl(){return a.gx() < b.gx() ? a.gx() : b.gx(); }
	public double gxb(){return a.gx() > b.gx() ? a.gx() : b.gx(); }
	public double gyl(){return a.gy() < b.gy() ? a.gy() : b.gy(); }
	public double gyb(){return a.gy() > b.gy() ? a.gy() : b.gy(); }
    public void sa(Punto a){this.a = a;}
    public void  sb(Punto b){this.a = b;}

	public void flip(){
        if( a.gx() < b.gx() ) return;
		Punto x = this.b.clone();
		this.b = this.a;
		this.a = x;
	}

    public double gslope()
        { return Math.atan2( b.gy() - a.gy(), b.gx() - a.gx() ); }

    public Punto pat( double d ){
        return new Punto( 
            a.gx() + d * Math.sin( this.gslope() ),
            a.gy() + d * Math.sin( this.gslope() )
		);
	}

	public Punto inter( Recta r )
		{return Trigo.interRecta(this, r);}
}
