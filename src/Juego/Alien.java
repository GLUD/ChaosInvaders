
package Juego;

public class Alien extends Actor {
	protected int vx;
	protected static final double frecuenciaDisparo = 0.01;
	
	public Alien(Etapa stage) {
		super(stage);
		setSpriteNombres( new String[] {"bicho0.gif","bicho1.gif"});
		setVelocidadFrame(35);
	}
	
 
    
	public void acto() {
		super.acto();
		x+=vx;
		if (x < 0 || x > Etapa.WIDTH)
		  vx = -vx;
		if (Math.random()<frecuenciaDisparo)
		  fuego();
	}

	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	
	public void colision(Actor a) {
		if (a instanceof Misil || a instanceof Bomba) {
		  eliminar();
		  stage.getSoundCache().playSound("explosion.wav");
		  spawn();
		  stage.getPlayer().addPuntuacion(20);
		}
	}
	
	public void spawn() {
		Alien m = new Alien(stage);
		m.setX( (int)(Math.random()*Etapa.WIDTH) );
    m.setY( (int)(Math.random()*Etapa.PLAY_HEIGHT/2) );
	  m.setVx( (int)(Math.random()*20-10) );
	  stage.addActor(m);
	}
	
	public void fuego() {
		Laser m = new Laser(stage);
		m.setX(x+getWidth()/2);
		m.setY(y + getHeight());
		stage.addActor(m);
		stage.getSoundCache().playSound("photon.wav");

	}
}
