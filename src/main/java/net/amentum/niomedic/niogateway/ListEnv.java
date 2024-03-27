package net.amentum.niomedic.niogateway;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
//import org.springframework.core.env.Environment;

/**
 *
 * @author SRE
 */

public class ListEnv {

@Autowired
Environment env;

    public ListEnv() {
        super();
        listalos();
    }
    
    public void listalos() {
        List<PropertySource> lista = env.getPropertySources();
        for (PropertySource una : lista) {
            Map source = una.getSource();
            System.out.println("En " + una.getName() + ":");
            System.out.println("-->" + source.toString());
        }
    }
}
