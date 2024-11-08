package petriNet.app;

class Place {
    private int token; // 令牌数量

    public Place() {
    }

    public Place(int token) {
        this.token = token; // 构造函数，初始化令牌数量
    }

    public int getToken() {
        return token; // 获取当前令牌数量
    }

    public void removeToken(int count) {
        token -= count; // 移除指定数量的令牌
    }

    public void addToken(int count) {
        token += count; // 添加指定数量的令牌
    }
}