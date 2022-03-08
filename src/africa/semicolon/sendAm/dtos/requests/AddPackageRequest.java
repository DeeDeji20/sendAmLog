package africa.semicolon.sendAm.dtos.requests;

import africa.semicolon.sendAm.data.models.PackageDescription;

public class AddPackageRequest {
    private int id;
    private PackageDescription description;
    private int quantity;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PackageDescription getDescription() {
        return description;
    }

    public void setDescription(PackageDescription description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AddPackageRequest{" +
                "id=" + id +
                ", description=" + description +
                ", quantity=" + quantity +
                '}';
    }
}
