package kodlamaio.hrms.core.utilities.Activation.concrates;

import kodlamaio.hrms.core.utilities.Activation.abstracts.ActivationService;
import org.springframework.stereotype.Service;

@Service("fakeEmailActivation")
public class EmailActivationManager implements ActivationService {
    public boolean activate(){
        return true;
    }
}
