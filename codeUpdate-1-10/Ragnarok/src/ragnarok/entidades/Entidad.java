package ragnarok.entidades;

import ragnarok.colisiones.Colisionador;
import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;

public abstract class Entidad {
	
	protected float velocidad;
	protected Posicion posHeroe;
	protected Grafico grafico;
	protected int vida;
	protected boolean eliminado;
	protected Colisionador colisionador;
	protected int valor;
	
	//METODOS
	
	public Entidad() {
		vida = 1;
		eliminado = false;
	}
	
	public int getValor() {
		return valor;
	}
	
	public Posicion getPosHeroe() {
		return posHeroe;
	}
	
	public void setPosHeroe(Posicion p) {
		posHeroe=p;
	}
	
	public Posicion getPos() {
		return grafico.getPosicion();
	}
	
	public void setPosicion(float x, float y ) {
		grafico.setPosicion(x, y);
	}
	
	public float getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(float v) {
		velocidad=v;
	}
	
	public void actualizar() {}
	
	public int getVida() {
		return vida;
	}
	
	public void dañar(int daño) {
		vida-=daño;
	}
	
	public boolean estaEliminado() {
		return eliminado;
	}
	
	public void eliminar() {
		eliminado = true;
	}
	
	public Grafico getGrafico() {
		return grafico;
	}
	
	public boolean colisiona(Entidad e) {
		boolean choca = false;
		if (e.getGrafico().colisiona(this.getGrafico())) {
			choca = true;
		}
		return choca;
	}
	
	public void colisionar(Entidad e) {
		e.serChocado(colisionador);
	}
	
	public abstract void serChocado(Colisionador col); //accept
}
