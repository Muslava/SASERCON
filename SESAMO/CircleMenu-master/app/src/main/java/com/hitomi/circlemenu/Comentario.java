package com.hitomi.circlemenu;

//Clase para representar un Comentario
public class Comentario {
    //Campos correspondientes a la base de datos
    int id;
    String nombre;
    String comentario;

    //Constructor
    public Comentario(int _id, String _nombre, String _comentario){
        id=_id;
        nombre=_nombre;
        comentario=_comentario;
    }

    //Represetacion del objeto como cadena de texto
    @Override
    public String toString() {
        return nombre;
    }

    //Metodos de acceso a cada atribito de la clase
    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getComentario(){
        return comentario;
    }


}
