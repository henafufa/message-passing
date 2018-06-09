
public class Consumer extends Thread { 
    Producer producer; 
    int time;
    Consumer(Producer p) { 
        producer = p; 
    } 
     public static void main(String args[]) { 
        Producer producer = new Producer(); 
        producer.start(); 
        new Consumer( producer ).start(); 
    } 

    public void run() { 
        try { 
            while ( true ) { 
                java.util.Random rand=new java.util.Random();
                int time=rand.nextInt(1000);
                String message = producer.getMessage(); 
                for(int i=0;i <= time;i++){
                    System.out.println("Message received for: " + i +" " + "time"); 
                    System.out.println("---------------------------------"); 
                    System.out.println(message); 
                    sleep(time); 
            } 
        }  }
        catch( InterruptedException e ) { } 
    } 

   
}