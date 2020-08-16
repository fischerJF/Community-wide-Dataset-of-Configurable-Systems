package IncLing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import IncLingSpecification.Specification;
import splat.Variables;


public class IncLing extends IncLingAdapter {

	private int covarege;
	private int time;
	private ArrayList<Combination> combsLeft;
	private ArrayList<Combination> combsFinal;
	private ArrayList<Combination> combsForTest;
	private ArrayList<Combination> featuresExcluded;
	private ArrayList<Combination> combsNew;
	private ArrayList<Combination> combsOld;
	private ArrayList<String> featureName;
	private FeatureRank rank;
	private Specification configuration;

	public IncLing(int covarege, int time, ArrayList<String> featureName, Specification conf, Variables vars) {
		this.covarege = covarege;
		this.time = time;
		this.configuration= conf;
		combsLeft = new ArrayList<Combination>();
		combsFinal = new ArrayList<Combination>();
		combsForTest = new ArrayList<Combination>();
		featuresExcluded = new ArrayList<Combination>();
		combsNew = new ArrayList<Combination>();
		combsOld = new ArrayList<Combination>();
		this.featureName =featureName;
		rank = new FeatureRank();
		System.out.println("Inicio");
		pairWiseConfigurationGenerator(vars);
		generateCombinations();
		buildConfigurations();

		autoComplete();
		// apenas para verificação do algoritmo
		sortCombination();
		verificarDuplicados();

		isSatisfiable();
		// testa os produtos criados com a suíte de teste
//		executeJunitTestCase();
	}
	public ArrayList<Combination> getCombsForTest(){
		return combsForTest;
	}

	// linha 5 Gera as combinações segundo a estratégia do pairWise
	private void pairWiseConfigurationGenerator(Variables vars) {
		combsLeft = callPairWise(vars);

	}

	// private void

	// linha 6
	// gera as combinações válidas
	private void generateCombinations() {
		int cont = 0;
		ArrayList<Combination> aux = new ArrayList<Combination>();
		for (Combination combination : combsLeft) {
			System.out.println("cont:" + cont + combination.getListFeatures().get(0).getNameForGuidsl() + " - "
					+ combination.getListFeatures().get(1).getNameForGuidsl());
			if (configuration.validPar(combination.getListFeatures().get(0).getNameForGuidsl(),
					combination.getListFeatures().get(1).getNameForGuidsl())) {
				aux.add(combination);
			}
			cont++;
		}
		combsLeft = aux;
	}

	// linhas 7 a 17
	// int covarege, int time
	private void buildConfigurations() {
		// long start = System.currentTimeMillis();
		// long elapsed=0;
		// int count=0;
		while (/* count<covarege && elapsed<time */!combsLeft.isEmpty()) {

			updateFrequency();
			sort();
			resetCombsNew();
//			System.out.println("\n\n\n ");
			for (int i = 1; i < rank.getRankList().size(); i++) {
				for (int j = 0; j < i; j++) {
					getCombinations(rank.getRankList().get(i), rank.getRankList().get(j));
					testPrintCombNew();
				}
			}
			exclusionOfDiscoveredConfigurations();
			// elapsed = System.currentTimeMillis() - start;
			generateAndReturnProduct();

			if (combsNew.isEmpty()) {
				return;
			}
		}

	}

	private void autoComplete() {
		Combination combination;
		for (int i = 0; i < combsFinal.size(); i++) {
			combination = combsFinal.get(i);
//			if (i == 19) {
////				System.out.println();
//			}
			for (String feature : featureName) {
//				System.out.println("feature: " + feature);
				if (!isFeatureInCombsNew(combination, feature)) {
					FeatureIncling f = new FeatureIncling(feature, "0");
					combination.add(f);
					if (!configuration.validCombination(combination)) {
						// combination=removeCombsFinal(combination,f);
						combination.setListFeatures(removeCombsFinal(combination, f));
						combination.add(new FeatureIncling(feature, "1"));
//						System.out.println(configuration.validCombination(combination));
					}
				}
			}
			if(configuration.thereIsBase()) {
				if (!isFeatureInCombsNew(combination, "BASE")) {
				   combination.add(new FeatureIncling("BASE", "1"));
				}
			}
//			System.out.println("i:" + i + "    - tamanho:  " + combination.getListFeatures().size());
//			System.out.println(configuration.validCombination(combination));
		}

	}

	private boolean isFeatureInCombsNew(Combination combination, String feature) {
		for (FeatureIncling f : combination.getListFeatures()) {

			if (f.getName().equals(feature)) {
				return true;
			}
		}
		return false;
	}

	private void sortCombination() {
		for (Combination combination : combsFinal) {
			Collections.sort(combination.getListFeatures(), Collections.reverseOrder(new Comparator<FeatureIncling>() {

				@Override
				public int compare(FeatureIncling f1, FeatureIncling f2) {
					return f1.getName().compareTo(f2.getName());
				}
			}));

		}
	}

	// armazena a nova configuração final encontrada
	private void generateAndReturnProduct() {
		Combination auxComb = new Combination();
		for (Combination comb : combsNew) {
			for (FeatureIncling f : comb.getListFeatures()) {
				auxComb.add(f);
//				System.err.println(f.getName() + " ");
			}
		}
		combsFinal.add(auxComb);
	}

	// linha 9
	private void updateFrequency() {
		rank.resetRank();
		for (Combination combination : combsLeft) {
			for (FeatureIncling f : combination.getListFeatures()) {
				rank.updateRank(f);
			}
		}
	}

	// linh 10
	private void sort() {
		rank.sort();
	}

	private void getCombinations(FeatureHeuristic f1, FeatureHeuristic f2) {

		ArrayList<Combination> combsLeft = new ArrayList<Combination>();

		// Feature pair 1
		combsLeft.add(totalCombinationsOfFeatures(f1, f2, "0", "0"));

		// Feature pair 2
		combsLeft.add(totalCombinationsOfFeatures(f1, f2, "0", "1"));

		// Feature pair 3
		combsLeft.add(totalCombinationsOfFeatures(f1, f2, "1", "0"));

		// Feature pair 4
		combsLeft.add(totalCombinationsOfFeatures(f1, f2, "1", "1"));

		addCombinations(combsLeft);
	}

	private Combination totalCombinationsOfFeatures(FeatureHeuristic f1, FeatureHeuristic f2, String f1State,
			String f2State) {
		FeatureIncling finc1;
		FeatureIncling finc2;
		// par1
		finc1 = new FeatureIncling();
		finc1.setName(f2.getFeatureName());
		finc1.setState(f1State);
		if (f1State.equals("0")) {
			finc1.setNameForGuidsl("-" + f2.getFeatureName() + "___");
		} else {
			finc1.setNameForGuidsl(f2.getFeatureName() + "___");
		}

		finc2 = new FeatureIncling();
		finc2.setName(f1.getFeatureName());

		finc2.setState(f2State);
		if (f2State.equals("0")) {
			finc2.setNameForGuidsl("-" + f1.getFeatureName() + "___");
		} else {
			finc2.setNameForGuidsl(f1.getFeatureName() + "___");
		}

		Combination c = new Combination();
		c.add(finc1);
		c.add(finc2);

		return c;
	}

	private void addCombinations(ArrayList<Combination> combsLeft) {

		for (Combination combination : combsLeft) {
//			System.out.print(" ********************* " + combination.getListFeatures().get(0).getName() + " - "
//					+ combination.getListFeatures().get(0).getState());
//			System.out.print(" &&&&&&&&&&& " + combination.getListFeatures().get(1).getName() + " - "
//					+ combination.getListFeatures().get(1).getState());
//			System.out.println("");
			if (!combsNewContains(combination))
				return;
		}

	}

	private boolean combsOldContains(Combination combination) {
		FeatureIncling f1 = combination.getListFeatures().get(0);
		FeatureIncling f2 = combination.getListFeatures().get(1);
		boolean fa = false;
		boolean fb = false;
		if (combsOld.isEmpty()) {
			return false;
		} else {
			for (Combination comb : combsOld) {
				for (FeatureIncling feature : comb.getListFeatures()) {
					// fa pertence a combsnew
					if (feature.getName().equals(f1.getName()) && feature.getState().equals(f1.getState())) {
						fa = true;
					}
					if (feature.getName().equals(f2.getName()) && feature.getState().equals(f2.getState())) {
						fb = true;
					}
				}
				if (fa && fb)
					return true;
				else {
					fa = false;
					fb = false;
				}
			}
		}
		return false;
	}

	private void addCombsOld(Combination combination) {
		combsOld.add(combination);
	}

	private boolean combsNewContains(Combination combination) {
		FeatureIncling f1 = combination.getListFeatures().get(0);
		FeatureIncling f2 = combination.getListFeatures().get(1);
		boolean fa = false;
		boolean fb = false;
		if (combsNew.isEmpty()) {
			// verifica se é uma configuração proibida
			// caso não seja coloca na lista do combsNew
			if (!combsOldContains(combination)) {
				combsNew.add(combination);
				if (!configuration.validPar(combination.getListFeatures().get(0).getNameForGuidsl(),
						combination.getListFeatures().get(1).getNameForGuidsl())) {
					combsNew.remove(combination);
					return true;
				} else {
					addCombsOld(combination);
					return false;
				}
			}

		} else {
			for (Combination comb : combsNew) {
				for (FeatureIncling feature : comb.getListFeatures()) {
					// fa pertence a combsnew
					if (feature.getName().equals(f1.getName())) {
						fa = true;
					}
					if (feature.getName().equals(f2.getName())) {
						fb = true;
					}
				}
			}

			if (!fa && !fb) {
				if (!combsOldContains(combination)) {
					combsNew.add(combination);
					if (!configuration.validArrayCombination(combsNew)) {
						combsNew.remove(combination);
						return true;
					} else {
						addCombsOld(combination);
						return false;
					}
				}
			}
		}
		return true;
	}

	private void verificarDuplicados() {
		int contDuplic = 0;
		int contNDuplic = 0;

		for (Combination comb : combsFinal) {
			if (verificarDuplicadosCombsFinal(comb)) {
				contDuplic++;
			} else {
				contNDuplic++;
			}
			addCombsForTest(comb);

		}
		// apenas para impressao das configurações encontradas
////		System.out.println();
//		for (Combination c : combsForTest) {
//			for (FeatureIncling f : c.getListFeatures()) {
//				System.out.print(f.getName() + ":" + f.getState()+" ");
//			}
////			System.out.println();
//		}

//		System.out.println("duplicados:" + contDuplic);
//		System.out.println("Nao duplicados:" + contNDuplic);
	}

	private boolean verificarDuplicadosCombsFinal(Combination comb2) {
		int cont = 0;
		for (Combination comb : combsFinal) {
			int index = 0;

			boolean controle = true;
			int i = 0;
			while (i < comb.getListFeatures().size() && controle) {
				FeatureIncling f = comb.getListFeatures().get(i);
				if (f.getName().equals(comb2.getListFeatures().get(index).getName())
						&& f.getState().equals(comb2.getListFeatures().get(index).getState())) {
					index++;
				} else {
					controle = false;

				}
				i++;
			}
			if (controle)
				cont++;
		}
		if (cont > 1)
			return true;
		else
			return false;
	}

	private boolean isSatisfiable() {

//		for (Combination combination : combsFinal) {
//
//			System.out.println(configuration.validCombination(combination));
//		}

		return true;
	}

	private void testPrintCombNew() {
//		System.out.println("\n\n Print combnew: \n\n");
		for (Combination combination : combsNew) {
			for (FeatureIncling f : combination.getListFeatures()) {

//				System.out.println(f.getName() + ": " + f.getState() + " ");
			}
		}
	}

	private void resetCombsNew() {
		combsNew.clear();

	}

	private void exclusionOfDiscoveredConfigurations() {

//		System.out.println("\n combsleft");
		for (Combination comb : combsNew) {
			// combsLeftContains(comb);
			combsLeftContains(comb.getListFeatures().get(0), comb.getListFeatures().get(1));

		}
	}

	private void combsLeftContains(FeatureIncling fa, FeatureIncling fb) {
//		System.out.println("\n encontrar as features para restirar do combsleft");
		boolean fAisFound = false;
		boolean fBisFound = false;

		for (int index = 0; index < combsLeft.size(); index++) {

			fAisFound = false;
			fBisFound = false;
			for (FeatureIncling fCombsLeft : combsLeft.get(index).getListFeatures()) {

				if (fCombsLeft.getName().equals(fa.getName()) && fCombsLeft.getState().equals(fa.getState())) {
					fAisFound = true;
				}
				if (fCombsLeft.getName().equals(fb.getName()) && fCombsLeft.getState().equals(fb.getState())) {
					fBisFound = true;
				}

			}

			if (fAisFound && fBisFound) {
//				System.out.println("&&&&&&&&&&&&&&&& essa configuração tem que sair do combsleft");
				// combsLeft.remove(combsLeft.get(index));
				remove(index);
			}

			index++;
		}

	}

	private void remove(int i) {
		ArrayList<Combination> aux = new ArrayList<Combination>();
		for (int index = 0; index < combsLeft.size(); index++) {
			if (index != i) {
				aux.add(combsLeft.get(index));
			}
		}
		combsLeft = aux;

	}

	private ArrayList<FeatureIncling> removeCombsFinal(Combination combination, FeatureIncling feature) {
		Combination aux = new Combination();

		for (FeatureIncling f : combination.getListFeatures()) {
			if (f != feature) {
				aux.getListFeatures().add(f);

			}
		}

		return aux.getListFeatures();

	}

	private void addCombsForTest(Combination comb2) {
		boolean control;
		boolean contrFinal = false;

		for (Combination comb : combsForTest) {
			control = true;
			int index = 0;
			for (FeatureIncling f : comb.getListFeatures()) {
				if(comb.getListFeatures().size()==comb2.getListFeatures().size()) {
				if (!(f.getName().equals(comb2.getListFeatures().get(index).getName())
						&& f.getState().equals(comb2.getListFeatures().get(index).getState()))) {
					control = false;
				}
				}
				index++;
			}
			if (control)
				contrFinal = true;
		}
		if (!contrFinal || combsForTest.size() == 0) {
			combsForTest.add(comb2);
		}
	}

//	private void executeJunitTestCase() {
//
//		for (Combination combination : combsForTest) {
//			for (FeatureIncling f : combination.getListFeatures()) {
//				if (f.getName().equals("DIRECTED")) {
//					Configuration.DIRECTED = (f.getState().equals("0") ? false : true);
//				}
//				if (f.getName().equals("UNDIRECTED")) {
//					Configuration.UNDIRECTED = (f.getState().equals("0") ? false : true);
//				}
//				if (f.getName().equals("WEIGHTED")) {
//					Configuration.WEIGHTED = (f.getState().equals("0") ? false : true);
//				}
//				if (f.getName().equals("SEARCH")) {
//					Configuration.SEARCH = (f.getState().equals("0") ? false : true);
//				}
//				if (f.getName().equals("BFS")) {
//					Configuration.BFS = (f.getState().equals("0") ? false : true);
//				}
//				if (f.getName().equals("NUMBER")) {
//					Configuration.NUMBER = (f.getState().equals("0") ? false : true);
//				}
//				if (f.getName().equals("CONNECTED")) {
//					Configuration.CONNECTED = (f.getState().equals("0") ? false : true);
//				}
//				if (f.getName().equals("STRONGLYCONNECTED")) {
//					Configuration.STRONGLYCONNECTED = (f.getState().equals("0") ? false : true);
//				}
//				if (f.getName().equals("CYCLE")) {
//					Configuration.CYCLE = (f.getState().equals("0") ? false : true);
//				}
//				if (f.getName().equals("MSTPRIM")) {
//					Configuration.MSTPRIM = (f.getState().equals("0") ? false : true);
//				}
//				if (f.getName().equals("MSTKRUSKAL")) {
//					Configuration.MSTKRUSKAL = (f.getState().equals("0") ? false : true);
//				}
//
//				if (f.getName().equals("SHORTEST")) {
//					Configuration.SHORTEST = (f.getState().equals("0") ? false : true);
//				}
//
//				/* Chama a bibioteca core do junit para rodar a suite de testes */
//				JUnitCore junit = new JUnitCore();
//				junit.addListener(new TextListener(System.out));
//				org.junit.runner.Result result = junit.run(ConnectedTests_Caio.class, CycleRelated_Caio.class,
//						GraphReturnTests_Caio.class, MultiFeatureTest_Caio.class, NumberTests_Caio.class,
//						TestSuite_NEW.class);
//				/* fim core junit */
//			}
//		}
//	}

}