package springclass.sfgpetclinic.model;

/**
 * @author Jardel Brandao
 * @date 26/02/2025
 */
public class Specialty extends BaseEntity{

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
