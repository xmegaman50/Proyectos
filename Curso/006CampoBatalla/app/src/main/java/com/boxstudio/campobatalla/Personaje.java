package com.boxstudio.campobatalla;

public class Personaje {

    String nombre; //String texto
    int vida; //int numeros
    int ataque;
    int defensa;
    int monedas;


    //declaramos un metodo | funciones
    //es un fragmento de codigo


    public void tomarPocion(int aumento)
    {
        vida = vida+ aumento;
    }

    public void atacar(Personaje enemigo)
    {
        enemigo.vida = enemigo.vida - ataque;
    }
}
