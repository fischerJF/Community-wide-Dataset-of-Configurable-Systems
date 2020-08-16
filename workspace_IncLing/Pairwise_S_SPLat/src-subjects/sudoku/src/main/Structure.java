package main;


/** 
 * 
 * 
 */
public class Structure extends AbstractEnum {
	public static final Structure ROW = new Structure("ROW");
	public static final Structure COL = new Structure("COL");
	public static final Structure BOX = new Structure("BOX");

	public static Structure[] values() {
//		if (SudokuTEST.SINGLETON.get_BASE___()) {
			return (Structure[]) values0(Structure.class,
					new Structure[count(Structure.class)]);
//		} 
//		return null;
	}

	public static Structure valueOf(final String name) {
//		if (SudokuTEST.SINGLETON.get_BASE___()) {
			return (Structure) valueOf0(Structure.class, name);
//		}
//		return null; 
	}

	private Structure(final String name) {
		super(name);
//		if (SudokuTEST.SINGLETON.get_BASE___()) {
//		}
	}
}
