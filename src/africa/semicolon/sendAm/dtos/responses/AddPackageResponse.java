package africa.semicolon.sendAm.dtos.responses;

import africa.semicolon.sendAm.data.models.PackageDescription;

public class AddPackageResponse {
    private int id;
    private PackageDescription description;

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
}
