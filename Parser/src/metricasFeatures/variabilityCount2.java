package metricasFeatures;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import SplatOutput.ReadFile;
import SplatOutput.TargetSystem;
import report.Record;
import report.RunReport;

public class variabilityCount2 {
	static int cont = 0;
	static String nomeClasse = "";
	public static ArrayList<Feature> features = new ArrayList<Feature>();
	public static ArrayList<Feature> featuresAux = new ArrayList<Feature>();
	public static ArrayList<Feature> espalhamento = new ArrayList<Feature>();

	public static ArrayList<M_Classes> metricas = new ArrayList<M_Classes>();
	static Record record = new Record();

	public static void inicialization(TargetSystem t) {

		// ATM
		if (t == TargetSystem.ATM) {
			ArrayList<CMF> cmf = new ArrayList<CMF>();
			cmf.add(new CMF("atm/ATMUserInterface.java", 2, 1, 6, 0, 10, 0, 1, 0, 0, 0, 0, 0, 0, 42));
			features.add(new Feature("ADMIN_CONTROL", cmf, 1, 0, 1, 54, 1, 1, 2, 32, 39.02));

			ArrayList<CMF> cmf2 = new ArrayList<CMF>();
			cmf2.add(new CMF("atm/ATM.java", 7, 28, 1, 0, 7, 84, 17, 14, 0, 17, 0, 5, 0, 121));
			cmf2.add(new CMF("atm/ATMUserInterface.java", 1, 1, 6, 0, 11, 0, 1, 0, 0, 0, 0, 0, 0, 38));
			cmf2.add(new CMF("atm/BalanceInquiry.java", 3, 3, 2, 0, 9, 3, 3, 2, 0, 0, 0, 0, 0, 34));
			features.add(new Feature("BALANCE_INQUIRY", cmf2, 3, 1, 20, 243, 7, 3, 2, 32, 39.02));

			ArrayList<CMF> cmf3 = new ArrayList<CMF>();
			cmf3.add(new CMF("atm/Deposit.java", 5, 10, 2, 0, 9, 1, 2, 2, 0, 0, 0, 0, 0, 56));
			cmf3.add(new CMF("atm/ATM.java", 7, 24, 1, 0, 9, 51, 15, 12, 0, 17, 0, 5, 0, 115));
			cmf3.add(new CMF("atm/ATMUserInterface.java", 1, 1, 6, 0, 11, 0, 1, 0, 0, 0, 0, 0, 0, 38));
			features.add(new Feature("DEPOSITING", cmf3, 3, 1, 17, 264, 7, 3, 2, 42, 51.22));

			ArrayList<CMF> cmf4 = new ArrayList<CMF>();
			cmf4.add(new CMF("atm/ATM.java", 6, 8, 1, 0, 6, 0, 2, 0, 0, 17, 0, 5, 0, 60));
			features.add(new Feature("LOGGING", cmf4, 1, 0, 2, 71, 8, 4, 2, 41, 50.00));

			ArrayList<CMF> cmf5 = new ArrayList<CMF>();
			cmf5.add(new CMF("atm/ATM.java", 6, 8, 1, 0, 6, 0, 2, 0, 0, 17, 0, 5, 0, 60));
			cmf5.add(new CMF("atm/Screen.java", 2, 4, 1, 0, 0, 6, 4, 4, 0, 0, 0, 0, 0, 17));
			cmf5.add(new CMF("atm/Withdrawal.java", 5, 6, 2, 0, 6, 0, 2, 2, 0, 4, 0, 1, 0, 46));
			features.add(new Feature("USER_INTERFACE", cmf5, 3, 3, 24, 237, 12, 4, 3, 64, 78.05));

			ArrayList<CMF> cmf6 = new ArrayList<CMF>();
			cmf6.add(new CMF("atm/ATM.java", 7, 13, 1, 0, 5, 0, 4, 1, 0, 17, 0, 5, 0, 76));
			features.add(new Feature("WITHDRAWING", cmf6, 1, 0, 4, 89, 7, 3, 2, 44, 53.66));

			ArrayList<CMF> cmf7 = new ArrayList<CMF>();
			cmf7.add(new CMF("atm/ATM.java", 3, 1, 6, 0, 10, 0, 1, 0, 0, 30, 17, 19, 0, 106));
			features.add(new Feature("WITHDRAWING_ALL_VALUES", cmf7, 1, 0, 1, 123, 2, 1, 2, 32, 39.02));
		}

		// BANKACCOUNT
		else if (t == TargetSystem.BANKACCOUNT) {

			ArrayList<CMF> cmf = new ArrayList<CMF>();
			cmf.add(new CMF("bankaccount/LogEntry.java", 1, 4, 1, 0, 0, 2, 4, 4, 0, 3, 0, 0, 0, 21));
			cmf.add(new CMF("bankaccount/Transaction.java", 1, 17, 1, 0, 6, 3, 3, 1, 1, 1, 0, 0, 1, 35));
			cmf.add(new CMF("bankaccount/Application.java", 1, 3, 1, 0, 2, 1, 3, 2, 0, 1, 1, 0, 0, 17));
			cmf.add(new CMF("bankaccount/Account.java", 0, 36, 1, 0, 5, 58, 13, 9, 0, 7, 6, 2, 0, 85));
			features.add(new Feature("bankaccount", cmf, 4, 2, 21, 210, 2, 2, 2, 6, 4.17));

			ArrayList<CMF> cmf1 = new ArrayList<CMF>();
			cmf1.add(new CMF("bankaccount/Account.java", 0, 2, 1, 0, 1, 1, 2, 0, 0, 0, 0, 0, 0, 12));
			features.add(new Feature("creditworthiness", cmf1, 1, 0, 2, 16, 2, 2, 2, 3, 02.08));

			ArrayList<CMF> cmf2 = new ArrayList<CMF>();
			cmf2.add(new CMF("bankaccount/Account.java", 0, 14, 1, 0, 1, 0, 2, 0, 0, 2, 0, 1, 0, 39));
			cmf2.add(new CMF("bankaccount/Application.java", 0, 2, 1, 0, 1, 1, 2, 1, 0, 0, 0, 0, 0, 9));
			features.add(new Feature("dailylimit", cmf2, 2, 0, 4, 57, 3, 2, 2, 6, 4.17));

			ArrayList<CMF> cmf3 = new ArrayList<CMF>();
			cmf3.add(new CMF("bankaccount/Account.java", 0, 1, 1, 0, 0, 0, 1, 0, 0, 2, 0, 1, 0, 11));
			cmf3.add(new CMF("bankaccount/Application.java", 0, 2, 1, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0, 20));
			features.add(new Feature("interest", cmf3, 2, 0, 3, 38, 1, 1, 2, 4, 2.77));

			ArrayList<CMF> cmf4 = new ArrayList<CMF>();
			cmf4.add(new CMF("bankaccount/Account.java", 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 9));
			features.add(new Feature("interestestimation", cmf4, 1, 0, 1, 11, 0, 0, 2, 2, 1.38));

			ArrayList<CMF> cmf5 = new ArrayList<CMF>();
			cmf5.add(new CMF("bankaccount/Account.java", 0, 3, 1, 0, 0, 0, 3, 0, 0, 1, 0, 0, 0, 21));
			features.add(new Feature("lock", cmf5, 1, 0, 3, 26, 0, 0, 2, 6, 4.19));

			ArrayList<CMF> cmf6 = new ArrayList<CMF>();
			cmf6.add(new CMF("bankaccount/LogEntry.java", 1, 4, 1, 0, 0, 0, 4, 4, 0, 3, 0, 0, 0, 23));
			features.add(new Feature("logging", cmf6, 1, 1, 0, 3, 1, 1, 0, 0, 0));

			ArrayList<CMF> cmf7 = new ArrayList<CMF>();
			cmf7.add(new CMF("bankaccount/Account.java", 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 3));
			features.add(new Feature("overdraft", cmf7, 1, 0, 0, 6, 0, 0, 2, 6, 4.17));

			ArrayList<CMF> cmf8 = new ArrayList<CMF>();
			cmf8.add(new CMF("bankaccount/Transaction.java", 1, 14, 1, 0, 6, 1, 2, 1, 1, 0, 0, 0, 1, 39));
			features.add(new Feature("transaction", cmf8, 1, 0, 2, 41, 1, 1, 2, 6, 4.16));

			ArrayList<CMF> cmf9 = new ArrayList<CMF>();
			features.add(new Feature("transactionlog", cmf9, 1, 0, 1, 4, 1, 1, 2, 0, 0.00));
		}
		// companies
		else if (t == TargetSystem.COMPANIES) {
			ArrayList<CMF> cmf = new ArrayList<CMF>();
			features.add(new Feature("ACCESS_CONTROL", cmf, 0, 0, 0, 0, 0, 0, 0, 0, 0));

			ArrayList<CMF> cmf1 = new ArrayList<CMF>();
			cmf1.add(new CMF("companies/EmployeeImpl.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 23));
			cmf1.add(new CMF("companies/Reducer.java", 7, 10, 1, 0, 5, 0, 5, 4, 0, 1, 0, 0, 0, 53));
			cmf1.add(new CMF("companies/ObservableSimpleList.java", 4, 20, 2, 0, 8, 9, 7, 7, 0, 1, 0, 0, 0, 63));
			cmf1.add(new CMF("companies/Model.java", 10, 15, 1, 0, 10, 17, 11, 10, 1, 3, 1, 0, 3, 136));
			cmf1.add(new CMF("companies/MaxDoubles.java", 2, 10, 1, 0, 1, 6, 4, 3, 1, 1, 0, 1, 1, 19));
			cmf1.add(new CMF("companies/CompanyImpl.java", 5, 7, 2, 0, 2, 3, 3, 3, 0, 0, 0, 0, 0, 26));
			cmf1.add(new CMF("companies/ProxyCompany.java", 4, 6, 1, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 33));
			cmf1.add(new CMF("companies/ProxyDepartment.java", 4, 6, 1, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 33));
			cmf1.add(new CMF("companies/CutCompany.java", 5, 4, 2, 0, 2, 1, 1, 1, 0, 0, 0, 0, 0, 20));
			cmf1.add(new CMF("companies/MainView.java", 1, 3, 6, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 35));
			cmf1.add(new CMF("companies/DepartmentImpl.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 28));
			cmf1.add(new CMF("companies/CompanyImpl___.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 25));
			cmf1.add(new CMF("companies/AddDoubles.java", 2, 6, 1, 0, 0, 6, 4, 3, 1, 1, 0, 1, 0, 15));
			cmf1.add(new CMF("companies/SimpleLinkedList.java", 2, 3, 1, 0, 3, 0, 3, 3, 0, 1, 0, 0, 0, 19));
			cmf1.add(new CMF("companies/AbstractView.java", 1, 11, 5, 3, 3, 0, 3, 3, 0, 5, 0, 1, 0, 64));
			cmf1.add(new CMF("companies/EmployeeView.java", 2, 5, 6, 0, 7, 0, 1, 0, 0, 1, 0, 0, 0, 82));
			cmf1.add(new CMF("companies/SimpleList.java", 1, 2, 1, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 8));
			cmf1.add(new CMF("companies/ProxyEmployee.java", 4, 6, 1, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 28));
			cmf1.add(new CMF("companies/Walker.java", 5, 15, 1, 0, 3, 55, 5, 5, 0, 0, 0, 0, 0, 67));
			cmf1.add(new CMF("companies/AddToList.java", 1, 1, 2, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 4));
			cmf1.add(new CMF("companies/Monoid.java", 1, 2, 1, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 8));
			cmf1.add(new CMF("companies/ChangeList.java", 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 7));
			cmf1.add(new CMF("companies/RemoveFromList.java", 1, 1, 2, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 4));
			cmf1.add(new CMF("companies/Controller.java", 12, 29, 1, 0, 18, 0, 7, 7, 0, 2, 0, 0, 0, 148));
			cmf1.add(new CMF("companies/EmployeeImpl___.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 24));
			cmf1.add(new CMF("companies/DepartmentView.java", 2, 7, 6, 0, 7, 0, 1, 0, 0, 0, 0, 0, 0, 73));
			cmf1.add(new CMF("companies/DepartmentImpl___.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 28));
			cmf1.add(new CMF("companies/ReturningVisitor.java", 4, 3, 1, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 9));
			cmf1.add(new CMF("companies/CompanyView.java", 2, 7, 6, 0, 7, 0, 1, 0, 0, 0, 0, 0, 0, 72));
			cmf1.add(new CMF("companies/VoidVisitor.java", 3, 3, 1, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 9));
			features.add(new Feature("CUT_NO_DEPARTMENT", cmf1, 29, 11, 59, 1527, 31, 17, 3, 0, 0.00));

			ArrayList<CMF> cmf2 = new ArrayList<CMF>();
			cmf2.add(new CMF("companies/ProxyDepartment.java", 4, 6, 1, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 33));
			cmf2.add(new CMF("companies/CompanyView.java", 2, 7, 6, 0, 7, 0, 1, 0, 0, 0, 0, 0, 0, 72));
			cmf2.add(new CMF("companies/DepartmentImpl.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 28));
			cmf2.add(new CMF("companies/ObservableSimpleList.java", 4, 20, 2, 0, 8, 9, 7, 7, 0, 1, 0, 0, 0, 63));
			cmf2.add(new CMF("companies/CompanyImpl.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 25));
			cmf2.add(new CMF("companies/ChangeList.java", 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 7));
			cmf2.add(new CMF("companies/EmployeeImpl.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 23));
			cmf2.add(new CMF("companies/Walker.java", 5, 15, 1, 0, 3, 55, 5, 5, 0, 0, 0, 0, 0, 67));
			cmf2.add(new CMF("companies/DepartmentView.java", 2, 7, 6, 0, 7, 0, 1, 0, 0, 0, 0, 0, 0, 70));
			cmf2.add(new CMF("companies/VoidVisitor.java", 3, 3, 1, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 9));
			cmf2.add(new CMF("companies/Reducer.java", 7, 10, 1, 0, 5, 0, 5, 4, 0, 1, 0, 0, 0, 53));
			cmf2.add(new CMF("companies/Monoid.java", 1, 2, 1, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 8));
			cmf2.add(new CMF("companies/Controller.java", 11, 24, 1, 0, 12, 0, 2, 2, 0, 2, 0, 0, 0, 105));
			cmf2.add(new CMF("companies/CutCompany.java", 5, 4, 2, 0, 2, 1, 1, 1, 0, 0, 0, 0, 0, 21));
			cmf2.add(new CMF("companies/EmployeeView.java", 2, 5, 6, 0, 7, 0, 1, 0, 0, 1, 0, 0, 0, 83));
			cmf2.add(new CMF("companies/MainView.java", 1, 3, 6, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 35));
			cmf2.add(new CMF("companies/ProxyEmployee.java", 4, 6, 1, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 28));
			cmf2.add(new CMF("companies/Model.java", 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 31));
			cmf2.add(new CMF("companies/AddToList.java", 1, 1, 2, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 4));
			cmf2.add(new CMF("companies/RemoveFromList.java", 1, 1, 2, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 4));
			cmf2.add(new CMF("companies/EmployeeImpl___.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 23));
			cmf2.add(new CMF("companies/MaxDoubles.java", 2, 10, 1, 0, 1, 6, 4, 3, 1, 1, 0, 1, 1, 19));
			cmf2.add(new CMF("companies/AddDoubles.java", 2, 6, 1, 0, 0, 6, 4, 3, 1, 1, 0, 1, 0, 15));
			cmf2.add(new CMF("companies/ReturningVisitor.java", 4, 3, 1, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 9));
			cmf2.add(new CMF("companies/SimpleLinkedList.java", 2, 3, 1, 0, 3, 0, 3, 3, 0, 1, 0, 0, 0, 19));
			cmf2.add(new CMF("companies/DepartmentImpl___.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 28));
			cmf2.add(new CMF("companies/CompanyImpl___.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 23));
			cmf2.add(new CMF("companies/ProxyCompany.java", 4, 6, 1, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 33));
			cmf2.add(new CMF("companies/AbstractView.java", 1, 11, 5, 3, 3, 0, 3, 3, 0, 5, 0, 1, 0, 65));
			cmf2.add(new CMF("companies/SimpleList.java", 1, 2, 1, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 8));
			features.add(new Feature("CUT_NO_MANAGER", cmf2, 29, 8, 46, 1345, 31, 17, 3, 1, 0.52));

			ArrayList<CMF> cmf3 = new ArrayList<CMF>();
			cmf3.add(new CMF("companies/ProxyDepartment.java", 4, 6, 1, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 33));
			cmf3.add(new CMF("companies/CompanyView.java", 2, 7, 6, 0, 7, 0, 1, 0, 0, 0, 0, 0, 0, 72));
			cmf3.add(new CMF("companies/DepartmentImpl.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 28));
			cmf3.add(new CMF("companies/ObservableSimpleList.java", 4, 20, 2, 0, 8, 9, 7, 7, 0, 1, 0, 0, 0, 63));
			cmf3.add(new CMF("companies/CompanyImpl.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 25));
			cmf3.add(new CMF("companies/ChangeList.java", 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 7));
			cmf3.add(new CMF("companies/EmployeeImpl.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 23));
			cmf3.add(new CMF("companies/Walker.java", 5, 15, 1, 0, 3, 55, 5, 5, 0, 0, 0, 0, 0, 67));
			cmf3.add(new CMF("companies/DepartmentView.java", 2, 7, 6, 0, 7, 0, 1, 0, 0, 0, 0, 0, 0, 70));
			cmf3.add(new CMF("companies/VoidVisitor.java", 3, 3, 1, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 9));
			cmf3.add(new CMF("companies/Reducer.java", 7, 10, 1, 0, 5, 0, 5, 4, 0, 1, 0, 0, 0, 53));
			cmf3.add(new CMF("companies/Monoid.java", 1, 2, 1, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 8));
			cmf3.add(new CMF("companies/Controller.java", 11, 24, 1, 0, 12, 0, 2, 2, 0, 2, 0, 0, 0, 105));
			cmf3.add(new CMF("companies/CutCompany.java", 5, 4, 2, 0, 2, 1, 1, 1, 0, 0, 0, 0, 0, 21));
			cmf3.add(new CMF("companies/EmployeeView.java", 2, 5, 6, 0, 7, 0, 1, 0, 0, 1, 0, 0, 0, 83));
			cmf3.add(new CMF("companies/MainView.java", 1, 3, 6, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 35));
			cmf3.add(new CMF("companies/ProxyEmployee.java", 4, 6, 1, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 28));
			cmf3.add(new CMF("companies/Model.java", 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 31));
			cmf3.add(new CMF("companies/AddToList.java", 1, 1, 2, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 4));
			cmf3.add(new CMF("companies/RemoveFromList.java", 1, 1, 2, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 4));
			cmf3.add(new CMF("companies/EmployeeImpl.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 23));
			cmf3.add(new CMF("companies/MaxDoubles.java", 2, 10, 1, 0, 1, 6, 4, 3, 1, 1, 0, 1, 1, 19));
			cmf3.add(new CMF("companies/AddDoubles.java", 2, 6, 1, 0, 0, 6, 4, 3, 1, 1, 0, 1, 0, 15));
			cmf3.add(new CMF("companies/ReturningVisitor.java", 4, 3, 1, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 9));
			cmf3.add(new CMF("companies/SimpleLinkedList.java", 2, 3, 1, 0, 3, 0, 3, 3, 0, 1, 0, 0, 0, 19));
			cmf3.add(new CMF("companies/DepartmentImpl___.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 28));
			cmf3.add(new CMF("companies/CompanyImpl___.java", 5, 6, 2, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 23));
			cmf3.add(new CMF("companies/ProxyCompany.java", 4, 6, 1, 0, 2, 1, 2, 2, 0, 0, 0, 0, 0, 33));
			cmf3.add(new CMF("companies/AbstractView.java", 1, 11, 5, 3, 3, 0, 3, 3, 0, 5, 0, 1, 0, 65));
			cmf3.add(new CMF("companies/SimpleList.java", 1, 2, 1, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 8));
			features.add(new Feature("CUT_WHATEVER", cmf3, 29, 9, 49, 1399, 31, 17, 3, 17, 8.85));

			ArrayList<CMF> cmf4 = new ArrayList<CMF>();
			cmf4.add(new CMF("companies/EmployeeImpl.java", 2, 3, 2, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 18));
			cmf4.add(new CMF("companies/EmployeeImpl.java", 2, 3, 2, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 19));
			cmf4.add(new CMF("companies/ProxyDepartment.java", 6, 13, 1, 0, 3, 12, 9, 8, 0, 5, 0, 0, 0, 60));
			cmf4.add(new CMF("companies/DepartmentImpl.java", 6, 19, 2, 0, 5, 13, 10, 10, 0, 3, 0, 0, 0, 64));
			cmf4.add(new CMF("companies/ContainerImpl.java", 9, 11, 2, 1, 4, 0, 7, 7, 0, 2, 0, 0, 0, 47));
			cmf4.add(new CMF("companies/DepartmentImpl___.java", 6, 19, 3, 0, 6, 13, 10, 10, 0, 3, 0, 0, 0, 64));
			cmf4.add(new CMF("companies/ProxyEmployee.java", 1, 3, 1, 0, 2, 0, 1, 1, 0, 0, 0, 0, 0, 20));
			cmf4.add(new CMF("companies/ProxyCompany.java", 3, 4, 1, 0, 2, 4, 4, 4, 0, 3, 0, 0, 0, 33));
			cmf4.add(new CMF("companies/CompanyImpl.java", 5, 8, 2, 0, 2, 0, 6, 6, 0, 1, 0, 0, 0, 40));
			features.add(new Feature("GUI", cmf4, 7, 5, 33, 492, 48, 9, 2, 9, 4.69));

			ArrayList<CMF> cmf5 = new ArrayList<CMF>();
			cmf5.add(new CMF("companies/EmployeeImpl.java", 2, 14, 3, 0, 3, 6, 4, 4, 0, 4, 0, 0, 0, 48));
			cmf5.add(new CMF("companies/ComponentImpl.java", 2, 3, 2, 2, 2, 0, 1, 1, 0, 2, 0, 0, 0, 22));
			cmf5.add(new CMF("companies/ContainerImpl.java", 6, 9, 3, 0, 6, 0, 3, 3, 0, 1, 0, 0, 0, 36));
			cmf5.add(new CMF("companies/Model.java", 8, 5, 1, 0, 2, 0, 1, 1, 0, 3, 1, 0, 0, 39));
			features.add(new Feature("LOGGING", cmf5, 4, 1, 8, 187, 9, 4, 2, 8, 4.17));

			ArrayList<CMF> cmf6 = new ArrayList<CMF>();
			cmf6.add(new CMF("companies/ComponentImpl.java", 2, 3, 3, 0, 2, 0, 1, 1, 0, 0, 0, 0, 0, 19));
			cmf6.add(new CMF("companies/EmployeeImpl.java", 2, 17, 3, 0, 3, 9, 7, 7, 0, 5, 0, 0, 0, 59));
			cmf6.add(new CMF("companies/Model.java", 8, 5, 1, 0, 2, 0, 1, 1, 0, 3, 1, 0, 0, 40));
			cmf6.add(new CMF("companies/ComponentImpl.java", 1, 3, 2, 2, 2, 0, 1, 1, 0, 1, 0, 0, 0, 20));
			features.add(new Feature("PRECEDENCE", cmf6, 4, 1, 9, 186, 13, 4, 2, 16, 8.33));

			ArrayList<CMF> cmf7 = new ArrayList<CMF>();
			cmf7.add(new CMF("companies/CutCompany.java", 5, 4, 2, 0, 2, 1, 1, 1, 0, 0, 0, 0, 0, 21));
			cmf7.add(new CMF("companies/DepartmentImpl.java", 6, 6, 2, 0, 1, 1, 2, 2, 0, 0, 0, 0, 0, 28));
			cmf7.add(new CMF("companies/ProxyCompany.java", 5, 6, 1, 0, 1, 1, 2, 2, 0, 0, 0, 0, 0, 33));
			cmf7.add(new CMF("companies/DepartmentView.java", 3, 8, 6, 0, 8, 1, 2, 1, 0, 1, 0, 1, 0, 85));
			cmf7.add(new CMF("companies/EmployeeView.java", 3, 8, 6, 0, 9, 0, 4, 3, 0, 2, 0, 1, 0, 114));
			cmf7.add(new CMF("companies/EmployeeImpl.java", 6, 6, 2, 0, 1, 1, 2, 2, 0, 0, 0, 0, 0, 23));
			cmf7.add(new CMF("companies/AbstractView.java", 1, 8, 5, 3, 2, 0, 2, 2, 0, 5, 0, 1, 0, 51));
			cmf7.add(new CMF("companies/CompanyImpl.java", 6, 6, 2, 0, 1, 1, 2, 2, 0, 0, 0, 0, 0, 25));
			cmf7.add(new CMF("companies/ProxyDepartment.java", 5, 6, 1, 0, 1, 1, 2, 2, 0, 0, 0, 0, 0, 33));
			cmf7.add(new CMF("companies/Controller.java", 11, 24, 1, 0, 12, 0, 2, 2, 0, 2, 0, 0, 0, 103));
			cmf7.add(new CMF("companies/EmployeeImpl.java", 6, 6, 2, 0, 1, 1, 2, 2, 0, 0, 0, 0, 0, 24));
			cmf7.add(new CMF("companies/Model.java", 3, 1, 1, 0, 2, 0, 1, 1, 0, 3, 1, 0, 1, 37));
			cmf7.add(new CMF("companies/MainView.java", 1, 3, 6, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 35));
			cmf7.add(new CMF("companies/DepartmentImpl.java", 6, 6, 2, 0, 1, 1, 2, 2, 0, 0, 0, 0, 0, 28));
			cmf7.add(new CMF("companies/CompanyImpl___.java", 3, 8, 6, 0, 9, 1, 2, 1, 0, 1, 0, 1, 0, 85));
			cmf7.add(new CMF("companies/ProxyEmployee.java", 5, 6, 1, 0, 1, 1, 2, 2, 0, 0, 0, 0, 0, 28));
			cmf7.add(new CMF("companies/CompanyImpl___.java", 6, 6, 2, 0, 1, 1, 2, 2, 0, 0, 0, 0, 0, 23));
			features.add(new Feature("TOTAL_REDUCER", cmf7, 16, 5, 23, 1000, 31, 17, 3, 1, 0.52));

			ArrayList<CMF> cmf8 = new ArrayList<CMF>();

			cmf8.add(new CMF("companies/Model.java",3,1,1,0,3,0,1,1,0,3,1,0,1,38));
			cmf8.add(new CMF("companies/DepartmentImpl.java",6,6,2,0,1,1,2,2,0,0,0,0,0,28));
			cmf8.add(new CMF("companies/CompanyImpl.java",6,6,2,0,1,1,2,2,0,0,0,0,0,25));
			cmf8.add(new CMF("companies/ProxyCompany.java",5,6,1,0,1,1,2,2,0,0,0,0,0,33));
			cmf8.add(new CMF("companies/Controller.java",11,24,1,0,12,0,2,2,0,2,0,0,0,103));
			cmf8.add(new CMF("companies/EmployeeImpl.java",6,6,2,0,1,1,2,2,0,0,0,0,0,24));
			cmf8.add(new CMF("companies/ProxyDepartment.java",5,6,1,0,1,1,2,2,0,0,0,0,0,33));
			cmf8.add(new CMF("companies/EmployeeView.java",3,8,6,0,9,0,4,3,0,2,0,1,0,114));
			cmf8.add(new CMF("companies/AbstractView.java",1,8,5,3,2,0,2,2,0,5,0,1,0,51));
			cmf8.add(new CMF("companies/DepartmentImpl.java",6,6,2,0,1,1,2,2,0,0,0,0,0,28));
			cmf8.add(new CMF("companies/CompanyImpl.java",6,7,2,0,1,3,3,3,0,0,0,0,0,26));
			cmf8.add(new CMF("companies/EmployeeImpl___.java",6,7,2,0,1,3,3,3,0,0,0,0,0,30));
			cmf8.add(new CMF("companies/MainView.java",7,19,6,0,26,25,10,5,0,5,0,1,0,145));
			cmf8.add(new CMF("companies/CutCompany.java",5,4,2,0,2,1,1,1,0,0,0,0,0,21));
			cmf8.add(new CMF("companies/CompanyView.java",2,7,6,0,7,0,1,0,0,0,0,0,0,73));
			cmf8.add(new CMF("companies/ProxyEmployee.java",5,6,1,0,1,1,2,2,0,0,0,0,0,28));
			cmf8.add(new CMF("companies/DepartmentView.java",2,7,6,0,7,0,1,0,0,0,0,0,0,74));
			features.add(new Feature("TOTAL_WALKER", cmf8, 16, 5, 32, 1119, 31, 17, 3, 16, 8.33));
				
			ArrayList<CMF> cmf9 = new ArrayList<CMF>();
			features.add(new Feature("TREE_STRUCTURE",cmf9, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		}
		
		 // chess
	    else if (t == TargetSystem.CHESS) {
		   
	    	ArrayList<CMF> cmf = new ArrayList<CMF>();
	    	cmf.add(new CMF("chess/View.java",2,1,1,0,8,0,1,1,0,0,0,0,1,27));
	    	cmf.add(new CMF("chess/AI_Player.java",1,1,1,0,1,0,1,1,0,0,0,0,0,15));
	    	cmf.add(new CMF("chess/Board.java",16,172,1,0,43,160,40,27,0,14,0,0,0,570));
	       features.add(new Feature("AI_PLAYER",cmf,4,4,38,690,10,2,2,8,100.00));
		   
	       ArrayList<CMF> cmf1 = new ArrayList<CMF>();
	       cmf1.add(new CMF("chess/View.java",2,1,1,0,8,0,1,1,0,0,0,0,1,26));
	       cmf1.add(new CMF("chess/Board.java",16,172,1,0,41,130,40,27,0,14,0,0,0,567));
	       features.add(new Feature("ONLINE_PLAYER",cmf1,3,3,38,665,5,2,2,8,100.00));
	       
	       ArrayList<CMF> cmf2 = new ArrayList<CMF>();
	       cmf2.add(new CMF("chess/Board.java",16,172,1,0,41,130,40,27,0,14,0,0,0,567));
	       cmf2.add(new CMF("chess/View.java",2,1,1,0,8,0,1,1,0,0,0,0,1,26));
		   features.add(new Feature("OFFLINE_PLAYER",cmf2,3,3,38,663,5,2,2,8,100.00));
		}

		 // FeatureAMP1
    	 else if (t == TargetSystem.FeatureAMP1) {
    	 ArrayList<CMF> cmf = new ArrayList<CMF>();
    	 features.add(new Feature("base",cmf,0,0,0,0,0,0,0,0,0));
    	 
    	 ArrayList<CMF> cmf2 = new ArrayList<CMF>();
		 cmf2.add(new CMF("FeatureAMP1/App.java",0,2,1,0,6,1,2,2,0,2,0,0,0,19));
    	 features.add(new Feature("clearplaylist",cmf2,1,0,2,28,1,1,7,177,25.69));
    	 
    	 features.add(new Feature("control",cmf,0,0,0,0,0,0,0,0,0));
    	 
    	 ArrayList<CMF> cmf3 = new ArrayList<CMF>();
		 cmf3.add(new CMF("FeatureAMP1/App.java",0,1,1,0,2,0,1,1,0,0,0,0,0,9));
    	 features.add(new Feature("dark",cmf3,1,0,1,14,1,1,5,180,26.12));

    	 features.add(new Feature("featureamp",cmf,0,0,0,0,0,0,0,0,0));
    	 features.add(new Feature("gui",cmf,0,0,0,0,0,0,0,0,0));
    	 features.add(new Feature("id3information",cmf,0,0,0,0,0,0,0,0,0));
    	 
    	 ArrayList<CMF> cmf4 = new ArrayList<CMF>();
		 cmf4.add(new CMF("FeatureAMP1/App.java",0,1,1,0,2,0,1,1,0,0,0,0,0,8));
    	 features.add(new Feature("light",cmf4,1,0,1,12,1,1,5,224,32.51));
    	 
    	 ArrayList<CMF> cmf5 = new ArrayList<CMF>();
		 cmf5.add(new CMF("FeatureAMP1/App.java",2,8,1,0,13,1,2,1,0,1,0,0,2,44));
    	 features.add(new Feature("loadfolder",cmf5,1,0,2,53,1,1,5,404,58.64));
    	 
    	 ArrayList<CMF> cmf6 = new ArrayList<CMF>();    	 
    	 cmf6.add(new CMF("FeatureAMP1/MusicFileFactory.java",2,3,1,0,4,0,1,1,1,0,0,0,0,12));
    	 cmf6.add(new CMF("FeatureAMP1/Extensions.java",0,1,1,0,0,0,1,0,0,0,0,0,0,6));
    	 cmf6.add(new CMF("FeatureAMP1/MP3MusicFile.java",4,31,2,0,21,0,8,8,0,1,0,0,0,83));
    	 features.add(new Feature("mp3",cmf6,3,1,9,126,3,3,4,365,52.98));
    	 
    	 ArrayList<CMF> cmf7 = new ArrayList<CMF>();
		 cmf7.add(new CMF("FeatureAMP1/App.java",0,4,1,0,5,0,1,1,0,1,0,0,0,22));
    	 features.add(new Feature("mute",cmf7,1,0,2,30,1,1,5,102,14.80));
    	 
    	
    	 features.add(new Feature("openfile",cmf,0,0,0,0,0,0,0,0,0));
    	 features.add(new Feature("playlist",cmf,0,0,0,0,0,0,0,0,0));
    	 
    	 ArrayList<CMF> cmf8 = new ArrayList<CMF>();
		 cmf8.add(new CMF("FeatureAMP1/App.java",0,2,1,0,6,0,2,1,0,1,0,0,0,17));
    	 features.add(new Feature("progressbar",cmf8,1,0,2,24,2,1,5,404,58.64));
    	
    	 ArrayList<CMF> cmf9 = new ArrayList<CMF>();
		 cmf9.add(new CMF("FeatureAMP1/App.java",1,7,1,0,7,3,3,3,0,4,0,0,0,37));
		 cmf9.add(new CMF("FeatureAMP1/PlaylistHandler.java",2,9,1,0,8,0,3,2,0,3,0,0,0,31));
    	 features.add(new Feature("queuetrack",cmf9,2,0,5,89,4,2,5,202,29.32));
    
    	 ArrayList<CMF> cmf10 = new ArrayList<CMF>();
		 cmf10.add(new CMF("FeatureAMP1/App.java",1,5,1,0,9,1,2,2,0,2,0,0,0,26));
    	 features.add(new Feature("removetrack",cmf10,1,0,2,36,1,1,6,283,41.07));
    	 
    	 
    	 ArrayList<CMF> cmf11 = new ArrayList<CMF>();
		 cmf11.add(new CMF("FeatureAMP1/App.java",1,7,1,0,10,3,3,3,0,4,0,0,0,38));
    	 features.add(new Feature("reorderplaylist",cmf11,1,0,2,51,1,1,6,221,32.08));
    	 
    	 ArrayList<CMF> cmf12 = new ArrayList<CMF>();
		 cmf12.add(new CMF("FeatureAMP1/App.java",0,1,1,0,2,0,1,0,0,0,0,0,0,7));
    	 features.add(new Feature("resizable",cmf12,1,0,1,8,1,1,4,404,58.64));
    	 
    	 ArrayList<CMF> cmf13 = new ArrayList<CMF>(); 
		 cmf13.add(new CMF("FeatureAMP1/App.java",1,16,1,0,31,1,3,3,0,4,0,0,5,102));
    	 features.add(new Feature("saveandloadplaylist",cmf13,1,0,2,115,1,1,5,0,0.00));
    	 
    	 
    	 ArrayList<CMF> cmf14 = new ArrayList<CMF>();
		 cmf14.add(new CMF("FeatureAMP1/App.java",2,5,1,0,9,1,3,1,0,1,0,0,0,32));
    	 features.add(new Feature("showcover",cmf14,1,0,3,39,2,1,4,161,23.37));
    	
    	 
    	 ArrayList<CMF> cmf15 = new ArrayList<CMF>();
		 cmf15.add(new CMF("FeatureAMP1/App.java",1,2,1,0,6,0,2,1,0,2,0,0,0,16));
    	 features.add(new Feature("showtime",cmf15,1,0,2,22,2,1,5,404,58.64));
    	
    	 
    	 ArrayList<CMF> cmf16 = new ArrayList<CMF>();
		 cmf16.add(new CMF("FeatureAMP1/App.java",1,6,1,0,6,0,2,2,0,3,0,0,0,43));
		 cmf16.add(new CMF("FeatureAMP1/PlayMode.java",0,2,1,0,0,0,2,1,0,1,0,0,0,16));
		 cmf16.add(new CMF("FeatureAMP1/PlaylistHandler.java",2,15,1,0,8,1,2,2,0,0,0,0,0,42));
    	 features.add(new Feature("shufflerepeat",cmf16,3,1,5,132,3,3,6,42,16.80));
    	 features.add(new Feature("skins",cmf,0,0,0,0,0,0,0,0,0));
    	 
    	 ArrayList<CMF> cmf17 = new ArrayList<CMF>();
		 cmf17.add(new CMF("FeatureAMP1/App.java",0,2,1,0,4,1,2,2,0,2,0,0,0,18));
    	 features.add(new Feature("skiptrack",cmf17,1,0,2,26,1,1,6,218,31.64));

    	 features.add(new Feature("supportedformats",cmf,0,0,0,0,0,0,0,0,0));
    	 features.add(new Feature("time",cmf,0,0,0,0,0,0,0,0,0));
    	 
    	 ArrayList<CMF> cmf18 = new ArrayList<CMF>();
		 cmf18.add(new CMF("FeatureAMP1/App.java",0,2,1,0,4,1,2,2,0,2,0,0,0,18));
    	 features.add(new Feature("volumecontrol",cmf18,2,1,6,70,3,2,4,218,31.64));
    	
    	 ArrayList<CMF> cmf19 = new ArrayList<CMF>();
		 
    	 cmf19.add(new CMF("FeatureAMP1/MusicFileFactory.java",2,3,1,0,4,0,1,1,1,0,0,0,0,12));
		 cmf19.add(new CMF("FeatureAMP1/Extensions.java",0,1,1,0,1,0,1,0,1,0,0,0,0,7));
		 cmf19.add(new CMF("FeatureAMP1/FileNameFilter.java",1,1,1,0,2,0,1,1,0,0,0,0,0,7));
		 cmf19.add(new CMF("FeatureAMP1/WAVMusicFile.java",4,10,2,0,18,0,8,8,0,1,0,0,0,56));
    	 features.add(new Feature("wav",cmf19,4,1,10,112,4,4,4,404,58.64));
		
    	 }
		
		// mine
		else if (t == TargetSystem.MINE) {
		 features.add(new Feature("base"));
		 
		 ArrayList<CMF> cmf = new ArrayList<CMF>();
		 cmf.add(new CMF("mine/MinePump.java",0,4,1,0,4,1,2,1,0,0,0,0,0,15));
		 cmf.add(new CMF("mine/Environment.java",0,1,1,0,0,0,1,0,0,0,0,0,0,6));
		 features.add(new Feature("highWaterSensor",cmf,2,0,3,27,1,1,4,24,37.50));
		 
		 
		 ArrayList<CMF> cmf2 = new ArrayList<CMF>();
		 cmf2.add(new CMF("mine/MinePump.java",0,4,1,0,4,1,2,1,0,0,0,0,0,14));
		 cmf2.add(new CMF("mine/Environment.java",0,1,1,0,0,0,1,0,0,0,0,0,0,6));
		 features.add(new Feature("lowWaterSensor",cmf2,2,0,3,26,1,1,4,0,0.00));
		
		 ArrayList<CMF> cmf3 = new ArrayList<CMF>();
		 cmf3.add(new CMF("mine/MinePump.java",0,3,1,0,3,0,1,1,0,0,0,0,0,11));
		 features.add(new Feature("methaneQuery",cmf3, 1,0,1,13,1,1,4,0,0.00));
		 
		 
		 ArrayList<CMF> cmf4 = new ArrayList<CMF>();
		 cmf4.add(new CMF("mine/MinePump.java",0,3,1,0,2,0,1,0,0,0,0,0,0,11));
		 features.add(new Feature("methaneAlarm",cmf4, 1,0,1,13,1,1,4,0,0.00));
	
		 
		 ArrayList<CMF> cmf5 = new ArrayList<CMF>();
		 cmf5.add(new CMF("mine/MinePump.java",0,3,1,0,1,0,1,1,0,0,0,0,0,11));
		 cmf5.add(new CMF("mine/Actions.java",0,1,1,0,1,0,1,0,0,0,0,0,0,7));
		 features.add(new Feature("stopCommand",cmf5,2,0,2,21,1,1,4,12,18.75));
		 
		 ArrayList<CMF> cmf6 = new ArrayList<CMF>();
		 cmf6.add(new CMF("mine/MinePump.java",0,1,1,0,0,0,1,1,0,0,0,0,0,8));
		 cmf6.add(new CMF("mine/Actions.java",0,1,1,0,1,0,1,0,0,0,0,0,0,7));
		 features.add(new Feature("startCommand", cmf6,2,2,2,2,0,2,12,12,18.75 ));
		}
	 // sudoku
	    else if (t == TargetSystem.SUDOKU) {
		 features.add(new Feature("BASE"));
		
		 ArrayList<CMF> cmf = new ArrayList<CMF>();
		 cmf.add(new CMF("sudoku/BoardManager.java",3,6,1,0,7,0,5,3,0,3,0,0,0,48));
		 cmf.add(new CMF("sudoku/Board.java",2,4,1,0,5,0,3,1,0,1,0,0,0,36));
		 cmf.add(new CMF("sudoku/Field.java",1,5,1,0,11,0,4,2,0,6,1,1,0,66));
		 cmf.add(new CMF("sudoku/SudokuFacade.java",3,9,1,0,3,0,2,2,0,3,0,0,0,30));
		 features.add(new Feature("STATES", cmf,4,1,13,236,13,4,2,4,20.00));
		 
		 ArrayList<CMF> cmf2 = new ArrayList<CMF>();
		 cmf2.add(new CMF("sudoku/BoardManager.java",1,3,1,0,3,0,1,1,0,2,0,0,0,23));
		 cmf2.add(new CMF("sudoku/SudokuFacade.java",1,1,1,0,1,0,1,1,0,1,0,0,0,8));
		 features.add(new Feature("UNDO", cmf2,2,0,2,44,2,2,2,4,20.00));
		 
		 ArrayList<CMF> cmf3 = new ArrayList<CMF>();
		 cmf.add(new CMF("sudoku/Field.java",0,3,1,0,0,0,3,3,0,4,0,0,0,39));
		 features.add(new Feature("COLOR", cmf3, 1,3,0,48,3,1,2,3,15.00));
		 
		 
		 ArrayList<CMF> cmf4 = new ArrayList<CMF>();
		 cmf4.add(new CMF("sudoku/Guesser.javaa",2,9,1,0,8,0,1,1,0,0,0,0,0,33));
		 cmf4.add(new CMF("sudoku/SudokuFacade.java",1,12,1,0,5,0,2,2,0,1,0,0,0,36));
		 cmf4.add(new CMF("sudoku/ForcedField.java",3,7,1,0,6,0,1,1,0,0,0,0,0,11));
		 cmf4.add(new CMF("sudoku/BoardManager.java",7,39,1,0,24,3,6,4,0,3,0,0,6,133));
		 cmf4.add(new CMF("sudoku/Board.java",2,25,1,0,21,8,5,2,0,1,0,0,2,69));
		 cmf4.add(new CMF("sudoku/ForcedNumber.java",3,7,1,0,6,0,1,1,0,0,0,0,0,11));
		 cmf4.add(new CMF("sudoku/Field.java",1,5,1,0,11,0,4,2,0,6,1,1,0,66));
		 features.add(new Feature("SOLVER",cmf4,7,4,19,467,23,7,2,4,20.00));
		 
		 ArrayList<CMF> cmf5 = new ArrayList<CMF>();
		 cmf5.add(new CMF("sudoku/Board.java",2,8,1,0,6,0,1,1,0,1,0,0,0,34));
		 cmf5.add(new CMF("sudoku/BoardManager.java",1,1,1,0,2,0,1,1,0,1,0,0,0,21));
		 cmf5.add(new CMF("sudoku/SudokuFacade.java",3,2,1,0,1,0,2,2,0,2,0,0,0,13));
		 cmf5.add(new CMF("sudoku/SudokuGenerator.java",3,12,1,0,14,3,3,2,1,0,0,0,1,55));
		 cmf5.add(new CMF("sudoku/Field.java",0,1,1,0,0,0,1,1,0,1,0,0,0,22));
		 features.add(new Feature("GENERATOR", cmf5,5,1,7,195,8,5,2,3,15.00));
		 
		 ArrayList<CMF> cmf6 = new ArrayList<CMF>();
		 cmf6.add(new CMF("sudoku/SudokuFacade.java",1,1,1,0,1,0,1,1,0,1,0,0,0,8));
		 cmf6.add(new CMF("sudoku/BoardManager.java",1,1,1,0,1,0,1,1,0,1,0,0,0,21));
		 features.add(new Feature("EXTENDEDSUDOKU",cmf6,2,0,2,45,2,2,2,2,10.00 ));
		 }
		//PAYCARD
		 else if (t == TargetSystem.PAYCARD) {
			 ArrayList<CMF> cmf = new ArrayList<CMF>();
			 cmf.add(new CMF("Paycard/LogRecord.java",1,6,1,0,0,2,4,4,0,4,0,1,0,37));
			 cmf.add(new CMF("Paycard/LogFile.java",1,5,1,0,1,0,2,2,0,3,0,1,0,28));
			 cmf.add(new CMF("Paycard/PayCard.java",1,5,1,0,1,0,2,2,0,3,0,1,0,28));
			 features.add(new Feature("logging",cmf,3,2,5,94,3,3,2,2,33.33));
		    
			 ArrayList<CMF> cmf1 = new ArrayList<CMF>();
			 cmf1.add(new CMF("Paycard/IssueCardUI.java",2,16,1,0,28,21,5,5,0,17,0,3,3,114));
			 cmf1.add(new CMF("Paycard/CardException.java",0,1,3,0,0,0,1,1,0,0,0,0,0,5));
			 cmf1.add(new CMF("Paycard/ChargeUI.java",1,18,1,0,31,28,5,4,0,13,0,0,5,103));
			 cmf1.add(new CMF("Paycard/PayCard.java",1,11,1,0,2,9,7,7,1,3,0,0,0,74));
			 cmf1.add(new CMF("Paycard/Start.java",1,1,1,0,1,0,1,1,1,0,0,0,0,10));
			features.add(new Feature("paycard",cmf1, 6,5,16,339,5,4,1,3,50.00));
			
			ArrayList<CMF> cmf2 = new ArrayList<CMF>();
			cmf2.add(new CMF("Paycard/LogFile.java",1,4,1,0,1,0,1,1,0,0,0,0,0,24));
			features.add(new Feature("maximumrecord", cmf2,1,0,1,8,1,1,3,1,16.66));
			
			ArrayList<CMF> cmf3 = new ArrayList<CMF>();
			cmf3.add(new CMF("Paycard/PayCard.java",0,6,1,0,1,0,2,2,0,1,0,0,0,28));
			features.add(new Feature("lockout",cmf3,1,0,2,33,2,1,2,3,50.00));
		 }
		 // GPL
		 else if (t == TargetSystem.GPL) {
			 features.add(new Feature("BFS",2,0,1,6,2,0,6));
			 features.add(new Feature("CONNECTED",3,1,5,18,6,0,4));
			 features.add(new Feature("CYCLE",3,1,7,56,8,1,4));
			 features.add(new Feature("DIRECTED",1,0,1,5,1,1,4));
			 features.add(new Feature("MSTKRUSKAL",3,1,3,198,4,1,4));
			 features.add(new Feature("MSTPRIM",2,0,3,200,3,1,4));
			 features.add(new Feature("NUMBER",3,1,4,19,5,0,4));
			 features.add(new Feature("SEARCH",2,0,6,77,6,1,5));
			 features.add(new Feature("SHORTEST",2,0,3,183,3,0,4));
			 features.add(new Feature("STRONGLYCONNECTED",4,2,7,66,9,0,4));
			 features.add(new Feature("UNDIRECTED",2,0,3,11,3,0,4 ));
			 features.add(new Feature("WEIGHTED",2,0,8,54,9,1,3 ));

		  }
		/* Jtopas */
		 if (t == TargetSystem.jTOPAS) {
			 features.add(new Feature("BLOCKCOMMENTS",1,0,1,337,1,1,2));
			 features.add(new Feature("COUNTLINES",1,0,5,396,4,1,2));
			 features.add(new Feature("IMAGEPARTS",2,0,4,530,3,2,2));
			 features.add(new Feature("LINECOMMENTS",4,4,13,714,2,1,2));
			 features.add(new Feature("TOKENPOSONLY",4,4,13,714,2,1,2));
		 }
		 // NOTEPAD
		 else if (t == TargetSystem.NOTEPAD) {
			 features.add(new Feature("BASEMENUBAR",1,0,1,37,1,1,2));
			 features.add(new Feature("BASETOOLBAR",1,0,1,39,1,1,2));
			 features.add(new Feature("EDITMENUBAR",1,0,2,104,1,1,2));
			 features.add(new Feature("EDITTOOLBAR",1,0,2,78,1,1,2));
			 features.add(new Feature("FORMATMENUBAR",1,0,2,103,1,1,2));
			 features.add(new Feature("FORMATTOOLBAR",1,0,2,79,1,1,2));
			 features.add(new Feature("PERSISTENCEMENUBAR",2,0,4,285,3,2,2));
			 features.add(new Feature("PERSISTENCETOOLBAR",2,0,4,265,3,2,2));
			 features.add(new Feature("PRINTMENUBAR",1,0,2,105,1,1,2));
			 features.add(new Feature("PRINTTOOLBAR",1,0,2,80,1,1,2));
			 features.add(new Feature("SEARCHMENUBAR",1,0,2,108,1,1,2));
			 features.add(new Feature("SEARCHTOOLBAR",1,0,2,80,1,1,2));
			 features.add(new Feature("UNDOREDOMENUBAR",1,0,3,99,3,1,2));
			 features.add(new Feature("UNDOREDOTOOLBAR",1,0,3,82,3,1,2));
			 features.add(new Feature("WORDCOUNTMENUBAR",1,0,2,104,1,1,2));
			 features.add(new Feature("WORDCOUNTTOOLBAR",1,0,2,77,1,1,2));
			 }
		 // Prop4j
			 else if (t == TargetSystem.PROP4J) {
				 features.add(new Feature("and",1,2,4,58,2,1,3));
				 features.add(new Feature("atleast",1,2,2,38,2,1,4));
				 features.add(new Feature("atmost",1,2,2,38,2,1,4));
				 features.add(new Feature("choose",1,2,2,37,2,1,4));
				 features.add(new Feature("equals",1,1,2,28,1,1,3));
				 features.add(new Feature("extended",0,0,0,0,0,0,0));
				 features.add(new Feature("implies",1,1,3,36,1,1,3));
				 features.add(new Feature("input_output",0,0,0,0,0,0,0));
				 features.add(new Feature("negation",1,1,2,61,1,1,3));
				 features.add(new Feature("node_reader",0,0,0,0,0,0,0));
				 features.add(new Feature("node_writer",1,1,14,401,1,1,3));
				 features.add(new Feature("operators",2,2,22,240,2,1,2));
				 features.add(new Feature("or",1,2,9,161,2,1,3));
				 features.add(new Feature("prop4jspl",0,0,0,0,0,0,0));
				 features.add(new Feature("satsolver",1,1,13,305,1,1,2));
				 features.add(new Feature("tests",0,0,0,0,0,0,0));
				 features.add(new Feature("to_cnf",0,0,0,0,0,0,0));

			 }
		 
		// /* Zipme */
		// else if (t == TargetSystem.ZIPME) {
		// features.add(new Feature("BASE"));
		// features.add(new Feature("COMPRESS"));
		// features.add(new Feature("GZIP"));
		// features.add(new Feature("EXTRACT"));
		// features.add(new Feature("ARCHIVECHECK"));
		// features.add(new Feature("CRC"));
		// features.add(new Feature("ADLER32CHECKSUM"));
		// features.add(new Feature("DERIVATIVE_COMPRESS_ADLER32CHECKSUM"));
		// features.add(new Feature("DERIVATIVE_COMPRESS_CRC"));
		// features.add(new Feature("DERIVATIVE_COMPRESS_GZIP"));
		// features.add(new Feature("DERIVATIVE_COMPRESS_GZIPCRC"));
		// features.add(new Feature("DERIVATIVE_EXTRACT_CRC"));
		// features.add(new Feature("DERIVATIVE_GZIPCRC"));
		// }
		// // // email
		// else if (t == TargetSystem.EMAIL) {
		// features.add(new Feature("BASE"));
		// features.add(new Feature("KEYS"));
		// features.add(new Feature("ENCRYPT"));
		// features.add(new Feature("AUTORESPONDER"));
		// features.add(new Feature("ADDRESSBOOK"));
		// features.add(new Feature("SIGN"));
		// features.add(new Feature("FORWARD"));
		// features.add(new Feature("VERIFY"));
		// features.add(new Feature("DECRYPT"));
		// }
		
		
		// // elevator
		// else if (t == TargetSystem.ELEVATOR) {
		// features.add(new Feature("base"));
		// features.add(new Feature("weight"));
		// features.add(new Feature("empty"));
		// features.add(new Feature("twothirdsfull"));
		// features.add(new Feature("executivefloor"));
		// features.add(new Feature("overloaded"));
		// }
		// // Desktopsearcher
		// else if (t == TargetSystem.DESCKTOPSEARCHER) {
		// features.add(new Feature("BASE"));
		// features.add(new Feature("HTML"));
		// features.add(new Feature("TXT"));
		// features.add(new Feature("LATEX"));
		// features.add(new Feature("USER_INTERFACE"));
		// features.add(new Feature("COMMAND_LINE"));
		// features.add(new Feature("GUI"));
		// features.add(new Feature("GUI_PREFERENCES"));
		// features.add(new Feature("QUERY_HISTORY"));
		// features.add(new Feature("INDEX_HISTORY"));
		// features.add(new Feature("SINGLE_DIRECTORY"));
		// features.add(new Feature("MULTI_DIRECTORY"));
		// features.add(new Feature("NORMAL_VIEW"));
		// features.add(new Feature("TREE_VIEW"));
		// features.add(new Feature("WINDOWS"));
		// features.add(new Feature("LINUX"));
		// }
		//
		

		// // TASK
		// else if (t == TargetSystem.TASK) {
		// features.add(new Feature("OBSERVER"));
		// features.add(new Feature("REMOVER"));
		// features.add(new Feature("LOGGIN"));
		// }
		// // Telecon
		// else if (t == TargetSystem.TELECOM) {
		// features.add(new Feature("HISTORIC"));
		// features.add(new Feature("TIMING"));
		// }
		// // vending
		// else if (t == TargetSystem.VENDING) {
		// features.add(new Feature("base"));
		// features.add(new Feature("coinValidation"));
		// features.add(new Feature("availability"));
		// features.add(new Feature("terminal"));
		// features.add(new Feature("keyboard"));
		// features.add(new Feature("showStock"));
		// features.add(new Feature("flexiblequantity"));
		// features.add(new Feature("totalValueCollected"));
		// }
		
		// // set
		// else if (t == TargetSystem.SET) {
		// features.add(new Feature("tree"));
		// features.add(new Feature("integerset"));
		// features.add(new Feature("hashset"));
		// } else if (t == TargetSystem.UNIONFIND) {
		// features.add(new Feature("wqu_byheight"));
		// features.add(new Feature("quickfind"));
		// features.add(new Feature("qu_weighted_modifications"));
		// features.add(new Feature("unionfind"));
		// features.add(new Feature("qu_weighted"));
		// features.add(new Feature("unionfindspl"));
		// features.add(new Feature("quickunion"));
		// features.add(new Feature("wqu_halfing"));
		// features.add(new Feature("wqu_pathcompression"));
		// features.add(new Feature("tests"));
		// }
		//
		
		// // FeatureAMP1
		// else if (t == TargetSystem.FeatureAMP1) {
		// features.add(new Feature("volumecontrol"));
		// features.add(new Feature("skiptrack"));
		// features.add(new Feature("removetrack"));
		// features.add(new Feature("time"));
		// features.add(new Feature("resizable"));
		// features.add(new Feature("wav"));
		// features.add(new Feature("supportedformats"));
		// features.add(new Feature("reorderplaylist"));
		// features.add(new Feature("playlist"));
		// features.add(new Feature("control"));
		// features.add(new Feature("light"));
		// features.add(new Feature("saveandloadplaylist"));
		// features.add(new Feature("gui"));
		// features.add(new Feature("featureamp"));
		// features.add(new Feature("queuetrack"));
		// features.add(new Feature("mute"));
		// features.add(new Feature("progressbar"));
		// features.add(new Feature("showtime"));
		// features.add(new Feature("id3information"));
		// features.add(new Feature("showcover"));
		// features.add(new Feature("loadfolder"));
		// features.add(new Feature("shufflerepeat"));
		// features.add(new Feature("base"));
		// features.add(new Feature("mp3"));
		// features.add(new Feature("skins"));
		// features.add(new Feature("dark"));
		// features.add(new Feature("openfile"));
		// features.add(new Feature("clearplaylist"));
		// }
		//
		// // FeatureAMP2
		// else if (t == TargetSystem.FeatureAMP2) {
		// features.add(new Feature("skiptrack"));
		// features.add(new Feature("volumecontrol"));
		// features.add(new Feature("lightskin"));
		// features.add(new Feature("removetrack"));
		// features.add(new Feature("time"));
		// features.add(new Feature("reorderplaylist"));
		// features.add(new Feature("playlist"));
		// features.add(new Feature("darkskin"));
		// features.add(new Feature("saveandloadplaylist"));
		// features.add(new Feature("gui"));
		// features.add(new Feature("featureamp"));
		// features.add(new Feature("queuetrack"));
		// features.add(new Feature("progressbar"));
		// features.add(new Feature("mute"));
		// features.add(new Feature("showtime"));
		// features.add(new Feature("player"));
		// features.add(new Feature("controlplayist"));
		// features.add(new Feature("showcover"));
		// features.add(new Feature("loadfolder"));
		// features.add(new Feature("shufflerepeat"));
		// features.add(new Feature("ogg"));
		// features.add(new Feature("mp3"));
		// features.add(new Feature("skins"));
		// features.add(new Feature("clearplaylist"));
		// }
		// // FeatureAMP3
		// else if (t == TargetSystem.FeatureAMP3) {
		// features.add(new Feature("skiptrack"));
		// features.add(new Feature("volumecontrol"));
		// features.add(new Feature("playlistcontrol"));
		// features.add(new Feature("removetrack"));
		// features.add(new Feature("time"));
		// features.add(new Feature("wav"));
		// features.add(new Feature("reorderplaylist"));
		// features.add(new Feature("mp3"));
		// features.add(new Feature("playlist"));
		// features.add(new Feature("light"));
		// features.add(new Feature("saveandloadplaylist"));
		// features.add(new Feature("changelistener"));
		// features.add(new Feature("gui"));
		// features.add(new Feature("featureamp"));
		// features.add(new Feature("queuetrack"));
		// features.add(new Feature("filesupport"));
		// features.add(new Feature("playlistcontextmenu"));
		// features.add(new Feature("mute"));
		// features.add(new Feature("progressbar"));
		// features.add(new Feature("tageditor"));
		// features.add(new Feature("showtime"));
		// features.add(new Feature("aac"));
		// features.add(new Feature("loadfolder"));
		// features.add(new Feature("multipleplaylists"));
		// features.add(new Feature("showcover"));
		// features.add(new Feature("playlistmenu"));
		// features.add(new Feature("shufflerepeat"));
		// features.add(new Feature("base"));
		// features.add(new Feature("ogg"));
		// features.add(new Feature("playlisttabs"));
		// features.add(new Feature("addplaylistwrapper"));
		// features.add(new Feature("skins"));
		// features.add(new Feature("dark"));
		// features.add(new Feature("clearplaylist"));
		// //
		// } else if (t == TargetSystem.FeatureAMP4) {
		// features.add(new Feature("skins"));
		// features.add(new Feature("player_control"));
		// features.add(new Feature("reorder_playlist"));
		// features.add(new Feature("title_time"));
		// features.add(new Feature("skip_track"));
		// features.add(new Feature("progress"));
		// features.add(new Feature("clear_playlist"));
		// features.add(new Feature("progress_bar"));
		// features.add(new Feature("volume_control"));
		// features.add(new Feature("remove_track"));
		// features.add(new Feature("light"));
		// features.add(new Feature("dark"));
		// features.add(new Feature("shuffle_repeat"));
		// features.add(new Feature("show_cover"));
		// features.add(new Feature("ogg"));
		// features.add(new Feature("mp3"));
		// features.add(new Feature("save_load_playlist"));
		// features.add(new Feature("base_featureamp"));
		// features.add(new Feature("load_folder"));
		// features.add(new Feature("queue_track"));
		// features.add(new Feature("file_support"));
		// features.add(new Feature("player_bar"));
		// features.add(new Feature("mute"));
		// features.add(new Feature("id3_title"));
		// features.add(new Feature("playlist"));
		// } else if (t == TargetSystem.FeatureAMP5) {
		// features.add(new Feature("volumecontrol"));
		// features.add(new Feature("skiptrack"));
		// features.add(new Feature("removetrack"));
		// features.add(new Feature("queueremove"));
		// features.add(new Feature("reorderplaylist"));
		// features.add(new Feature("playlist"));
		// features.add(new Feature("light"));
		// features.add(new Feature("saveandloadplaylist"));
		// features.add(new Feature("gui"));
		// features.add(new Feature("featureamp"));
		// features.add(new Feature("filesupport"));
		// features.add(new Feature("queuetrack"));
		// features.add(new Feature("mute"));
		// features.add(new Feature("progressbar"));
		// features.add(new Feature("progress"));
		// features.add(new Feature("showtime"));
		// features.add(new Feature("playlistcontrols"));
		// features.add(new Feature("showcover"));
		// features.add(new Feature("loadfolder"));
		// features.add(new Feature("skiprepeat"));
		// features.add(new Feature("shufflerepeat"));
		// features.add(new Feature("base"));
		// features.add(new Feature("wave"));
		// features.add(new Feature("mp3"));
		// features.add(new Feature("skins"));
		// features.add(new Feature("dark"));
		// features.add(new Feature("clearplaylist"));
		// } else if (t == TargetSystem.FeatureAMP6) {
		// features.add(new Feature("skiptrack"));
		// features.add(new Feature("metadata"));
		// features.add(new Feature("removetrack"));
		// features.add(new Feature("album"));
		// features.add(new Feature("wav"));
		// features.add(new Feature("nicetohave"));
		// features.add(new Feature("playlist"));
		// features.add(new Feature("jumpposition"));
		// features.add(new Feature("light"));
		// features.add(new Feature("openfolder"));
		// features.add(new Feature("gui"));
		// features.add(new Feature("featureamp"));
		// features.add(new Feature("queuetrack"));
		// features.add(new Feature("mute"));
		// features.add(new Feature("tageditor"));
		// features.add(new Feature("tracknumber"));
		// features.add(new Feature("codecs"));
		// features.add(new Feature("progress"));
		// features.add(new Feature("aac"));
		// features.add(new Feature("playlistcontrols"));
		// features.add(new Feature("multipleplaylists"));
		// features.add(new Feature("randomcolor"));
		// features.add(new Feature("saveandload"));
		// features.add(new Feature("shufflerepeat"));
		// features.add(new Feature("base"));
		// features.add(new Feature("ogg"));
		// features.add(new Feature("youtube"));
		// features.add(new Feature("mp3"));
		// features.add(new Feature("oscolors"));
		// features.add(new Feature("reorder"));
		// features.add(new Feature("cover"));
		// features.add(new Feature("volume"));
		// features.add(new Feature("skins"));
		// features.add(new Feature("dark"));
		// features.add(new Feature("clearplaylist"));
		// features.add(new Feature("remeberstatus"));
		// features.add(new Feature("progressbar"));
		// features.add(new Feature("titlebar"));
		// } else if (t == TargetSystem.FeatureAMP7) {
		// features.add(new Feature("openwavfile"));
		// features.add(new Feature("volumecontrol"));
		// features.add(new Feature("skiptrack"));
		// features.add(new Feature("mp3player"));
		// features.add(new Feature("removetrack"));
		// features.add(new Feature("time"));
		// features.add(new Feature("changeplaylist"));
		// features.add(new Feature("openmp3file"));
		// features.add(new Feature("reorderplaylist"));
		// features.add(new Feature("playlist"));
		// features.add(new Feature("light"));
		// features.add(new Feature("saveandloadplaylist"));
		// features.add(new Feature("gui"));
		// features.add(new Feature("audioformats"));
		// features.add(new Feature("featureamp"));
		// features.add(new Feature("queuetrack"));
		// features.add(new Feature("mute"));
		// features.add(new Feature("progressbar"));
		// features.add(new Feature("showtime"));
		// features.add(new Feature("showtitle"));
		// features.add(new Feature("wavplayer"));
		// features.add(new Feature("loadfolder"));
		// features.add(new Feature("showcover"));
		// features.add(new Feature("shufflerepeat"));
		// features.add(new Feature("skins"));
		// features.add(new Feature("orangebluest"));
		// features.add(new Feature("dark"));
		// features.add(new Feature("openfile"));
		// features.add(new Feature("clearplaylist"));
		// } else if (t == TargetSystem.FeatureAMP8) {
		// features.add(new Feature("volumecontrol"));
		// features.add(new Feature("skiptrack"));
		// features.add(new Feature("playengine"));
		// features.add(new Feature("removetrack"));
		// features.add(new Feature("wav"));
		// features.add(new Feature("reorderplaylist"));
		// features.add(new Feature("playlist"));
		// features.add(new Feature("control"));
		// features.add(new Feature("light"));
		// features.add(new Feature("saveandloadplaylist"));
		// features.add(new Feature("gui"));
		// features.add(new Feature("featureamp"));
		// features.add(new Feature("filesupport"));
		// features.add(new Feature("queuetrack"));
		// features.add(new Feature("progressbar"));
		// features.add(new Feature("mute"));
		// features.add(new Feature("showtime"));
		// features.add(new Feature("loadfolder"));
		// features.add(new Feature("tracktime"));
		// features.add(new Feature("shufflerepeat"));
		// features.add(new Feature("ogg"));
		// features.add(new Feature("mp3"));
		// features.add(new Feature("skins"));
		// features.add(new Feature("dark"));
		// features.add(new Feature("choosefile"));
		// features.add(new Feature("clearplaylist"));
		// features.add(new Feature("showcover"));
		// } else if (t == TargetSystem.FeatureAMP9) {
		// features.add(new Feature("volumecontrol"));
		// features.add(new Feature("skiptrack"));
		// features.add(new Feature("removetrack"));
		// features.add(new Feature("weichbrodt_featureamp"));
		// features.add(new Feature("reorderplaylist"));
		// features.add(new Feature("playlist"));
		// features.add(new Feature("timedisplay"));
		// features.add(new Feature("light"));
		// features.add(new Feature("shuffleskipremove"));
		// features.add(new Feature("saveandloadplaylist"));
		// features.add(new Feature("gui"));
		// features.add(new Feature("queuetrack"));
		// features.add(new Feature("filesupport"));
		// features.add(new Feature("progressbar"));
		// features.add(new Feature("mute"));
		// features.add(new Feature("showtime"));
		// features.add(new Feature("showcover"));
		// features.add(new Feature("loadfolder"));
		// features.add(new Feature("shufflerepeat"));
		// features.add(new Feature("ogg"));
		// features.add(new Feature("mp3"));
		// features.add(new Feature("skins"));
		// features.add(new Feature("dark"));
		// features.add(new Feature("clearplaylist"));
		//
		// }
		//
		
	}

	public void leitor(String arquivo) {

		File dir = new File(arquivo);
		// computa as metricas de classe
		M_Classes met_Classes = new M_Classes();
		// nome da classe
		met_Classes.nomeClasse = arquivo;

		String featureAtual = "";

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();
		int cont2 = 0;
		for (int i = 0; i < listas.size(); i++) {

			if (listas.get(i).contains("if(Configuration.") || listas.get(i).contains("if (Configuration.")
					|| listas.get(i).contains("if(specifications.Configuration")
					|| listas.get(i).contains("if (specifications.Configuration")
					|| listas.get(i).contains("if(!Configuration.") || listas.get(i).contains("if (!Configuration.")
					|| listas.get(i).contains("if(!specifications.Configuration")
					|| listas.get(i).contains("if (!specifications.Configuration")) {
				System.out.println("Linha: " + (i + 1) + " " + listas.get(i));
				cont++;
				cont2++;

				if (!listas.get(i).equals(featureAtual)) {
					// quantidade de entrelacamento na classe
					met_Classes.entrelacamento++;
					featureAtual = listas.get(i);

				}

				for (int x = 0; x < features.size(); x++) {
					if (listas.get(i).contains("Configuration." + features.get(x).nome + " ")
							|| listas.get(i).contains("Configuration." + features.get(x).nome + "&")
							|| listas.get(i).contains("Configuration." + features.get(x).nome + "|")
							|| listas.get(i).contains("Configuration." + features.get(x).nome + ")")) {
						features.get(x).quantidade++;
						featuresAux.get(x).quantidade++;
					}
				}
			}

		}
		System.out.println("\n\t\tSomatorio local:" + cont2 + "  Somatorio total:" + cont + "\n\n");
		// pontos variablidade total da classe
		met_Classes.pontosVariabilidade = cont2;
		int total = 0;
		for (int x = 0; x < featuresAux.size(); x++) {
			if (featuresAux.get(x).quantidade != 0) {
				System.out.println("\t\t\t\t{\"name\": \"" + featuresAux.get(x).nome + "\", \"value\":"
						+ featuresAux.get(x).quantidade + ", \"fail\": 0},");
				espalhamento.get(x).quantidade++;

				// quantidade de features diferentes manipuladas na classe
				met_Classes.featManipuladas++;

				computarMetricasFeature(met_Classes, features.get(x), arquivo);
			}
			total += featuresAux.get(x).quantidade;
		}
		// System.out.println("\t\t\t ]");
		for (int x = 0; x < featuresAux.size(); x++) {
			featuresAux.get(x).quantidade = 0;
		}

		System.err.println("nomeClasse: \t" + met_Classes.nomeClasse);
		System.err.println("featManipuladas: \t" + met_Classes.featManipuladas);
		System.err.println("pontosVariabilidade: \t" + met_Classes.pontosVariabilidade);
		System.err.println("entrelacamento: \t" + met_Classes.entrelacamento);
		System.err.println("classes: " + met_Classes.Scattering);
		System.err.println("constructors: " + met_Classes.constructors);
		System.err.println("methods: " + met_Classes.methods);
		System.err.println("LOCs: " + met_Classes.LOCs);
		System.err.println("occurrences: " + met_Classes.VP);
		System.err.println("FDT: " + met_Classes.DT_Max);
		System.err.println("quantFailures: " + met_Classes.quantFailures);
		System.err.println("porcfeature: " + met_Classes.porcfeature);

		RunReport runReport = new RunReport(met_Classes, record);
		runReport.runReport();

	}

	private void computarMetricasFeature(M_Classes met_Classes, Feature feature, String nomeClasse) {

		met_Classes.Scattering += feature.classes;
		met_Classes.constructors += feature.constructors;
		met_Classes.methods += feature.methods;
		met_Classes.LOCs += feature.LOCs;
		met_Classes.VP += feature.occurrences;

		if (feature.DT_Max > met_Classes.DT_Max)
			met_Classes.DT_Max = feature.DT_Max;

		if (feature.DT_Max < met_Classes.DT_Min)
			met_Classes.DT_Min = feature.DT_Max;

		if(feature.NGOr_Max> met_Classes.NGOr_Max)
			met_Classes.NGOr_Max=feature.NGOr_Max;
		
		if(feature.NGXOr_Max > met_Classes.NGXOr_Max)
			met_Classes.NGXOr_Max=feature.NGXOr_Max;
		
		if(feature.BF_Max_Branching > met_Classes.BF_Max_Branching)
			met_Classes.BF_Max_Branching=feature.BF_Max_Branching;
		
		met_Classes.NO += feature.NO;
		met_Classes.NTop += feature.NTop;
		met_Classes.NLeaf += feature.NLeaf;
			
		met_Classes.quantFailures += feature.quantFailures;

		if (feature.porcfeature > met_Classes.porcfeature)
			met_Classes.porcfeature = feature.porcfeature;

		for (CMF cmf : feature.classManiFeat) {

			if (cmf.nomeClasse.equals(nomeClasse)) {
				met_Classes.cmf_Final.cbo += cmf.cbo;
				met_Classes.cmf_Final.wmc += cmf.wmc;
				met_Classes.cmf_Final.dit += cmf.dit;
				met_Classes.cmf_Final.noc += cmf.noc;
				met_Classes.cmf_Final.rfc += cmf.rfc;
				met_Classes.cmf_Final.lcom += cmf.lcom;
				met_Classes.cmf_Final.nom += cmf.nom;
				met_Classes.cmf_Final.nopm += cmf.nopm;
				met_Classes.cmf_Final.nosm += cmf.nosm;
				met_Classes.cmf_Final.nof += cmf.nof;
				met_Classes.cmf_Final.nopf += cmf.nopf;
				met_Classes.cmf_Final.nosf += cmf.nosf;
				met_Classes.cmf_Final.nosi += cmf.nosi;
				met_Classes.cmf_Final.loc += cmf.loc;

			}
		}
	}

	public static void main(String[] args) {

		String path = "Prop4j/";
		inicialization(TargetSystem.PROP4J);
		
		for (int x = 0; x < features.size(); x++) {
			featuresAux.add(new Feature(features.get(x).nome));
			espalhamento.add(new Feature(features.get(x).nome));
		}

		String fileName;
		String fileNameAndPath = null;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		variabilityCount2 ler = new variabilityCount2();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				fileName = listOfFiles[i].getName();
				try {
					fileNameAndPath = path + fileName;
					System.err.println(fileNameAndPath);
					nomeClasse = fileNameAndPath;
					ler.leitor(fileNameAndPath);
				} catch (Exception e) {
					System.out.println(
							"Erro ao processar o arquivo %s com a mensagem: %s" + fileNameAndPath + e.getMessage());
				}
			}
		}
		System.out.print("\n somatório total de variabilidade: ");
		System.err.println(cont + "\n\n");
		System.out.println("\n\n\n somatório da variabilidade das features");

		Comparator crescente = new ComparadorDeFeature();
		Comparator decrescente = Collections.reverseOrder(crescente);
		Collections.sort(features, crescente);

		int total = 0;
		for (int x = 0; x < features.size(); x++) {
			System.out.println(features.get(x).nome + "\t" + features.get(x).quantidade);
			total += features.get(x).quantidade;
		}
		System.out.println("Total: \t" + total);

		System.out.println("\n\nEspalhamento de features.");

		Collections.sort(espalhamento, crescente);

		for (int x = 0; x < espalhamento.size(); x++) {
			System.out.println(espalhamento.get(x).nome + "\t" + espalhamento.get(x).quantidade);
		}

		System.out.println("\n\n\nnome  \t\t Occurrences \t Other Features");
		for (int x = 0; x < features.size(); x++) {
			if (features.get(x).quantidade != 0)
				System.out.println(features.get(x).nome + "\t\t" + features.get(x).quantidade + "\t"
						+ espalhamento.get(x).quantidade);

		}

		try {
			record.record2();
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("\n\nTodos os arquivos foram processados.");
	}

}