package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.repositories.PackageRepository;
import africa.semicolon.sendAm.data.repositories.PackageRepositoryImpl;
import africa.semicolon.sendAm.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.dtos.responses.AddPackageResponse;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;

public class PackageServicesImpl implements PackageServices{
    private PackageRepository packageRepository = new PackageRepositoryImpl();
    @Override
    public AddPackageResponse addPackage(AddPackageRequest myPackage) {
        if (packageAlreadyExist(myPackage.getId())) throw new RegisterFailureException("Package already exists");
        Package packageToBeAdded = new Package();
        packageToBeAdded.setId(myPackage.getId());
        Package savedPackage =packageRepository.save(packageToBeAdded);

        AddPackageResponse packageResponse = new AddPackageResponse();
        packageResponse.setId(savedPackage.getId());
        return packageResponse;
    }

    private boolean packageAlreadyExist(int id) {
        Package foundPackage = packageRepository.findById(id);
        if(foundPackage == null) return false;
        return true;
    }

    @Override
    public PackageRepository getRepository() {
        return packageRepository;
    }
}
