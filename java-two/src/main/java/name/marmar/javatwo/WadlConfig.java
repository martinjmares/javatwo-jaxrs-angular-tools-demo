package name.marmar.javatwo;

import org.glassfish.jersey.server.wadl.config.WadlGeneratorConfig;
import org.glassfish.jersey.server.wadl.config.WadlGeneratorDescription;
import org.glassfish.jersey.server.wadl.internal.generators.resourcedoc.WadlGeneratorResourceDocSupport;

import java.util.List;

/**
 * Created by martinmares on 23.09.14.
 */
public class WadlConfig extends WadlGeneratorConfig {

  @Override
  public List<WadlGeneratorDescription> configure() {
        return generator(WadlGeneratorResourceDocSupport.class)
            .prop("resourceDocStream", "resourcedoc.xml")
            .descriptions();
  }

}
