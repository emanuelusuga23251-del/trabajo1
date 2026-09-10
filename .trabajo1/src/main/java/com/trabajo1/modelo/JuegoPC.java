package com.trabajo1.modelo;

public class JuegoPC implements juegocompleto {
    private juego juego;

    public JuegoPC(juego juego) {
        this.juego = juego;

    }
    @Override
    public String iniciarJuego(juego juego) {
        return "Encendiendo la consola y ejecutando " + juego.getNombre();
    }

    @Override
    public String realizarPartida(juego juego) {
        return "Partida multijugador iniciada en la consola " + juego.getPlataforma();
    }

    @Override
    public String terminarJuego(juego juego) {
        return "Cerrando sesión en la consola para el juego " + juego.getNombre();
    }

    public juego getJuego() { return juego; }
}