package ragnarok.entidades.enemigos;

import java.util.Random;

import ragnarok.armas.Arma;
import ragnarok.armas.ArmaEnemigo;
import ragnarok.entidades.Entidad;
import ragnarok.inteligencia.Inteligencia;
import ragnarok.powerups.PowerUp;
import ragnarok.powerups.magiastemporales.MTCongelarTiempo;
import ragnarok.principal.Mapa;

public abstract class Enemigo extends Entidad{
	
	protected Inteligencia inteligenciaAtaque;
	protected Inteligencia inteligenciaMovimiento;
	protected Arma arma;
	
	public Enemigo() {
		super();
		valor = 20;
		vida = 80;
		velocidad = 1;
		arma = new ArmaEnemigo();
	}
	
	public void actualizar() {
		mover();
	}
	
	protected void mover() {
		inteligenciaMovimiento.mover(this);
	}
	
	public void dropearPowerUp() {
		Random rnd = new Random();
		if (rnd.nextInt(1) == 0) {
			PowerUp premio = new MTCongelarTiempo(grafico.getPosicion());
			Mapa.getMapa().agregarEntidad(premio);
		}
	}
}
