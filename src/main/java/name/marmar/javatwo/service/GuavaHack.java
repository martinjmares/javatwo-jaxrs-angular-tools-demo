package name.marmar.javatwo.service;

import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * This is included to bypass the Java EE 7 issue with Google Guava and CDI:
 * Issue 1433:  guava 14.0.1 cannot be deployed in a JEE7 Container
 * https://code.google.com/p/guava-libraries/issues/detail?id=1433
 */
@ApplicationScoped
public class GuavaHack
{
    @Produces
    java.util.Set<Service> dummyServices()
    {
        return ImmutableSet.of();
    }
}