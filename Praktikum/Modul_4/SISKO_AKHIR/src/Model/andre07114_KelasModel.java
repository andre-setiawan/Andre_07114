package Model;

import Entity.andre07114_KelasEntity;

import java.util.ArrayList;

public class andre07114_KelasModel {
    public ArrayList<andre07114_KelasEntity> kelasEntity = new ArrayList<>();

    public andre07114_KelasModel() {
        kelasEntity.add(new andre07114_KelasEntity("PBO", "kelas Q"));
        kelasEntity.add(new andre07114_KelasEntity("SO", "kelas V"));
        kelasEntity.add(new andre07114_KelasEntity("JARKOM", "kelas W"));
    }

    public andre07114_KelasEntity getDataByKode(String kode) {
        for(andre07114_KelasEntity kelas : kelasEntity) {
            if(kelas.getCode().equals(kode)) {
                return kelas;
            }
        }
        return null;
    }

    public andre07114_KelasEntity getDataByIndex(int index) {
        return kelasEntity.get(index);
    }

    public int getMax() {
        return kelasEntity.size();
    }
}
