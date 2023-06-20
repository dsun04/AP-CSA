package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import utilities.GDV5;

public class Particle extends Rectangle{
	
	static Particle[] particles;
	private int speedx;
	private int speedy;
	
	private Color color;
	private int alphaIncrement = 2;
	
	private boolean alive = true;
	
	public Particle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.color = color;		
	}
	
	private static int partPerRow = 8;
	private static int rowPerArr = 5;
	
	public static void makeParticles(Brick b) {
		int x = (int)b.getX();
		int y = (int)b.getY();
	
		Color bcol = b.getCol();
		
		int pwidth = (int)(b.getWidth()/partPerRow);
		int pheight = (int)(b.getHeight()/rowPerArr);
		
		particles = new Particle[partPerRow*rowPerArr];
		
		for (int i = 0; i < particles.length; i++) {
			particles[i] = new Particle(x, y, pwidth, pheight, bcol);
			x += pwidth;
			if (i % partPerRow == 0) {
				x = (int)b.getX();
				y += pheight/rowPerArr;
			}
		}
	}
	
	public void move(Brick []bricks) {
		if (Math.random() < .5) {
			speedx = 1;
			}
		else {
			speedx = -1;
			}
		if (Math.random() < .5) {
			speedy = 1;
		}
		else { 
			speedy = -1;
		}
		
		this.translate(speedx, speedy);
	}
	
	public static void moveParticles(Brick [] bricks) {
		for(Particle p:particles) {
			p.move(bricks);
			}	
		}
	
	public void draw(Graphics2D win) {
		if(color.getAlpha() >= 2) {
			color = new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()-alphaIncrement);
		}
		
		win.setColor(color);
		win.fill(this);
	}
	
	public static void drawParticles(Graphics2D pb, Brick[]bricks) {
		for (Particle p:particles) {
			if (p.alive) {
				p.draw(pb);
			}
		}
	}
}

