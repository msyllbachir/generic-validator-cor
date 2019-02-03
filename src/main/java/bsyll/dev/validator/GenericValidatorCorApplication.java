package bsyll.dev.validator;

import bsyll.dev.validator.domain.Empowerment;
import bsyll.dev.validator.domain.Identity;
import bsyll.dev.validator.domain.User;
import bsyll.dev.validator.handler.user.AnnonymousHandler;
import bsyll.dev.validator.handler.user.RootHandler;
import bsyll.dev.validator.handler.user.UserLevelOneHandler;
import bsyll.dev.validator.handler.user.UserLevelTwoHandler;
import bsyll.dev.validator.utils.TryExecute;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

/**
 * @author bsyll
 */
@SpringBootApplication
public class GenericValidatorCorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GenericValidatorCorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AbstractHandler<User> annonymousHandler = new AnnonymousHandler();
		AbstractHandler<User> userLevelOneHandler = new UserLevelOneHandler();
		AbstractHandler<User> userLevelTwoHandler = new UserLevelTwoHandler();
		AbstractHandler<User> rootHandler = new RootHandler();
		TryExecute.combine(
				() -> annonymousHandler.setNext(userLevelOneHandler),
				() -> userLevelOneHandler.setNext(userLevelTwoHandler),
				() -> userLevelTwoHandler.setNext(rootHandler),
				() -> getUsers().stream()
								.filter(user -> Empowerment.ROOT.equals(user.getEmpowerment()))
								.findAny()
								.ifPresent(annonymousHandler::process));

	}

	private List<User> getUsers(){
		return Arrays.asList(
				User.<Integer>builder()
						.empowerment(Empowerment.ANNONYMOUS)
						.identity(Identity.of("annonyme", "password"))
						.valueToExecute(10).<Integer>build(),
				User.<Integer>builder()
						.empowerment(Empowerment.USER_L1)
						.identity(Identity.of("user", "password"))
						.valueToExecute(10).<Integer>build(),
				User.<Integer>builder()
						.empowerment(Empowerment.USER_L2)
						.identity(Identity.of("user", "password"))
						.valueToExecute(10).build(),
				User.<Integer>builder()
						.empowerment(Empowerment.ROOT)
						.identity(Identity.of("user", "password"))
						.valueToExecute(10).<Integer>build());
	}

}