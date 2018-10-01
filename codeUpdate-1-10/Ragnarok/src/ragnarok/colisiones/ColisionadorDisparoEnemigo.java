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
	
	protected int daño;
	public ColisionadorDisparoEnemigo(int d) {
		daño = d;
	}

	public void afectarHeroe(Heroe h) {
		//El heroe fue chocado por un disparo enemigo
		h.dañar(daño);
		if (h.getVida()<=0) {
			h.eliminar();
		}
		
	}
	
	public void afectarDisparoJugador(Flecha f) {
		//Un disparo de jugador fue chocado por un disparo enemigo
		f.eliminar();
	}
}
