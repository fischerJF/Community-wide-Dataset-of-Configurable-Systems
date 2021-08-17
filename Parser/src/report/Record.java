package report;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class Record {

	public List <Report> report= new ArrayList<>(); 
	
	
	public void record() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		Writer writer = Files.newBufferedWriter(Paths.get("date.csv"));
        StatefulBeanToCsv<Report> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

        beanToCsv.write(report);

        writer.flush();
        writer.close();
	}
	public void record2() throws IOException {
		String[] cabecalho = {
		"Name","NTF","Scattering","Constructors","Methods","LoCs", "VP","Tangling",
		"DT_Max", "DT_Min" ,"NGOr_Max",	"NGXOr_Max","BF_Max","NO",
		"NTop",	"NLeaf","NVCF", "NomesFeatures"};

        List<String[]> linhas = new ArrayList<>();
        for (Report r : report) {
        linhas.add(new String[]{
        r.nomeClasse,r.NTF, r.Scattering, r.constructors, r.methods, 
        r.LOCs, r.VP, r.Tangling, r.DT_Max, r.DT_Min, r.NGOr_Max, r.NGXOr_Max,
        r.BF_Max_Branching, r.NO, r.NTop, r.NLeaf, r.NVCF, r.nomeFeature});
        }
        Writer writer = Files.newBufferedWriter(Paths.get("date.csv"));
        CSVWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeNext(cabecalho);
        csvWriter.writeAll(linhas);

        csvWriter.flush();
        writer.close();
	}
}
