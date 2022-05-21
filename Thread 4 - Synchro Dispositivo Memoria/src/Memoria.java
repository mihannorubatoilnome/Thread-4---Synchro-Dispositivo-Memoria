public class Memoria{
    private float archivio;
    private float spazioLibero;
    private float dati;

    public Memoria(float archivio) {
        this.archivio = archivio;
        this.spazioLibero = archivio;
    }

    public float getArchivio() {
        return archivio / 1000;
    }

    public void setArchivio(float archivio) {
        this.archivio = archivio;
    }

    public synchronized void saveArchivio(){
        //if(this.dati > this.archivio)
        while(this.dati > this.archivio){
            System.out.println(Thread.currentThread().getName()+" ASPETTA!");
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("Memoria Libera : "+this.archivio);
            }
        }
        //else{
            this.dati = (float) (Math.random()*600);
            this.archivio = this.archivio - this.dati;
            System.out.println(Thread.currentThread().getName()+" Salvataggio di "+dati+" MB");
        //}
    }

    public synchronized void delArchivio(){
        //if((this.archivio + this.dati) >= this.spazioLibero)
            //System.out.println("Memoria completamente LIBERA!");
        //else{
            this.dati = (float) (Math.random()*600);
            this.archivio = this.archivio + this.dati;
            System.out.println(Thread.currentThread().getName()+" Eliminazione di "+dati+" MB");
            notifyAll();
        //}
    }

    public synchronized void fattArchivio(){
        this.archivio = this.spazioLibero;
    }
}