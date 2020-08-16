package email.defpackage;
public class Scenario {
	public static boolean abortedRun = false;
	public static void test() {

		Test_Actions.setup();
        Test_Actions.bobKeyAdd();
        Test_Actions.bobSetAddressBook();
        //Test_Actions.bobToRjh();
        Test_Actions.bobToAlias();
}
}