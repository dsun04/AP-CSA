package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Particle extends Rectangle{
	static Particle[] particles;
	private static int particlesSide = 10;
	private int speedx;
	private int speedy;
	
	private Color color;
	private int alphaIncrement = 1;
	
	private boolean alive;
	
	public Particle(int x, int y, int size, Color color) {
		super(x, y, size, size);
		this.color = color;	
		alive = true;
	}
		
	public static Particle[] makeParticlesLeft(Snake s) {		
	
		particles = new Particle[particlesSide*particlesSide];
		int offX = 0;
		int offY = 0;
		
		for (int i = 0; i < particles.length; i++) {
			if (i % particlesSide == 0 & i != 0) {
				offY += (int)(Tile.getDimension()/particlesSide);
				offX = 0;
			}
			particles[i] = new Particle((int)Snake.getBody().get(0).getX()+offX, (int)Snake.getBody().get(0).getY()+offY, (int)(Tile.getDimension()/particlesSide), s.getCol());
			for (int j = 0; j < Snake.getBody().size(); j++) {
				offX+=(int)(Snake.getBody().get(j).getWidth()/particlesSide);
			}
		}
		return particles;
	}
	
	public static Particle[] makeParticlesRight(Snake s) {
		particles = new Particle[particlesSide*particlesSide];
		int offX = 0;
		int offY = 0;
		
		for (int i = 0; i < particles.length; i++) {
			if (i % particlesSide == 0 & i != 0) {
				offY += (int)(Tile.getDimension()/particlesSide);
				offX = 0;
			}
			particles[i] = new Particle((int)Snake.getBody().get(0).getX()+offX, (int)Snake.getBody().get(0).getY()+offY, (int)(Tile.getDimension()/particlesSide), s.getCol());
			for (int j = 0; j < Snake.getBody().size(); j++) {
				offX-=(int)(Snake.getBody().get(j).getWidth()/particlesSide);
			}
		}
		return particles;
	}
	
	public static Particle[] makeParticlesUp(Snake s) {
		particles = new Particle[particlesSide*particlesSide];
		int offX = 0;
		int offY = 0;
		
		for (int i = 0; i < particles.length; i++) {
			if (i % particlesSide == 0 & i != 0) {
				offX += (int)(Tile.getDimension()/particlesSide);
				offY = 0;
			}
			particles[i] = new Particle((int)Snake.getBody().get(0).getX()+offX, (int)Snake.getBody().get(0).getY()+offY, (int)(Tile.getDimension()/particlesSide), s.getCol());
			for (int j = 0; j < Snake.getBody().size(); j++) {
				offY+=(int)(Snake.getBody().get(j).getWidth()/particlesSide);
			}
		}
		return particles;
	}
	
	public static Particle[] makeParticlesDown(Snake s) {
		particles = new Particle[particlesSide*particlesSide];
		int offX = 0;
		int offY = 0;
		
		for (int i = 0; i < particles.length; i++) {
			if (i % particlesSide == 0 & i != 0) {
				offX += (int)(Tile.getDimension()/particlesSide);
				offY = 0;
			}
			particles[i] = new Particle((int)Snake.getBody().get(0).getX()+offX, (int)Snake.getBody().get(0).getY()+offY, (int)(Tile.getDimension()/particlesSide), s.getCol());
			for (int j = 0; j < Snake.getBody().size(); j++) {
				offY-=(int)(Snake.getBody().get(j).getWidth()/particlesSide);
			}
		}
		return particles;
	}
	
	public void move(Snake snake) {
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
	
	public static void moveParticles(Snake snake) {
		for (Particle p:particles) {
			p.move(snake);
		}
	}
	
	public void draw(Graphics2D win) {
		if (color.getAlpha() >= 0) {
			color = new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()-alphaIncrement);
		}
		if (color.getAlpha() == 0) {
			alive = false;
		}
		win.setColor(color);
		win.draw(this);
		win.fill(this);
	}
	
	public static void drawParticles(Graphics2D pb, Snake snake) {
		for (Particle p:particles) {
			if (p.alive) {
				p.draw(pb);
			}
		}
	}
}
