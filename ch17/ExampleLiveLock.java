package ch17;

public class ExampleLiveLock {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        final PhoneCall buddy1 = new PhoneCall("Patricia");
        final PhoneCall buddy2 = new PhoneCall("Patrick");

        final HangUpButton s = new HangUpButton(buddy1);

        new Thread(new Runnable() {
            public void run() { buddy1.callWith(s, buddy2); }
        }).start();

        new Thread(new Runnable() {
            public void run() { buddy2.callWith(s, buddy1); }
        }).start();
    }

    static class HangUpButton {
        private PhoneCall owner;
        public HangUpButton(PhoneCall d) { owner = d; }
        public PhoneCall getOwner() { return owner; }
        public synchronized void setOwner(PhoneCall d) { owner = d; }
        public synchronized void use() {
            System.out.printf("%s has hang up!", owner.name);
        }
    }

    static class PhoneCall {
        private String name;
        private boolean isDone;

        public PhoneCall(String n) { name = n; isDone = true; }
        public String getName() { return name; }
        public boolean isDone() { return isDone; }

        public void callWith(HangUpButton hangUpButton, PhoneCall buddy) {
            while (isDone) {
                if (hangUpButton.owner != this) {
                    try { Thread.sleep(1); }
                    catch(InterruptedException e) { continue; }
                    continue;
                }

                if (buddy.isDone()) {
                    System.out.printf(
                            "%s: You hang up, buddy %s!%n",
                            name, buddy.getName());
                    hangUpButton.setOwner(buddy);
                    continue;
                }


            }
        }
    }

}
