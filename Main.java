public class Main {
    public static void main(String[] args) {
        bankAccount acc = new bankAccount("Bob");
        bankAccount acc2 = new bankAccount("Lisa");
        System.out.println(acc.getBalance());
        System.out.println(acc2.getBalance());
        System.out.println(acc.transferFunds(acc2, 500));
        System.out.println(acc.getBalance());
        System.out.println(acc2.getBalance());
        System.out.println(acc.transferFunds(acc2, 1600));
    }
}