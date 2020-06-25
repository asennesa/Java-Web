package app.service;

import app.model.view.HeroViewModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HeroService {
    List<HeroViewModel> findAllItems();
}
