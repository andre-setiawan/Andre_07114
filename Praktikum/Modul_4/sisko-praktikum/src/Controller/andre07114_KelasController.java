package Controller;

import Entity.andre07114_KelasEntity;
import Model.andre07114_KelasModel;

public class andre07114_KelasController {

    private andre07114_KelasModel kelasModel = new andre07114_KelasModel();

    public int maxData() {
        return kelasModel.getMax();
    }

    public andre07114_KelasEntity getDataByKode(String kode) {
        return kelasModel.getDataByKode(kode);
    }

    public andre07114_KelasEntity getDataByIndex(int index) { return kelasModel.getDataByIndex(index); }

    public andre07114_KelasEntity view(int index) {
        return kelasModel.getDataByIndex(index);
    }
}
