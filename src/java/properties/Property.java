package properties;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Doñan
 */

public class Property {
    
    public static Properties getProp() {
        try {
            Properties prop = new Properties();
            prop.load(Property.class.getResourceAsStream("BD.properties"));
            return prop;
        } catch (IOException ex) {
            Logger.getLogger(Property.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
