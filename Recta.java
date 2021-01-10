public class Recta(){
    private Punto a;
    private Punto b;
    public Recta( Punto a, Punto b ){
        this.a = a; this.b = b;
        if( a.gx() < b.gx() )
            this.flip();
    }
    public ga(){return this.a}
    public gb(){return this.b}
    public sa(Punta a){this.a = a}
    public sb(Punta b){this.a = b}

	public void flip(){
		Punto x = this.b.clone();
		this.b = this.a;
		this.a = x;
	}

    public void gslope()
        { return atan2( b.gy() - a.gy(), b.gx() - a.gx() ); }

    public Punto pat( double d){
        return new Punto( 
            a.gx() + d * sin( gslope() ),
            a.gy() + d * sin( gslop() )  );}
}
