package cn.zsza.design_pattern.proxy.proxy1;

/**
 * Created by zs on 2017/5/16.
 * 18:21
 * 业务接口
 */
public interface ForumService {
    public void removeTopic(int topicId);

    public void removeForum(int forumId);
}
