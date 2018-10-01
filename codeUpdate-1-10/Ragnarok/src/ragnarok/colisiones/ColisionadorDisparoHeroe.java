package ragnarok.colisiones;

import ragnarok.disparos.Flecha;
import ragnarok.disparos.FlechaE;
import ragnarok.entidades.Heroe;
import ragnarok.entidades.enemigos.EnemigoArmado;
import ragnarok.entidades.enemigos.Kamikaze;
import ragnarok.obstaculos.Barrera;
import ragnarok.obstaculos.Obstaculo;
import ragnarok.powerups.PowerUp;
import ragnarok.principal.Mapa;

public class ColisionadorDisparoHeroe extends Colisionador {
	
	protected int da�o;
	public ColisionadorDisparoHeroe(int d) {
		da�o = d;
	}

	public void afectarEnemigoArmado(EnemigoArmado e) {
		//"Un enemigo fue chocado por el disparo del heroe"
		e.da�ar(da�o);
		if (e.getVida() <= 0) {
			e.eliminar();
			Mapa.getMapa().getHeroe().sumarPuntaje(e.getValor());
			e.dropearPowerUp();
		}
	}

	public void afectarObstaculo(Obstaculo o) {
		//Un obstaculo fue chocado por el disparo del heroe"
		o.da�ar(da�o);
		if (o.getVida() <= 0) {
			o.eliminar();
			Mapa.getMapa().getHeroe().sumarPuntaje(o.getValor());
		}
	}
	
	public void afectarKamikaze(Kamikaze k) {
		//Un kamikaze fue chocado por un disparo de heroe
		k.da�ar(da�o);
		if (k.getVida() <= 0) {
			k.eliminar();
			Mapa.getMapa().getHeroe().sumarPuntaje(k.getValor());
			k.dropearPowerUp();
		}
	}

	public void afectarDisparoEnemigo(FlechaE f) {
		//Un disparo enemigo fue chocado por un disparo de heroe
		f.eliminar();
	}

	public void afectarPowerUp(PowerUp p) {
		//Un power up fue chocado por un disparo enemigo
		p.activar();
		p.eliminar();
	}
	
}
