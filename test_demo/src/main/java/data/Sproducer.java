package data;

import java.util.ArrayList;

public class Sproducer extends Thread {
    private final static ArrayList<String> numbers=new ArrayList<String>();
    private final static ArrayList<Thread> threads=new ArrayList<Thread>();
    private  volatile boolean negotiating=false;

    private class Negotiation implements  Runnable {
        private String number;
        private Negotiation(String number){
            this.number=number;
        }
        @Override
        public void run() {
            try {
                System.out.println("status negotiation……");
                 sleep(5000);
                if(number.startsWith("7")||number.startsWith("3")){
                    System.out.println("broken.");
                    for(Thread t:threads){
                      t.interrupt();
                    }
                    return;
                }
                System.out.println("ngegotiation succeeds.");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("mi man is killed");
            }
            synchronized (Negotiation.class){
                negotiating=false;
                Negotiation.class.notify();
            }
        }
    }

    private class Carrier implements Runnable{

       private String name;
       private Carrier(String name){
           this.name=name;
       }

       private boolean negotiating(boolean atBeginning){
           synchronized (Negotiation.class){
               while (negotiating){
                   try {
                       System.out.println("["+name+"] join stricks.");

                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           }
       }
        @Override
        public void run() {

        }
    }

}
