import java.util.List;
import java.util.Random;

public class PaymentManager {
    private PaymentStrategy paymentStrategy;
    private Random random = new Random();
    public PaymentManager(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }
    public paymentStatus pay(List<Seat> seats){
        //Implemented some logic based on paymentStrategy
        //randomness is used to generate failures

        int randomNumber = random.nextInt(100);
        if(randomNumber >= 90)return paymentStatus.FAILURE;
        return paymentStatus.SUCCESS;
    }
}
