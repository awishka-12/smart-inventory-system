package lk.inventory.repository;

import lk.inventory.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface supplierRespository
extends JpaRepository<Supplier,Integer> {

}
