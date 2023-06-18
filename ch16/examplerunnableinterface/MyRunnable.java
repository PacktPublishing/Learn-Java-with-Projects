package ch16.examplerunnableinterface;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from thread: " + Thread.currentThread().getId());
    }
}

