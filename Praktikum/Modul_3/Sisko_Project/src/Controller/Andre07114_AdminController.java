package Controller;

import Entity.Andre07114_AdminEntity;
import Model.Andre07114_AdminModel;

public class Andre07114_AdminController {

    private Andre07114_AdminModel adminModel = new Andre07114_AdminModel();

    public int maxData() {
        return adminModel.getMax();
    }

    public Andre07114_AdminEntity getDataByKode(String kode) {
        return adminModel.getDataByKode(kode);
    }

    public Andre07114_AdminEntity view(int index) {
        return adminModel.getDataByIndex(index);
    }
}
