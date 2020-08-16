package util;

public class CollectionUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean equals(String[] array1, String[] array2){
		if(array1.length == array2.length){
			for (int i = 0; i < array1.length; i++) {
				if(!array1[i].equals(array2[i]))
					return false;
			}
			return true;
		}
		return false;
	}

}
