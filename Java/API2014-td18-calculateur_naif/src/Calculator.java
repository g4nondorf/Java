public class Calculator {
	public static void main(String[] args){ 
	  if(args.length > 0){
		double r = Double.parseDouble(args[0]);
		System.out.print(args[0]);
		for(int i=0; i+2<args.length; i=i+2){
                        System.out.print(args[i+1]);
                        System.out.print(args[i+2]);
			double m = Double.parseDouble(args[i+2]);
			char op = args[i+1].charAt(0);
			switch(op){
				case '+' : r = r + m; break;
				case '-' : r = r - m; break;
				case '*' : r = r * m; break;
				case '/' : r = r / m;break;
				case '%' : r = r % m; break;
				default : System.out.println("Operation invalide");
						System.exit(0);
			}
			//System.out.print(args[i+1] + args[i+2]);
		} 
		System.out.println(" = " + r);
	}
        }
}

