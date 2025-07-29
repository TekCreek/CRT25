/**
 * Proxy Pattern -
 *
 * Use the proxy pattern to create a representative object that controls
 * access to another object.
 *
 * Types -
 *
 * Remote Proxy - For accessing a remote object e.g. use case in RMI, API clients
 * 
 * Virtual Proxy - For deferred initialization
 * 
 * Protection proxy - for secured and controlled access to the object.
 * 
 * Smart proxy - for enhancing the behaviour such as logging, caching etc with 
 *               out altering the actual object.
 */

interface StockAPI {
    String getQuote(String ticker);
}

// ---------------Remote service (assume) ------
// Actual impl
class StockAPIImpl implements StockAPI {
    @Override
    public String getQuote(String ticker) {
        return "100";
    }
}
// ------------------------------------------------


class StockAPIProxy implements StockAPI {

    @Override
    public String getQuote(String ticker) {
        // make an REST API call to the webservice.....
        // Just for simulation
        StockAPIImpl impl = new StockAPIImpl();
        return impl.getQuote(ticker);
    }
}


public class ProxyPatternDemo1 {
    public static void main(String[] args) {
        // Client
        StockAPI api = new StockAPIProxy();
        String quote = api.getQuote("someticker");
        System.out.println( quote );
    }
}
