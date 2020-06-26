package app.model.view;

import app.model.entity.HeroClass;

public class HeroViewModel {
    private String id;
    private String name;
    private HeroClass aHeroClass;
    private Integer level;
    private String imgUrl;

    public HeroViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroClass getaHeroClass() {
        return aHeroClass;
    }

    public void setaHeroClass(HeroClass aHeroClass) {
        this.aHeroClass = aHeroClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
