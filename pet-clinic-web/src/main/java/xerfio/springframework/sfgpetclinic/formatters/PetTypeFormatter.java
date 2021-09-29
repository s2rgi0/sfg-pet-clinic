package xerfio.springframework.sfgpetclinic.formatters;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import xerfio.springframework.sfgpetclinic.model.PetType;
import xerfio.springframework.sfgpetclinic.services.PetTypeService;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatter  implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    /**
     * Print the object of type T for display.
     *
     * @param locale the current user locale
     * @return the printed text string
     */
    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    /**
     * Parse a text String to produce a T.
     *
     * @param text   the text string
     * @param locale the current user locale
     * @return an instance of T
     * @throws ParseException           when a parse exception occurs in a java.text parsing library
     * @throws IllegalArgumentException when a parse exception occurs
     */
    @Override
    public PetType parse(String text, Locale locale) throws ParseException {

        Collection<PetType> findPetTypes = petTypeService.findAll();

        for( PetType petType : findPetTypes ){
            if(petType.getName().equals(text)){
                return petType;
            }
        }

        throw new ParseException("type not found "+text, 0);
    }

}
