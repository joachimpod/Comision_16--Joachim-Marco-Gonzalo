package ragnarok.colisiones;

import ragnarok.disparos.Flecha;
import ragnarok.disparos.FlechaE;
import ragnarok.entidades.Heroe;
import ragnarok.entidades.enemigos.EnemigoArmado;
import ragnarok.entidades.enemigos.Kamikaze;
import ragnarok.obstaculos.Barrera;
import ragnarok.obstaculos.Obstaculo;
import ragnarok.powerups.PowerUp;

public class ColisionadorPowerUp extends Colisionador{

	public void afectarDisparoJugador(Flecha f) {
		//Un disparo de jugador fue chocado por un power up
		f.eliminar();
	}
}
