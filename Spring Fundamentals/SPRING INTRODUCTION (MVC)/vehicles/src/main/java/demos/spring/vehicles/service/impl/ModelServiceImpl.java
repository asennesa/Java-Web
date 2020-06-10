package demos.spring.vehicles.service.impl;

import demos.spring.vehicles.dao.ModelRepository;
import demos.spring.vehicles.model.entity.Model;
import demos.spring.vehicles.model.entity.VehicleCategory;
import demos.spring.vehicles.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model addModel(Model model) {
        model.setCategory(VehicleCategory.CAR);
        model.setCreated(new Date());
        model.setModified(new Date());

        return this.modelRepository.saveAndFlush(model);
    }
}
