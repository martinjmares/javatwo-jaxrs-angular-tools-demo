package name.marmar.javatwo.filter;

import org.glassfish.jersey.message.filtering.EntityFiltering;

import javax.enterprise.util.AnnotationLiteral;
import java.lang.annotation.*;

/**
 * Created by martinmares on 29.09.14.
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EntityFiltering
public @interface RoomDetailView {

}
