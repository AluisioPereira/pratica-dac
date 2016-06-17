package ifpb.ads.dac.jsf;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 25/05/2016, 07:51:42
 */
@FacesConverter("converter.LocalDate")
public class ConvertToLocalDate implements Converter {

    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {

        try {
            LocalDate date = LocalDate.parse(value, formato);
            return date;
        } catch (DateTimeParseException ex) {
            throw new ConverterException("Digite corretamente");
        }

    }

    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Object value) {
        LocalDate date = (LocalDate) value;
        return date.format(formato);
    }
}
