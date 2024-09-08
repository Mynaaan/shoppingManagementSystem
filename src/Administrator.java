import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Administrator {
    private String username;
    private String password;

    public Administrator() {
        this.username = "admin";
        this.password = "ynuinfo#777";
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void modifyOwnPassword(String newPassword) {
        // 修改管理员密码的逻辑
        this.password = newPassword;
        System.out.println("管理员密码修改成功。");
    }

    public void resetUserPassword(User user) {
        // 重置用户密码的逻辑
        String newPassword = generateRandomPassword();
        // 发送随机生成的密码到用户邮箱的逻辑（模拟）
        System.out.println("已将新密码发送到用户 " + user.getUsername() + " 的邮箱。");
        user.setPassword(newPassword);
    }

    public void listAllCustomers() {
        // 列出所有客户信息的逻辑
        System.out.println("所有客户信息：");
        // 模拟获取客户信息并输出
        List<User> customers = new ArrayList<>();
        customers.add(new User("1", "user1", "password1", "金牌客户", "2023-01-01", 1000.0, "123456789", "user1@example.com"));
        customers.add(new User("2", "user2", "password2", "银牌客户", "2023-02-01", 500.0, "987654321", "user2@example.com"));
        for (User customer : customers) {
            System.out.println(customer);
        }
    }

    public void deleteCustomer(User user) {
        // 删除客户信息的逻辑
        System.out.println("警告：删除客户信息后无法恢复，请确认是否继续删除操作。");
        Scanner scanner = new Scanner(System.in);
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            // 模拟删除客户信息
            System.out.println("客户 " + user.getUsername() + " 的信息已删除。");
        } else {
            System.out.println("取消删除操作。");
        }
    }

    public void queryCustomer(String customerId, String username) {
        // 查询客户信息的逻辑
        System.out.println("查询客户信息：");
        // 模拟根据客户 ID 或用户名查询并输出
        List<User> customers = new ArrayList<>();
        customers.add(new User("1", "user1", "password1", "金牌客户", "2023-01-01", 1000.0, "123456789", "user1@example.com"));
        customers.add(new User("2", "user2", "password2", "银牌客户", "2023-02-01", 500.0, "987654321", "user2@example.com"));
        for (User customer : customers) {
            if (customer.getUserId().equals(customerId) || customer.getUsername().equals(username)) {
                System.out.println(customer);
            }
        }
    }

    public void listAllProducts() {
        // 列出所有商品信息的逻辑
        System.out.println("所有商品信息：");
        // 模拟获取商品信息并输出
        List<Product> products = new ArrayList<>();
        products.add(new Product("P1", "Product 1", "Manufacturer 1", "2023-03-01", "Model 1", 50.0, 100.0, 10));
        products.add(new Product("P2", "Product 2", "Manufacturer 2", "2023-04-01", "Model 2", 80.0, 150.0, 5));
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void addProduct(Product product) {
        // 添加商品信息的逻辑
        // 模拟添加商品信息
        System.out.println("商品 " + product.getProductName() + " 的信息已添加。");
    }

    public void modifyProduct(Product product) {
        // 修改商品信息的逻辑
        // 模拟修改商品信息
        System.out.println("商品 " + product.getProductName() + " 的信息已修改。");
    }

    public void deleteProduct(Product product) {
        // 删除商品信息的逻辑
        System.out.println("警告：删除商品后无法恢复，请确认是否继续删除操作。");
        Scanner scanner = new Scanner(System.in);
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            // 模拟删除商品信息
            System.out.println("商品 " + product.getProductName() + " 的信息已删除。");
        } else {
            System.out.println("取消删除操作。");
        }
    }

    public void queryProduct(String productName, String manufacturer, double retailPrice) {
        // 查询商品信息的逻辑
        System.out.println("查询商品信息：");
        // 模拟根据商品名称、生产厂家、零售价格查询并输出
        List<Product> products = new ArrayList<>();
        products.add(new Product("P1", "Product 1", "Manufacturer 1", "2023-03-01", "Model 1", 50.0, 100.0, 10));
        products.add(new Product("P2", "Product 2", "Manufacturer 2", "2023-04-01", "Model 2", 80.0, 150.0, 5));
        for (Product product : products) {
            if (product.getProductName().equals(productName) || product.getManufacturer().equals(manufacturer)
                    || product.getRetailPrice() == retailPrice) {
                System.out.println(product);
            }
        }
    }

    public void logout() {
        // 退出管理员登录的逻辑
        System.out.println("管理员已退出登录。");
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
