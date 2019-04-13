package bsyll.dev.validator;

import bsyll.dev.validator.domain.Empowerment;
import bsyll.dev.validator.domain.Identity;
import bsyll.dev.validator.domain.User;
import bsyll.dev.validator.utils.TryExecute;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

/**
 * @author bsyll
 */
@SpringBootApplication
@Data
public class GenericValidatorCorApplication implements CommandLineRunner {

	@Autowired
	private final AbstractHandler anonymousHandler;
	@Autowired
	private final AbstractHandler userLevelOneHandler;
	@Autowired
	private final AbstractHandler userLevelTwoHandler;
	@Autowired
	private final AbstractHandler rootHandler;

	public static void main(String[] args) {
		SpringApplication.run(GenericValidatorCorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		TryExecute.combine(
				() -> anonymousHandler.setNext(userLevelOneHandler),
				() -> userLevelOneHandler.setNext(userLevelTwoHandler),
				() -> userLevelTwoHandler.setNext(rootHandler),
				() -> getUsers().stream()
								.filter(user -> Empowerment.ROOT.equals(user.getEmpowerment()))
								.findAny()
								.ifPresent(anonymousHandler::process));
	}

	private List<User> getUsers(){
		return Arrays.asList(
				User.<Integer>builder()
						.empowerment(Empowerment.ANONYMOUS)
						.identity(Identity.of("unknown", "password"))
						.valueToExecute(10).<Integer>build(),
				User.<Integer>builder()
						.empowerment(Empowerment.USER_LEVEL1)
						.identity(Identity.of("user", "password"))
						.valueToExecute(10).<Integer>build(),
				User.<Integer>builder()
						.empowerment(Empowerment.USER_LEVEL2)
						.identity(Identity.of("user", "password"))
						.valueToExecute(10).build(),
				User.<Integer>builder()
						.empowerment(Empowerment.ROOT)
						.identity(Identity.of("user", "password"))
						.valueToExecute(10).<Integer>build());
	}

}