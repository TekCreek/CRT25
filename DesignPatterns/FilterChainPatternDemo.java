import java.util.List;
import java.util.Arrays;

// Filter interface
interface MyFilter {
    void doFilter(String request, String response, MyFilterChain chain);
}

// Filter Chain class
class MyFilterChain {
    private List<MyFilter> filters;
    private int index = 0;

    public MyFilterChain(List<MyFilter> filters) {
        this.filters = filters;
    }

    public void doFilter(String request, String response) {
        if (index < filters.size()) {
            MyFilter filter = filters.get(index++);
            filter.doFilter(request, response, this);
        } else {
            System.out.println("Reached end of filter chain.");
        }
    }
}

// Concrete filter: Authentication
class AuthenticationFilter implements MyFilter {
    public void doFilter(String request, String response, MyFilterChain chain) {
        System.out.println("AuthenticationFilter: Checking authentication...");
        chain.doFilter(request, response);
    }
}

// Concrete filter: Logging
class LoggingFilter implements MyFilter {
    public void doFilter(String request, String response, MyFilterChain chain) {
        System.out.println("LoggingFilter: Logging request...");
        chain.doFilter(request, response);
    }
}

// "Main" class renamed as FilterChainPatternDemo
public class FilterChainPatternDemo {
    public static void main(String[] args) {
        MyFilter authFilter = new AuthenticationFilter();
        MyFilter loggingFilter = new LoggingFilter();

        MyFilterChain filterChain = new MyFilterChain(Arrays.asList(authFilter, loggingFilter));

        filterChain.doFilter("requestData", "responseData");
    }
}

