package ch17.examplerunnableinterface;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from thread: " + Thread.currentThread().threadId());
    }
}

