package ragnarok.colisiones;

import ragnarok.disparos.Flecha;
import ragnarok.disparos.FlechaE;
import ragnarok.entidades.Heroe;
import ragnarok.entidades.enemigos.Enemigo;
import ragnarok.entidades.enemigos.EnemigoArmado;
import ragnarok.entidades.enemigos.Kamikaze;
import ragnarok.obstaculos.Barrera;
import ragnarok.obstaculos.Obstaculo;
import ragnarok.powerups.PowerUp;

public class ColisionadorDisparoEnemigo extends Colisionador{
	
	protected int da�o;
	public ColisionadorDisparoEnemigo(int d) {
		da�o = d;
	}

	public void afectarHeroe(Heroe h) {
		//El heroe fue chocado por un disparo enemigo
		h.da�ar(da�o);
		if (h.getVida()<=0) {
			h.eliminar();
		}
		
	}
	
	public void afectarDisparoJugador(Flecha f) {
		//Un disparo de jugador fue chocado por un disparo enemigo
		f.eliminar();
	}
}
