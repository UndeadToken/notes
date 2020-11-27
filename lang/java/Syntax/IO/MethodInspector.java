package IO;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodInspector {

	public static void main(String[] args) {
		Class inspect;
		try {
			 if (args.length > 0) 
				 inspect = Class.forName(args[0]);
			 else
				 inspect = Class.forName("MethodInspector");
			 
			 Method[] methods = inspect.getDeclaredMethods();
			 for (int i = 0; i < methods.length; i++) {
				 Method methVal = methods[i];
				 Class returnVal = methVal.getReturnType();
				 int mods = methVal.getModifiers();
				 String modVal = Modifier.toString(mods);
				 Class[] paramVal = methVal.getParameterTypes();
				 StringBuffer params = new StringBuffer();
				 
				 for(int j = 0; j < paramVal.length; j++) {
					 if(j >0)
						 params.append(", ");
					 params.append(paramVal[j].getName());
				 }
			 }
			 
		} catch(ClassNotFoundException cnf) {
			System.out.println(cnf.toString());
		}
	}

}
