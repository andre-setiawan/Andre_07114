package Model;

import Entity.Andre07114_KelasEntity;
import java.util.ArrayList;

public class Andre07114_KelasModel {
    public ArrayList<Andre07114_KelasEntity> kelasEntity = new ArrayList<>();

    public Andre07114_KelasModel() {
        kelasEntity.add(new Andre07114_KelasEntity("Biologi", "Q"));
        kelasEntity.add(new Andre07114_KelasEntity("Fisika", "V"));
        kelasEntity.add(new Andre07114_KelasEntity("Kimia", "W"));
    }

    public Andre07114_KelasEntity getDataByKode(String code) {
        for(Andre07114_KelasEntity kelas : kelasEntity) {
            if(kelas.getKode().equals(code)) {
                return kelas;
            }
        }
        return null;
    }

    public Andre07114_KelasEntity getDataByIndex(int index) {
        return kelasEntity.get(index);
    }

    public int getMax() {
        return kelasEntity.size();
    }
}
