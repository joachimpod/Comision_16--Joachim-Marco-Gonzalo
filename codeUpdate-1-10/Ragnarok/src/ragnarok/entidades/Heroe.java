package ragnarok.entidades;

import com.badlogic.gdx.graphics.Texture;

import ragnarok.armas.ArmaHeroe;
import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorJugador;
import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;
import ragnarok.inteligencia.ataques.InteligenciaAtaqueHeroe;
import ragnarok.inteligencia.movimientos.InteligenciaHeroe;
import ragnarok.principal.Juego;
import ragnarok.puntaje.Puntaje;

public class Heroe extends Entidad{
	
	private final int vidaMax = 100;
	private Inteligencia inteligenciaAtaque;
	private Inteligencia inteligenciaMovimiento;
	private Puntaje puntos;
	
	public Heroe() {
		super();
		
		puntos = new Puntaje();
		
		iniciarGraficamente();
		
		iniciarInteligencias();
		
		vida = 100;
		
		velocidad = 7;
		
		colisionador = new ColisionadorJugador();
		
	}
	
	private void iniciarGraficamente() {
		grafico = new Grafico(new Texture("img/heroe.jpg"));
		Posicion posicion = new Posicion(20,(Juego.ALTO-Juego.caminable)/2);
		grafico.setPosicion(posicion.getX(), posicion.getY());
	}
	
	private void iniciarInteligencias() {
		inteligenciaAtaque = new InteligenciaAtaqueHeroe(new ArmaHeroe());
		inteligenciaMovimiento= new InteligenciaHeroe();
	}
	
	public void actualizar() {
		mover();
		atacar();
	}
	
	private void mover() {
		inteligenciaMovimiento.mover(this);
	}
	
	private void atacar() {
		inteligenciaAtaque.atacar(this);
	}

	public void serChocado(Colisionador col) {
		col.afectarHeroe(this);
	}
	
	public void sumarPuntaje(int p) {
		puntos.sumarPuntaje(p);
	}
	
	public int getPuntaje() {
		return puntos.getPuntaje();
	}
}
