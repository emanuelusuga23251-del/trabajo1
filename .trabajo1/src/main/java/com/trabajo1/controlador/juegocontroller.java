package com.trabajo1.controlador;
import com.trabajo1.modelo.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
public class juegocontroller {
    // Clase auxiliar interna para transferir la información a la vista de manera estructurada
    public static class ResultadoJuego {
        private String tipo;
        private String mensajeInicio;
        private String mensajePartida;
        private String mensajeFin;

        public ResultadoJuego(String tipo, String mensajeInicio, String mensajePartida, String mensajeFin) {
            this.tipo = tipo;
            this.mensajeInicio = mensajeInicio;
            this.mensajePartida = mensajePartida;
            this.mensajeFin = mensajeFin;
        }
        public String getTipo() { return tipo; }
        public String getMensajeInicio() { return mensajeInicio; }
        public String getMensajePartida() { return mensajePartida; }
        public String getMensajeFin() { return mensajeFin; }
    }
    @GetMapping("/")
    public String mostrarJuegos(Model model) {
        // Polimorfismo: Creamos una lista usando el tipo de la interfaz
        List<juegocompleto> listaJuegos = new ArrayList<>();

        // Instanciar 9 objetos de las 3 clases concretas con diferentes Objetos "Juego"
        juego j1 = new  juego("Cyberpunk 2077", "PC Steam", "RPG");
        juego j2 = new  juego("Valorant", "PC Windows", "FPS");
        juego j3 = new  juego("World of Warcraft", "PC Battle.net", "MMORPG");

        juego j4 = new  juego("God of War", "PlayStation 5", "Acción");
        juego j5 = new  juego("Halo Infinite", "Xbox Series X", "Shooter");
        juego j6 = new  juego("Zelda: Tears of the Kingdom", "Nintendo Switch", "Aventura");

        juego j7 = new  juego("Clash Royale", "Android", "Estrategia");
        juego j8 = new  juego("Genshin Impact", "iOS", "RPG");
        juego j9 = new  juego("Free Fire", "Android", "Battle Royale");

        // Agregamos los 9 objetos a la lista mediante Polimorfismo
        listaJuegos.add(new JuegoPC(j1));
        listaJuegos.add(new JuegoPC(j2));
        listaJuegos.add(new JuegoPC(j3));

        listaJuegos.add(new JuegoConsola(j4));
        listaJuegos.add(new JuegoConsola(j5));
        listaJuegos.add(new JuegoConsola(j6));

        listaJuegos.add(new JuegoMovil(j7));
        listaJuegos.add(new JuegoMovil(j8));
        listaJuegos.add(new JuegoMovil(j9));

        List<ResultadoJuego> resultados = new ArrayList<>();

        // Iteración polimórfica sobre los 9 objetos
        for (juegocompleto juegoObjeto : listaJuegos) {
            juego j = null;
            if (juegoObjeto instanceof JuegoPC) j = ((JuegoPC) juegoObjeto).getJuego();
            else if (juegoObjeto instanceof JuegoConsola) j = ((JuegoConsola) juegoObjeto).getJuego();
            else if (juegoObjeto instanceof JuegoMovil) j = ((JuegoMovil) juegoObjeto).getJuego();

            // Llamada polimórfica a los 3 métodos
            String inicio = juegoObjeto.iniciarJuego(j);
            String partida = juegoObjeto.realizarPartida(j);
            String fin = juegoObjeto.terminarJuego(j);

            resultados.add(new ResultadoJuego(juegoObjeto.getClass().getSimpleName(), inicio, partida, fin));
        }

        // Enviar la lista de resultados a la plantilla Thymeleaf
        model.addAttribute("resultados", resultados);

        return "vista";
    }
}
