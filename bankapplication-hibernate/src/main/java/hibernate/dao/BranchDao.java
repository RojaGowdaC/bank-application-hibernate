package hibernate.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernate.model.Branch;

@Repository
public class BranchDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addBranch(Branch branch) {
        sessionFactory.getCurrentSession().saveOrUpdate(branch);

    }

    @SuppressWarnings("unchecked")
    public List<Branch> getAllBranch() {

        return sessionFactory.getCurrentSession().createQuery("from branch")
                .list();
    }


    public void deleteBranch(Integer branchid) {
        Branch branch = (Branch) sessionFactory.getCurrentSession().load(
                Branch.class, branchid);
        if (null != branch) {
            this.sessionFactory.getCurrentSession().delete(branch);
        }

    }

    public Branch getBranch(int id) {
        return (Branch) sessionFactory.getCurrentSession().get(
                Branch.class, id);
    }

    public Branch updateBranch(Branch branch) {
        sessionFactory.getCurrentSession().update(branch);
        return branch;
    }

}
