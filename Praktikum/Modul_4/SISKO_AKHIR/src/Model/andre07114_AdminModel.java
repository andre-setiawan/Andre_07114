package Model;

import Entity.andre07114_AdminEntity;

import java.util.ArrayList;

public class andre07114_AdminModel {
    public ArrayList<andre07114_AdminEntity> adminEntity = new ArrayList<>();

    public andre07114_AdminModel() {
        adminEntity.add(new andre07114_AdminEntity("Fernanda", "kelas Q"));
        adminEntity.add(new andre07114_AdminEntity("Fitria", "kelas V"));
        adminEntity.add(new andre07114_AdminEntity("Eric", "kelas W"));
    }

    public andre07114_AdminEntity getDataByKode(String kode) {
        for(andre07114_AdminEntity aslab : adminEntity) {
            if(aslab.getCode().equals(kode)) {
                return aslab;
            }
        }
        return null;
    }

    public andre07114_AdminEntity getDataByIndex(int index) {
        return adminEntity.get(index);
    }

    public int getMax() {
        return adminEntity.size();
    }
}
