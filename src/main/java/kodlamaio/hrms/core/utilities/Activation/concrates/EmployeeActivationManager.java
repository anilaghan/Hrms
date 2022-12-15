package kodlamaio.hrms.core.utilities.Activation.concrates;

import kodlamaio.hrms.core.utilities.Activation.abstracts.ActivationService;
import org.springframework.stereotype.Service;

@Service("fakeEmployeeActivation")
public class EmployeeActivationManager implements ActivationService {

    @Override
    public boolean activate() {
        return true;
    }
}
