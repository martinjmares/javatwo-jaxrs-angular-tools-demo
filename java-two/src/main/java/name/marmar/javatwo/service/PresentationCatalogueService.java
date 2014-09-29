package name.marmar.javatwo.service;

import name.marmar.javatwo.model.ConferenceDay;
import name.marmar.javatwo.model.Presentation;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Represents modifiable list of presentations.
 */
@Singleton
public class PresentationCatalogueService {

    private final List<Presentation> presentations = new ArrayList<>();
    {
        presentations.add(new Presentation("Groovy on the Moon", "Armstrong", 101, ConferenceDay.MONDAY));
        presentations.add(new Presentation("Tea or Coffee", "Geremy", 102, ConferenceDay.MONDAY));
        presentations.add(new Presentation("The game theory", "Caesar", 101, ConferenceDay.TUESDAY));
        presentations.add(new Presentation("Coding in the rain", "Kelly", 101, ConferenceDay.WEDNESDAY));
        presentations.add(new Presentation("StarWARs and StarEARs", "Lucas", 1024, ConferenceDay.TUESDAY));
    }

    public PresentationCatalogueService() {
    }

    public List<Presentation> listPresentations() {
        return Collections.unmodifiableList(presentations);
    }

    public List<Presentation> findByDay(ConferenceDay day) {
        if (day == null) {
            return Collections.EMPTY_LIST;
        }
        List<Presentation> result = new ArrayList<>();
        for (Presentation p : presentations) {
            if (day == p.getConferenceDay()) {
                result.add(p);
            }
        }
        return result;
    }

    public void add(Presentation presentation) {
        presentations.add(presentation);
    }
}
