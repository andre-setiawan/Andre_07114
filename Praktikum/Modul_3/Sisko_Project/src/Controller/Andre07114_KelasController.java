package Controller;

import Entity.Andre07114_KelasEntity;
import Model.Andre07114_KelasModel;

public class Andre07114_KelasController {

    private Andre07114_KelasModel kelasModel = new Andre07114_KelasModel();

    public int maxData() {
        return kelasModel.getMax();
    }

    public Andre07114_KelasEntity getDataByKode(String kode) {
        return kelasModel.getDataByKode(kode);
    }

    public Andre07114_KelasEntity view(int index) {
        return kelasModel.getDataByIndex(index);
    }
}
