public class Utente extends Thread{
    Memoria m;
    private String nome;
    
    public Utente(String nome, Memoria m) {
        this.m = m;
        this.setName(nome);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.setName(nome);
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            m.saveArchivio();
        }
        for (int i = 0; i < 5; i++) {
            m.delArchivio();
        }
    }
}
