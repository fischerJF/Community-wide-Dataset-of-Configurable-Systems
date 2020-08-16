package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	private final File file;
	private List<String> listas;

	public ReadFile(File file) {

		this.file = file;
		this.listas = new ArrayList<String>();
		this.criaListadeLinhasdoArquivo();
	}

	private void criaListadeLinhasdoArquivo() {

		List<String> dataFile = getDataFile();
		for (int x = 0; x < dataFile.size(); x++) {
				listas.add(dataFile.get(x));
		}

	}

	/** Faz a leitura do arquivo e retorna os dados em uma lista */
	@SuppressWarnings("resource")
	public List<String> getDataFile() {

		List<String> data = new ArrayList<String>();
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(file));

			try {

				while (br.ready()) {
					String line = br.readLine();
					data.add(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return data;
	}

	/** Separa cada linha do em arquivo em uma array de elementos */
	public List<String> splitLine(String line) {
		List<String> novo = new ArrayList<String>();
		
		String[] split = line.split(";");

		if (split.length <= 0)
			return null;

		for (String string : split) {
			if (!string.isEmpty())
				novo.add(string);
		}

		return novo;
	}

	public ArrayList<String> splitLine2(String line) {
		ArrayList<String> novo = new ArrayList<String>();
		
		String[] split = line.split(" ");

		if (split.length <= 0)
			return null;

		for (String string : split) {
			if (!string.isEmpty())
				novo.add(string);
		}

		return novo;
	}

	

	public List<String> getListas() {
		return listas;
	}

}
