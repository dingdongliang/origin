package space.dyenigma.shiro;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * origin/space.dyenigma.shiro
 *
 * @Description :
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:52
 */
public class CustomShiroSessionDAO extends AbstractSessionDAO {

    private final Logger logger = LoggerFactory.getLogger(CustomShiroSessionDAO.class);

    private ShiroSessionRepository shiroSessionRepository;

    public ShiroSessionRepository getShiroSessionRepository() {
        return shiroSessionRepository;
    }

    public void setShiroSessionRepository(ShiroSessionRepository shiroSessionRepository) {
        this.shiroSessionRepository = shiroSessionRepository;
    }

    @Override
    public void delete(Session session) {
        if (session == null) {
            logger.error("session can not be null,delete failed");
            return;
        }
        Serializable id = session.getId();
        if (id != null)
            getShiroSessionRepository().deleteSession(id);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return getShiroSessionRepository().getAllSessions();
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        getShiroSessionRepository().saveSession(session);
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        getShiroSessionRepository().saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return getShiroSessionRepository().getSession(sessionId);
    }

}
