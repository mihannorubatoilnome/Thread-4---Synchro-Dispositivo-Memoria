public class App {
    public static void main(String[] args) throws Exception {
        Memoria m = new Memoria(1000);

        Thread t1 = new Utente("Guilot", m);
        Thread t2 = new Utente("Maximoff", m);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //System.out.println("Memoria Libera : "+m.getArchivio()+" GB");
    }
}
