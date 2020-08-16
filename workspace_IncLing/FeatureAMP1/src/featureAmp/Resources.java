package featureAmp; 

import java.awt.image.BufferedImage; 
import java.io.File; 
import java.io.IOException; 

import javax.imageio.ImageIO; 

public  class  Resources {
	

	public static BufferedImage FEATURE_IMAGE;

	
	
	static{
		FEATURE_IMAGE = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		try {
			FEATURE_IMAGE = ImageIO.read(new File("resources/featureIcon.png"));
		} catch (IOException e) {
			System.out.println("image not found");
		}
	}


}
