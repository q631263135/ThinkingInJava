package 注解.编写注解处理器;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7 0007.
 */
public class PasswordUtils {

    @UseCase(id = 47, desc = "Passwords must contain at least on numeric")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 49, desc = "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return prevPasswords.contains(password);
    }
}
