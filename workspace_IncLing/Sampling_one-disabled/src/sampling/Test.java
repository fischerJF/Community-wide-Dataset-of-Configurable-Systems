package sampling;

public class Test {

	public static void main(String[] args) {

		Feature f1 = new Feature();
		f1.setType(FeatureType.OPTIONAL);

		Feature f2 = new Feature();
		f2.setType(FeatureType.OPTIONAL);

		Feature f3 = new Feature();
		f3.setType(FeatureType.OPTIONAL);

		Feature f4 = new Feature();
		f4.setType(FeatureType.OPTIONAL);

		Feature f5 = new Feature();
		f5.setType(FeatureType.OPTIONAL);

		
		
		SPL spl = new SPL();
		spl.addOthersFeature(f1);
		spl.addOthersFeature(f2);
		spl.addOthersFeature(f3);
		spl.addOthersFeature(f4);
		spl.addOthersFeature(f5);


		System.out.println("one_Enabled:\n////////////////////////////////////////////");

		SamplingConfiguration conf = new SamplingConfiguration(spl);
		conf.one_Enabled();
		
		System.out.println(conf.printConfiguration());

		System.out.println("//////////////////////////////////////////////////////////");

		System.out.println("\n\none_Disabled:\n///////////////////////////////////////");

		SamplingConfiguration conf2 = new SamplingConfiguration(spl);
		conf2.one_Disabled();
		
		System.out.println(conf2.printConfiguration());

		System.out.println("//////////////////////////////////////////////////////////");

		System.out.println("\n\nmost_Enabled_Disabled:\n//////////////////////////////////");
		SamplingConfiguration conf3 = new SamplingConfiguration(spl);
		conf3.most_Enabled_Disabled();
		System.out.println(conf3.printConfiguration());

		System.out.println("//////////////////////////////////////////////////////////");

		System.out.println("\n\npairWise:\n///////////////////////////////////////////");
		SamplingConfiguration conf4 = new SamplingConfiguration(spl);
		conf4.pairWise(5, 2);
		System.out.println(conf4.printConfiguration());
		

	}
}
