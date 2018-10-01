package ragnarok.disparos;

import ragnarok.entidades.Entidad;
import ragnarok.inteligencia.Inteligencia;

public abstract class Disparo extends Entidad{
	
	protected Inteligencia inteligenciaMovimiento;
	
	public void actualizar() {
		mover();
	}
	
	private void mover() {
		inteligenciaMovimiento.mover(this);
	}
}
