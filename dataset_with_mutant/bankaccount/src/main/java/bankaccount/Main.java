//package bankaccount;
//
//import specifications.Configuration;
//
///**
// * @author chupanw
// */
//public class Main {
//    public static void main(String[] args) {
//        new Main();
//    }
//
//    private Application a;
//
//    private Application b;
//
//   // private Configuration fm = new Configuration();   // we need to call the <init> of FM in order to set features for plain executions.
//
//    public Main() {
//    	Configuration.bankaccount=true;
//    	Configuration.creditworthiness=true;
//    	Configuration.transaction=true;
//        a = new Application();
//        b = new Application();
//        if (Configuration.bankaccount) {
//            getA().account.update(100);
//            getB().account.update(200);
//            getA().nextDay();
//            getB().nextYear();
//        }
//
//        if (Configuration.creditworthiness) {
//            getA().account.credit(10);
//            getB().account.credit(20);
//        }
//
//        if (Configuration.transaction) {
//            new Transaction().transfer(getA().account, getB().account, 30);
//           // new Transaction().transfer(getB().account, getA().account, 100);
//        }
//
//        System.out.println(" a: "+a.account.balance);
//        System.out.println(" b: "+b.account.balance);
//    }
//
//    private Application getA() {
//        return a;
//    }
//
//    private Application getB() {
//        return b;
//    }
//}
