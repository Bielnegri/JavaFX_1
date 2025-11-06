import java.time.LocalDate;

public class Usuario {
    private String nome;
    private String telefone;
    private String email;
    private LocalDate dataNasc;

    public Usuario(){
        super();
    }

    public Usuario(String nome, String telefone, String email, LocalDate dataNasc){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString(){
        return this.nome + ", " + this.email;
    }
}
