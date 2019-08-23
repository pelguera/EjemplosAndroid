package cibertec.dam1.el02_t5am;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cibertec.dam1.el02_t5am.dao.EmpleadoDAO;
import cibertec.dam1.el02_t5am.modelo.Empleado;

public class MainActivity extends AppCompatActivity {

    private EmpleadoDAO empleadoDAO;
    private Empleado empleado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empleadoDAO = new EmpleadoDAO(this);

        if(empleadoDAO.listarEmpleados().size() < 1){

            Empleado emp1 = new Empleado("Carlos", "Pelaez", "TI", "Jefe Desarrollo");
            Empleado emp2 = new Empleado("Luis", "Mendoza", "Finanzas", "Especialista Finanzas");
            Empleado emp3 = new Empleado("Maria", "Gutierrez", "Contabilidad", "Auxiliar Contable");
            Empleado emp4 = new Empleado("Rosa", "Lopez", "Marketing", "Encargado de Marketing");
            Empleado emp5 = new Empleado("Caleb", "Elguera", "RRHH", "Gerente RRHH");
            Empleado emp6 = new Empleado("Claudia", "Torres", "Finanzas", "Sub Gerente Finanzas");
            Empleado emp7 = new Empleado("Paul", "Elguera", "Contabilidad", "Especialista Contable");
            Empleado emp8 = new Empleado("Roberto", "Valenzuela", "TI", "Lider Tecnico");
            Empleado emp9 = new Empleado("Diana", "Giron", "RRHH", "Especialista RRHH");
            Empleado emp10 = new Empleado("Jorge", "Medina", "TI", "Especialista TI");

            empleadoDAO.insertarEmpleado(emp1);
            empleadoDAO.insertarEmpleado(emp2);
            empleadoDAO.insertarEmpleado(emp3);
            empleadoDAO.insertarEmpleado(emp4);
            empleadoDAO.insertarEmpleado(emp5);
            empleadoDAO.insertarEmpleado(emp6);
            empleadoDAO.insertarEmpleado(emp7);
            empleadoDAO.insertarEmpleado(emp8);
            empleadoDAO.insertarEmpleado(emp9);
            empleadoDAO.insertarEmpleado(emp10);
        }



    }
}
