package hibernate.model;
import javax.persistence.*;

@Entity
@Table(name="account")
public class Account {
    @Id
    @Column(name="AccountNumber")
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    private String accountNumber;
    @Column(name = "Type")  //savings,current,loan
    private String type;
    @Column(name ="balance")
    private long balance;
    @ManyToOne(targetEntity = Branch.class)
    @JoinColumn(name = "BranchIFSC")
    private Branch branch;

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public long getBalance() {
        return balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
    public Branch getBranch() {
        return branch;
    }
    public void setBranch(Branch branch) {
        this.branch = branch;
    }
    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", branch=" + branch +
                '}';
    }
}