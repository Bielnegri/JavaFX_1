import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TelaUsuario extends Application {

    private UsuarioControl control = new UsuarioControl();
    private TableView<Usuario> tabela = new TableView<>();
    private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane panPrincipal = new BorderPane();

        Scene scene = new Scene(panPrincipal);
        
        GridPane panCampos = new GridPane();

        TextField txtNome = new TextField("");
        TextField txtTelefone = new TextField("");
        TextField txtEmail = new TextField("");
        TextField txtNascimento = new TextField("");

        Bindings.bindBidirectional(txtNome.textProperty(), control.getNomeProperty());
        Bindings.bindBidirectional(txtTelefone.textProperty(), control.getTelefoneProperty());
        Bindings.bindBidirectional(txtEmail.textProperty(), control.getEmailProperty());
        Bindings.bindBidirectional(txtNascimento.textProperty(), control.getNascimentoProperty());

        tabela.setItems(control.getUsuarios());

        TableColumn<Usuario, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getNome()));
        TableColumn<Usuario, String> colTelefone = new TableColumn<>("Telefone");
        colTelefone.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getTelefone()));
        TableColumn<Usuario, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getEmail()));
        TableColumn<Usuario, String> colDataNasc = new TableColumn<>("DataNasc");
        colDataNasc.setCellValueFactory(item -> new ReadOnlyStringWrapper(formatador.format(item.getValue().getDataNasc())));

        tabela.getSelectionModel().selectedItemProperty().addListener((obj, antigo, novo) -> control.atualizar(novo));

        tabela.getColumns().add( colNome );
        tabela.getColumns().add( colTelefone );
        tabela.getColumns().add( colEmail );
        tabela.getColumns().add( colDataNasc );

        panPrincipal.setCenter(tabela);

        panCampos.add(new Label("Nome: "), 0, 0);
        panCampos.add(txtNome, 1, 0);
        panCampos.add(new Label("Telefone: "), 0, 1);
        panCampos.add(txtTelefone, 1, 1);
        panCampos.add(new Label("Email: "), 0, 2);
        panCampos.add(txtEmail, 1, 2);
        panCampos.add(new Label("Nascimento: "), 0, 3);
        panCampos.add(txtNascimento, 1, 3);
        
        panPrincipal.setTop(panCampos);

        Button btnSalvar = new Button("Salvar");
        btnSalvar.setOnAction(e->{
            control.adicionar();
            txtNome.setText(" ");
            txtTelefone.setText(" ");
            txtEmail.setText(" ");
            txtNascimento.setText(" ");
        });
        Button btnBuscar = new Button("Buscar");
        btnBuscar.setOnAction(e->{
            control.buscar();
        });

        HBox panBotoes = new HBox();
        panBotoes.getChildren().addAll(btnSalvar, btnBuscar);

        panPrincipal.setBottom(panBotoes);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(TelaUsuario.class, args);
    }
}
