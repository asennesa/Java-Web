package demos.spring.vehicles.model.Service;

public abstract class BaseServiceModel {
    private Long id;

    public BaseServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}