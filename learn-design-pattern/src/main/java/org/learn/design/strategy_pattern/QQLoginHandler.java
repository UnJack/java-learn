package org.learn.design.strategy_pattern;

public class QQLoginHandler implements LoginHandler<String> {

    @Override
    public int getLoginType() {
        return 0;
    }

    @Override
    public void handleLogin(String request) {
        System.out.println("qq login");
    }
}
