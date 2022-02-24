package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {
    private PackageRepository packageRepository;

    @BeforeEach
    void setUp(){
        packageRepository = new PackageRepositoryImpl();
    }
    @Test
    void repositorySaveTest(){
        //given thta there is a package
        Package myPackage = new Package();

        //when itry to save in the repository
        Package savedPackage = packageRepository.save(myPackage);
        //assert that the return has an id
        assertEquals(1, savedPackage.getId());
        //assert that count is 1
        assertEquals(1, packageRepository.count());
    }
    @Test
    public void repositoryFindByIdTest(){
        Package firstPackage = new Package();
        Package secondPackage = new Package();
        Package thridPackage = new Package();

        packageRepository.save(firstPackage);
        packageRepository.save(secondPackage);
        packageRepository.save(thridPackage);

        assertEquals(3, packageRepository.count());

        Package foundPackage = packageRepository.findById(2);
        assertEquals(secondPackage, foundPackage);
        assertEquals(2, foundPackage.getId());
    }

    @Test
    public void deleteByIdTest(){
        saveThreePackages();
        packageRepository.delete(2);
        assertEquals(2, packageRepository.count());
    }
    @Test
    public void findByIdWorksAfterADelete(){
        saveThreePackages();
        packageRepository.delete(2);
        Package foundPackage = packageRepository.findById(2);
        assertNull(foundPackage);
    }
    private void saveThreePackages(){
        Package firstPackage = new Package();
        Package secondPackage = new Package();
        Package thridPackage = new Package();
        packageRepository.save(firstPackage);
        packageRepository.save(secondPackage);
        packageRepository.save(thridPackage);
    }

    @Test
    void saveAfterADelete_givesCorrectPackageIdTest(){
        saveThreePackages();
        packageRepository.delete(1);
        Package savedPackage = packageRepository.save(new Package());
        assertEquals(4, savedPackage.getId());
    }

    @Test
    void deleteByPackageTest(){
        Package firstPackage = new Package();
        Package secondPackage = new Package();
        Package thridPackage = new Package();
        packageRepository.save(firstPackage);
        packageRepository.save(secondPackage);
        packageRepository.save(thridPackage);

        packageRepository.delete(secondPackage);
        assertEquals(2, packageRepository.count());
        assertNull( packageRepository.findById(2));
    }

    @Test
    void findAllTest(){
        saveThreePackages();
        List<Package> all = packageRepository.findAll();
        assertEquals(3, all.size());
    }
}