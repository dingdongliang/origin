package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "gen_answer")
public class GenAnswer extends BaseDomain {
    /**
     * 问题ID
     */
    @Id
    @Column(name = "QSTN_ID")
    private String qstnId;

    /**
     * 答复ID
     */
    @Column(name = "ANSR_ID")
    private String ansrId;

    /**
     * 回答内容描述
     */
    @Column(name = "ANSR_DESC")
    private String ansrDesc;

    /**
     * 赞同次数
     */
    @Column(name = "ANSR_AGREE")
    private Integer ansrAgree;

    /**
     * 反对次数
     */
    @Column(name = "ANSR_OPOS")
    private Integer ansrOpos;

    /**
     * 获取问题ID
     *
     * @return QSTN_ID - 问题ID
     */
    public String getQstnId() {
        return qstnId;
    }

    /**
     * 设置问题ID
     *
     * @param qstnId 问题ID
     */
    public void setQstnId(String qstnId) {
        this.qstnId = qstnId;
    }

    /**
     * 获取答复ID
     *
     * @return ANSR_ID - 答复ID
     */
    public String getAnsrId() {
        return ansrId;
    }

    /**
     * 设置答复ID
     *
     * @param ansrId 答复ID
     */
    public void setAnsrId(String ansrId) {
        this.ansrId = ansrId;
    }

    /**
     * 获取回答内容描述
     *
     * @return ANSR_DESC - 回答内容描述
     */
    public String getAnsrDesc() {
        return ansrDesc;
    }

    /**
     * 设置回答内容描述
     *
     * @param ansrDesc 回答内容描述
     */
    public void setAnsrDesc(String ansrDesc) {
        this.ansrDesc = ansrDesc;
    }

    /**
     * 获取赞同次数
     *
     * @return ANSR_AGREE - 赞同次数
     */
    public Integer getAnsrAgree() {
        return ansrAgree;
    }

    /**
     * 设置赞同次数
     *
     * @param ansrAgree 赞同次数
     */
    public void setAnsrAgree(Integer ansrAgree) {
        this.ansrAgree = ansrAgree;
    }

    /**
     * 获取反对次数
     *
     * @return ANSR_OPOS - 反对次数
     */
    public Integer getAnsrOpos() {
        return ansrOpos;
    }

    /**
     * 设置反对次数
     *
     * @param ansrOpos 反对次数
     */
    public void setAnsrOpos(Integer ansrOpos) {
        this.ansrOpos = ansrOpos;
    }
}