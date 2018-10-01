package ragnarok.principal;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import ragnarok.entidades.Entidad;
import ragnarok.entidades.Heroe;
import ragnarok.entidades.enemigos.EnemigoArmado;
import ragnarok.entidades.enemigos.EnemigoArmadoEspecial;
import ragnarok.entidades.enemigos.KamikazeBuscador;
import ragnarok.entidades.enemigos.KamikazeEspecial;
import ragnarok.entidades.enemigos.KamikazeMareado;
import ragnarok.obstaculos.Barrera;
import ragnarok.obstaculos.Obstaculo;

public class Mapa {
	
	private static Mapa mapa;
	private int cantEntidades;
	private int nivel;
	private  Collection<Entidad> coleccionEntidades;
	private int vidasExtra;
	
	private Heroe heroe;
	
	private Mapa() {
		heroe=new Heroe();
		vidasExtra = 3;
		nivel = 1;
		cantEntidades = 1;
		coleccionEntidades = new CopyOnWriteArrayList<Entidad>();
        crearEntidades(nivel);
        agregarEntidad(heroe);
	}
	
	private void crearEntidades(int nivel) {
		switch (nivel) {
			case 1 : {
					//2 Kamikazes buscadores, 1 kamikaze mareado
					generarTodo(2,1,0,0,0,0,0);
				break;
			}
			case 2 : {
					//1 kamikaze buscador,2 Kamikaze mareado, 2 enemigos armados
				generarTodo(1,2,0,2,0,0,0);
				break;
					
			}
			case 3 : {
				//, 2 kamikazes mareados,2 Enemigos armados, 1 enemigo armado especial
				generarTodo(0,2,0,2,1,0,0);
			break;
				
			}
			case 4 : {
				//1 kamikaze buscador, 1 kamikaze mareado, 3 enemigos armados,2 Enemigos armados especiales
				generarTodo(1,1,0,3,2,0,0);
			break;
				
			}
			case 5 : {
				// 2 kamikaze buscador, 2 kamikaze mareado,4 enemigos armados, 2 enemigos armados especiales
				generarTodo(2,2,0,4,2,0,0);
			break;
				
			}
			case 6 : {
				// 2 kamikaze buscadores,2 kamikaze mareado, 2 enemigos armados especiales, 2 barreras, 2 obstaculos
				generarTodo(2,2,0,0,2,2,2);
			break;
				
			}
			case 7 : {
				//4 kamikazes buscadores,2 kamikazes especiales,2 Enemigos armados, 2 enemigos armados especiales,  4 obstaculos
				generarTodo(4,0,2,2,2,0,4);
			break;
				
			}
			case 8 : {
				// 4 kamikazes buscadores,2 kamikaze mareados, 2 kamikaze especiales, 4 enemigos armados, 2 enemigos armados especiales, 2 barreras, 2 obstaculos
				generarTodo(4,2,2,4,2,2,2);
			break;
				
			}
			case 9 : {
				// 3 kamikaze buscador,4 kamikaze mareado, 2 kamikaze especial, 6 enemigos armados, 1 enemigo armado especial, 3 barreras, 1 obstaculo
				generarTodo(3,4,2,6,1,3,1);
			break;
				
			}
			case 10 : {
				//4 kamikaze buscador,2 kamikaze mareado,  2 kamikaze especial, 9 enemigo armado, 3 enemigo armado especial, 4 barreras
				generarTodo(4,2,2,9,3,4,0);
			break;
				
			}
		}
		setPosiciones(coleccionEntidades);
		cantEntidades = coleccionEntidades.size();
	}
	private void generarTodo(int KB,int KM,int KE,int EA,int EAE,int B,int O) {
		int aux;
		for (aux=0;aux<KB;aux++) {
			coleccionEntidades.add(new KamikazeBuscador());
		}
		for (aux=0;aux<KM;aux++) {
			coleccionEntidades.add(new KamikazeMareado());
		}
		for (aux=0;aux<KE;aux++) {
			coleccionEntidades.add(new KamikazeEspecial());
		}
		for (aux=0;aux<EA;aux++) {
			coleccionEntidades.add(new EnemigoArmado());
		}
		for (aux=0;aux<EAE;aux++) {
			coleccionEntidades.add(new EnemigoArmadoEspecial());
		}
		for (aux=0;aux<B;aux++) {
			coleccionEntidades.add(new Barrera());
		}
		for (aux=0;aux<O;aux++) {
			coleccionEntidades.add(new Obstaculo());
		}
	}
	
	private void setPosiciones(Collection<Entidad> lista) {
		for(Entidad entidad:lista) {
			if (entidad != heroe) {
				Random rnd = new Random();
				int alto =(int) entidad.getGrafico().getAlto();
				int ancho =(int) entidad.getGrafico().getAncho();
				entidad.setPosicion(rnd.nextInt(700)-ancho+100,rnd.nextInt(350)+alto);
			}
		}
	}
		
	public int cantEntidades() {
		cantEntidades=coleccionEntidades.size();
		return cantEntidades;
	}
		
	public Collection<Entidad> getEntidades() {
		return coleccionEntidades;
	}
	
	public Heroe getHeroe() {
		return heroe;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public static Mapa getMapa() {
		if (mapa==null) {
			mapa=new Mapa();
		}
		return mapa;
	}
	
	public void subirNivel() {
		nivel++;
		crearEntidades(nivel);
	}
	
	public void resetearNivel() {
		coleccionEntidades = new CopyOnWriteArrayList<Entidad>();
		if (vidasExtra>0) {
			int puntaje = heroe.getPuntaje();
			heroe = new Heroe();
			heroe.sumarPuntaje(puntaje);
			agregarEntidad(heroe);
			crearEntidades(nivel);
			vidasExtra--;
		}
		else {
			System.out.println("GAMEOVER");
			//gameover();
		}
	}
	
	public void agregarEntidad(Entidad e) {
		coleccionEntidades.add(e);
	}
	
	public void eliminarEntidad(Entidad e) {
		coleccionEntidades.remove(e);
	}
}
