public class main{
    public static void main( String[] args ){
		Punto[] ps = {
			new Punto(3,2),
			new Punto(7,4),
			new Punto(5,3),
			new Punto(10,7),
			new Punto(-7,4),
			new Punto(-4,6),
			new Punto(-9,2),
			new Punto(-3,8),
			new Punto(-7,-5),
			new Punto(-3,-2),
			new Punto(-8,-7),
			new Punto(2,-6),
			new Punto(5,-3),
			new Punto(4,-8),
			new Punto(8,-4)
		};
		Rectangulo[][] r = {
			{ new Rectangulo( "r1c1", ps[0], ps[1] ),	new Rectangulo( "r2c1", ps[2], ps[3] )	},
			{ new Rectangulo( "r1c2" ),					new Rectangulo( "r2c2" )				},
			{ new Rectangulo( "r1c3", -7,-3,-5,-2 ),	new Rectangulo( "r2c3", -6,-4,-7,-3 )	},
			{ new Rectangulo( "r1c4", 2,5,-6,-3),		new Rectangulo( "r2c4", 4,8,-8,-4 )		}
		};
		r[1][0].sa( ps[4] ); r[1][0].sb( ps[5] );
		r[1][1].sa( ps[6] ); r[1][1].sb( ps[7] );

		print("Rectangulos");
		for( Rectangulo c[] : r )
			for( Rectangulo rec : c )
				print( rec.toString() );

		print("Comparar");
		for( Rectangulo c[] : r )
			for( int i = 0; i < c.length - 1; i++)
				print( c[0].gn() + " ? " + c[1].gn() + " : " + c[i].comparar(c[i+1]) );
		
		print("Union");
		for( Rectangulo c[] : r )
			for( int i = 0; i < c.length - 1; i+=2 )
				print( c[0].gn() + " ∪ " + c[1].gn() + " : " +c[i].union(c[i+1]).toString() );
		
		print("Interseccion");
		for( Rectangulo c[] : r )
			for( int i = 0; i < c.length - 1; i+=2 )
				print( c[0].gn() + " ∩ " + c[1].gn() + " : " +c[i].inter(c[i+1]).toString() );
		
		print("¿Esta dentro?");
		for( Rectangulo c[] : r )
			for( int i = 0; i < c.length - 1; i+=2 )
				print( c[0].gn() + " ← " + c[1].gn() + " : " +c[i].dentro(c[i+1]) );

		print("Cuandrante");
		for( Rectangulo c[] : r )
			for( Rectangulo i : c )
				print( i.gn() + " : " + i.cuadRect() );

		print("Mover +1+1");
		for( Rectangulo c[] : r )
			for( Rectangulo i : c )
				print( i.moverRect( i.ga().add(new Punto(1,1)) , i.gb().add(new Punto(1,1)) ).toString() );
    }

	public static void print( String s )
		{System.out.println(s);}
}
