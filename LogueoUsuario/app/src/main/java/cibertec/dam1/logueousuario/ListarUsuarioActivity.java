package cibertec.dam1.logueousuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.List;

import cibertec.dam1.logueousuario.Adapters.AdapterListaUsuario;
import cibertec.dam1.logueousuario.Dao.UsuarioDAO;
import cibertec.dam1.logueousuario.Modelo.Usuario;

public class ListarUsuarioActivity extends AppCompatActivity {

    private ListView lvListaUsuarios;
    private Usuario usuario;
    private UsuarioDAO usuarioDAO;
    private List<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuario);

        this.usuarioDAO = new UsuarioDAO(this);
        listaUsuarios = usuarioDAO.listarUsuarios();

        this.lvListaUsuarios = (ListView) findViewById(R.id.lvListaUsuarios);
        AdapterListaUsuario adapter = new AdapterListaUsuario(this,R.layout.item_lista_usuario, this.listaUsuarios);
        this.lvListaUsuarios.setAdapter(adapter);

    }

}
