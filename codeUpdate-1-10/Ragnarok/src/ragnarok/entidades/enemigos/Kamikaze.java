package ragnarok.entidades.enemigos;

import ragnarok.armas.ArmaKamikaze;
import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorKamikaze;
import ragnarok.inteligencia.ataques.InteligenciaAtaqueKamikaze;

public abstract class Kamikaze extends Enemigo {
	
	protected final int vidaMax = 50;
	
	public Kamikaze() {
		super();
		
		valor = 30;
		
		arma = new ArmaKamikaze();
		
		vida = 50;
		
		inteligenciaAtaque = new InteligenciaAtaqueKamikaze(new ArmaKamikaze());
		
		colisionador = new ColisionadorKamikaze(arma.getDa�o());
	}
	
	public void actualizar() {
		mover();
	}
	
	public void serChocado(Colisionador col) {
		col.afectarKamikaze(this);
	}
}
