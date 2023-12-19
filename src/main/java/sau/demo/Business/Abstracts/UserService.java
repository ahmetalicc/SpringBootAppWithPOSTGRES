package sau.demo.Business.Abstracts;

import sau.demo.Core.Entities.User;
import sau.demo.Core.Utilites.Results.DataResult;
import sau.demo.Core.Utilites.Results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail (String email);
}
