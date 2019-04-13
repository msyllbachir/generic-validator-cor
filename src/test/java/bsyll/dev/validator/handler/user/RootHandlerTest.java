package bsyll.dev.validator.handler.user;

import bsyll.dev.validator.AbstractHandler;
import bsyll.dev.validator.domain.Empowerment;
import bsyll.dev.validator.domain.User;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
@Data
public class RootHandlerTest {

    @Autowired
    private AbstractHandler rootHandler;

    @Test
    public void should_fail_to_process_user() {
        // GIVEN
        User<Integer> anonymousUser = User.<Integer>builder().empowerment(Empowerment.USER_LEVEL2).build();
        // THEN
        assertFalse(rootHandler.processToImpl(anonymousUser));


    }
}