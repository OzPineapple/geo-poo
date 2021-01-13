import java.lang.Math;

public class Trigo{
	/*
	 * a⃗ . b⃗ = |a||b| cosΘ
	 * a . b = a.x b.x + a.y + b.y
	 * | a | = sqrt( x^2 + y^2 )
	 * Θ = acon( a . b /  |a||b| )
	 * */
    public static double angle(Punto a, Punto b )
		{return Math.acos( ( a.punto( b ) )/( a.mag() * b.mag() ));}

	public static double angle(Punto a, Punto b, Punto c)
		{return Trigo.angle( b.vec(a), b.vec(c) );}

	public static double punto( Punto a, Punto b )
		{return (a.gx()*b.gx()) + (a.gy()*b.gy());}

    public static Punto interRecta( Recta r1, Recta r2 ){
		if( r1.gxl() > r2.gxb() || r1.gxb() < r2.gxl() ||
			r1.gyl() > r2.gyb() || r1.gyb() < r2.gyl() )
				return null;
        double delta = Trigo.angle( r2.gb(), r1.ga(), r2.ga() );
        double alpha = Trigo.angle( r1.gb(), r1.ga(), r2.ga() );
        double omega = Math.PI - alpha - delta;
        double dg = Trigo.sinlaw( omega, r1.ga().distancia(r2.ga()), alpha, null );
		return r2.pat( dg );        
    }

	public static double sinlaw(Double alpha, Double da, Double betta, Double db ){
        if( da == null )
            return db * ( Math.sin(betta) / Math.sin(alpha) );
        else if( db == null )
		    return da * ( Math.sin(alpha) / Math.sin(betta) );
        if( alpha == null )
            return Math.asin( ( da / db ) * Math.sin(alpha) );
        else if( betta == null )
		    return Math.asin( ( db / da ) * Math.sin(betta) );
        else return 0.0;
	}

	public static double[] cruz( double[] u, double[] v ){
		return new double[]{
			u[1]*v[2] - u[2]*v[1],
			u[2]*v[0] - u[0]*v[2],
			u[0]*v[2] - u[1]*v[0]
		};
	}

	public static double abs( double[] vec ){
		double val = 0;
		for( double uni : vec )
			val += uni * uni;
		return Math.sqrt( val );
	}
}
