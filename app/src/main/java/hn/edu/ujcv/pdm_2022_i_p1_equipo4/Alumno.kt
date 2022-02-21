package hn.edu.ujcv.pdm_2022_i_p1_equipo4

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.regex.Pattern

class Alumno {


    var NumeroCuenta : String =""
        set(value){
            val pattern = "20[0-9][0-9][1,2][3,2]0[0-9][0-9][1-9]" //expresion para validar un numero de cuenta.
            if(Pattern.matches(pattern, value)){
                field = value
            }else{
                throw IllegalArgumentException("1")
            }
        }
    var Nombre : String = ""
        set(value){
            val pattern = "^([A-Z][a-záéíóú]* )(([A-Z][a-záéíóú]* [A-Z][a-záéíóú]*)|([A-Z][a-záéíóú]*)|([A-Z][a-záéíóú]* [A-Z][a-záéíóú]* [A-Z][a-záéíóú]*))\$" //expresion para validar un nombre, minimo 2 nombres y 1 apellido
            if(Pattern.matches(pattern,value)){
                field = value
            }else{
                throw IllegalArgumentException("2")
            }
        }
    var Carrera : String = ""
        set(value) {
            val pattern = "^[A-Z][a-záéíóú]* ([a-záéíóú]* [a-záéíóú]*|[a-záéíóú]*)\$" //expresion para validar un nombre de carrera como: Ingenieria en infotecnologia o Administracion empresas
            if(Pattern.matches(pattern,value)){
                field = value
            }else{
                throw IllegalArgumentException("3")
            }
        }
    var FechaIngreso : String = ""
        set(value){
            val formato = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            try{
                val date = LocalDate.parse(value,formato)
                field = date.format(formato)
            }catch (ex : java.time.DateTimeException){
                throw IllegalArgumentException("4")
            }
        }
    var Correo : String = ""
        set(value) {
            val pattern = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})\$" //expresion para validar correo como: algo@algunservidor.com o nombre.apellido@servidor.dominio.com
            if(Pattern.matches(pattern,value)){
                field = value
            }else{
                throw IllegalArgumentException("5")
            }
        }

    constructor()
    constructor(numCuenta:String, nombre:String, carrera:String, fechaIngreso:String, correo:String){
        this.NumeroCuenta = numCuenta
        this.Nombre = nombre
        this.Carrera = carrera
        this.FechaIngreso = fechaIngreso
        this.Correo = correo
    }

    fun guardarAlumno(){
        SingletonEstudiantes.listaAlumnos.add(this)
    }

    override fun toString(): String {
        return "NumCuenta: $NumeroCuenta, Nombre: $Nombre, Carrera: $Carrera, FechaIngreso: $FechaIngreso, Correo: $Correo"
    }
}