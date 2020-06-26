package app.service.impl;

import app.model.entity.Hero;
import app.model.service.HeroServiceModel;
import app.model.view.HeroViewModel;
import app.repository.HeroRepository;
import app.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;
    private final ModelMapper modelMapper;

    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper) {
        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<HeroViewModel> findAllHeroes() {
        return this.heroRepository.findAll().stream().map(hero -> {
            HeroViewModel heroViewModel = this.modelMapper.map(hero, HeroViewModel.class);
            heroViewModel.setImgUrl(String.format("/img/%s.jpg", hero.getaHeroClass().name()));
            return heroViewModel;
        }).collect(Collectors.toList());
    }

    @Override
    public void addHero(HeroServiceModel heroServiceModel) {
        Hero hero = this.modelMapper.map(heroServiceModel, Hero.class);
        this.heroRepository.saveAndFlush(hero);
    }

    @Override
    public HeroViewModel findById(String id) {
        Hero hero = this.heroRepository.findById(id).orElse(null);
        return this.modelMapper.map(hero, HeroViewModel.class);

    }

    @Override
    public void delete(String id) {
        this.heroRepository.deleteById(id);
    }
}
