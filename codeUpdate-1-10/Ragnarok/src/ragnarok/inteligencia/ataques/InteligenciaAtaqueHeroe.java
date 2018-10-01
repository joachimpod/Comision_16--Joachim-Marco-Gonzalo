package ragnarok.inteligencia.ataques;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import ragnarok.armas.Arma;
import ragnarok.disparos.Flecha;
import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;
import ragnarok.principal.Mapa;

public class InteligenciaAtaqueHeroe extends Inteligencia {

	protected Arma arma;
	
	public InteligenciaAtaqueHeroe(Arma a) {
		arma = a;
	}
	
	public void atacar(Entidad e) {
		Posicion pos = e.getPos();
		Posicion posDisp = new Posicion(pos.getX()+1+e.getGrafico().getAncho(),pos.getY()+(e.getGrafico().getAlto()/2));
		if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			Flecha flecha = new Flecha(posDisp,arma.getDaño());
			Mapa.getMapa().agregarEntidad(flecha);
		}
	}
}
