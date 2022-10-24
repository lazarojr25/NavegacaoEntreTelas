package dadm.quixada.ufc.navegacaoentretelas.model;

public class Disciplina
{

    int id;
    String nome;
    String local;
    String codigo;
    String horario;


    public Disciplina(String nome, String local, String codigo, String horario){
        this.nome = nome;
        this.local = local;
        this.codigo = codigo;
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return nome;
    }
}
