package app.service.impl;

import app.model.view.HeroViewModel;
import app.service.HeroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {
    @Override
    public List<HeroViewModel> findAllItems() {
        return null;
    }
}
