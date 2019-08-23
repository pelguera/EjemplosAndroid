package cibertec.dam1.el02t5bm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import cibertec.dam1.el02t5bm.adapter.MyAdapter;
import cibertec.dam1.el02t5bm.dao.AlumnoDAO;
import cibertec.dam1.el02t5bm.modelo.Alumno;

public class MainActivity extends AppCompatActivity  implements View .OnClickListener, AdapterView.OnItemClickListener {

    private AlumnoDAO alumnoDAO;
    private Alumno alumno;
    private List<Alumno> alumnos = null;
    private ListView lvlista;
    private Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         lvlista=findViewById(R.id.lvLista);
         btnListar=findViewById(R.id.btnListar);
         btnListar.setOnClickListener(this);
         lvlista.setOnItemClickListener(this);
        this.alumnoDAO = new AlumnoDAO(this);
        //List<Alumno>
                alumnos = alumnoDAO.listarAlumnos();
        if(this.alumnoDAO.listarAlumnos().size() < 1){

            Alumno alu1 = new Alumno("Carlos", "Pelaez", "Inicial", "4 años");
            Alumno alu2 = new Alumno("Luis", "Perez", "Primaria", "5to");
            Alumno alu3 = new Alumno("Blanca", "Gonzales", "Secundaria", "2do");
            Alumno alu4 = new Alumno("Joaquin", "Rubio", "Inicial", "5 años");
            Alumno alu5 = new Alumno("Nicola", "Mendoza", "Inicial", "5 años");
            Alumno alu6 = new Alumno("Alexia", "Lopez", "Secundaria", "5to");
            Alumno alu7 = new Alumno("Jorge", "Gutierrez", "Primaria", "6to");
            Alumno alu8 = new Alumno("Yago", "Soto", "Primaria", "1ero");
            Alumno alu9 = new Alumno("Luhana", "Miranda", "Secundaria", "3ero");
            Alumno alu10 = new Alumno("Domenica", "Mendiola", "Inicial", "4 años");

            alumnoDAO.insertarAlumno(alu1);
            alumnoDAO.insertarAlumno(alu2);
            alumnoDAO.insertarAlumno(alu3);
            alumnoDAO.insertarAlumno(alu4);
            alumnoDAO.insertarAlumno(alu5);
            alumnoDAO.insertarAlumno(alu6);
            alumnoDAO.insertarAlumno(alu7);
            alumnoDAO.insertarAlumno(alu8);
            alumnoDAO.insertarAlumno(alu9);
            alumnoDAO.insertarAlumno(alu10);


        }


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnListar){
           // List<Alumno> alumnos = alumnoDAO.listarAlumnos();
            MyAdapter adaptador = new MyAdapter(this,R.layout.list_item,alumnos);
            lvlista.setAdapter(adaptador);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Alumno alu = alumnos.get(position);

        Intent i = new Intent(MainActivity.this, DetalleAlumno.class);
        i.putExtra("Nombre", alu.getNombre());
        i.putExtra("Apellido", alu.getApellido());
        i.putExtra("Nivel",alu.getNivel());
        i.putExtra("Grado",alu.getGrado());

        startActivity(i);

    }
}
