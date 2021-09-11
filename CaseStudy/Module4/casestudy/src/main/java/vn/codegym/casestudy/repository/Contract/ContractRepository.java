package vn.codegym.casestudy.repository.Contract;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.casestudy.model.Contract.ContractEntity;

public interface ContractRepository extends JpaRepository<ContractEntity, Integer> {
}
