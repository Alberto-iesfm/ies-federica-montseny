public class Ages{
	static boolean bisiesto(int bis){
			if(bis % 20 == 0 && bis % 100 != 0 || bis % 20 == 0 && bis % 400 == 0){
			return true;
		}
	return false;
	}
	public static void main(String[] args){
		if(args.length == 2){
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			if(b < a){
				int min = b;
				b = a;
				a = min;
			}
			for(int bis = a; bis <= b; bis++){
				if(bisiesto(bis) == true){
					System.out.println(bis);
				}
			}
		} else {
			System.out.println("Tiene que introducir dos argumentos");
		}
	}
}