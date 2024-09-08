import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择你的身份：1.管理员 2.客户");
        int identity=scanner.nextInt();

        if(identity==1){
            // 管理员登录
            Scanner input=new Scanner(System.in);
            System.out.println("管理员登录：");
            System.out.println("用户名：");
            String adminUsername = input.nextLine();
            System.out.println("密码：");
            String adminPassword = input.nextLine();

            Administrator administrator = new Administrator();
            if (administrator.login(adminUsername, adminPassword)) {
                while (true) {
                    System.out.println("管理员功能菜单：");
                    System.out.println("1. 密码管理");
                    System.out.println("2. 客户管理");
                    System.out.println("3. 商品管理");
                    System.out.println("4. 退出登录");

                    System.out.print("请选择功能：");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // 消耗换行符

                    switch (choice) {
                        case 1:
                            System.out.println("密码管理功能：");
                            System.out.println("1. 修改自身密码");
                            System.out.println("2. 重置指定客户/用户的密码");

                            System.out.print("请选择功能：");
                            int passwordChoice = scanner.nextInt();
                            scanner.nextLine(); // 消耗换行符

                            if (passwordChoice == 1) {
                                System.out.print("请输入新密码：");
                                String newPassword = scanner.nextLine();
                                administrator.modifyOwnPassword(newPassword);
                            } else if (passwordChoice == 2) {
                                System.out.print("请输入要重置密码的客户用户名：");
                                String username = scanner.nextLine();
                                // 查找并重置指定客户的密码
                                User user = findUserByUsername(username);
                                if (user!= null) {
                                    administrator.resetUserPassword(user);
                                } else {
                                    System.out.println("未找到该客户。");
                                }
                            }
                            break;
                        case 2:
                            System.out.println("客户管理功能：");
                            System.out.println("1. 列出所有客户信息");
                            System.out.println("2. 删除客户信息");
                            System.out.println("3. 查询客户信息");

                            System.out.print("请选择功能：");
                            int customerChoice = scanner.nextInt();
                            scanner.nextLine(); // 消耗换行符

                            if (customerChoice == 1) {
                                administrator.listAllCustomers();
                            } else if (customerChoice == 2) {
                                System.out.print("请输入要删除的客户用户名：");
                                String username = scanner.nextLine();
                                // 查找并删除指定客户的信息
                                User user = findUserByUsername(username);
                                if (user!= null) {
                                    administrator.deleteCustomer(user);
                                } else {
                                    System.out.println("未找到该客户。");
                                }
                            } else if (customerChoice == 3) {
                                System.out.print("请输入客户 ID 或用户名：");
                                String customerIdOrUsername = scanner.nextLine();
                                administrator.queryCustomer(customerIdOrUsername, "");
                            }
                            break;
                        case 3:
                            System.out.println("商品管理功能：");
                            System.out.println("1. 列出所有商品信息");
                            System.out.println("2. 添加商品信息");
                            System.out.println("3. 修改商品信息");
                            System.out.println("4. 删除商品信息");
                            System.out.println("5. 查询商品信息");

                            System.out.print("请选择功能：");
                            int productChoice = scanner.nextInt();
                            scanner.nextLine(); // 消耗换行符

                            if (productChoice == 1) {
                                administrator.listAllProducts();
                            } else if (productChoice == 2) {
                                System.out.print("请输入商品编号：");
                                String productId = scanner.nextLine();
                                System.out.print("请输入商品名称：");
                                String productName = scanner.nextLine();
                                System.out.print("请输入生产厂家：");
                                String manufacturer = scanner.nextLine();
                                System.out.print("请输入生产日期：");
                                String productionDate = scanner.nextLine();
                                System.out.print("请输入型号：");
                                String model = scanner.nextLine();
                                System.out.print("请输入进货价：");
                                double purchasePrice = scanner.nextDouble();
                                scanner.nextLine(); // 消耗换行符
                                System.out.print("请输入零售价格：");
                                double retailPrice = scanner.nextDouble();
                                System.out.print("请输入数量：");
                                int quantity = scanner.nextInt();
                                scanner.nextLine(); // 消耗换行符

                                Product product = new Product(productId, productName, manufacturer, productionDate, model, purchasePrice, retailPrice, quantity);
                                administrator.addProduct(product);
                            } else if (productChoice == 3) {
                                System.out.print("请输入要修改的商品编号：");
                                String productId = scanner.nextLine();
                                // 查找并修改指定商品的信息
                                Product product = findProductByProductId(productId);
                                if (product!= null) {
                                    System.out.print("请输入新的商品名称：");
                                    String newProductName = scanner.nextLine();
                                    System.out.print("请输入新的生产厂家：");
                                    String newManufacturer = scanner.nextLine();
                                    System.out.print("请输入新的生产日期：");
                                    String newProductionDate = scanner.nextLine();
                                    System.out.print("请输入新的型号：");
                                    String newModel = scanner.nextLine();
                                    System.out.print("请输入新的进货价：");
                                    double newPurchasePrice = scanner.nextDouble();
                                    scanner.nextLine(); // 消耗换行符
                                    System.out.print("请输入新的零售价格：");
                                    double newRetailPrice = scanner.nextDouble();
                                    System.out.print("请输入新的数量：");
                                    int newQuantity = scanner.nextInt();
                                    scanner.nextLine(); // 消耗换行符

                                    product.setProductName(newProductName);
                                    product.setManufacturer(newManufacturer);
                                    product.setProductionDate(newProductionDate);
                                    product.setModel(newModel);
                                    product.setPurchasePrice(newPurchasePrice);
                                    product.setRetailPrice(newRetailPrice);
                                    product.setQuantity(newQuantity);

                                    administrator.modifyProduct(product);
                                } else {
                                    System.out.println("未找到该商品。");
                                }
                            } else if (productChoice == 4) {
                                System.out.print("请输入要删除的商品编号：");
                                String productId = scanner.nextLine();
                                // 查找并删除指定商品的信息
                                Product product = findProductByProductId(productId);
                                if (product!= null) {
                                    administrator.deleteProduct(product);
                                } else {
                                    System.out.println("未找到该商品。");
                                }
                            } else if (productChoice == 5) {
                                System.out.print("请输入商品名称（可选）：");
                                String productName = scanner.nextLine();
                                System.out.print("请输入生产厂家（可选）：");
                                String manufacturer = scanner.nextLine();
                                System.out.print("请输入零售价格（可选）：");
                                double retailPrice = scanner.nextDouble();
                                scanner.nextLine(); // 消耗换行符

                                administrator.queryProduct(productName, manufacturer, retailPrice);
                            }
                            break;
                        case 4:
                            administrator.logout();
                            return;
                        default:
                            System.out.println("无效的选择，请重新输入。");
                    }
                }
            } else {
                System.out.println("管理员登录失败。");
            }
        }

        if(identity==2){
            // 用户操作
            System.out.println("请选择：1.注册 2.登录");
            int option = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            if (option == 1) {
                System.out.println("请输入用户名(用户名长度不少于 5 个字符)");
                String name = scanner.nextLine();
                System.out.println("请输入密码(密码长度大于 8 个字符，必须是大小写字母、数字和标点符号的组合)");
                String password = scanner.nextLine();
                Customer customer = new Customer("", name, password);
                if (customer.register(name,password)) {
                    System.out.println("注册成功。");
                } else {
                    System.out.println("注册失败。");
                }
            } else if (option == 2) {
                System.out.println("请登录");
                System.out.print("用户名：");
                String userName = scanner.nextLine();
                System.out.print("密码：");
                String userPassword = scanner.nextLine();
                Customer customer = new Customer("", userName, userPassword);
                if (customer.login(userName, userPassword)) {
                    while (true) {
                        System.out.println("用户功能菜单：");
                        System.out.println("1. 密码管理");
                        System.out.println("2. 购物");
                        System.out.println("3. 查看购物历史");
                        System.out.println("4. 退出登录");

                        System.out.print("请选择功能：");
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // 消耗换行符

                        switch (choice) {
                            case 1:
                                System.out.println("密码管理功能：");
                                System.out.println("1. 修改密码");
                                System.out.println("2. 重置密码");

                                System.out.print("请选择功能：");
                                int passwordChoice = scanner.nextInt();
                                scanner.nextLine(); // 消耗换行符

                                if (passwordChoice == 1) {
                                    System.out.print("请输入新密码(密码长度大于 8 个字符，必须是大小写字母、数字和标点符号的组合)：");
                                    String newPassword = scanner.nextLine();
                                    customer.modifyOwnPassword(newPassword);
                                } else if (passwordChoice == 2) {
                                    System.out.print("请输入用户名：");
                                    String username = scanner.nextLine();
                                    System.out.print("请输入注册所使用的邮箱地址：");
                                    String email = scanner.nextLine();
                                    customer.forgetPassword(username, email);
                                }
                                break;
                            case 2:
                                System.out.println("购物功能：");
                                System.out.println("1. 将商品加入购物车");
                                System.out.println("2. 将商品从购物车中移除");
                                System.out.println("3. 修改购物车中的商品");
                                System.out.println("4. 结账");

                                System.out.print("请选择功能：");
                                int shoppingChoice = scanner.nextInt();
                                scanner.nextLine(); // 消耗换行符

                                if (shoppingChoice == 1) {
                                    // 实现将商品加入购物车的功能
                                    System.out.print("请输入商品编号：");
                                    String productId = scanner.nextLine();
                                    System.out.print("请输入数量：");
                                    int quantity = scanner.nextInt();
                                    scanner.nextLine(); // 消耗换行符

                                    // 假设这里有一个获取商品的方法
                                    Product product = findProductByProductId(productId);
                                    if (product!= null) {
                                        customer.addToShoppingCart(product, quantity);
                                    } else {
                                        System.out.println("未找到该商品。");
                                    }
                                } else if (shoppingChoice == 2) {
                                    // 实现将商品从购物车中移除的功能
                                    System.out.print("请输入要移除的商品编号：");
                                    String productId = scanner.nextLine();
                                    // 假设这里有一个获取商品的方法
                                    Product product = findProductByProductId(productId);
                                    if (product!= null) {
                                        customer.removeFromShoppingCart(product);
                                    } else {
                                        System.out.println("未找到该商品。");
                                    }
                                } else if (shoppingChoice == 3) {
                                    // 实现修改购物车中商品数量的功能
                                    System.out.print("请输入要修改的商品编号：");
                                    String productId = scanner.nextLine();
                                    System.out.print("请输入新的数量：");
                                    int quantity = scanner.nextInt();
                                    scanner.nextLine(); // 消耗换行符

                                    // 假设这里有一个获取商品的方法
                                    Product product = findProductByProductId(productId);
                                    if (product!= null) {
                                        customer.modifyShoppingCartItem(product, quantity);
                                    } else {
                                        System.out.println("未找到该商品。");
                                    }
                                } else if (shoppingChoice == 4) {
                                    // 实现结账的功能
                                    System.out.print("请选择支付渠道（1.支付宝 2.微信 3.银行卡）：");
                                    int paymentChoice = scanner.nextInt();
                                    scanner.nextLine(); // 消耗换行符

                                    String paymentMethod = "";
                                    if (paymentChoice == 1) {
                                        paymentMethod = "支付宝";
                                    } else if (paymentChoice == 2) {
                                        paymentMethod = "微信";
                                    } else if (paymentChoice == 3) {
                                        paymentMethod = "银行卡";
                                    }

                                    customer.checkout(paymentMethod);
                                }
                                break;
                            case 3:
                                customer.viewShoppingHistory();
                                break;
                            case 4:
                                customer.logout();
                                return;
                            default:
                                System.out.println("无效的选择，请重新输入。");
                        }
                    }
                } else {
                    System.out.println("登录失败。");
                }
            }
        }
        scanner.close();
    }
    public static User findUserByUsername(String username) {
        // 模拟查找用户的逻辑
        Administrator administrator = new Administrator();
        List<User> customers = new ArrayList<>();
        customers.add(new User("0921", "Karry", "xiaopangxie", "一级客户", "2023 - 01 - 01", 1000.0, "123456789", "user1@example.com"));
        customers.add(new User("1108", "Roy", "xiaotangyuan", "二级客户", "2023 - 02 - 01", 500.0, "987654321", "user2@example.com"));

        for (User customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }

    public static Product findProductByProductId(String productId) {
        // 模拟查找商品的逻辑
        Administrator administrator = new Administrator();
        List<Product> products = new ArrayList<>();
        products.add(new Product("P1", "Product 1", "Manufacturer 1", "2023 - 03 - 01", "Model 1", 50.0, 100.0, 10));
        products.add(new Product("P2", "Product 2", "Manufacturer 2", "2023 - 04 - 01", "Model 2", 80.0, 150.0, 5));

        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }
}
