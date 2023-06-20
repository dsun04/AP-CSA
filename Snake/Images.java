package Snake;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Images {
	
	//fruits
	BufferedImage apple;{
		try {
			File file = new File("src/images/apple.png");
			FileInputStream fis = new FileInputStream(file);
			apple = ImageIO.read(fis);
		} catch(IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage banana;{
		try {
			File file2 = new File("src/images/banana.png");
			FileInputStream fis = new FileInputStream(file2);
			banana = ImageIO.read(fis);
		} catch(IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage grapes;{
		try {
			File file3 = new File("src/images/grapes.png");
			FileInputStream fis = new FileInputStream(file3);
			grapes = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage cherry;{
		try {
			File file4 = new File("src/images/cherry.png");
			FileInputStream fis = new FileInputStream(file4);
			cherry = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	//power ups
	BufferedImage lightningBolt;{
		try {
			File file5 = new File("src/images/lightningBolt.png");
			FileInputStream fis = new FileInputStream(file5);
			lightningBolt = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage mushroom;{
		try {
			File file6 = new File("src/images/mushroom.png");
			FileInputStream fis = new FileInputStream(file6);
			mushroom = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage pill;{
		try {
			File file7 = new File("src/images/pill.png");
			FileInputStream fis = new FileInputStream(file7);
			pill = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	//splashpages
	BufferedImage mainMenu;{
		try {
			File file8 = new File("src/images/mainMenu.png");
			FileInputStream fis = new FileInputStream(file8);
			mainMenu = ImageIO.read(fis);
		} catch(IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage score;{
		try {
			File file9 = new File("src/images/score.png");
			FileInputStream fis = new FileInputStream(file9);
			score = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage howToPlayNormalMode;{
		try {
			File file10 = new File("src/images/howToPlayNormalMode.png");
			FileInputStream fis = new FileInputStream(file10);
			howToPlayNormalMode = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage pickFruitType;{
		try {
			File file11 = new File("src/images/pickFruitType.png");
			FileInputStream fis = new FileInputStream(file11);
			pickFruitType = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage howToPlayWallTileMode;{
		try {
			File file12 = new File ("src/images/howToPlayWallTileMode.png");
			FileInputStream fis = new FileInputStream(file12);
			howToPlayWallTileMode = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
