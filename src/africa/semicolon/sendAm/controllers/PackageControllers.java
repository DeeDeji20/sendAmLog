package africa.semicolon.sendAm.controllers;

import africa.semicolon.sendAm.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.dtos.responses.AddPackageResponse;
import africa.semicolon.sendAm.services.PackageServices;
import africa.semicolon.sendAm.services.PackageServicesImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/package")
public class PackageControllers {
    private PackageServices services = new PackageServicesImpl();

    @PostMapping("/addPackage")
    public AddPackageResponse addNewPackage( @RequestBody AddPackageRequest myPackage){
        return services.addPackage(myPackage);
    }
}
