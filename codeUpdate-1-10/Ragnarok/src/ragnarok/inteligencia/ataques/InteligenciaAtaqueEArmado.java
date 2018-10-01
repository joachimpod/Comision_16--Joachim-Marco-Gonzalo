package ragnarok.inteligencia.ataques;

import ragnarok.armas.Arma;
import ragnarok.disparos.FlechaE;
import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;
import ragnarok.principal.Mapa;

public class InteligenciaAtaqueEArmado extends Inteligencia{
	
	protected Arma arma;
	protected int timer;
	
	public InteligenciaAtaqueEArmado(Arma a) {
		timer = 0;
		arma = a;
	}
	
	public void atacar(Entidad e) {
		Posicion pos = e.getPos();
		Posicion posDisp = new Posicion(pos.getX()-1,pos.getY()+(e.getGrafico().getAlto()/2));
		if (timer>=100) {
			FlechaE flecha = new FlechaE(posDisp,arma.getDaño());
			Mapa.getMapa().agregarEntidad(flecha);
			timer = 0;
		}
		timer++;
	}
}
