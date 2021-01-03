package Controller;

import Entity.Andre07114_MuridEntity;
import Model.Andre07114_MuridModel;

public class Andre07114_MuridController {

    private Andre07114_MuridModel muridModel = new Andre07114_MuridModel();

    public int maxData() {
        return muridModel.getMax();
    }

    public Andre07114_MuridEntity view(int index) {
        return muridModel.getData(index);
    }

    public String insert(Andre07114_MuridEntity muridEntity) {
        boolean result = muridModel.insert(muridEntity);
        if(result) {
            return "Data berhasil dimasukkan !";
        }

        return "Data gagal dimasukkan";
    }

    public String update(Andre07114_MuridEntity siswaEntity, int nisLama) {
        boolean result = muridModel.update(siswaEntity, nisLama);
        if(result) {
            return "Data berhasil diedit !";
        }

        return "Data gagal diedit";
    }

    public int cekData(int nis) {
        return muridModel.cekData(nis);
    }
}

