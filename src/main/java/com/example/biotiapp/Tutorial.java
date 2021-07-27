package com.example.biotiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Tutorial extends AppCompatActivity {

    EditText instrucciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        instrucciones = (EditText)findViewById(R.id.editTextTextMultiLine);
        String texto = "Para realizar la medición no debes olvidar usar tus guantes y tener una lupa para ver mejor los macroinvertebrados.\n" +
                "\n" +
                "La aplicación cuenta con una interfaz de simple uso que te ayudará a saber el nombre de cada invertebrado solo por su apariencia.\n" +
                "\n" +
                "Lo primero que debes hacer es crear una nueva medición. Para esto ingresas el nombre, fecha y hora de la medición.\n" +
                "\n" +
                "Una vez creada la medición, debes agregar los macroinvertebrados que encuentre. Ten en cuenta que solo debes agregar una vez el tipo de macroinvertebrado, aún si ves muchos de esa clase.\n" +
                "\n" +
                "Cuando acabes de agregar todas las clases de macroinvertebrados que viste solo dale al botón de calcular.\n" +
                "\n" +
                "En la parte de historial de mediciones aparecerán todas las mediciones que tomes. Si quieres borrarlas solo oprime la caneca en la parte superior derecha.\n" +
                "\n" +
                "La app cuenta con una galería de imágenes donde puedes ver mejor la imagen de cada uno de los macroinvertebrados si oprimes sobre ellos. Así mismo se encuentra su índice BMWP relacionado, que es el que se usa para medir la calidad del agua.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Esta aplicación fue desarrollada por estudiantes de TPI de la Universidad Nacional de Colombia para Corpochivor.";
        instrucciones.setText(texto);

    }
}