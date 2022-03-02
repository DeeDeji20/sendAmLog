package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageServicesImplTest {
    PackageServices packageService;
    @BeforeEach
    void setUP(){
         packageService = new PackageServicesImpl();
    }
    @Test
    void package_can_be_added_test_to_repository(){
        AddPackageRequest packageToAdd = new AddPackageRequest();
        packageToAdd.setId(1);
        packageService.addPackage(packageToAdd);
        assertEquals(1, packageService.getRepository().count());
    }

    @Test
    void test_that_packages_with_duplicate_id_throws_exception(){
        AddPackageRequest packageToAdd = new AddPackageRequest();
        packageToAdd.setId(1);
        packageService.addPackage(packageToAdd);


        assertThrows(RegisterFailureException.class, ()-> packageService.addPackage(packageToAdd));
    }

}