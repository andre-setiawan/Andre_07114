package Model;

import Entity.Andre07114_AdminEntity;
import java.util.ArrayList;

public class Andre07114_AdminModel {
    public ArrayList<Andre07114_AdminEntity> adminEntity = new ArrayList<>();

    public Andre07114_AdminModel() {
        adminEntity.add(new Andre07114_AdminEntity("Andre", "Q"));
        adminEntity.add(new Andre07114_AdminEntity("Setiawan", "V"));
        adminEntity.add(new Andre07114_AdminEntity("Budi", "W"));
    }

    public Andre07114_AdminEntity getDataByKode(String code) {
        for(Andre07114_AdminEntity admin : adminEntity) {
            if(admin.getKode().equals(code)) {
                return admin;
            }
        }
        return null;
    }

    public Andre07114_AdminEntity getDataByIndex(int index) {
        return adminEntity.get(index);
    }

    public int getMax() {
        return adminEntity.size();
    }
}
