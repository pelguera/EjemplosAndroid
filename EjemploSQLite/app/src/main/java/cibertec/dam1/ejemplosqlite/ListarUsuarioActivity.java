package cibertec.dam1.ejemplosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import cibertec.dam1.ejemplosqlite.Adapters.AdapterUsuarios;
import cibertec.dam1.ejemplosqlite.DAO.UsuarioDAO;
import cibertec.dam1.ejemplosqlite.Modelo.Usuario;

public class ListarUsuarioActivity extends AppCompatActivity {

    private ListView lvLista;
    private List<Usuario> listaUsuario;
    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuario);

        this.lvLista = findViewById(R.id.lvListaUsuarios);
        this.usuarioDAO = new UsuarioDAO(this);

        this.listaUsuario = usuarioDAO.listarUsuarios();

        AdapterUsuarios adapter = new AdapterUsuarios(this, R.layout.list_item, this.listaUsuario);
        this.lvLista.setAdapter(adapter);

    }
}
