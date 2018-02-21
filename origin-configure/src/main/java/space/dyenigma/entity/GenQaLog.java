package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "gen_qa_log")
public class GenQaLog extends BaseDomain {
    /**
     * 日志ID
     */
    @Id
    @Column(name = "LOG_ID")
    private String logId;

    /**
     * 操作类型，A:agree赞同,O:Oppose反对
     */
    @Column(name = "QA_TYPE")
    private String qaType;

    /**
     * 获取日志ID
     *
     * @return LOG_ID - 日志ID
     */
    public String getLogId() {
        return logId;
    }

    /**
     * 设置日志ID
     *
     * @param logId 日志ID
     */
    public void setLogId(String logId) {
        this.logId = logId;
    }

    /**
     * 获取操作类型，A:agree赞同,O:Oppose反对
     *
     * @return QA_TYPE - 操作类型，A:agree赞同,O:Oppose反对
     */
    public String getQaType() {
        return qaType;
    }

    /**
     * 设置操作类型，A:agree赞同,O:Oppose反对
     *
     * @param qaType 操作类型，A:agree赞同,O:Oppose反对
     */
    public void setQaType(String qaType) {
        this.qaType = qaType;
    }

}