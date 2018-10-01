package ragnarok.powerups;

import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorPowerUp;
import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;

public abstract class PowerUp extends Entidad {
	
	public PowerUp(Posicion pos) {
		vida = 1;
		colisionador = new ColisionadorPowerUp();
	}
	
	public abstract void activar();
	
	public void serChocado(Colisionador col) {
		col.afectarPowerUp(this);
	}
}
