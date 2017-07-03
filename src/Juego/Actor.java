
package Juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Actor {
	protected int x,y;
	protected int width, height;
	protected String[] spriteNombres;
	protected int frameActual;
	protected int velocidadFrame;
	protected int t;
	protected Etapa stage;//etapa
	protected SpriteCache spriteCache;
	protected boolean marcadoParaEliminar;
	
	public Actor(Etapa stage) {
		this.stage = stage;
		spriteCache = stage.getSpriteCache();
		frameActual = 0;
		velocidadFrame = 1;
		t=0;
	}
	
	public void eliminar() {
		marcadoParaEliminar = true;
	}
	
	public boolean esMarcadoParaEliminar() {
		return marcadoParaEliminar;
	}
	
	public void pintar(Graphics2D g){
		g.drawImage( spriteCache.getSprite(spriteNombres[frameActual]), x,y, stage );
	}
	
	public int getX()  { return x; }
	public void setX(int i) {	x = i; }

	public int getY() {	return y; }
	public void setY(int i) { y = i; }
	
	public int getVelocidadFrame() {return velocidadFrame;	}
	public void setVelocidadFrame(int i) {velocidadFrame = i;	}
	
	
	public void setSpriteNombres(String[] nombres) { 
		spriteNombres = nombres;
		height = 0;
		width = 0;
		for (int i = 0; i < nombres.length; i++ ) {
  		BufferedImage image = spriteCache.getSprite(spriteNombres[i]);
	  	height = Math.max(height,image.getHeight());
		  width = Math.max(width,image.getWidth());
		}
	}			
	
	public int getHeight() { return height; }
	public int getWidth() {	return width;	}
	public void setHeight(int i) {height = i;	}
	public void setWidth(int i) {	width = i;	}

	public void acto() {
		t++;
		if (t % velocidadFrame == 0){
			t=0;
  		frameActual = (frameActual + 1) % spriteNombres.length;
		}
	}
	
	public Rectangle getLimites() {
		return new Rectangle(x,y,width,height);
	}
	
	public void colision(Actor a){
		
	}
}
