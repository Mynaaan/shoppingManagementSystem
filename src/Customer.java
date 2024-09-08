import java.util.List;
import java.util.Random;

class Customer {
    private String userId;
    private String username;
    private String password;
    private ShoppingCart shoppingCart;

    public Customer(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.shoppingCart = new ShoppingCart();
    }

    public boolean register(String username, String password) {
        // 注册的逻辑
        if (username.length() < 5 || password.length() < 8) {
            System.out.println("用户名长度不少于 5 个字符，密码长度大于 8 个字符。");
            return false;
        }
        // 检查密码是否符合要求（大小写字母、数字和标点符号的组合）
        if (!isValidPassword(password)) {
            System.out.println("密码必须是大小写字母、数字和标点符号的组合。");
            return false;
        }
        this.username = username;
        this.password = password;
        System.out.println("注册成功。");
        return true;
    }

    public boolean login(String username, String password) {
        // 登录的逻辑
        if (!this.username.equals(username) ||!this.password.equals(password)) {
            System.out.println("用户名或密码错误。");
            return false;
        }
        System.out.println("登录成功。");
        return true;
    }

    public void modifyOwnPassword(String newPassword) {
        // 修改自身密码的逻辑
        if (newPassword.length() < 8) {
            System.out.println("密码长度大于 8 个字符。");
            return;
        }
        // 检查密码是否符合要求（大小写字母、数字和标点符号的组合）
        if (!isValidPassword(newPassword)) {
            System.out.println("密码必须是大小写字母、数字和标点符号的组合。");
            return;
        }
        this.password = newPassword;
        System.out.println("密码修改成功。");
    }

    public void forgetPassword(String username, String email) {
        // 忘记密码的逻辑
        if (!this.username.equals(username)) {
            System.out.println("用户名或邮箱错误。");
            return;
        }
        String newPassword = generateRandomPassword();
        // 发送随机生成的密码到指定邮箱的逻辑（模拟）
        System.out.println("已将新密码发送到您的邮箱。");
        this.password = newPassword;
    }

    public void addToShoppingCart(Product product, int quantity) {
        // 将商品加入购物车的逻辑
        shoppingCart.addItem(product, quantity);
        System.out.println("商品 " + product.getProductName() + " 已加入购物车。");
    }

    public void removeFromShoppingCart(Product product) {
        // 将商品从购物车中移除的逻辑
        shoppingCart.removeItem(product);
        System.out.println("商品 " + product.getProductName() + " 已从购物车中移除。");
    }

    public void modifyShoppingCartItem(Product product, int quantity) {
        // 修改购物车中商品数量的逻辑
        shoppingCart.modifyItemQuantity(product, quantity);
        System.out.println("商品 " + product.getProductName() + " 的数量已修改。");
    }

    public void checkout(String paymentMethod) {
        // 结账的逻辑
        System.out.println("模拟 " + paymentMethod + " 支付操作。");
        // 模拟支付成功后修改商品数量的逻辑
        List<ShoppingCartItem> items = shoppingCart.getItems();
        for (ShoppingCartItem item : items) {
            Product product = item.getProduct();
            product.setQuantity(product.getQuantity() - item.getQuantity());
        }
        System.out.println("支付成功。");
    }

    public void viewShoppingHistory() {
        // 查看购物历史的逻辑
        System.out.println("购物历史：");
        // 模拟获取购物历史并输出
        System.out.println("时间: 2023-05-01, 购买的商品清单: Product 1");
        System.out.println("时间: 2023-05-02, 购买的商品清单: Product 2");
    }

    public void logout() {
        // 退出登录的逻辑
        System.out.println("客户已退出登录。");
    }

    private boolean isValidPassword(String password) {
        // 检查密码是否符合要求的逻辑
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    private String generateRandomPassword() {
        // 生成随机密码的逻辑
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        return password.toString();
    }
}
