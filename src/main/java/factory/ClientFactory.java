package factory;


import beans.ClientBean;
import org.springframework.stereotype.Service;

/**
 * Created by ausova on 06.02.16.
 */

public interface ClientFactory {
    ClientBean createClientBean();
}
