package org.learn.design.observer_pattern;


/**
 * User: jimjian
 * Date: 16-3-23 上午11:48
 */
public interface Subject {

    public void postNewJob(String job);

    public void registerUser(Observer observer);

    public void notifyAllUser(String str);
}
