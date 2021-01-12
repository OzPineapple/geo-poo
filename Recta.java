public class Recta(){
    private Punto a;
    private Punto b;
    public Recta( Punto a, Punto b ){
        this.a = a;
		this.b = b;
        this.flip();
    }
    public Punto ga(){return this.a}
    public Punto gb(){return this.b}
	public double gxl(){return a.gx() < b.gx() ? a.gx() : b.gx(); }
	public double gxg(){return a.gx() > b.gx() ? a.gx() : b.gx(); }
	public double gyl(){return a.gy() < b.gy() ? a.gy() : b.gy(); }
	public double gyg(){return a.gy() > b.gy() ? a.gy() : b.gy(); }
    public Punto sa(Punta a){this.a = a}
    public sb(Punta b){this.a = b}

	public void flip(){
        if( a.gx() < b.gx() )
		Punto x = this.b.clone();
		this.b = this.a;
		this.a = x;
	}

    public void gslope()
        { return atan2( b.gy() - a.gy(), b.gx() - a.gx() ); }

    public Punto pat( double d){
        return new Punto( 
            a.gx() + d * sin( gslope() ),
            a.gy() + d * sin( gslope() )
		);
	}
}
