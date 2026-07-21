package lk.inventory.service;

import lk.inventory.entity.Supplier;
import lk.inventory.repository.supplierRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final supplierRespository repo;

    public SupplierService(supplierRespository repo) {
        this.repo = repo;
    }

    public Supplier save(Supplier supplier) {
        return repo.save(supplier);
    }

    public List<Supplier> findAll(){
        return repo.findAll();
    }

    public Supplier getById(Long id){
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id){

        repo.deleteById(id);
    }

    public Supplier update(Long id,Supplier supplier){

        Supplier supplier1 = repo.findById(id).orElse(null);
        if(supplier1 != null){
            supplier1.setName(supplier.getName());
            supplier1.setAddress(supplier.getAddress());
            supplier1.setPhone(supplier.getPhone());
            supplier1.setEmail(supplier.getEmail());
            return repo.save(supplier1);
        }

        return null;
    }
}
