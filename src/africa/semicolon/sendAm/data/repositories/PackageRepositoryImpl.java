package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;

import java.util.ArrayList;
import java.util.List;

public class PackageRepositoryImpl implements PackageRepository {
    private List<Package> db = new ArrayList<>();
    private int availableId = 1;

    @Override
    public Package save(Package aPackage) {
        int id = generateId();
        aPackage.setId(id);
        db.add(aPackage);
        return aPackage;
//        return db.get(id-1);
    }

    private int generateId() {
        return availableId++;
    }

    @Override
    public Package findById(int id) {
        for (Package p : db) {
            if (p.getId() == id) return p;
        }
      return null;
    }

    @Override
    public void delete(Package aPackage) {
        db.remove(aPackage);
    }

    @Override
    public void delete(int id) {
        Package foundPackage = findById(id);
        delete(foundPackage);
    }

    @Override
    public List<Package> findAll() {
        return db;
    }

    @Override
    public int count() {
        return db.size();
    }
}
