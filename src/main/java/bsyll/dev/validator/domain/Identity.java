package bsyll.dev.validator.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author bsyll
 */
@FieldDefaults(makeFinal = true)
@Data
@RequiredArgsConstructor(staticName = "of")
public class Identity {
    private String login;
    private String password;
}