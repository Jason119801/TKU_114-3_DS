public class LoginCheck {
    public static void main(String[] args) {
        // 設定預設的帳號與密碼
        String username = "admin";
        String password = "1234";

        // 設定輸入結果變數
        String inputUsername = "admin";
        String inputPassword = "1234";

        // 判斷帳號與密碼是否正確 (使用兩個 .equals() 判斷)
        boolean loginSuccess = inputUsername.equals(username) && inputPassword.equals(password);

        System.out.println("InputUsername: " + inputUsername);
        System.out.println("InputPassword: " + inputPassword);
        System.out.println("LoginSuccess: " + loginSuccess);
    }
}
