package pl.javastart.healtycalc;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
class BMRMessageConverter extends AbstractHttpMessageConverter<BMRDto> {
    public BMRMessageConverter() {
        super(MediaType.TEXT_PLAIN);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return BMRDto.class.equals(clazz);
    }

    @Override
    protected BMRDto readInternal(Class<? extends BMRDto> clazz, HttpInputMessage inputMessage) throws HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(BMRDto bmrDto, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        outputMessage.getBody().write(Integer.toString(bmrDto.getBmr()).concat("kcal").getBytes(StandardCharsets.UTF_8));
    }
}
