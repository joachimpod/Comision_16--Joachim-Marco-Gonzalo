package ragnarok.colisiones;

import ragnarok.disparos.Flecha;
import ragnarok.disparos.FlechaE;
import ragnarok.entidades.Heroe;
import ragnarok.entidades.enemigos.EnemigoArmado;
import ragnarok.entidades.enemigos.Kamikaze;
import ragnarok.obstaculos.Barrera;
import ragnarok.obstaculos.Obstaculo;
import ragnarok.powerups.PowerUp;

public class ColisionadorObstaculo extends Colisionador {

	public void afectarKamikaze(Kamikaze k) {
		//Un kamikaze fue chocado por obstaculo
		k.eliminar();
	}

	public void afectarDisparoJugador(Flecha f) {
		//Un disparo de jugador fue chocado por un obstaculo
		f.eliminar();
	}

	public void afectarDisparoEnemigo(FlechaE f) {
		//Un disparo enemigo fue chocado por un obstaculo
		f.eliminar();
	}
}