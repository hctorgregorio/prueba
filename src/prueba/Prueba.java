package prueba;

import java.util.ArrayList;
import java.util.Random;

public class Prueba {

	public Prueba() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<String> jornadas (ArrayList<String> primerGrupo, ArrayList<String> segundoGrupo, ArrayList<String> partidosPrimeraVuelta, ArrayList<String> partidosSegundaVuelta ) {
		
		Random rnd = new Random();
		
		boolean control = false;
		int cont = 0;
		int condicion = 0;
		
		int aleatorio1;
		int aleatorio2;
		
		String local;
		String visitante;
		String combinacion;
		
		ArrayList<String> aux1 = new ArrayList<String>();
		ArrayList<String> aux2 = new ArrayList<String>();
		
		ArrayList<String> partidosBorradosPrimeraVuelta = new ArrayList<String>();
		ArrayList<String> partidosBorradosSegundaVuelta = new ArrayList<String>();
		
		ArrayList<String> jornadas = new ArrayList<String>();
		
		
		while (control == false) {
			
			aleatorio1 = rnd.nextInt(primerGrupo.size());
			local = primerGrupo.get(aleatorio1);
			aleatorio2 = rnd.nextInt(segundoGrupo.size());
			visitante = segundoGrupo.get(aleatorio2);
			combinacion = local + "#" + visitante;
			
			if (partidosPrimeraVuelta.contains(combinacion)) {
				while (!partidosPrimeraVuelta.get(cont).equals(combinacion)) {
					cont++;
				}
				//poner en el arraylist de vuelta el partido
				jornadas.add(combinacion);
				//poner los equipos que se vayan a borrar en aux1 y aux2
				aux1.add(local);
				aux2.add(visitante);
				//poner el partido que se vaya a borrar en partidosBorradosPrimeraVuelta
				partidosBorradosPrimeraVuelta.add(combinacion);
				//borrar local y visitante de primer y segundo grupo
				primerGrupo.remove(aleatorio1);
				segundoGrupo.remove(aleatorio2);
				//borrar el partido de prartidosPrimeraVuelta
				partidosPrimeraVuelta.remove(cont);
				condicion++;
				cont = 0;
			} else if (partidosSegundaVuelta.contains(combinacion)) {
				while (!partidosSegundaVuelta.get(cont).equals(combinacion)) {
					cont++;
				}
				//poner en el arraylist de vuelta el partido
				jornadas.add(combinacion);
				//poner los equipos que se vayan a borrar en aux1 y aux2
				aux1.add(local);
				aux2.add(visitante);
				//poner el partido que se vaya a borrar en partidosBorradosSegundaVuelta
				partidosBorradosSegundaVuelta.add(combinacion);
				//borrar local y visitante de primer y segundo grupo
				primerGrupo.remove(aleatorio1);
				segundoGrupo.remove(aleatorio2);
				//borrar el partido de prartidosPrimeraVuelta
				partidosSegundaVuelta.remove(cont);
				condicion++;
				cont = 0;
			} else {
				//poner todos los equipos en sus grupos de nuevo
				primerGrupo.addAll(0, aux1);
				segundoGrupo.addAll(0, aux2);
				//poner los partidos borrados
				partidosPrimeraVuelta.addAll(0, partidosBorradosPrimeraVuelta);
				partidosSegundaVuelta.addAll(0, partidosBorradosSegundaVuelta);
				condicion = 0;
				cont = 0;
			}
			if(condicion == 10)
				control = true;
		}
		primerGrupo.addAll(0, aux1);
		segundoGrupo.addAll(0, aux2);
		return jornadas;
		
	}
}
