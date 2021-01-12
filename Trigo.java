import java.lang.Math;

public class Trigo{
    public static double angle(Punto a, Punto b, Punto c){
		double alpha = atan2( b.gy() - a.gy(), b.gx() - a.gy() );
		double gamma = atan2( b.gy() - c.gy(), b.gx() - c.gy() );
		alpha = alpha < 0 ? alpha * -1 : alpha;
		gamma = gamma < 0 ? gamma * -1 : gamma;
		return Math.PI - alpha - gamma;
	}

    public static Punto inter( Punto a, Punto b, Punto c, Punto d ){
		return Trigo.inter( new Recta( a, b ), new Recta( a, b ) );
	}
    public static Punto inter( Recta r1, Recta r2 ){
		if( r1.gxl() > r2.gxb() || r1.gxb() < r2.gxl() ||
			r1.gyl() > r2.gyb() || r1.gyb() < r2.gyl() )
				return null;
        double delta = Trigo.angle( r2.gb(), r1.ga() r2.ga() );
        double omega = Math.PI - alpha - delta;
        double dg = Trigo.sinlaw( omega, r1.ga().distancia(r2.ga()), alpha, null );
		return r2.pat( dg );        
    }

	public static double sinlaw(Double alpha, Double da, Double betta, Double db ){
        if( da == null )
            return db * ( sin(betta) / sin(alpha) );
        else if( db == null )
		    return da * ( sin(alpha) / sin(betta) );
        if( alpha == null )
            return asin( ( da / db ) * sin(alpha) );
        else if( betta == null )
		    return asin( ( db / da ) * sin(betta) );
        else return null;
	}
}
