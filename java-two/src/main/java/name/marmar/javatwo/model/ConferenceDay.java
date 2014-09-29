package name.marmar.javatwo.model;

import com.wordnik.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by martinmares on 15.09.14.
 */
@ApiModel( value = "ConferenceDay", description = "Enumeration of days of the conference" )
public enum ConferenceDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY
}
