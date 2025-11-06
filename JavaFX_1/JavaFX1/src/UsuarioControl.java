import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UsuarioControl {
    private ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty nascimento = new SimpleStringProperty("");
    private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

    public ObservableList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void adicionar(){
        Usuario usuario = new Usuario();
        usuario.setNome(nome.get());
        usuario.setTelefone(telefone.get());
        usuario.setEmail(email.get());
        LocalDate dataNasc = LocalDate.parse(nascimento.get(), formatador);
        usuario.setDataNasc(dataNasc);
        this.usuarios.add(usuario);
    }

    public void atualizar(Usuario usuario){
        if(usuario != null){
            nome.set(usuario.getNome());
            email.set(usuario.getEmail());
            telefone.set(usuario.getTelefone());
            nascimento.set(formatador.format(usuario.getDataNasc()));
        }
    }

    public void buscar(){
        for (Usuario usuario : usuarios) {
            if(usuario.getNome().contains(nome.get())){
                nome.set(usuario.getNome());
                telefone.set(usuario.getTelefone());
                email.set(usuario.getEmail());
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                nascimento.set(usuario.getDataNasc().format(formatador));
            }
        }
    }
}
