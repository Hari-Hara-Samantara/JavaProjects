package CJ.Proj1.newInstance;

public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//Loads the Class
		Class c = Class.forName(args[0]);
		//Create the Object
		Object obj = c.newInstance();
		
		System.out.println(obj.getClass()+" "+obj.hashCode()+" "+obj);
	}
}
