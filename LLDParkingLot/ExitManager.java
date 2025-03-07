public class ExitManager {
    //validate the ticket, //create the bill // unpark the vehicle
    private BillGenerator billGenerator;
    private PaymentHandler paymentHandler;

    public ExitManager(BillGenerator billGenerator, PaymentHandler paymentHandler) {
        this.billGenerator = billGenerator;
        this.paymentHandler = paymentHandler;
    }

    public Boolean Validadte(){
        return true;
    }

    public int bill(Ticket ticker){
    }

    public void unpark(Ticket ticket){
        //1.validate
        //2.bill
        //3.unpark
    }
}

