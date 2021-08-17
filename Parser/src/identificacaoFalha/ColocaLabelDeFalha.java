package identificacaoFalha;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import SplatOutput.EscreverArquivo;
import SplatOutput.ReadFile;
import SplatOutput.TargetSystem;
import variability.variabilityCount;

public class ColocaLabelDeFalha {
	static String saida="";
	public void leitor(String arquivo, String classe) {

		File dir = new File(arquivo);

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();
		ArrayList<String> features= new ArrayList<String>();
        String conf="";
        
		for (int i = 0; i < listas.size(); i++) {

				conf=listas.get(i);
				//System.out.println(conf);
				if (listas.get(i).contains(classe)) {
//					System.out.println(listas.get(i)+",1");
					saida+=listas.get(i)+",1"+"\n";
				}else if (!listas.get(i).contains("file,class,type,cbo,wmc,dit,noc,rfc,lcom,nom,nopm,nosm,nof,nopf,nosf,nosi,loc")){
//					System.out.println(listas.get(i)+",0");
					saida+=listas.get(i)+",0"+"\n";
				}
		      
		}
	}
	
	
public static void main(String[] args) {
		
	
		//****Parametros para indicação da falha*****//
	   
	   //diretorios onde estao os arquivos .csv de metricas
	   String path = "metricasSistemas/";
	
	   //arquivo de saida com o csv preenchido
	    String nome="FeatureAMP4_2.csv";
		
	    //classe que deve ser colocado o label 1 indicando a falha
		String classe="FeatureAmp,class";
		
		
		
		String fileName;
		String fileNameAndPath = null;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		ColocaLabelDeFalha falha= new ColocaLabelDeFalha();
		
	
		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				fileName = listOfFiles[i].getName();
				try {
					fileNameAndPath = path + fileName;
					System.err.println(fileNameAndPath);
					
					falha.leitor(fileNameAndPath, classe);
				} catch (Exception e) {
					System.out.println(
							"Erro ao processar o arquivo %s com a mensagem: %s" + fileNameAndPath + e.getMessage());
				}
				// }
			}

		}
		
		
	       EscreverArquivo escrever= new EscreverArquivo(nome);
		   escrever.escrever(saida);
		System.out.println(saida);
		
		System.out.println("\n\nTodos os arquivos foram processados.");

	}

}
