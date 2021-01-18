package Controller;

import Entity.andre07114_AdminEntity;
import Model.andre07114_AdminModel;

public class andre07114_AdminController {

    private andre07114_AdminModel adminModel = new andre07114_AdminModel();

    public int maxData() {
        return adminModel.getMax();
    }

    public andre07114_AdminEntity getDataByKode(String kode) {
        return adminModel.getDataByKode(kode);
    }

    public andre07114_AdminEntity view(int index) {
        return adminModel.getDataByIndex(index);
    }
}
