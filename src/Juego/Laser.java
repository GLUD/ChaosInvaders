
package Juego;


public class Laser extends Actor {
	protected static final int velocidadMisil=3;
	
	public Laser(Etapa stage) {
		super(stage);
		setSpriteNombres( new String[] {"disparo0.gif","disparo1.gif","disparo2.gif"});
		setVelocidadFrame(10);
	}
	
   
    
	public void acto() {
		super.acto();
		y+=velocidadMisil;
		if (y > Etapa.PLAY_HEIGHT)
		  eliminar();
	}
}
