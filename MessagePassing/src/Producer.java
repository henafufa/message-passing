import java.util.Vector; 

public class Producer extends Thread { 
    static final int numberMessage = 2; 
    private Vector vector = new Vector(); 
    int time;
    public void run() { 
        try { 
            while ( true ) { 
                java.util.Random rand=new java.util.Random();
                int time=rand.nextInt(1000); 
                for(int i=0;i <= time;i++){
                    System.out.println("Message setted:"+ i);
                    System.out.println("--------------------------------");
                    setMessage(); 
                    System.out.println("--------------------------------");
                    sleep( time ); 
            } 
        }  }
        catch( InterruptedException e ) { } 
    } 

    private synchronized void setMessage() throws InterruptedException { 

        while ( vector.size() == numberMessage ) 
            wait(); 
            vector.add(time, java.util.Timer.class);
            notify(); 
    } 

    // Called by Consumer 
    public synchronized String getMessage() throws InterruptedException { 
        notify(); 
        while ( vector.size() == 0 ) 
            wait(); 
            String message = "message returned"; 
            vector.removeElement( message ); 
            return message; 
    } 
} 
