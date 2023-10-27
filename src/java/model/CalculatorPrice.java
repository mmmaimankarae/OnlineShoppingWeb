package model;
/* mmmaimankarae */
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/* service of calculator */
@WebService(serviceName = "TotalPrice")
public class CalculatorPrice {
    @WebMethod(operationName = "sumOfMovie")
    public int sumOfMovie(@WebParam(name = "qty") int qty, @WebParam(name = "price") int price) {
        int sum = qty * price;
        return sum;
    }
}
