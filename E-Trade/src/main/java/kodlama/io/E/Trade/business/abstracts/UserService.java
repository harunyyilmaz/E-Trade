package kodlama.io.E.Trade.business.abstracts;


import kodlama.io.E.Trade.entities.concretes.User;

public interface UserService {

    void saveUserByRole(User user , String roleName);
}
