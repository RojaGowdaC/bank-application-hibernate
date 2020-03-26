package hibernate.service;

import hibernate.dao.BranchDao;
import hibernate.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BranchService {

    BranchDao branchDao;

    @Autowired
    public void setBranchDao(BranchDao branchDao) {
        this.branchDao = branchDao;
    }

    public List listAllBranches() {
        return branchDao.getAllBranch();
    }


    public void saveOrUpdate(Branch branch) {
        branchDao.updateBranch(branch);
    }


    public Branch findBranchById(int id) {
        return branchDao.getBranch(id);
    }


    public void deleteBranch(int id) {
        branchDao.deleteBranch(id);
    }
}
