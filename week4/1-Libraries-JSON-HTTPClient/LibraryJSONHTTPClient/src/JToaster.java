import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;

public class JToaster {

	public static void main(String[] args) {
		Toaster toasterManager = new Toaster();
		BufferedImage backgroundImage = null;
		try {
			backgroundImage = ImageIO.read(new File(
					"C:/Users/Radi/Desktop/study.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Color color = new Color(0.2f, 0.5f, 0.9f);
		
		toasterManager.setToasterWidth(900);
		toasterManager.setToasterHeight(600);
		toasterManager.setBackgroundImage(backgroundImage);
		toasterManager.setToasterColor(color);
		toasterManager.setStep(5);
		toasterManager.showToaster("ые явсоъ рнг рекебхгнп!");
	}
}
