class User {
    private String userId;
    private String username;
    private String password;
    private String userLevel; // 金牌客户、银牌客户、铜牌客户
    private String registrationTime;
    private double totalConsumptionAmount;
    private String phoneNumber;
    private String email;

    public User(String userId, String username, String password, String userLevel, String registrationTime,
                double totalConsumptionAmount, String phoneNumber, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userLevel = userLevel;
        this.registrationTime = registrationTime;
        this.totalConsumptionAmount = totalConsumptionAmount;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public double getTotalConsumptionAmount() {
        return totalConsumptionAmount;
    }

    public void setTotalConsumptionAmount(double totalConsumptionAmount) {
        this.totalConsumptionAmount = totalConsumptionAmount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "客户 ID: " + userId + ", 用户名: " + username + ", 用户级别: " + userLevel + ", 用户注册时间: "
                + registrationTime + ", 客户累计消费总金额: " + totalConsumptionAmount + ", 用户手机号: " + phoneNumber
                + ", 用户邮箱: " + email;
    }
}
