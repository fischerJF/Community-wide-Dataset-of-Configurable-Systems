package SplatOutput___SAC;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class EscreverArquivo {

	private File file;

	public EscreverArquivo(String arquivo) {
		File dir = new File(arquivo);
		this.file = dir;
	}
	
	
	public void escrever(String str){		
		
		try {
			FileWriter fr = new FileWriter(file);
			str= str.replace("*", " ");
			fr.write(str);			
			fr.close();
			//System.out.println("Escrita concluida com sucesso");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Falha ao escrever no arquivo");
			e.printStackTrace();
			
		}
	}
	
	
}
