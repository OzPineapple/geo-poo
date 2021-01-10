public class main{
    public static void main( String[] args ){
        Rectangulo r1c1 = new Rectangulo( "r1c1", 3,7,2,4 );
        Rectangulo r2c1 = new Rectangulo( "r2c1", 5,10,3,7 );
        Rectangulo r1c2 = new Rectangulo( "r1c2", -3,-9,8,2 );
        Rectangulo r2c2 = new Rectangulo( "r2c2", -4,-7,6,4 );
        Rectangulo r1c3 = new Rectangulo( "r1c3", -7,-3,-5,-2 );
        Rectangulo r2c3 = new Rectangulo( "r2c3", -6,-4,-7,-3 );
        Rectangulo r1c4 = new Rectangulo( "r1c4", 2,5,-6,-3);
        Rectangulo r2c4 = new Rectangulo( "r2c4", 4,8,-8,-4 );

	System.out.println("Rectangulos");
        System.out.println( r1c1.toString() );
        System.out.println( r2c1.toString() );
        System.out.println( r1c2.toString() );
        System.out.println( r2c2.toString() );
        System.out.println( r1c3.toString() );
        System.out.println( r2c3.toString() );
        System.out.println( r1c4.toString() );
        System.out.println( r2c4.toString() );

	System.out.println("Areas");
        System.out.println( r1c1.area() );
        System.out.println( r2c1.area() );
        System.out.println( r1c2.area() );
        System.out.println( r2c2.area() );
        System.out.println( r1c3.area() );
        System.out.println( r2c3.area() );
        System.out.println( r1c4.area() );
        System.out.println( r2c4.area() );

        Rectangulo u1 = r1c1.union(r2c1);
        Rectangulo u2 = r1c2.union(r2c2);
        Rectangulo u3 = r1c3.union(r2c3);
        Rectangulo u4 = r1c4.union(r2c4);

	System.out.println("Uniones");
        System.out.println( u1.toString() );
        System.out.println( u2.toString() );
        System.out.println( u3.toString() );
        System.out.println( u4.toString() );

        Rectangulo i1 = r1c1.inter(r2c1);
        Rectangulo i2 = r1c2.inter(r2c2);
        Rectangulo i3 = r1c3.inter(r2c3);
        Rectangulo i4 = r1c4.inter(r2c4);

	System.out.println("Intersecciones");
        System.out.println( i1.toString() );
        System.out.println( i2.toString() );
        System.out.println( i3.toString() );
        System.out.println( i4.toString() );
    }
}
