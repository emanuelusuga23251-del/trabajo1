package com.trabajo1.modelo;

public class JuegoMovil implements juegocompleto{
    private juego juego;

    public JuegoMovil(juego juego) {
        this.juego = juego;
    }

    @Override
    public String iniciarJuego(juego juego) {
        return "Abriendo la App móvil: " + juego.getNombre();
    }

    @Override
    public String realizarPartida(juego juego) {
        return "Jugando una partida rápida táctil en el teléfono " + juego.getPlataforma();
    }

    @Override
    public String terminarJuego(juego juego) {
        return "Minimizando y cerrando la app de " + juego.getNombre();
    }

    public juego getJuego() { return juego; }
}
