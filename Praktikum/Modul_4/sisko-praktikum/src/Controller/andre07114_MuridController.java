package Controller;

import Entity.andre07114_Murid;
import Model.andre07114_MuridModel;

public class andre07114_MuridController {

    private andre07114_MuridModel muridModel = new andre07114_MuridModel();

    public int maxData() {
        return muridModel.getMax();
    }

    public andre07114_Murid getDataByNis(int nis) { return muridModel.getDataByNis(nis); }

    public andre07114_Murid view(int index) {
        return muridModel.getData(index);
    }

    public String insert(andre07114_Murid siswaEntity) {
        boolean result = muridModel.insert(siswaEntity);
        if(result) {
            return "berhasil dimasukkan !";
        }

        return "gagal dimasukkan";
    }

    public String update(andre07114_Murid siswaEntity, int nisLama) {
        boolean result = muridModel.update(siswaEntity, nisLama);
        if(result) {
            return "berhasil diedit !";
        }

        return "gagal diedit";
    }

    public int delete(int nis) { return muridModel.delete(nis); }

    public int cekData(int nis) {
        return muridModel.cekData(nis);
    }
}

