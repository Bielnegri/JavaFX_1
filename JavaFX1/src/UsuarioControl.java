import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UsuarioControl {
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty nascimento = new SimpleStringProperty("");

    public StringProperty getNomeProperty(){
        return nome;
    }

    public StringProperty getTelefoneProperty() {
        return telefone;
    }

    public StringProperty getEmailProperty() {
        return email;
    }
    
    public StringProperty getNascimentoProperty() {
        return nascimento;
    }

    public void adicionar(){
        Usuario usuario = new Usuario();
        usuario.setNome(nome.get());
        usuario.setTelefone(telefone.get());
        usuario.setEmail(email.get());
        LocalDate dataNasc = LocalDate.parse(nascimento.get());
        usuario.setDataNasc(dataNasc);
        this.usuarios.add(usuario);
    }

    public void buscar(){
        for (Usuario usuario : usuarios) {
            if(usuario.getNome().contains(nome.get())){
                nome.set(usuario.getNome());
                telefone.set(usuario.getTelefone());
                email.set(usuario.getEmail());
                nascimento.set(usuario.getDataNasc().toString());
            }
        }
    }
}
