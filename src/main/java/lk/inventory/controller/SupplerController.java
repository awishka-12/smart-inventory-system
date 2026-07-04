package lk.inventory.controller;

import lk.inventory.entity.Supplier;
import lk.inventory.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Supplier")
public class SupplerController {


private final SupplierService service;

    public SupplerController(SupplierService service) {
        this.service = service;
    }

    @PostMapping
    public Supplier save(@RequestBody Supplier supplier){
        return service.save(supplier);
    }

    @GetMapping
    public List<Supplier> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Supplier getByid(@PathVariable int id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Supplier update(
            @PathVariable int id,
            @RequestBody Supplier supplier){
        return service.update(id,supplier);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
         service.delete(id);
        return "suppler Deleted Successfully";
    }
}
