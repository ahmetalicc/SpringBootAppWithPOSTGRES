package sau.demo.Business.Concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sau.demo.Business.Abstracts.UserService;
import sau.demo.Core.DataAccess.UserDao;
import sau.demo.Core.Entities.User;
import sau.demo.Core.Utilites.Results.DataResult;
import sau.demo.Core.Utilites.Results.Result;
import sau.demo.Core.Utilites.Results.SuccessDataResult;
import sau.demo.Core.Utilites.Results.SuccessResult;

@Service
public class UserManager implements UserService {

    private UserDao userDao;
    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi.");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>
                (this.userDao.findByEmail(email),
                        "Kullanıcı bulundu.");
    }
}
