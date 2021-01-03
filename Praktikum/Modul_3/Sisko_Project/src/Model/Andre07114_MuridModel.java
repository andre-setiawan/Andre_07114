package Model;

import Entity.Andre07114_MuridEntity;
import java.util.ArrayList;

public class Andre07114_MuridModel {
    private ArrayList<Andre07114_MuridEntity> MuridArrayList;

    public Andre07114_MuridModel() {
        MuridArrayList = new ArrayList<Andre07114_MuridEntity>();
    }

    public Andre07114_MuridEntity getData(int index) {
        return MuridArrayList.get(index);
    }

    public int getMax() {
        return MuridArrayList.size();
    }

    public boolean insert(Andre07114_MuridEntity muridEntity) {
        MuridArrayList.add(muridEntity);
        if(MuridArrayList.contains(muridEntity)) {
            return true;
        }

        return false;
    }

    public boolean update(Andre07114_MuridEntity newAndre07114MuridEntity, int nisLama) {
        for(int i = 0; i < MuridArrayList.size(); i++) {
            if(MuridArrayList.get(i).getNis() == nisLama) {
                MuridArrayList.set(i, newAndre07114MuridEntity);
                return true;
            }
        }
        return false;
    }

    public int delete(int nis) {
        int index = cekData(nis);
        if(index != -1 && index != -2) {
            MuridArrayList.remove(index);
            return 0;
        }

        return index;
    }

    public int cekData(int nis) {
        int index = 0;
        if(MuridArrayList.size() == 0) {
            index = -1;
        } else {
            for(int i = 0; i < MuridArrayList.size(); i++) {
                if(MuridArrayList.get(i).getNis() == nis) {
                    index = i;
                    break;
                } else {
                    index = -2;
                }
            }
        }
        return index;
    }
}
