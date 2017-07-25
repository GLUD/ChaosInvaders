
package Juego;


public class Misil extends Actor {
	protected static final int velocidadMisil=10;
	
	public Misil(Etapa stage) {
		super(stage);
		setSpriteNombres( new String[] {"misil.gif"});
	}
	
   
    
	public void acto() {
		super.acto();
		y-=velocidadMisil;
		if (y < 0)
		  eliminar();
	}
}
