package dataRace;

import org.junit.Test;

public class DataRaceTest {
    boolean buggy;
    private DataRace ti;
    public void DataRaceTest(){
	    ti = new DataRace();
    	buggy = false;
    }
    @Test
    public void test1(){
        run();
	    if(buggy){
		    System.out.println("Bug Found .. ");
    	}
    }


    /*@Test
    public void test2(){
        run();
	    if(buggy){
		    System.out.println("Bug Found for API .. ");
    	}
    }*/

    public void run() {
	    int threadsNum = 3;
	    // Threads to run the buggy method
	    Thread[] ts = new Thread[threadsNum];
	    for (int i = 0; i < threadsNum; i++) {
	        ts[i] = new TestThread();
	        ts[i].start();
	    }	     
        for (int i = 0; i < threadsNum; i++) {
	        try {
    	         ts[i].join();
	         } catch (InterruptedException e) {
    	     e.printStackTrace();
	         }
         }
    }

    private class TestThread extends Thread {
        public void run() {
	        String[] rt = ti.request3();
	        int rt4 = ti.request4();
    	    // Check if elements returned by buggy method is null.
	        // It has probability to be null at buggy version.
	        for (String s : rt) {
    	        if (s == null) {
    	          buggy = true;
	              System.out.println("buggy ..........");
	              //buggy = true;
    	         throw new NullPointerException();					
	            }
            }

    	    if (rt4 < 1) {
    	      buggy = true;
	          System.out.println("buggy in API..........");
	          //buggy = true;
    	     throw new NullPointerException();					
	        }
	   }
    }
}
