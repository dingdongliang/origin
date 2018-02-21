package space.dyenigma.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;

public class User {
    @Id
    @Column(name = "atomId")
    private Integer atomid;

    @Column(name = "userName")
    private String username;

    private Integer age;

    private BigDecimal balance;

    /**
     * @return atomId
     */
    public Integer getAtomid() {
        return atomid;
    }

    /**
     * @param atomid
     */
    public void setAtomid(Integer atomid) {
        this.atomid = atomid;
    }

    /**
     * @return userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * @param balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}