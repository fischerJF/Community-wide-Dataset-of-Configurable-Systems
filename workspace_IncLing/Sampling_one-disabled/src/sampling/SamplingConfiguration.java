package sampling;

import java.util.ArrayList;
import java.util.Random;

public class SamplingConfiguration {

	private SPL spl;

	private ArrayList<SPL> listConfiguration;

	public SamplingConfiguration(SPL spl) {

		this.spl = spl;
		listConfiguration = new ArrayList<SPL>();
	}

	public void one_Enabled() {

		for (int i = 0; i < spl.getOthersFeatureList().size(); i++) {

			SPL temp = new SPL();
			creatlistFeature(temp);

			for (int j = 0; j < spl.getOthersFeatureList().size(); j++) {
				if (j == i) {
					temp.getOthersFeatureList().get(j).setStatus(1);
				} else {
					temp.getOthersFeatureList().get(j).setStatus(0);
				}
			}
			listConfiguration.add(temp);
		}
	}

	public void one_Disabled() {

		for (int i = 0; i < spl.getOthersFeatureList().size(); i++) {

			SPL temp = new SPL();
			creatlistFeature(temp);

			for (int j = 0; j < spl.getOthersFeatureList().size(); j++) {

				if (j != i) {
					temp.getOthersFeatureList().get(j).setStatus(1);
				} else {
					temp.getOthersFeatureList().get(j).setStatus(0);
				}
			}
			listConfiguration.add(temp);
		}
	}

	public void most_Enabled_Disabled() {

		ArrayList<Integer> listPossibility = new ArrayList<Integer>();

		listPossibility = sortMostEnableDisabled(spl.getOthersFeatureList().size());

		int cont = 0;
		for (int i = 0; i < spl.getOthersFeatureList().size(); i++) {

			SPL temp = new SPL();
			creatlistFeature(temp);

			for (int j = 0; j < spl.getOthersFeatureList().size(); j++) {

					temp.getOthersFeatureList().get(j).setStatus(listPossibility.get(cont));
				cont++;
			}
			listConfiguration.add(temp);
		}

	}

	public void pairWise(int size, int with) {

		boolean control=true;
		for (int i = 0; i < spl.getOthersFeatureList().size(); i++) {
			SPL temp = new SPL();
			creatlistFeature(temp);
			for (int j = i; j < spl.getOthersFeatureList().size(); j++) {
				
				if(i!=j && control== true){
					temp.getOthersFeatureList().get(j).setStatus(1);
					temp.getOthersFeatureList().get(i).setStatus(1);
					control=false;
				}else{
					temp.getOthersFeatureList().get(j).setStatus(0);
				}
				
			}
			control=true;

			listConfiguration.add(temp);
		}

	}

	public ArrayList<SPL> getListConfiguration() {
		return listConfiguration;
	}

	public void creatlistFeature(SPL temp) {

		for (Feature f : spl.getOthersFeatureList()) {
			temp.addOthersFeature(new Feature());
		}
	}

	private ArrayList<Integer> sortValue(int size) {
		Random gerador = new Random();

		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
					temp.add(gerador.nextInt(2));
							}
		}
		return temp;
	}

	private ArrayList<Integer> sortMostEnableDisabled(int size) {
		ArrayList<Integer> temp = new ArrayList<Integer>();

		int contFalse = 0;
		int contTrue = 0;

		while (contTrue == contFalse) {
			temp = sortValue(size);
			contFalse = 0;
			contTrue = 0;

			for (Integer integer : temp) {
				if (integer == 0)
					contFalse++;
				else
					contTrue++;
			}

		}
		return temp;
	}

	public String printConfiguration() {
		int cont0 = 0;
		int cont1 = 0;

		String result = "";
		for (int j = 0; j < getListConfiguration().size(); j++) {
			result += "Product " + (j + 1)+": ";
			for (Feature feature : getListConfiguration().get(j).getOthersFeatureList()) {

				if (feature.getType() == FeatureType.MANDATORY) {
					result += "\t(" + feature.getStatus() + ")";
				} else {
					result += "\t" + feature.getStatus();
				}

				// apenas para teste

				if (feature.getStatus() == 0)
					cont0++;
				else
					cont1++;

			}
			result += "\n";
		}
		result += "\n#Enable: " + cont1 + "  #Disabled: " + cont0;
		return result;
	}
	
	

}
