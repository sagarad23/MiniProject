package com.example.MiniProject.controller.areaTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class areaService {

    private final areaRepository areaRepository;

    @Autowired
    public areaService(areaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public ResponseEntity<String> saveProperties(area area) {
        try {
            areaRepository.save(area);
            return ResponseEntity.ok("Property saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
    public area getPropertiesById(Long id) {
        return areaRepository.findById(id).orElse(null);
    }

    public void deletePropertiesById(Long id) {
        areaRepository.deleteById(id);
    }

}