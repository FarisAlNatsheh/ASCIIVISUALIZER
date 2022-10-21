import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GetPixelColor {
	int[][] image;
	
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}
	
	public int[][] getImage(){
		File file = new File(Main.imageName);
		BufferedImage imageR = null;
		try {
			imageR = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int height = imageR.getHeight();
		int width = imageR.getWidth();
		double scale = 0.175;
		Image imageScaled = imageR.getScaledInstance((int) (width * scale), (int) (height * scale), Image.SCALE_SMOOTH);
		BufferedImage image = toBufferedImage(imageScaled);
		this.image = new int[image.getHeight()][image.getWidth()];
		for(int i =0; i < image.getWidth(); i++) {
			for(int j =0; j < image.getHeight(); j++) {
				int clr = image.getRGB(i, j);
				this.image[j][i]=getColor(clr);
			}
		}
		return this.image;
	}
	public int getColor(int clr) {
		int red =   (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue =   clr & 0x000000ff;
        
		return (red + blue+ green)/3;
	}
}