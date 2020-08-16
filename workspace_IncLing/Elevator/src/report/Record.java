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
		String[] cabecalho = {"configuration", "trace", "description"};

        List<String[]> linhas = new ArrayList<>();
        for (Report r : report) {
        linhas.add(new String[]{r.configuration,r.trace, r.description});
        }
        Writer writer = Files.newBufferedWriter(Paths.get("date.csv"));
        CSVWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeNext(cabecalho);
        csvWriter.writeAll(linhas);

        csvWriter.flush();
        writer.close();
	}
}
