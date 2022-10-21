import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Window{

	
	private int[][] imageArr = new GetPixelColor().getImage();
	public Window() {
		PrintStream fileOut = null;
		try {
			fileOut = new PrintStream("./out.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		System.setOut(fileOut);
		String range = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";
		int interval = 255 / range.length();
		for(int i =0; i < imageArr.length; i++) {
			for(int j =0; j < imageArr[0].length; j++) {
				try {
					System.out.print(range.charAt(imageArr[i][j]/interval));
				}
				catch(Exception e) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
