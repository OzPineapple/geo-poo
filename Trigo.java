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
		return Trigo.interRecta(	
				r1.ga(),
				r2.ga(),
				r1.ga().vec( r1.gb() ),
				r2.ga().vec( r2.gb() )
		);
	}
	
    public static Punto interRecta( Punto p , Punto q, Punto r, Punto s ){
		double rXs		= r.cruz( s );
		double q_pXr	= q.vec( p ).cruz( r );
		double q_pXs	= q.vec( p ).cruz( s );
		double t,u;
		if( rXs == 0 ){
			if( q_pXr == 0 ){
				t = (q.vec(p) ).punto( r ) / ( r.punto( r ) );
				u = t + s.punto( r )   / ( r.punto( r ) );
				if( t < 0 || u < 0 || t > 1 || u > 1 ) return null;
				return p.add( r.scal( t ) ); 
			} else return null;
		} else {
			t = q_pXs / rXs;		
			u = q_pXr / rXs;		
			if( t >= 0 && t <= 1 &&
				u >= 0 && u <= 1 ){
				return p.add( r.scal( t ) );
			} else return null;
		} 
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

	public static double cruz( Punto a, Punto b ) {
		return Trigo.abs( Trigo.cruz( 
				new double[]{ a.gx(), a.gy(), 0 },
				new double[]{ b.gx(), b.gy(), 0 }
		));
	}

	public static double[] cruz( double[] u, double[] v ){
		return new double[]{
			u[1]*v[2] - u[2]*v[1],
			u[2]*v[0] - u[0]*v[2],
			u[0]*v[1] - u[1]*v[0]
		};
	}

	public static double abs( double[] vec ){
		double val = 0;
		for( double uni : vec )
			val += uni * uni;
		return Math.sqrt( val );
	}
}
