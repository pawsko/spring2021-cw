package pl.javastart.healtycalc;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
class BMIMessageConverter extends AbstractHttpMessageConverter<BMIDto> {
    public BMIMessageConverter() {
        super(MediaType.TEXT_PLAIN);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return BMIDto.class.equals(clazz);
    }

    @Override
    protected BMIDto readInternal(Class<? extends BMIDto> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(BMIDto bmiDto, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        System.out.println("asdf");
        outputMessage.getBody().write("asdf".getBytes(StandardCharsets.UTF_8));
    }
}
