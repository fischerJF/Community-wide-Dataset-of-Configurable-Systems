package vending;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import specifications.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import static org.junit.Assert.assertFalse;

public class MenuTest {

	protected Menu menu;

	@Before
	public void setup() {
		Configuration.keyboard=false;
	
		Configuration.terminal=false;
		menu = new Menu();
	}

	@Test
	public void runInsertCoinTest() throws Exception {
		if(Configuration.terminal) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);


		BufferedReader reader1 = new BufferedReader(new FileReader("input1"));
		menu.run(reader1);
		String stg = "";
		stg = "VendingMachine LIGADA\r\n";
		stg += "Current Credit = 200\r\n";
		stg += "VendingMachine DESLIGADA\r\n";
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertEquals(stg, output.toString());
		}
	}
		

	@Test
	public void runReturnCoinTest() throws Exception {
		if(Configuration.terminal) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
		BufferedReader reader1 = new BufferedReader(new FileReader("input2"));
		menu.run(reader1);
		String stg = "";
		stg = "VendingMachine LIGADA\r\n";
		stg += "Current Credit = 200\r\n";
		stg += "Withdraw your coins\r\n";
		stg += "VendingMachine DESLIGADA\r\n";
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertEquals(stg, output.toString());
		}
	}

	@Test
	public void runReturnCoin__NoCredidForReturnTest() throws Exception {
		if(Configuration.terminal) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
		BufferedReader reader1 = new BufferedReader(new FileReader("input3"));
		menu.run(reader1);
		String stg = "";
		stg = "VendingMachine LIGADA\r\n";
		stg += "Current Credit = 0\r\n";
		stg += "No credit for return\r\n";
		stg += "VendingMachine DESLIGADA\r\n";
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertEquals(stg, output.toString());
		}
	}

	@Test
	public void runReturnRemoveTheDesiredItemTest() throws Exception {
		if(Configuration.terminal) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
		BufferedReader reader1 = new BufferedReader(new FileReader("input4"));
		menu.run(reader1);
		String stg = "";
		stg = "VendingMachine LIGADA\r\n";
		stg += "Current Credit = 200\r\n";
		stg += "Remove the desired item!\r\n";
		stg += "Current Credit = 150\r\n";
		stg += "VendingMachine DESLIGADA\r\n";
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertEquals(stg, output.toString());
		}
	}

	@Test
	public void runCurrentCreditIsInsufficientTest() throws Exception {
		if(Configuration.terminal) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);

		BufferedReader reader1 = new BufferedReader(new FileReader("input5"));
		menu.run(reader1);
		String stg = "";
		stg = "VendingMachine LIGADA\r\n";
		stg += "Current Credit = 10\r\n";
		stg += "Current credit is insufficient for purchase of item 4.\r\n";
		stg += "VendingMachine DESLIGADA\r\n";
		System.setOut(originalPrintStream);
		String output = new String(stream.toByteArray());

		assertEquals(stg, output.toString());
		}
	}
	
	

	///@Test
	public void runshowInvalidOperation() throws Exception {
//		Configuration.showStock=false;
		if (!Configuration.showStock) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setOut(ps);

			
		BufferedReader reader1 = new BufferedReader(new FileReader("input6"));
		menu.run(reader1);
		String stg = "";
		stg = "VendingMachine LIGADA\r\n";
		stg += "Current Credit = 200\r\n";
		stg += "Invalid operati	on!\r\n";
		stg += "VendingMachine DESLIGADA\r\n";

		System.setOut(originalPrintStream);
		String output = new String(stream.toByteArray());
		assertEquals(stg, output.toString());
		}
	}

//	@Test
	public void runShowItemsTest() throws Exception {
//		Configuration.showStock = true;
		
		if (Configuration.showStock) {
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setOut(ps);

			
	        BufferedReader reader1 = new BufferedReader(new FileReader("input7"));
			menu.run(reader1);
			String stg = "";
			stg = "VendingMachine LIGADA\r\n";
			stg += "Current Credit = 200\r\n";
			stg += "Item: 1	 Stock: 20\n";
			stg += "Item: 2	 Stock: 20\n";
			stg += "Item: 3	 Stock: 20\n";
			stg += "Item: 4	 Stock: 0\n";
			stg += "Item: 5	 Stock: 20\n";
			stg += "Item: 6	 Stock: 20\n";
			stg += "Item: 7	 Stock: 20\n";
			stg += "Item: 8	 Stock: 20\n";
			stg += "Item: 9	 Stock: 20\n";
			stg += "Item: 10	 Stock: 20\n";
			stg += "Item: 11	 Stock: 20\n";
			stg += "Item: 12	 Stock: 20\n";
			stg += "Item: 13	 Stock: 20\n";
			stg += "Item: 14	 Stock: 20\n";
			stg += "Item: 15	 Stock: 20\n";
			stg += "Item: 16	 Stock: 20\n";
			stg += "Item: 17	 Stock: 20\n";
			//stg += "Item: 18	 Stock: 20\n";
			stg += "Item: 19	 Stock: 20\n";
			stg += "Item: 20	 Stock: 20\n";
			stg += "Available items total: 360\r\n";
			stg += "VendingMachine DESLIGADA\r\n";

			System.setOut(originalPrintStream);
			String output = new String(stream.toByteArray());

			assertEquals(stg, output.toString());
		}
	}
	@Test
	public void runTotalValueCollectedTest() throws Exception {
//		Configuration.totalValueCollected=true;
		if (Configuration.totalValueCollected && Configuration.terminal)  {

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        PrintStream originalPrintStream = System.out;
	        System.setOut(ps);
		BufferedReader reader1 = new BufferedReader(new FileReader("input8"));
		menu.run(reader1);
		String stg = "";
		stg = "VendingMachine LIGADA\r\n";
		stg += "Current Credit = 200\r\n";
		stg += "200\r\n";
		stg += "VendingMachine DESLIGADA\r\n";
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertEquals(stg, output.toString());
		}
	}
	@Test
	public void runTheSelectedItemisInvalidTest() throws Exception {
		if(Configuration.terminal) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
		BufferedReader reader1 = new BufferedReader(new FileReader("input9"));
		menu.run(reader1);
		String stg = "";
		stg = "VendingMachine LIGADA\r\n";
		stg += "Current Credit = 200\r\n";
		stg += "The selected item(21)  is invalid!!!\r\n";
		stg += "VendingMachine DESLIGADA\r\n";
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		
		assertEquals(stg, output.toString());
		}
	}

	@Test
	public void runNoCoinsInsertedTest() throws Exception {
		if(Configuration.terminal) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
		BufferedReader reader1 = new BufferedReader(new FileReader("input10"));
		menu.run(reader1);
		String stg = "";
		stg = "VendingMachine LIGADA\r\n";
		stg += "Current Credit = 0\r\n";
		stg += "No coins inserted!\r\n";
		stg += "VendingMachine DESLIGADA\r\n";
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertEquals(stg, output.toString());
		}
	}
	@Test
	public void runTheSelectedItemIsSoldOutTest() throws Exception {
		if(Configuration.terminal) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
		BufferedReader reader1 = new BufferedReader(new FileReader("input11"));
		menu.run(reader1);
		String stg = "";
		stg = "VendingMachine LIGADA\r\n";
		stg += "Current Credit = 100\r\n";
		stg += "The selected item(18) is sold out!!!\r\n";
		stg += "VendingMachine DESLIGADA\r\n";
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertEquals(stg, output.toString());
		}
	}
}
