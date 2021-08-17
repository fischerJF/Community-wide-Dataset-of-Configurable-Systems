package IncLingInstrumentation;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import SplatOutput.ReadFile;

public class arquivoConfiguration {

	
	public void leitorIncLing(String arquivo) {

		File dir = new File(arquivo);

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();
       
		
        for (int i = 0; i < listas.size(); i++) {

        	//configuration
        	String min=listas.get(i);
        	String mai=min.toUpperCase();	
//			System.out.println(listas.get(i));
			
//        	System.out.println("public static String set"+mai+"() {");
//			System.out.println("return ("+min+") ? \""+mai+"___\" : \"-"+mai+"___\" ;");
//			System.out.println("}");
			
			
			/*System.out.println("if (f.getName().equals(\""+mai+"\")) {");
			System.out.println("Configuration."+min+" = (f.getState().equals(\"0\") ? false : true);");
			System.out.println("}");*/
//			
			//product print 
			
        	System.out.println("\""+mai+":\"+Configuration." +min+"+");
        	
        	//product valid
//        	
//      	System.out.println("t.add(set"+mai+"());");
        	
        	//incialização splat
//        	System.out.println(mai+"___,");
        	
        	//splat variables
        //	this.BASE___ = new FeatureVar("BASE___");
        	//System.out.println("this."+mai+"___  = new FeatureVar(\""+mai+"___\""+");");
        	
        	//feature name
        	
//        			System.out.println("featureName.add(\""+mai+"\");");
        	
        	//feature model
        	//System.out.print("["+mai+"___]  ");
        	
        	//splat init
        	
//        	System.out.println("state.put("+mai+"___, \"?\");");
        	
        	
		} 
	}
        
        
	public static void main(String[] args) {
		System.out.println("");
		arquivoConfiguration ler = new arquivoConfiguration();

		ler.leitorIncLing("src/IncLingInstrumentation/Configuration.txt");
		
		
		
		System.out.println("");
	}
}
