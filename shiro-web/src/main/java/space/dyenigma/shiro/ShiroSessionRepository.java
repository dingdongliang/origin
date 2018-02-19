package space.dyenigma.shiro;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;

/**
 * origin/space.dyenigma.shiro
 *
 * @Description :
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:53
 */
public interface ShiroSessionRepository {
    void saveSession(Session session);

    void deleteSession(Serializable sessionId);

    Session getSession(Serializable sessionId);

    Collection<Session> getAllSessions();
}
