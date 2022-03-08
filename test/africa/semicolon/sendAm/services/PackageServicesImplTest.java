package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.PackageDescription;
import africa.semicolon.sendAm.dtos.requests.AddPackageRequest;
import africa.semicolon.sendAm.dtos.responses.AddPackageResponse;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageServicesImplTest {
    PackageServices packageService;
    @BeforeEach
    void setUp(){
         packageService = new PackageServicesImpl();
    }
    @Test
    void package_can_be_added_test_to_repository(){
        AddPackageRequest packageToAdd = new AddPackageRequest();
        packageToAdd.setId(1);
        PackageDescription description = new PackageDescription();
        description.setName("My first package");
        description.setWeightInGrammes(25);
        packageToAdd.setDescription(description);
        packageService.addPackage(packageToAdd);
        assertEquals(1, packageService.getRepository().count());
    }

    @Test
    void test_that_packages_with_duplicate_id_throws_exception(){
        AddPackageRequest packageToAdd = new AddPackageRequest();
        packageToAdd.setId(1);
        PackageDescription description = new PackageDescription();
        description.setName("My first package");
        description.setWeightInGrammes(25);
        packageToAdd.setDescription(description);
        packageService.addPackage(packageToAdd);
        assertThrows(RegisterFailureException.class, ()-> packageService.addPackage(packageToAdd));
    }

    @Test
    void test_that_adding_a_package_give_correct_response() {
        AddPackageRequest packageToAdd = new AddPackageRequest();
        packageToAdd.setId(1);
        PackageDescription description = new PackageDescription();
        description.setName("My first package");
        description.setWeightInGrammes(25);
        packageToAdd.setDescription(description);
//        System.out.println(packageToAdd.getDescription().toString());
        AddPackageResponse packageResponse= packageService.addPackage(packageToAdd);
        assertEquals(1, packageResponse.getId());
        assertEquals("My first package", packageResponse.getDescription().getName());
    }

    @Test
    void test_that_adding_another_package_give_correct_response() {
        AddPackageRequest packageToAdd = new AddPackageRequest();
        packageToAdd.setId(1);
        PackageDescription description = new PackageDescription();
        description.setName("My first package");
        description.setWeightInGrammes(25);
        packageToAdd.setDescription(description);

        AddPackageRequest packageToAdd2 = new AddPackageRequest();
        packageToAdd2.setId(2);
        PackageDescription description2 = new PackageDescription();
        description2.setName("My second package");
        description2.setWeightInGrammes(20);
        packageToAdd2.setDescription(description2);
//        System.out.println(packageToAdd.getDescription().toString());
        AddPackageResponse packageResponse= packageService.addPackage(packageToAdd);
        AddPackageResponse packageResponse2= packageService.addPackage(packageToAdd2);
        assertEquals(2, packageResponse2.getId());
        assertEquals("My second package", packageResponse2.getDescription().getName());
    }

//    @Test
//    void test_that_package_info_can_be_updated(){
//        AddPackageRequest packageToAdd = new AddPackageRequest();
//        packageToAdd.setId(1);
//        PackageDescription description = new PackageDescription();
//        description.setName("My first package");
//        description.setWeightInGrammes(25);
//        packageToAdd.setDescription(description);
//        AddPackageResponse packageResponse= packageService.addPackage(packageToAdd);
//        packageService.updatePackage(packageToAdd, "Chocolate");
//    }

}