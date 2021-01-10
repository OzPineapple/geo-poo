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
        Recta r1 = new Recta( a, b );
        Recta r2 = new Recta( b, c );
        double alpha = Trigo.angle( r1.gb(), r1.ga() r2.ga() );
        double delta = Trigo.angle( r2.gb(), r1.ga() r2.ga() );
        double omega = Math.PI - alpha - delta;
        double dg = Trigo.sinlaw( omega, r1.ga().distancia(r2.ga()), alpha, null );
        
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