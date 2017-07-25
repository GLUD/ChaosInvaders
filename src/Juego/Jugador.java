
package Juego;

import java.awt.event.KeyEvent;

public class Jugador extends Actor {
	public static final int EscudosMaximos = 200;
	public static final int BombasMaximas = 5;
	protected static final int velocidadJugador = 4;
	protected int vx;
	protected int vy;
	private boolean up,down,left,right;
	private int clusterBombs; 
	private int puntuacion;
	private int escudos;
		
	
	public Jugador(Etapa stage) {
		super(stage);
		setSpriteNombres( new String[] {"nave.gif"});
		clusterBombs = BombasMaximas;
		escudos = EscudosMaximos;
		puntuacion = 0;
	}
	
    
	public void acto() {
		super.acto();
		x+=vx;
		y+=vy;
		if (x < 0 ) 
		  x = 0;
		if (x > Etapa.WIDTH - getWidth())
		  x = Etapa.WIDTH - getWidth();
		if (y < 0 )
		  y = 0;
		if ( y > Etapa.PLAY_HEIGHT-getHeight())
		  y = Etapa.PLAY_HEIGHT - getHeight();
	}

	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
 	public int getVy() { return vy; }
  public void setVy(int i) {vy = i;	}
  
  
  protected void updateSpeed() {
  	vx=0;vy=0;
  	if (down) vy = velocidadJugador;
  	if (up) vy = -velocidadJugador;
  	if (left) vx = -velocidadJugador;
  	if (right) vx = velocidadJugador;
  }
  
  public void keyReleased(KeyEvent e) {
   	switch (e.getKeyCode()) {
  		case KeyEvent.VK_DOWN : down = false;break;
		  case KeyEvent.VK_UP : up = false; break;
		  case KeyEvent.VK_LEFT : left = false; break; 
		  case KeyEvent.VK_RIGHT : right = false;break;
   	}
   	updateSpeed();
  }
  
  public void keyPressed(KeyEvent e) {
  	switch (e.getKeyCode()) {
		  case KeyEvent.VK_UP : up = true; break;
		  case KeyEvent.VK_LEFT : left = true; break;
		  case KeyEvent.VK_RIGHT : right = true; break;
		  case KeyEvent.VK_DOWN : down = true;break;
		  case KeyEvent.VK_SPACE : fuego(); break;
		  case KeyEvent.VK_B : fireCluster(); break;
  	}
  	updateSpeed();
  }
  
  public void fuego() {
   	Misil b = new Misil(stage);
   	b.setX(x);
   	b.setY(y - b.getHeight());
   	stage.addActor(b);
   	stage.getSoundCache().playSound("missile.wav");
  }
  
  public void fireCluster() {
  	if (clusterBombs == 0)
  	  return;
  	  
  	clusterBombs--;
  	stage.addActor( new Bomba(stage, Bomba.UP_LEFT, x,y));
	  stage.addActor( new Bomba(stage, Bomba.UP,x,y));
	  stage.addActor( new Bomba(stage, Bomba.UP_RIGHT,x,y));
	  stage.addActor( new Bomba(stage, Bomba.LEFT,x,y));
	  stage.addActor( new Bomba(stage, Bomba.RIGHT,x,y));
  	stage.addActor( new Bomba(stage, Bomba.DOWN_LEFT,x,y));
  	stage.addActor( new Bomba(stage, Bomba.DOWN,x,y));
	  stage.addActor( new Bomba(stage, Bomba.DOWN_RIGHT,x,y));
  }
  
  public int getPuntuacion() {		return puntuacion;	}
  public void setPuntuacion(int i) {	puntuacion = i;	}
  public void addPuntuacion(int i) { puntuacion += i;  }

	public int getEscudos() {	return escudos;	}
	public void setEscudos(int i) {	escudos = i;	}
	public void addEscudos(int i) {
		escudos += i;
		if (escudos > EscudosMaximos) escudos = EscudosMaximos;
	}
	
    
   
	public void colision(Actor a) {
		if (a instanceof Alien ) {
		  a.eliminar();
		  addPuntuacion(40);
		  addEscudos(-40);
		}
		if (a instanceof Laser ) {
			a.eliminar();
			addEscudos(-10);
		}
		if (getEscudos() < 0)
		  stage.gameOver();
	}	

	public int getClusterBombs() {	return clusterBombs;	}
	public void setClusterBombs(int i) {	clusterBombs = i;	}

}
